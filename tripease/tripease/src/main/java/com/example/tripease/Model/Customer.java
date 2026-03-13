package com.example.tripease.Model;

import com.example.tripease.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor  //for defualt-construtor
@AllArgsConstructor //for Constructor
@Getter
@Setter
@Entity
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String name;
    private int age;
    private String emailId;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    List<Booking>bookings=new ArrayList<>();

}
