package com.example.tripease.dto.Response;

import lombok.*;

@NoArgsConstructor  //for defualt-construtor
@AllArgsConstructor //for Constructor
@Setter
@Getter
@Builder
public class CustomerResponse {
    private int customerId;
    private String name;
    private int age;
    private String emailId;
}
