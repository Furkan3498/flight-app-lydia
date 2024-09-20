package com.lydiatechnology.flightticket.repository;

import com.lydiatechnology.flightticket.entity.Rotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotationRepository extends JpaRepository<Rotation,Integer> {
}
