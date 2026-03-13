package com.example.tripease.dto.Response;

import lombok.*;

@NoArgsConstructor  //for defualt-construtor
@AllArgsConstructor //for Constructor
@Setter
@Getter
@Builder
public class DriverResponse {
    private int driverId;
    private String name;
    private int age;
    private String emailId;
}
