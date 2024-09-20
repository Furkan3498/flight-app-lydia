package com.lydiatechnology.flightticket.repository;

import com.lydiatechnology.flightticket.entity.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPriceRepository extends JpaRepository<TicketPrice,Integer> {
}
