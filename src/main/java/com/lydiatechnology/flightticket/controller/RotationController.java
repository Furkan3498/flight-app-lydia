package com.lydiatechnology.flightticket.controller;



import com.lydiatechnology.flightticket.dto.RotationDto;
import com.lydiatechnology.flightticket.request.CreateUpdateRotationRequest;
import com.lydiatechnology.flightticket.service.RotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rotations")
@RequiredArgsConstructor
public class RotationController {
    private final RotationService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RotationDto createRotation(@RequestBody CreateUpdateRotationRequest request){
        return service.createRotation(request);
    }
    @GetMapping("{id}")
    public RotationDto getRotation(@PathVariable int id) {
        return service.getRotationById(id);
    }

    @PutMapping("{id}")
    public RotationDto updateRotation(@PathVariable int id, @RequestBody CreateUpdateRotationRequest request){
        return service.updateRotation(id,request);
    }

    @GetMapping
    public List<RotationDto> getRotationList() {
        return service.getRotationList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRotation(@PathVariable  int id){
        service.deleteRotation(id);
    }
}
