package com.vladene.service;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vladene.business.AccountBusiness;
import com.vladene.business.OperationBusiness;
import com.vladene.business.PageOperation;
import com.vladene.entities.Account;


/**
 * Implementation of RMI method base on business method define in business layer
 * @author henri.tala
 *
 */
@Component("myRmiService")
public class BankRmiImpl implements BankRmiRemote {

	@Autowired
	private AccountBusiness accountBusiness;
	
	@Autowired
	private OperationBusiness operationBusiness;
	
	
	
	@Override
	public Account saveAccount(Account ac) throws RemoteException {
		// TODO Auto-generated method stub
		return accountBusiness.saveAccount(ac);
	}

	@Override
	public Account getAccount(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return accountBusiness.getAccount(code);
	}

	@Override
	public boolean pay(String code, double amount, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return  operationBusiness.pay(code, amount, codeEmp);
	}

	@Override
	public boolean withdraw(String code, double amount, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationBusiness.withdraw(code, amount, codeEmp);
	}

	@Override
	public boolean transfer(String cpte1, String cpte2, double amount, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationBusiness.transfer(cpte1, cpte2, amount, codeEmp);
	}

	@Override
	public PageOperation getOperations(String codeAccount, int page, int size) throws RemoteException {
		// TODO Auto-generated method stub
		return operationBusiness.getOperations(codeAccount, page, size);
	}

}
