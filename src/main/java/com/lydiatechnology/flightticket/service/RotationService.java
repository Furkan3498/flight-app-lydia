package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.RotationDto;
import com.lydiatechnology.flightticket.entity.Rotation;
import com.lydiatechnology.flightticket.exception.BussinesException;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.RotationRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateRotationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class RotationService {
    private final RotationRepository repository;


    public RotationDto createRotation(CreateUpdateRotationRequest request){
        validateRotation(request);
        Rotation rotation= new Rotation();
        rotation.setArrivalAirportId(request.getArrivalAirportId());
        rotation.setDepartureAirportId(request.getDepartureAirportId());
        return convertToDto(repository.save(rotation));
    }
    public RotationDto updateRotation(int id, CreateUpdateRotationRequest request){
        Rotation rotation=repository.findById(id).orElseThrow(()->new NotFoundException("Rotation not found."));
        rotation.setDepartureAirportId(request.getDepartureAirportId());
        rotation.setArrivalAirportId(request.getArrivalAirportId());
        Rotation updatedrotation=repository.save(rotation);
        return convertToDto(updatedrotation);
    }
    public RotationDto getRotationById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Rotation not found.")));
    }
    public List<RotationDto> getRotationList(){
        List<RotationDto> rotationDtos = new ArrayList<>();
        repository.findAll().forEach(r -> rotationDtos.add(convertToDto(r)));
        return rotationDtos;
    }

    public void deleteRotation(int id){
        repository.deleteById(id);
    }

    public void validateRotation(CreateUpdateRotationRequest request){
        int arrivalAirport=request.getArrivalAirportId();
        int departureAirport=request.getDepartureAirportId();

        if(arrivalAirport==departureAirport){
            throw new BussinesException("You cannot select same airport");
        }
    }

    private RotationDto convertToDto(Rotation rotation) {
        return RotationDto.builder()
                .arrivalAirportId(rotation.getArrivalAirportId())
                .departureAirportId(rotation.getDepartureAirportId())
                .id(rotation.getId())
                .build();
    }
}
