package com.lydiatechnology.flightticket.controller;



import com.lydiatechnology.flightticket.dto.TicketPriceDto;
import com.lydiatechnology.flightticket.request.CreateUpdateTicketPriceRequest;
import com.lydiatechnology.flightticket.service.TicketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/ticketprices")
@RequiredArgsConstructor
public class TicketPriceController {
    private final TicketPriceService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketPriceDto createTicketPrice(@RequestBody CreateUpdateTicketPriceRequest request){
        return service.createTicketPrice(request);
    }
    @GetMapping("{id}")
    public TicketPriceDto getTicketPrice(@PathVariable int id) {
        return service.getTicketPriceById(id);
    }

    @PutMapping("{id}")
    public TicketPriceDto updateTicketPrice(@PathVariable int id, @RequestBody CreateUpdateTicketPriceRequest request){
        return service.updateTicketPrice(id,request);
    }

    @GetMapping
    public List<TicketPriceDto> getTicketPriceList() {
        return service.getTicketPriceList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicketPrice(@PathVariable  int id){
        service.deleteTicketPrice(id);
    }
}
