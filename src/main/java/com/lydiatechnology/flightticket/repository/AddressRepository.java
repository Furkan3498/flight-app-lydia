package com.lydiatechnology.flightticket.repository;


import com.lydiatechnology.flightticket.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {


}
