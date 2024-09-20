package com.lydiatechnology.flightticket.repository;


import com.lydiatechnology.flightticket.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
}
