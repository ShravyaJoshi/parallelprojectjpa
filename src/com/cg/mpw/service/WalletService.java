package com.cg.mpw.service;


import com.cg.mpw.dto.Customer;
import com.cg.mpw.exception.InsufficientBalException;
import com.cg.mpw.exception.InvalidInputException;

public interface WalletService {
	public Customer showBalance (String mobileno);

	public boolean validateName(String name) throws InvalidInputException;
	public boolean validateMobileNumber(String s) throws InsufficientBalException;
	public Customer ValidateDetails1(Customer c) throws InvalidInputException,InsufficientBalException;
	public Customer createAccount(String name, String mobileno, double balance);
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo,double amount) throws InvalidInputException;
	public Customer depositAmount(String mobileNo, double amount);
	public Customer withdrawAmount(String mobileNo, double amount);

	//public boolean validateAmount(double a) throws InsufficientBalException;

}
