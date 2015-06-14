package com.customer

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
public class Customer {
    @Id
    private String id

    String firstName
    String lastName

    Address address

    List<Work> experiences

    List<String> hobbies
}