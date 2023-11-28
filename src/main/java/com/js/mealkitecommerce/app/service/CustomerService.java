package com.js.mealkitecommerce.app.service;

import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.exception.DataNotFoundException;
import com.js.mealkitecommerce.app.model.VO.Customer.JoinRequestVO;
import com.js.mealkitecommerce.app.model.VO.Customer.ModifyCustomerVO;
import com.js.mealkitecommerce.app.model.context.CustomerContext;
import com.js.mealkitecommerce.app.repository.CustomerRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<Customer> findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer join(JoinRequestVO joinForm) {
        Customer customer =
                Customer.builder()
                        .name(joinForm.getName())
                        .username(joinForm.getUsername())
                        .password(passwordEncoder.encode(joinForm.getPassword()))
                        .name(joinForm.getName())
                        .email(joinForm.getEmail())
                        .phoneNum(joinForm.getPhoneNum())
                        .age(joinForm.getAge())
                        .sex(joinForm.getSex())
                        .address(joinForm.getAddress())
                        .addressDetail(joinForm.getAddressDetail())
                        .postNum(joinForm.getPostNum())
                        .build();

        customerRepository.save(customer);

        return customer;
    }

    public void updateCustomer(CustomerContext context, ModifyCustomerVO modifyForm) {
        Customer customer =
                customerRepository
                        .findByUsername(context.getUsername())
                        .orElseThrow(() -> new DataNotFoundException("Customer Not Found"));

        customer.setName(modifyForm.getName());
        customer.setEmail(modifyForm.getEmail());
        customer.setPhoneNum(modifyForm.getPhoneNum());
        customer.setAge(modifyForm.getAge());
        customer.setSex(modifyForm.getSex());
        customer.setAddress(modifyForm.getAddress());
        customer.setAddressDetail(modifyForm.getAddressDetail());
        customer.setPostNum(modifyForm.getPostNum());

        customerRepository.save(customer);
    }

    public void updatePassword(Customer customer, String modifyPassword) {
        String encodePassword = passwordEncoder.encode(modifyPassword);
        customer.setPassword(encodePassword);

        customerRepository.save(customer);
    }

    public Optional<Customer> findByUsernameAndEmail(String username, String email) {
        return customerRepository.findByUsernameAndEmail(username, email);
    }

    public void setNewPassword(Customer customer, String newPassword) {
        String encodePassword = passwordEncoder.encode(newPassword);
        customer.setPassword(encodePassword);

        customerRepository.save(customer);
    }
}
