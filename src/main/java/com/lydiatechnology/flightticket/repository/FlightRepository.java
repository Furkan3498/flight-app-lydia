package com.lydiatechnology.flightticket.repository;

import com.lydiatechnology.flightticket.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    List<Flight>  findByAvailableTrue();
    @Modifying(clearAutomatically = true)
    @Query("update #{#entityName} f set f.available= :available where f.id= :id")
    int setAvailable(@Param("id") Integer id, @Param("available") boolean available);

    @Modifying(clearAutomatically = true)
    @Query("update #{#entityName} f set f.seatLeft= :seatLeft where f.id= :id")
    int setSeatLeft(@Param("id") Integer id, @Param("seatLeft") int seatLeft );

}
