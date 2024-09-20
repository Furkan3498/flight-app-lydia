package com.lydiatechnology.flightticket.controller;




import com.lydiatechnology.flightticket.dto.AirplaneDto;
import com.lydiatechnology.flightticket.request.CreateUpdateAirplaneRequest;
import com.lydiatechnology.flightticket.service.AirplaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/airplanes")
@RequiredArgsConstructor
public class AirplaneController {
    private final AirplaneService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirplaneDto createAirplane(@RequestBody CreateUpdateAirplaneRequest request){
        return service.createAirplane(request);
    }
    @GetMapping("{id}")
    public AirplaneDto getAirplane(@PathVariable int id) {
        return service.getAirplaneById(id);
    }

    @PutMapping("{id}")
    public AirplaneDto updateAirplane(@PathVariable int id, @RequestBody CreateUpdateAirplaneRequest request){
        return service.updateAirplane(id,request);
    }

    @GetMapping
    public List<AirplaneDto> getAirplaneList() {
        return service.getAirplaneList();
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirplane(@PathVariable  int id){
        service.deleteAirplane(id);
    }
}
