package com.cg.mpw.ui;


import java.util.Scanner;

import com.cg.mpw.dto.Customer;
import com.cg.mpw.exception.InsufficientBalException;
import com.cg.mpw.exception.InvalidInputException;
import com.cg.mpw.service.WalletService;
import com.cg.mpw.service.WalletServiceImpl;


public class Main {
public static void main(String[] args){
	WalletService walletservice=new WalletServiceImpl();
	Customer customer;
	int ch=0;
	Scanner sc=new Scanner(System.in);
	do{
		System.out.println();
	System.out.println("Enter your required choice:");
	System.out.println("1.For Creating Account");
	System.out.println("2.To Show your Details");
	System.out.println("3.To Deposit your Amount");
	System.out.println("4.To withdraw Your Amount");
	System.out.println("5.Fund Transfer");
    ch=sc.nextInt();
	
	switch(ch){
	case 1:
	do{
		try{
	System.out.println("Enter your name:");
	String name1=sc.next();
	if(!walletservice.validateName(name1))
		throw new InvalidInputException("Enter valid name");
		
	System.out.println("Enter your Mobile no:");
	String mobno=sc.next();
	if(!walletservice.validateMobileNumber(mobno)) 
		throw new InvalidInputException("Enter valid mobile number");
	
	System.out.println("Enter your amount:");
	double bal=sc.nextDouble();
	
	 customer=walletservice.createAccount(name1, mobno, bal);
	 
			if( walletservice.ValidateDetails1(customer)!=null)
				break;
			else
				System.out.println("Invalid details entered... Check your details ");
		} catch (InsufficientBalException e) {
			e.printStackTrace();
		}
		catch(InvalidInputException e)
		{
			System.out.println(e.getMessage());
		}
			}
	
while(true);
System.out.println("Name of customer is:"+customer.getName());
System.out.println("Mobile no of the person is:"+customer.getMobileNo());
System.out.println("Balance is:"+customer.getBalance());
	break;
	case 2:
	
		
		System.out.println("Enter your Mobile no to show your data:");
		String mob=sc.next();
        customer=walletservice.showBalance(mob);
        if(customer == null)
        	System.out.println("No record found for this mobile number");
        else
        	System.out.println(customer);
		 break;
	case 3:
		System.out.println("Enter Mobile no to deposit:");
		String mobn=sc.next();
		System.out.println("Enter the amount to be deposited:");
		double balance=sc.nextDouble();
		customer=walletservice.depositAmount(mobn, balance);
		System.out.println(customer);
		break;
	case 4:
		System.out.println("Enter Mobile No to Withdraw:");
		String mobno1=sc.next();
		System.out.println("Enter the amount to get withdrawn from your account:");
	double balance1=sc.nextDouble();
		customer=walletservice.withdrawAmount(mobno1, balance1);
		System.out.println("The balance after withdrawn is:");
		System.out.println(customer.getBalance());
		break;
	case 5:
		System.out.println("Enter source mobile number:");
		String mn=sc.next();
		System.out.println("enter traget number");
		String tr=sc.next();
		System.out.println("enter your amount to get transferred:");
		double balance2=sc.nextDouble();
		customer=walletservice.fundTransfer(mn, tr,balance2);
		System.out.println("Amount after fund transfer:");
		System.out.println(customer.getBalance());
		break;
}
	}while(ch!=6);	
}
}
