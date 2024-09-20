package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.AirplaneDto;
import com.lydiatechnology.flightticket.dto.FlightDto;
import com.lydiatechnology.flightticket.dto.PilotDto;
import com.lydiatechnology.flightticket.entity.Flight;
import com.lydiatechnology.flightticket.exception.BussinesException;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.FlightRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateFlightRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository repository;
    private final AirplaneService airplaneService;
    private final PilotService pilotService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public FlightDto createFlight(CreateUpdateFlightRequest request){
        validateAirplane(request);
        validatePilot(request);
        Flight flight= Flight.builder()
                .flightCode(request.getFlightCode())
                .companyId(request.getCompanyId())
                .arrivalTime(request.getArrivalTime())
                .airplaneId(request.getAirplaneId())
                .depatureTime(request.getDepatureTime())
                .pilotId(request.getPilotId())
                .airplaneId(request.getAirplaneId())
                .ticketPriceId(request.getTicketPriceId())
                .rotationId(request.getRotationId())
                .build();

        AirplaneDto airplane=airplaneService.getAirplaneById(flight.getAirplaneId());
        flight.setSeatLeft(airplane.getAirplaneCapacity());
        return convertToDto(repository.save(flight));
    }

    public FlightDto updateFlight(int id,CreateUpdateFlightRequest request){
        Flight flight=repository.findById(id).orElseThrow(()->new NotFoundException("Flight  not found."));
        flight.setFlightCode(request.getFlightCode());
        flight.setCompanyId(request.getCompanyId());
        flight.setArrivalTime(request.getArrivalTime());
        flight.setAirplaneId(request.getAirplaneId());
        flight.setDepatureTime(request.getDepatureTime());
        flight.setPilotId(request.getPilotId());
        flight.setAirplaneId(request.getAirplaneId());
        flight.setTicketPriceId(request.getTicketPriceId());
        flight.setRotationId(request.getRotationId());
        Flight updatedflight=repository.save(flight);
        return convertToDto(updatedflight);
    }

    public FlightDto getFlightById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Flight not found.")));
    }

    public List<FlightDto> getAvailableFlightList(){
        List<FlightDto> flightDtos = new ArrayList<>();
        repository.findAll().forEach(f -> flightDtos.add(convertToDto(f)));
        return flightDtos;
    }

    public void deleteFlight(int id){
        repository.deleteById(id);
    }


    public void validatePilot(CreateUpdateFlightRequest request){
        int pilotId=request.getPilotId();
        PilotDto pilot=pilotService.getPilotById(pilotId);
        if(!pilot.isAvailable())
            throw new BussinesException("Pilot is not Available");

    }
    public void validateAirplane(CreateUpdateFlightRequest request){
        int airplaneId=request.getAirplaneId();
        AirplaneDto airplane=airplaneService.getAirplaneById(airplaneId);
        if(!airplane.isAvailable())
            throw new BussinesException("airplane is not Available");
    }

    private FlightDto convertToDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightCode(flight.getFlightCode());
        flightDto.setId(flight.getId());
        flightDto.setSeatLeft(flight.getSeatLeft());
        flightDto.setAvailable(flight.getAvailable());
        flightDto.setAirplaneId(flight.getAirplaneId());
        flightDto.setAirlineCompanyId(flight.getCompanyId());
        flightDto.setArrivalTime(flight.getArrivalTime());
        flightDto.setDepatureTime(flight.getDepatureTime());
        flightDto.setPilotId(flight.getPilotId());
        flightDto.setRotationId(flight.getRotationId());
        flightDto.setTicketPriceId(flight.getTicketPriceId());

        return flightDto;
    }



}


