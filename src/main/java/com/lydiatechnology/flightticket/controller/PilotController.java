package com.lydiatechnology.flightticket.controller;




import com.lydiatechnology.flightticket.dto.PilotDto;
import com.lydiatechnology.flightticket.request.CreateUpdatePilotRequest;
import com.lydiatechnology.flightticket.service.PilotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pilots")
@RequiredArgsConstructor
public class PilotController {
    
    private final PilotService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PilotDto createPilot(@RequestBody CreateUpdatePilotRequest request){
        return service.createPilot(request);
    }
    @GetMapping("{id}")
    public PilotDto getPilot(@PathVariable int id) {
        return service.getPilotById(id);
    }

    @PutMapping("{id}")
    public PilotDto updatePilot(@PathVariable int id, @RequestBody CreateUpdatePilotRequest request){
        return service.updatePilot(id,request);
    }

    @GetMapping
    public List<PilotDto> getPilotList() {
        return service.getPilotList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePilot(@PathVariable  int id){
        service.deletePilot(id);
    }
}
