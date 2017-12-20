package com.vladene.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.vladene.business.PageOperation;
import com.vladene.entities.Account;

/**
 * Define interface that extends Remote Interface. This infact is mandatory to implement RMI method
 * All RMI method must throws RemoteException
 * @author henri.tala
 *
 *
 */
public interface BankRmiRemote extends Remote{
	
	/**
	 * 
	 * @param ac
	 * @return
	 * @throws RemoteException
	 */
	public Account saveAccount(Account ac) throws RemoteException;
    
	/**
	 * 
	 * @param code
	 * @return
	 * @throws RemoteException
	 */
	public Account getAccount(String code) throws RemoteException;
    
    /**
     * 
     * @param code
     * @param amount
     * @param codeEmp
     * @return
     * @throws RemoteException
     */
	public boolean pay(String code, double amount, Long codeEmp)throws RemoteException;
	
	/**
	 * 
	 * @param code
	 * @param amount
	 * @param codeEmp
	 * @return
	 * @throws RemoteException
	 */
	public boolean withdraw(String code, double amount, Long codeEmp)throws RemoteException;
	
	/**
	 * 
	 * @param cpte1
	 * @param cpte2
	 * @param amount
	 * @param codeEmp
	 * @return
	 * @throws RemoteException
	 */
	public boolean transfer(String cpte1, String cpte2, double amount, Long codeEmp)throws RemoteException;
	
	/**
	 * 
	 * @param codeAccount
	 * @param page
	 * @param size
	 * @return
	 * @throws RemoteException
	 */
	public PageOperation getOperations(String codeAccount, int page, int size)throws RemoteException;
	
}
