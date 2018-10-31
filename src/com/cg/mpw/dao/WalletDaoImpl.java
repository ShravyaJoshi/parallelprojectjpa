package com.cg.mpw.dao;


import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




import com.cg.mpw.dto.Customer;
import com.cg.mpw.exception.InvalidInputException;


public class WalletDaoImpl implements WalletDao {

	EntityManager manager;
	Connection connection;
	public WalletDaoImpl() throws InvalidInputException{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
		manager=emf.createEntityManager();
	}
	

	@Override
	public boolean save(Customer customer) {
		manager.getTransaction().begin();
		manager.persist(customer);
	manager.getTransaction().commit();
			return true;
	
	}

	@Override
	public Customer findOne(String mobileNo) {

		manager.getTransaction().begin();
		
		Customer customer=manager.find(Customer.class, mobileNo);
		customer.getMobileNo();

     if(customer.getMobileNo()==null){
	System.out.println("enter a valid number");
}
		manager.getTransaction().commit();
		return customer;
	}

}
