package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.PilotDto;
import com.lydiatechnology.flightticket.entity.Pilot;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.PilotRepository;
import com.lydiatechnology.flightticket.request.CreateUpdatePilotRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class PilotService {
    private final PilotRepository repository;

    public PilotDto createPilot(CreateUpdatePilotRequest request){
        Pilot pilot = convertToEntity(request);
        return convertToDto(repository.save(pilot));
    }
    public PilotDto updatePilot(int id, CreateUpdatePilotRequest request){
        Pilot pilot=repository.findById(id).orElseThrow(()->new NotFoundException("Pilot   not found."));
        pilot.setPilotLicence(request.getPilotLicence());
        pilot.setPilotIdentityNumber(request.getPilotIdentityNumber());
        pilot.setPilotEmail(request.getPilotEmail());
        pilot.setPilotPhoneNumber(request.getPilotPhoneNumber());
        pilot.setPilotLastName(request.getPilotLastName());
        pilot.setPilotFirstName(request.getPilotFirstName());
        Pilot updatedpilot=repository.save(pilot);
        return convertToDto(updatedpilot);
    }
    public PilotDto getPilotById(int id){
        return convertToDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Pilot   not found.")));
    }
    public List<PilotDto> getPilotList(){
        List<PilotDto> pilotDtos = new ArrayList<>();
        repository.findAll().forEach(p -> pilotDtos.add(convertToDto(p)));
        return pilotDtos;
    }

    public void deletePilot(int id){
        repository.deleteById(id);
    }

    public void setAvailabilty(int id){
        repository.setAvailable(id,false);
    }

    private PilotDto convertToDto(Pilot pilot) {
        return PilotDto.builder()
                .available(pilot.getAvailable())
                .pilotEmail(pilot.getPilotEmail())
                .id(pilot.getId())
                .pilotFirstName(pilot.getPilotFirstName())
                .pilotLastName(pilot.getPilotLastName())
                .pilotIdentityNumber(pilot.getPilotIdentityNumber())
                .pilotPhoneNumber(pilot.getPilotPhoneNumber())
                .pilotLicence(pilot.getPilotLicence())
                .build();
    }

    private Pilot convertToEntity(CreateUpdatePilotRequest createUpdatePilotRequest) {
        return Pilot.builder()
                .pilotEmail(createUpdatePilotRequest.getPilotEmail())
                .pilotFirstName(createUpdatePilotRequest.getPilotFirstName())
                .pilotLastName(createUpdatePilotRequest.getPilotLastName())
                .pilotLicence(createUpdatePilotRequest.getPilotEmail())
                .pilotPhoneNumber(createUpdatePilotRequest.getPilotPhoneNumber())
                .pilotIdentityNumber(createUpdatePilotRequest.getPilotIdentityNumber())
                .build();
    }
}
