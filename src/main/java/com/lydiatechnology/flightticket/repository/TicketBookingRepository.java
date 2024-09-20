package com.lydiatechnology.flightticket.repository;

import com.lydiatechnology.flightticket.entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer> {
    List<TicketBooking> findByFlightId(int id) ;
}
