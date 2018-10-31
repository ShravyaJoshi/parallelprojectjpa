package com.cg.mpw.test;

import org.junit.Test;

import com.cg.mpw.exception.InvalidInputException;
import com.cg.mpw.service.WalletService;
import com.cg.mpw.service.WalletServiceImpl;

import junit.framework.Assert;


public class WalletTest {

	@Test(expected=InvalidInputException.class)
	public void test_ValidateName_null() throws InvalidInputException{
		WalletService service=new WalletServiceImpl();
		service.validateName(null);
	}
	
	@Test
	public void test_validateName_v1() throws InvalidInputException{
	
		String name="Shra121";
		WalletService service=new WalletServiceImpl();
		boolean result= service.validateName(name);
		Assert.assertEquals(false,result);
	}
	@Test
	public void test_validateName_v2() throws InvalidInputException{
	
		String name="Shravya";
		WalletService service=new WalletServiceImpl();;
		boolean result= service.validateName(name);
		Assert.assertEquals(true,result);
	}
	@Test
	public void test_validateName_v31() throws InvalidInputException{
	
		String name="shravya";
		WalletService service=new WalletServiceImpl();
		boolean result= service.validateName(name);
		Assert.assertEquals(false,result);
	}
	@Test(expected=InvalidInputException.class)
	public void test_ValidateName_null1() throws InvalidInputException{
		WalletService service=new WalletServiceImpl();
		service.validateName(null);
	}
	
	@Test
	public void test_validateName_v11() throws InvalidInputException{
	
		String name="Shra121";
		WalletService service=new WalletServiceImpl();
		boolean result= service.validateName(name);
		Assert.assertEquals(false,result);
	}
	@Test
	public void test_validateName_v22() throws InvalidInputException{
	
		String name="Shravya";
		WalletService service=new WalletServiceImpl();;
		boolean result= service.validateName(name);
		Assert.assertEquals(true,result);
	}
	@Test
	public void test_validateName_v33() throws InvalidInputException{
	
		String name="shravya";
		WalletService service=new WalletServiceImpl();
		boolean result= service.validateName(name);
		Assert.assertEquals(false,result);
	}
}
