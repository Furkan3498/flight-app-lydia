package com.lydiatechnology.flightticket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "countries")
@SuperBuilder
public class Country extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;





    @Column(unique = true,nullable = false)
    private String countryName;

    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<City> cityList;
}
