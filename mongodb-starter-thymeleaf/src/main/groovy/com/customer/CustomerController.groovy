package com.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class CustomerController {
    @Autowired
    CustomerRepository customerRepository

    @RequestMapping("/customer")
    String index(final ModelMap model) {
        model.addAllAttributes(["customers": customerRepository.findAll(), "customer": newCustomer()])
        return "customer/index";
    }

    @RequestMapping("/customer/create")
    String create(final ModelMap model) {
        model.addAllAttributes(["customer": newCustomer()])
        return "customer/create";
    }

    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    String save(Customer customer, final ModelMap model) {
        if (customer.firstName && customer.lastName) {
            customer.hobbies = []
            customerRepository.save(customer)
            return "redirect:/customer"
        } else {
            model.addAllAttributes(["customer": customer])
            return "customer/create";
        }
    }

    private Customer newCustomer() {
        Customer customer = new Customer()
        customer.address = new Address()
        customer.hobbies = []
        customer.experiences = []
    }
}
