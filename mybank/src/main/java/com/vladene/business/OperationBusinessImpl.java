package com.vladene.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vladene.dao.AccountRepository;
import com.vladene.dao.EmployeeRepository;
import com.vladene.dao.OperationRepository;
import com.vladene.entities.Account;
import com.vladene.entities.Deposit;
import com.vladene.entities.Employee;
import com.vladene.entities.Operation;
import com.vladene.entities.Withdrawal;

/**
 * @author henri.tala
 *
 */
@Service
public class OperationBusinessImpl implements OperationBusiness {

	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public boolean pay(String code, double amount, Long codeEmp) {
		
		Account ac = accountRepository.findOne(code);
		Employee emp = employeeRepository.findOne(codeEmp);
		Operation op = new Deposit();
		op.setDateOperation(new Date());
		op.setAmount(amount);
		op.setAccount(ac);
		op.setEmployee(emp);
		operationRepository.save(op);
		ac.setBalance(ac.getBalance()+amount);
		
		return true;
	}

	@Override
	@Transactional
	public boolean withdraw(String code, double amount, Long codeEmp) {

		Account ac = accountRepository.findOne(code);
		Employee emp = employeeRepository.findOne(codeEmp);
		
		if(ac.getBalance()<amount) throw new RuntimeException("Insufficient Balance");
		
		Operation op = new Withdrawal();
		op.setDateOperation(new Date());
		op.setAmount(amount);
		op.setAccount(ac);
		op.setEmployee(emp);
		operationRepository.save(op);
		ac.setBalance(ac.getBalance()-amount);
		
		return true;
	}

	@Override
	@Transactional
	public boolean transfer(String ac1, String ac2, double amount, Long codeEmp) {

		withdraw(ac1, amount, codeEmp);
		pay(ac2, amount, codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperations(String codeAccount, int page, int size) {
		
		Page<Operation> ops = operationRepository.getOperations(codeAccount, new PageRequest(page, size));
		
		PageOperation po = new PageOperation();
		po.setOperations(ops.getContent());
		po.setNumberOfOperations(ops.getNumberOfElements());
		po.setPage(ops.getNumber());
		po.setTotalPages(ops.getTotalPages());
		po.setTotalOperations((int)ops.getTotalElements());
		return  po;
	
	}

}
