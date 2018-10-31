package com.cg.mpw.dao;



import com.cg.mpw.dto.Customer;

public interface WalletDao {
   public boolean save(Customer customer);
	
	public Customer findOne(String mobileNo);
}
