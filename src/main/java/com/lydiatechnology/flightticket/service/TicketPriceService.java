package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.TicketPriceDto;
import com.lydiatechnology.flightticket.entity.TicketPrice;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.TicketPriceRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateTicketPriceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Service
@RequiredArgsConstructor
public class TicketPriceService {
    private final TicketPriceRepository repository;

    public TicketPriceDto createTicketPrice(CreateUpdateTicketPriceRequest request){
        TicketPrice ticketPrice=new TicketPrice();
        ticketPrice.setAmount(request.getAmount());
        ticketPrice.setCreationDate(new Date());

        return convertToDto(repository.save(ticketPrice));
    }
    public TicketPriceDto updateTicketPrice(int id, CreateUpdateTicketPriceRequest request){
        TicketPrice ticketPrice=repository.findById(id).orElseThrow(()->new NotFoundException("TicketPrice not found."));
        ticketPrice.setAmount(request.getAmount());
        TicketPrice updatedTicketPrice=repository.save(ticketPrice);
        return convertToDto(updatedTicketPrice);
    }
    public TicketPriceDto getTicketPriceById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()-> new NotFoundException("TicketPrice not found.")));
    }
    public List<TicketPriceDto> getTicketPriceList(){
        List<TicketPriceDto> ticketPriceDtos = new ArrayList<>();
        repository.findAll().forEach(t -> ticketPriceDtos.add(convertToDto(t)));
        return ticketPriceDtos;
    }
    public void deleteTicketPrice(int id){
        repository.deleteById(id);
    }

    private TicketPriceDto convertToDto(TicketPrice ticketPrice) {
        return TicketPriceDto.builder()
                .id(ticketPrice.getId())
                .amount(ticketPrice.getAmount())
                .build();
    }

}
