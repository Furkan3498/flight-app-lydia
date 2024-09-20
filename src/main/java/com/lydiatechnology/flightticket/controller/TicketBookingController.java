package com.lydiatechnology.flightticket.controller;



import com.lydiatechnology.flightticket.dto.TicketBookingDto;
import com.lydiatechnology.flightticket.request.CreateUpdateTicketBookingRequest;
import com.lydiatechnology.flightticket.service.TicketBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ticketbookings")
@RequiredArgsConstructor
public class TicketBookingController {
    private final TicketBookingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketBookingDto createTicketBooking(@RequestBody CreateUpdateTicketBookingRequest request){
        return service.createTicketBooking(request);
    }
    @GetMapping("{id}")
    public TicketBookingDto getTicketBooking(@PathVariable int id) {
        return service.getTicketBookingById(id);
    }

    @PutMapping("{id}")
    public TicketBookingDto updateTicketBooking(@PathVariable int id, @RequestBody CreateUpdateTicketBookingRequest request){
        return service.updateTicketBooking(id,request);
    }

    @GetMapping
    public List<TicketBookingDto> getTicketBookingList() {
        return service.getTicketBookingList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicketBooking(@PathVariable  int id){
        service.deleteTicketBooking(id);
    }
}
