package com.trading.repository;

 import org.springframework.data.jpa.repository.JpaRepository;

import com.trading.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
