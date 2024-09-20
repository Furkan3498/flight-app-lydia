package com.lydiatechnology.flightticket.controller;

import com.lydiatechnology.flightticket.dto.AddressDto;
import com.lydiatechnology.flightticket.request.CreateUpdateAddressRequest;
import com.lydiatechnology.flightticket.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
public class AddressController {
    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public AddressDto getAddress(@PathVariable int id) {
        return service.getAddressById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDto createAddress(@Valid @RequestBody CreateUpdateAddressRequest request){
        return service.createAddress(request);
    }

    @PutMapping("{id}")
    public AddressDto updateAddress(@PathVariable int id, @RequestBody CreateUpdateAddressRequest request){
        return service.updateAddress(id,request);
    }

    @GetMapping
    public List<AddressDto> getAllAdress() {
        return service.getAddressList();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(int id) {
        service.deleteAddress(id);
        return ResponseEntity.ok("Address deleted successfully.");
    }
}
