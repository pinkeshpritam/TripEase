package com.example.tripease.dto.Response;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {
    private String cabNumber;
    private String cabModel;
    private Double perKmRate;
    private boolean avialable;
    private DriverResponse driver;
}
