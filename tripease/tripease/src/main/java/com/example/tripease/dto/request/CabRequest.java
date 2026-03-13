package com.example.tripease.dto.request;

import com.example.tripease.dto.Response.DriverResponse;
import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabRequest {
    private String cabNumber;
    private String cabModel;
    private Double perKmRate;

}
