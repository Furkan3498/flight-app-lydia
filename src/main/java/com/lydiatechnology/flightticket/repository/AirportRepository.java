package com.lydiatechnology.flightticket.repository;

import com.lydiatechnology.flightticket.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer> {
}
