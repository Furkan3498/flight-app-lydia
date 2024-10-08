package com.lydiatechnology.flightticket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "airports")
public class Airport extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition="TEXT")
    private String details;

    @Column(name = "gate_capacity")
    private Integer gateCapacity;

    @Column(name = "city_id")
    private Integer cityId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_id",insertable = false,updatable = false,nullable = false)
    private City cities;

    @OneToMany(mappedBy = "departureAirport",fetch = FetchType.LAZY)
    private List<Rotation> departureList;

    @OneToMany(mappedBy = "arrivalAirport",fetch = FetchType.LAZY)
    private List<Rotation> arrivalList;

}
