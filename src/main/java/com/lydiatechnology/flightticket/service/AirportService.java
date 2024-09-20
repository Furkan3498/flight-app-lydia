package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.AirportDto;
import com.lydiatechnology.flightticket.entity.Airport;
import com.lydiatechnology.flightticket.exception.BussinesException;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.AirportRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateAirportRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository repository;

    public AirportDto createAirport(CreateUpdateAirportRequest request){
        Airport airport = new Airport();
        airport.setDetails(request.getDetails());
        airport.setName(request.getName());
        airport.setGateCapacity(request.getGateCapacity());
        return convertToDto(repository.save(airport));
    }
    public AirportDto updateAirport(int id,CreateUpdateAirportRequest request){
        Airport airport = repository.findById(id).orElseThrow(()->new BussinesException("Airport is not found."));
        airport.setDetails(request.getDetails());
        airport.setName(request.getName());
        airport.setGateCapacity(request.getGateCapacity());
        Airport updatedAirport=repository.save(airport);
        return convertToDto(airport);
    }
    public AirportDto getAirportById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Airport   not found.")));
    }
    public List<AirportDto> getAirportList(){
        List<AirportDto> airportDtos = new ArrayList<>();
        repository.findAll().forEach(a-> airportDtos.add(convertToDto(a)));
        return airportDtos;
    }
    public void deleteAirport(int id){
        repository.deleteById(id);
    }


    private AirportDto convertToDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setId(airport.getId());
        airportDto.setName(airport.getName());
        airportDto.setDetails(airport.getDetails());
        airportDto.setGateCapacity(airport.getGateCapacity());

        return airportDto;
    }

}
