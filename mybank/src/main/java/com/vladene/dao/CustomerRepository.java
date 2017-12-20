package com.vladene.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladene.entities.Customer;

/**
 * @author henri.tala
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
