package com.customer

import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

import static org.springframework.data.mongodb.core.query.Criteria.where

@Log
@Component
class CustomerBootstrap {
    @Autowired
    CustomerRepository customerRepository

    public void populate() {
        customerRepository.deleteAll();

        // save a couple of customers
        Customer customer1 = new Customer(firstName: 'Alice', lastName: 'Smith').with {
            address = new Address(city: 'Delhi', street: 'Street 1')
            experiences = new ArrayList<Work>()
            experiences.push(new Work(year: 1998, company: 'Xyz corp'))
            experiences.push(new Work(year: 2000, company: 'ABC & Co.'))
            experiences.push(new Work(year: 2006, company: 'Intelligrape Software Pvt Ltd'))

            hobbies = ["Tennis", "Reading", "Playing CS"]

            return it
        }
        customerRepository.save(customer1)

        Customer customer2 = new Customer(firstName: 'Bob', lastName: 'Smith').with {
            address = new Address(city: 'Bombay', street: 'XYz street')
            experiences = new ArrayList<Work>()
            experiences.push(new Work(year: 1999, company: 'Hello comp'))
            experiences.push(new Work(year: 2000, company: 'ABC & Co.'))
            experiences.push(new Work(year: 2010, company: 'Intelligrape Software Pvt Ltd'))
            experiences.push(new Work(year: 2013, company: 'Nodejs starter'))

            hobbies = ["Cricket", "Football", "Chess", "Coding"]

            return it
        }
        customerRepository.save(customer2)

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            println "*" * 30
            println(customer.dump());
        }

        // fetch an individual customer
        println("Customer found with findByFirstName('Alice'):");
        println("--------------------------------");
        println(customerRepository.findByFirstName("Alice"));

        println("Customers found with findByLastName('Smith'):");
        println("--------------------------------");
        for (Customer customer : customerRepository.findByLastName("Smith")) {
            println customer.dump();
        }
    }

    @Autowired
    MongoTemplate mongoTemplate

    public void complexQueryExample() {
        //Some complex queries
        Query query = Query.query(org.springframework.data.mongodb.core.query.Criteria.where('lastName').is("Smith"))

        //Projection
        query.fields()
                .include("firstName")
                .include("address.city")
                .slice("hobbies", 1, 2)
                .elemMatch("work", org.springframework.data.mongodb.core.query.Criteria.where("year").is(2000))

        //Sorting
        query.with(new Sort(Sort.Direction.ASC, "lastName"));

        //Pagination
        query.limit(1)
        query.skip(0)

        log.info query.toString()

        List<Customer> customers = mongoTemplate.find(query, Customer)
        for (Customer customer : customers) {
            log.info customer.dump()
        }
    }
}
