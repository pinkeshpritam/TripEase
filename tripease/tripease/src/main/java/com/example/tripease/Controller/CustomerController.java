package com.example.tripease.Controller;


import com.example.tripease.Enum.Gender;
import com.example.tripease.Model.Customer;
import com.example.tripease.Service.CustomerService;
import com.example.tripease.dto.Response.CustomerResponse;
import com.example.tripease.dto.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }
    @GetMapping("/get/customerId/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customerid){
        return customerService.getCustomer(customerid);
    }
    @GetMapping("/get")
    public List<CustomerResponse>getAllByGenderAndAge(@RequestParam("gender") Gender gender,
                                                      @RequestParam("age") Integer age){
        return customerService.getAllByGenderAndAge(gender,age);

    }

    @GetMapping("/get-genderandAge")
    public List<CustomerResponse>getAllByGenderAndAgeGreater(@RequestParam("gender") String gender,
                                                      @RequestParam("age") Integer age) {
        return customerService.getAllByGenderAndAgeGreater(gender, age);
    }
}
