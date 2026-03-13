package com.example.tripease.Service;

import com.example.tripease.Enum.Gender;
import com.example.tripease.Exception.CustomerNotFoundException;
import com.example.tripease.Model.Customer;
import com.example.tripease.Repository.CustomerRepository;
import com.example.tripease.Transformers.CustomerTransformer;
import com.example.tripease.dto.Response.CustomerResponse;
import com.example.tripease.dto.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //Dto to entity or Customer conversion
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        //save the entity to db

        Customer savedCustomer=customerRepository.save(customer);

        //Save entity to dto
       return CustomerTransformer.customerToCustomerRespone(customer);


    }

    public CustomerResponse getCustomer(int customerid)  {
        Optional<Customer> optionalcustomer=customerRepository.findById(customerid);
        if(optionalcustomer.isEmpty()){
            throw new CustomerNotFoundException("Invaild customer id");
        }
        // save the Entity
        Customer savedCustomer=optionalcustomer.get();
        //save entity to Respone Dto
        return CustomerTransformer.customerToCustomerRespone(savedCustomer);
    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, Integer age) {
        //save Entity
        List<Customer> customers =customerRepository.findByGenderAndAge(gender,age);
        //entity to Response
        List<CustomerResponse>customerResponses=new ArrayList<>();

        for(Customer customer : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerRespone(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreater(String gender, Integer age) {
        List<Customer> customers =customerRepository.findByGenderAndAgeGreater(gender,age);
        //entity to Response
        List<CustomerResponse>customerResponses=new ArrayList<>();

        for(Customer customer : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerRespone(customer));
        }
        return customerResponses;
    }
}
