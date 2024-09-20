package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.AirplaneDto;
import com.lydiatechnology.flightticket.entity.Airplane;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.AirplaneRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateAirplaneRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AirplaneService {
    private final AirplaneRepository repository;

    public AirplaneDto createAirplane(CreateUpdateAirplaneRequest request){
        Airplane airplane = new Airplane();
        airplane.setAirplaneCapacity(request.getAirplaneCapacity());
        airplane.setAirplaneDetails(request.getAirplaneDetails());
        airplane.setAirplaneName(request.getAirplaneName());
        airplane.setAirplaneManufacturer(request.getAirplaneManufacturer());
        airplane.setAvailable(Boolean.TRUE);

        return convertToDto(repository.save(airplane));
    }
    public AirplaneDto updateAirplane(int id , CreateUpdateAirplaneRequest request){
        Airplane airplane=repository.findById(id).orElseThrow(()->new NotFoundException("Not Found"));
        airplane.setAirplaneManufacturer(request.getAirplaneManufacturer());
        airplane.setAirplaneCapacity(request.getAirplaneCapacity());
        airplane.setAirplaneName(request.getAirplaneName());
        airplane.setAirplaneDetails(request.getAirplaneDetails());
        Airplane updatedAirplane=repository.save(airplane);
        return convertToDto(updatedAirplane);
    }
    public AirplaneDto getAirplaneById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()->new NotFoundException("Airplane not found")));
    }
    public List<AirplaneDto> getAirplaneList(){
        List<AirplaneDto> airplaneDtos = new ArrayList<>();
        repository.findAll().forEach(a -> airplaneDtos.add(convertToDto(a)));
        return airplaneDtos;
    }

    public void deleteAirplane(int id){  repository.deleteById(id);}

    public void setAvailabilty(int id){
        repository.setAvailable(id,false);
    }

    private AirplaneDto convertToDto(Airplane airplane) {
        AirplaneDto airplaneDto = new AirplaneDto();
        airplaneDto.setAirplaneCapacity(airplane.getAirplaneCapacity());
        airplaneDto.setAirplaneDetails(airplane.getAirplaneDetails());
        airplaneDto.setAirplaneManufacturer(airplane.getAirplaneManufacturer());
        airplaneDto.setAirplaneName(airplane.getAirplaneName());
        airplaneDto.setAvailable(airplane.getAvailable());
        airplaneDto.setId(airplane.getId());

        return airplaneDto;
    }

}
