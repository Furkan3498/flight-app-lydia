package com.lydiatechnology.flightticket.controller;



import com.lydiatechnology.flightticket.dto.AirlineCompanyDto;
import com.lydiatechnology.flightticket.request.CreateUpdateAirlineCompanyRequest;
import com.lydiatechnology.flightticket.service.AirlineCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/airlinecompanies")
@RequiredArgsConstructor
public class AirlineCompanyController {
    private final AirlineCompanyService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirlineCompanyDto createAirlineCompany(@RequestBody CreateUpdateAirlineCompanyRequest request){
        return service.createAirlineCompany(request);
    }
    @GetMapping("{id}")
    public AirlineCompanyDto getAirlineCompany(@PathVariable int id) {
        return service.getAirlineCompanyById(id);
    }


    @PutMapping("{id}")
    public AirlineCompanyDto updateAirlineCompany(@PathVariable int id, @RequestBody CreateUpdateAirlineCompanyRequest request){
        return service.updateAirlineCompany(id,request);
    }
    @GetMapping
    public List<AirlineCompanyDto> getAirlineCompanyList() {
        return service.getAirlineCompanyList();
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirlineCompany(@PathVariable  int id){
        service.deleteAirlineCompany(id);
    }
}
