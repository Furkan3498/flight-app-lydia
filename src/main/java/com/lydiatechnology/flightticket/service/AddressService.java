package com.lydiatechnology.flightticket.service;



import com.lydiatechnology.flightticket.dto.AddressDto;
import com.lydiatechnology.flightticket.entity.Address;
import com.lydiatechnology.flightticket.exception.BussinesException;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.AddressRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateAddressRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public AddressDto createAddress(CreateUpdateAddressRequest request){
        Address address = new Address();
        address.setAddress(request.getAddress());
        address.setAddressRegion(request.getAddressRegion());
        address.setCityId(request.getCityId());
        address.setAddressPostalcode(request.getAddressPostalcode());
        address = repository.save(address);

        return convertToDTO(address);
    }
    public AddressDto updateAddress(int id ,CreateUpdateAddressRequest request){
        Address address=repository.findById(id).orElseThrow(()->new NotFoundException("Not Found"));
        address.setAddress(request.getAddress());
        address.setAddressRegion(request.getAddressRegion());
        address.setCityId(request.getCityId());
        address.setAddressPostalcode(request.getAddressPostalcode());

        Address updatedAddress=repository.save(address);
        return convertToDTO(updatedAddress);
    }
    public AddressDto getAddressById(int id){
        Address address = repository.findById(id).orElseThrow(()->new NotFoundException("Address Not Found"));
        return convertToDTO(address);
    }
    public List<AddressDto> getAddressList(){
        List<AddressDto> addressDtos = new ArrayList<>();
        repository.findAll().forEach(a -> addressDtos.add(convertToDTO(a)));
        return addressDtos;
    }

    public void deleteAddress(int id){
        repository.deleteById(id);
    }

    public Address toAddress(int id){
        return repository.findById(id).orElseThrow(()->new BussinesException(""));
    }

    private AddressDto convertToDTO(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress(address.getAddress());
        addressDto.setAddressRegion(address.getAddressRegion());
        addressDto.setAddressPostalcode(address.getAddressPostalcode());
        addressDto.setCityId(address.getCityId());
        addressDto.setId(address.getId());
        return addressDto;
    }


}
