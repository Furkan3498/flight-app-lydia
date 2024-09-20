package com.lydiatechnology.flightticket.repository;


import com.lydiatechnology.flightticket.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
}
