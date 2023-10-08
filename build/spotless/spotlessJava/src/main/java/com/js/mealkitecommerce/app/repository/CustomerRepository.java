package com.js.mealkitecommerce.app.repository;

import com.js.mealkitecommerce.app.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByUsernameAndEmail(String username, String email);
}
