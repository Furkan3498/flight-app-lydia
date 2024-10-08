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
@Entity
@Table(name = "airline_company")
@SuperBuilder
public class AirlineCompany extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(unique = true,nullable = false)
    private String companyName;

    @Column(columnDefinition = "Text")
    private String companyDetail;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private List<Flight> flightList;


}
