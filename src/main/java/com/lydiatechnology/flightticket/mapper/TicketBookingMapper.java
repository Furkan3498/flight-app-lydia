package com.lydiatechnology.flightticket.mapper;

import com.lydiatechnology.flightticket.dto.TicketBookingDto;
import com.lydiatechnology.flightticket.entity.TicketBooking;
import com.lydiatechnology.flightticket.request.CreateUpdateTicketBookingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketBookingMapper {

    TicketBookingMapper TICKET_BOOKING_MAPPER= Mappers.getMapper(TicketBookingMapper.class);

    TicketBookingDto toTicketBookingDto(TicketBooking ticketBooking);

    List<TicketBookingDto> toTicketBookingDtoList(List<TicketBooking> ticketBookingList);

    TicketBooking createTicketBooking(CreateUpdateTicketBookingRequest request);

    void updateTicketBooking(@MappingTarget TicketBooking ticketBooking, CreateUpdateTicketBookingRequest request);

}
