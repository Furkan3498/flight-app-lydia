package com.lydiatechnology.flightticket.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateAirlineCompanyRequest {
    private String companyName;
    private String companyDetail;


}
