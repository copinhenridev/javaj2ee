package com.vladene.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladene.entities.Account;

/**
 * @author henri.tala
 *
 */
public interface AccountRepository extends JpaRepository<Account, String>{

}
