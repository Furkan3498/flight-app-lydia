package com.lydiatechnology.flightticket.service;

import com.lydiatechnology.flightticket.dto.AirlineCompanyDto;
import com.lydiatechnology.flightticket.entity.AirlineCompany;
import com.lydiatechnology.flightticket.exception.NotFoundException;
import com.lydiatechnology.flightticket.repository.AirlineCompanyRepository;
import com.lydiatechnology.flightticket.request.CreateUpdateAirlineCompanyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class  AirlineCompanyService {

    private final AirlineCompanyRepository repository;

    public AirlineCompanyDto createAirlineCompany(CreateUpdateAirlineCompanyRequest request){
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setCompanyDetail(request.getCompanyDetail());
        airlineCompany.setCompanyName(request.getCompanyName());
        return convertToDTO(repository.save(airlineCompany));
    }
    public AirlineCompanyDto updateAirlineCompany(int id,CreateUpdateAirlineCompanyRequest request){
        AirlineCompany airlineCompany=repository.findById(id).orElseThrow(()->new NotFoundException("Not Found"));
        airlineCompany.setCompanyName(request.getCompanyName());
        airlineCompany.setCompanyDetail(request.getCompanyDetail());

        AirlineCompany updatedAirlineCompany=repository.save(airlineCompany);
        return convertToDTO(updatedAirlineCompany);
    }

    public AirlineCompanyDto getAirlineCompanyById(int id){
        return convertToDTO(repository.findById(id).orElseThrow(()->new NotFoundException("Airline Company Not Found")));
    }

    public List<AirlineCompanyDto> getAirlineCompanyList(){
        List<AirlineCompanyDto> airlineCompanyDtos = new ArrayList<>();
        repository.findAll().forEach(a -> airlineCompanyDtos.add(convertToDTO(a)));
        return airlineCompanyDtos;
    }
    public void deleteAirlineCompany(int id){
        repository.deleteById(id);
    }

    private AirlineCompanyDto convertToDTO(AirlineCompany airlineCompany) {
        AirlineCompanyDto airlineCompanyDto = new AirlineCompanyDto();
        airlineCompanyDto.setCompanyDetail(airlineCompany.getCompanyDetail());
        airlineCompanyDto.setCompanyName(airlineCompany.getCompanyName());
        airlineCompanyDto.setId(airlineCompany.getId());

        return airlineCompanyDto;
    }

}
