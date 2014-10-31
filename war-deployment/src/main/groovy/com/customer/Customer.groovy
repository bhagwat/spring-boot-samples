package com.customer

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    private String id

    String firstName
    String lastName

    Address address

    List<Work> experiences

    List<String> hobbies
}