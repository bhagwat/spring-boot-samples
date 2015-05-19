package com.customer

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(@Param("value") String firstName);

    public List<Customer> findByLastName(@Param("value") String lastName);

    public List<Customer> findByAddressCity(@Param("value") String city);

}