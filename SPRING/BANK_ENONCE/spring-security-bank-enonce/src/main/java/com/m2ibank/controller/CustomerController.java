package com.m2ibank.controller;

import com.m2ibank.dto.CustomerGetDTO;
import com.m2ibank.dto.UserLoginDto;
import com.m2ibank.model.Customer;
import com.m2ibank.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServices customerServices;

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerServices.save(customer);
    }


    @PostMapping("/login")
    public CustomerGetDTO loginCustomer(@RequestBody UserLoginDto userLoginDto) {
        if (customerServices.checkUserNameExists(userLoginDto.getEmail())) {
            System.out.println("Email verifie");
            if (customerServices.verifsUser(userLoginDto.getEmail(), userLoginDto.getPwd())) {
                System.out.println("hello");
                Map<String, Object> data = new HashMap<>();

                System.out.println("test ->" +customerServices.generatedToken(userLoginDto.getEmail(), userLoginDto.getPwd()));
                data.put("token", customerServices.generatedToken(userLoginDto.getEmail(), userLoginDto.getPwd()));
                return new CustomerGetDTO("Succes", data);
            } else {
                return new CustomerGetDTO("Password not correctly");
            }

        } else {
            return new CustomerGetDTO("Email not found");
        }
    }
}
