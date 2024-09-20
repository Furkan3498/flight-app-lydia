package com.lydiatechnology.flightticket.repository;


import com.lydiatechnology.flightticket.entity.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany,Integer> {
}
