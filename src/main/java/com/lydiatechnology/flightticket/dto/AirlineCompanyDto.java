package com.lydiatechnology.flightticket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AirlineCompanyDto {
    private int id;

    private String companyName;

    private String companyDetail;


}
