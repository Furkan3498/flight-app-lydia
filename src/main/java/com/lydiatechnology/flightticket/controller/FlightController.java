package com.lydiatechnology.flightticket.controller;



import com.lydiatechnology.flightticket.dto.FlightDto;
import com.lydiatechnology.flightticket.request.CreateUpdateFlightRequest;
import com.lydiatechnology.flightticket.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlightDto createFlight(@RequestBody CreateUpdateFlightRequest request){
        return service.createFlight(request);
    }
    @GetMapping("{id}")
    public FlightDto getFlight(@PathVariable int id) {
        return service.getFlightById(id);
    }


    @PutMapping("{id}")
    public FlightDto updateFlight(@PathVariable int id, @RequestBody CreateUpdateFlightRequest request){
        return service.updateFlight(id,request);
    }

    @GetMapping
    public List<FlightDto> getFlightList() {
        return service.getAvailableFlightList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlight(@PathVariable  int id){
        service.deleteFlight(id);
    }
}
