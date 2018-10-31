package com.cg.mpw.service;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mpw.dao.WalletDao;
import com.cg.mpw.dao.WalletDaoImpl;
import com.cg.mpw.dto.Customer;
import com.cg.mpw.exception.InsufficientBalException;
import com.cg.mpw.exception.InvalidInputException;



public class WalletServiceImpl implements WalletService{
	WalletDao walletdao;
	
	
	public WalletServiceImpl() {
		walletdao=new WalletDaoImpl();	
	}
		
		

	@Override
	public Customer createAccount(String name, String mobileno,double balance) {
     
		Customer c=new Customer(name, mobileno, balance);
		walletdao.save(c);
               return c;
	}

	@Override
	public Customer showBalance(String mobileno) {
	 Customer c= walletdao.findOne(mobileno);
	 return c;
	}
	 

	@Override
public Customer fundTransfer(String sourceMobileNo, String targetMobileNo,
			double amount) throws InvalidInputException{
		
		if(sourceMobileNo.equals(targetMobileNo)) throw new InvalidInputException("Both the numbers are same");

		//else if(customerMap.get(sourceMobileNo) == null )
			//throw new InvalidInputException("source mobile no is null");
	//	else if(customerMap.get(targetMobileNo) == null )
			//throw new InvalidInputException("target no is null");
		else{
   Customer customer=null;
  Customer customer1=null;
   customer=walletdao.findOne(sourceMobileNo);
   customer1=walletdao.findOne(targetMobileNo);
double balance=customer.getBalance()-amount;
double balance1=customer1.getBalance()+amount;
customer.setBalance(balance);
customer1.setBalance(balance1);
walletdao.save(customer1);
  walletdao.save(customer);
return customer;
		}
	}

	@Override
	public Customer depositAmount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Customer customer = null;
		customer=walletdao.findOne(mobileNo);
	
		if(amount<=0)
			throw new InvalidInputException("Please enter a amount which has to be greater than zero");
	double balance=amount+customer.getBalance();
	customer.setBalance(balance);
	
	walletdao.save(customer);
		return customer;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Customer customer=null;
		customer=walletdao.findOne(mobileNo);
		if(amount>=customer.getBalance())
			throw new InvalidInputException("Please enter a amount which has to be less than the valid amount");
		double balance=customer.getBalance()-amount;
		customer.setBalance(balance);
		return customer;
	}
	public void validateDonor(Customer bean) throws InvalidInputException
	{
		List<String> validationErrors = new ArrayList<String>();

		//Validating customer name
		if(!(validateName(bean.getName()))) {
			validationErrors.add("\n Customer Name Should Be In Alphabets and minimum 3 characters long ! \n");
		}
		
		//Validating Phone Number
		if(!(validateMobileNumber(bean.getMobileNo()))){
			validationErrors.add("\n Phone Number Should be in 10 digit \n");
		}
		//Validating  Amount
		if(!(isValidAmount(bean.getBalance()))){
			validationErrors.add("\n Amount Should be a positive Number \n" );
		}
		
		if(!validationErrors.isEmpty())
			throw new InvalidInputException(validationErrors +"");
	}
	@Override
	public Customer ValidateDetails1(Customer c) throws InvalidInputException,InsufficientBalException {

			if(validateName(c.getName()) && validateMobileNumber(c.getMobileNo()))
			return c;
			else
		return null;

	}
	
	@Override
	public boolean validateName(String name) throws InvalidInputException {
		if(name==null)
			throw new InvalidInputException("name can not be null");
		Pattern pat = Pattern.compile("[A-Z][a-z]{3,12}");
		Matcher mat= pat.matcher(name);
		return mat.matches();
	}

	@Override
	public boolean validateMobileNumber(String s) throws InvalidInputException{
		Pattern pat = Pattern.compile("^[1-9]{1}[0-9]{9}$");
		Matcher mat= pat.matcher(s);
		try{
			if(!mat.matches())
				throw new InvalidInputException("Inalid mobile Number, please enter correct number");
		}catch(InvalidInputException e){
			System.out.println(e);
		}
		return mat.matches();
	}
	public boolean isValidAmount(double amount){
		return (amount>0);
	}




}
