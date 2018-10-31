package com.cg.mpw.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
		
		@Column(name = "cust_name")
		private String name;
		@Id
		@Column(name = "cust_mobile")
		private String mobileNo;
		@Column(name = "cust_balance")
	    private double balance;
	    public Customer(){}
		public Customer(String name, String mobileNo, double balance) {
			super();
			this.name = name;
			this.mobileNo = mobileNo;
			this.balance = balance;
		}
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		@Override
		public String toString() {
			return "Customer [name=" + name + ", mobileNo=" + mobileNo
					+ ", balance=" + balance + "]";
		}
		
}