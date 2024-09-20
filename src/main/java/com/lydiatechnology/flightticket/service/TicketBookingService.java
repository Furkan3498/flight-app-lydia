package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.TicketBookingDto;
import com.lydiatechnology.flightticket.entity.Airplane;
import com.lydiatechnology.flightticket.entity.Flight;
import com.lydiatechnology.flightticket.entity.TicketBooking;
import com.lydiatechnology.flightticket.exception.BussinesException;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.AirplaneRepository;
import com.lydiatechnology.flightticket.repository.FlightRepository;
import com.lydiatechnology.flightticket.repository.TicketBookingRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateTicketBookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class TicketBookingService {
    private final TicketBookingRepository repository;
    private final AirplaneRepository airplaneRepository;
    private final FlightRepository flightRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public TicketBookingDto createTicketBooking(CreateUpdateTicketBookingRequest request){
        validetaTicketBooking(request);
        TicketBooking ticketBooking= new TicketBooking();
        ticketBooking.setNumberOfTicket(request.getNumberOfTicket());
        ticketBooking.setFlightId(request.getFlightId());
        ticketBooking.setUserId(request.getUserId());
        Flight flight=flightRepository.findById(request.getFlightId()).orElseThrow(()-> new NotFoundException("Flight is Not Found"));
        ticketBooking.setTotalPaidPrice(flight.getTicketPrice().getAmount()*ticketBooking.getNumberOfTicket());
        return convertToDto(repository.save(ticketBooking));
    }
    public TicketBookingDto updateTicketBooking(int id, CreateUpdateTicketBookingRequest request){
        TicketBooking ticketBooking=repository.findById(id).orElseThrow(()->new NotFoundException("TicketBooking not found."));
        ticketBooking.setNumberOfTicket(request.getNumberOfTicket());
        ticketBooking.setFlightId(request.getFlightId());
        ticketBooking.setUserId(request.getUserId());
        TicketBooking updatedTicketBooking=repository.save(ticketBooking);
        return convertToDto(updatedTicketBooking);
    }
    public TicketBookingDto getTicketBookingById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()-> new NotFoundException("TicketBooking  not found.")));
    }
    public List<TicketBookingDto> getTicketBookingList(){
        List<TicketBookingDto> ticketBookingDtos = new ArrayList<>();
        repository.findAll().forEach(t -> ticketBookingDtos.add(convertToDto(t)));
        return ticketBookingDtos;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteTicketBooking(int id){
        TicketBooking ticketBooking= repository.findById(id).orElseThrow(()->new BussinesException("ticket could not cancelled"));
        Flight flight=flightRepository.findById(ticketBooking.getFlightId()).orElseThrow(()->new BussinesException("ticket could not cancelled"));
        List<TicketBooking> numOfTicket=repository.findByFlightId(flight.getId());
        int ticketSold= numOfTicket
                .stream()
                .mapToInt(ticketBookings -> ticketBookings.getNumberOfTicket())
                .sum();
        Airplane airplane=airplaneRepository.getById(flight.getAirplaneId());
        ticketSold-=ticketBooking.getNumberOfTicket();
        flightRepository.setSeatLeft(flight.getId(),(airplane.getAirplaneCapacity()-ticketSold));
        repository.deleteById(id);

    }

    public void validetaTicketBooking(CreateUpdateTicketBookingRequest request){
        Flight flight=flightRepository.findById(request.getFlightId()).orElseThrow(()->new BussinesException(""));
        List<TicketBooking> numOfTicket=repository.findByFlightId(flight.getId());
        int ticketSold= numOfTicket
                .stream()
                .mapToInt(ticketBooking -> ticketBooking.getNumberOfTicket())
                .sum();
        Airplane airplane=airplaneRepository.getById(flight.getAirplaneId());
        int leftSeat=airplane.getAirplaneCapacity()-ticketSold;
        if(leftSeat<=0){
            flightRepository.setAvailable(flight.getId(),false);
            throw new BussinesException("There is no empty Left");
        }else if(leftSeat>0&&(leftSeat-request.getNumberOfTicket()<0)){
            throw new BussinesException("There is no empty Left");
        }
        flightRepository.setSeatLeft(flight.getId(),(leftSeat-request.getNumberOfTicket()));

    }

    private TicketBookingDto convertToDto(TicketBooking ticketBooking) {
        return TicketBookingDto.builder()
                .id(ticketBooking.getId())
                .numberOfTicket(ticketBooking.getNumberOfTicket())
                .flightId(ticketBooking.getFlightId())
                .userId(ticketBooking.getUserId())
                .build();
    }
}
