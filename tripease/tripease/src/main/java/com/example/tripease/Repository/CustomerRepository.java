package com.example.tripease.Repository;

import com.example.tripease.Enum.Gender;
import com.example.tripease.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByGenderAndAge(Gender gender, int age);

//Hql mai hai
//@Query("select c from Customer c where c.gender=:gender and c.age > :age")

//we wanted to write in sql String ki gender lete hai sab jagah

@Query(value = "select * from customer where gender=:gender and age > :age",nativeQuery = true)
    List<Customer> findByGenderAndAgeGreater(@Param("gender") String gender,
                                             @Param("age") int age);

}
