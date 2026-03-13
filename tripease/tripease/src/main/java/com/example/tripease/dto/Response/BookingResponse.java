package com.example.tripease.dto.Response;

import com.example.tripease.Enum.TripStatus;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {
    String pickup;
    String destination;
    Double tripDistance;
    TripStatus tripStatus;
    Double tripAmount;

    Date bookedAt;

    Date lastUpdateAt;
    CustomerResponse customer;
    CabResponse cab;
}
