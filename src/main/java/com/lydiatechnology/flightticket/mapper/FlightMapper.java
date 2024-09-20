package com.lydiatechnology.flightticket.mapper;

import com.lydiatechnology.flightticket.dto.FlightDto;
import com.lydiatechnology.flightticket.entity.Flight;
import com.lydiatechnology.flightticket.request.CreateUpdateFlightRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper FLIGHT_MAPPER= Mappers.getMapper(FlightMapper.class);

    FlightDto toFlightDto(Flight flight);

    List<FlightDto> toFlightDtoList(List<Flight> flightList);

    Flight createFlight(CreateUpdateFlightRequest request);

    void updateFlight(@MappingTarget Flight flight,CreateUpdateFlightRequest createUpdateFlightRequest);

}
