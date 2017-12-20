package com.vladene.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladene.dao.AccountRepository;
import com.vladene.entities.Account;

/**
 * @author henri.tala
 *
 */
@Service
public class AccountBusinessImpl  implements AccountBusiness{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account saveAccount(Account a) {
		a.setDateCreation(new Date());
		return  accountRepository.save(a);
	}

	@Override
	public Account getAccount(String accountCode) {
		return accountRepository.findOne(accountCode);
	}

}
