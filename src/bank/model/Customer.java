package bank.model;

import java.util.List;

import bank.service.BankAccount;
/**
 * 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class Customer {
	public String panNumber;
	public List<BankAccount> accounts;
	
	public Customer() {
		
	}
	
	public Customer(String panNumber, List<BankAccount> accounts) {
		super();
		this.panNumber = panNumber;
		this.accounts = accounts;
	}
	
	public String getPanNumber() {
		return panNumber;
	}
	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [panNumber=" + panNumber + ", accounts=" + accounts + "]";
	}
}
