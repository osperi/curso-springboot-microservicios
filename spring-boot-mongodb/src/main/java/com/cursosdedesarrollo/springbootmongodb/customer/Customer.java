package com.cursosdedesarrollo.springbootmongodb.customer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    public String id;

    @NotNull
    @NotBlank
    public String firstName;
    @NotNull
    @NotBlank
    public String lastName;

    public String email;


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
