package com.m2ibank.service;

import com.m2ibank.config.jwt.JwtTokenProvider;
import com.m2ibank.dto.CustomerGetDTOReturn;
import com.m2ibank.model.Customer;
import com.m2ibank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServices implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    public Customer save(Customer customer) {
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        return customerRepository.save(customer);
    }

    // Check Si l'utilisateur exist
    public boolean checkUserNameExists(String email) {
        return customerRepository.findByEmail(email).isPresent();
    }

    public String generatedToken(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

    public boolean verifsUser(String email, String pwd) {
        return customerRepository.findByEmail(email).map(custumer -> passwordEncoder.matches(pwd, custumer.getPwd())).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    // Envoie le UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not Found"));
    }

    public CustomerGetDTOReturn entitytoGet(Customer customer) {
        CustomerGetDTOReturn customerGetDTOReturn = new CustomerGetDTOReturn();
        customerGetDTOReturn.setId(customer.getId());
        customerGetDTOReturn.setName(customer.getName());
        customerGetDTOReturn.setEmail(customer.getEmail());
        customerGetDTOReturn.setRole(customer.getRole());
        return customerGetDTOReturn;
    }
}
