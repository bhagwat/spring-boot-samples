package com.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
    @Autowired
    CustomerRepository customerRepository

    @RequestMapping("/")
    @ResponseBody
    public Map list() {
        return ["customers": customerRepository.findAll()]
    }
}
