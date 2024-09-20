package com.lydiatechnology.flightticket.repository;

import com.lydiatechnology.flightticket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User,Integer> {

    Optional<User> findByUserEmail(String email);

}
