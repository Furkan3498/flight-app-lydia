package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.CityDto;
import com.lydiatechnology.flightticket.entity.City;
import com.lydiatechnology.flightticket.exception.BussinesException;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.CityRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateCityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository repository;

    public CityDto createCity(CreateUpdateCityRequest request){
        City city = new City();
        city.setCityName(request.getCityName());
        city.setCountryId(request.getCountryId());
        return convertToDto(repository.save(city));
    }
    public CityDto updateCity(int id,CreateUpdateCityRequest request){
       City city=repository.findById(id).orElseThrow(()->new BussinesException("City is not found."));
       city.setCityName(request.getCityName());
       city.setCountryId(request.getCountryId());
       City updatedcity=repository.save(city);
       return convertToDto(updatedcity);
    }
    public CityDto getCityById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()-> new NotFoundException("City  not found.")));
    }
    public List<CityDto> getCityList(){
        List<CityDto> cityDtos = new ArrayList<>();
        repository.findAll().forEach(c -> cityDtos.add(convertToDto(c)));
        return cityDtos;
    }
    public void deleteCity(int id){
        repository.deleteById(id);
    }

    private CityDto convertToDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setCityName(city.getCityName());
        cityDto.setCountryId(city.getCountryId());
        cityDto.setId(city.getId());

        return cityDto;
    }
}
