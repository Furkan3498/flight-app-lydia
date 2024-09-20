package com.lydiatechnology.flightticket.controller;


 import com.lydiatechnology.flightticket.dto.CountryDto;
import com.lydiatechnology.flightticket.request.CreateUpdateCountryRequest;
 import com.lydiatechnology.flightticket.service.CountryService;
 import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CountryDto createCountry(@RequestBody CreateUpdateCountryRequest request){
        return service.createCountry(request);
    }
    @GetMapping("{id}")
    public CountryDto getCountry(@PathVariable int id) {
        return service.getCountryById(id);
    }

    @PutMapping("{id}")
    public CountryDto updateCountry(@PathVariable int id, @RequestBody CreateUpdateCountryRequest request){
        return service.updateCountry(id,request);
    }

    @GetMapping
    public List<CountryDto> getCountryList() {
        return service.getCountryList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable  int id){
        service.deleteCountry(id);
    }
}
