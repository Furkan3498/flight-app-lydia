package com.lydiatechnology.flightticket.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateCityRequest {
    private String cityName;

    private Integer countryId;
}
