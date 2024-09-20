package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.CountryDto;
import com.lydiatechnology.flightticket.entity.Country;
import com.lydiatechnology.flightticket.exception.BussinesException;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.CountryRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateCountryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository repository;

    public CountryDto createCountry(CreateUpdateCountryRequest request){
        Country country= new Country();
        country.setCountryName(request.getCountryName());
        country = repository.save(country);
        return convertToDto(country);
    }
    public CountryDto updateCountry(int id,CreateUpdateCountryRequest request){
        Country country=repository.findById(id).orElseThrow(()->new BussinesException("Country is not found."));
        country.setCountryName(request.getCountryName());
        Country updatedcountry=repository.save(country);
        return convertToDto(updatedcountry);
    }
    public CountryDto getCountryById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Country   not found.")));
    }
    public List<CountryDto> getCountryList(){
        List<CountryDto> countryDtos = new ArrayList<>();
        repository.findAll().forEach(c -> countryDtos.add(convertToDto(c)));
        return countryDtos;
    }
    public void deleteCountry(int id){
        repository.deleteById(id);
    }

    private CountryDto convertToDto(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setCountryName(country.getCountryName());
        countryDto.setId(country.getId());
        return countryDto;
    }
}
