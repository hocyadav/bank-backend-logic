package bank.model;

import java.util.LinkedList;
import java.util.List;

import bank.service.BankAccount;
import bank.service.CurrentAccount;
import bank.service.SavingAccount;
import bank.util.Next_;

public class Branch {
	public String branchID;
	public List<Customer> customers;
	public List<BankAccount> bankAccounts;

	public Branch() {
		super();
		this.branchID = Next_.branchID().toString();
		this.customers = new LinkedList<Customer>();
		this.bankAccounts = new LinkedList<BankAccount>();
	}

	public String getBranchID() {
		return this.branchID;
	}
	
	//Branch service method
	public void createBankAccount(String panNumber, String accountType, Double initialBalance) {
		BankAccount newBankAccount = null;
		
		if(accountType.equalsIgnoreCase("saving")) {
			newBankAccount = new SavingAccount();
			newBankAccount.setCurrentBalance(initialBalance);
			this.bankAccounts.add(newBankAccount);
		}else if(accountType.equalsIgnoreCase("current")) {
			newBankAccount = new CurrentAccount();
			newBankAccount.setCurrentBalance(initialBalance);
			this.bankAccounts.add(newBankAccount);
		}else {
			System.err.println("account type invalid input");
			return;
		}
		
		for(Customer customer : this.customers) {
			String panTemp = customer.getPanNumber();
			if(panNumber.equalsIgnoreCase(panTemp)) {
				customer.getAccounts().add(newBankAccount);
				return;
			}
		}
		//pan not present -->1. create new cust -> 2. add in branch account list  -> 3. add in customer list
		Customer newCustomer = new Customer(panNumber, new LinkedList<BankAccount>());//1
		newCustomer.getAccounts().add(newBankAccount);//2
		this.customers.add(newCustomer);//3
	}
	
	//service
	public Customer getCustomerByPanNumber(String panNumber) {
		for(Customer customer : this.customers) {
			String panTemp = customer.getPanNumber();
			if(panNumber.equalsIgnoreCase(panTemp)) {
				return customer;
			}
		}
		System.err.println("ERROR : customer not found");//TODO : exception 
		return null;//TODO : use Options java 
	}
	
	//service
	public BankAccount getAccountByAccountNumber(String accountNumber) {//TODO 
		for(BankAccount bankAccount : this.bankAccounts) {
			if(bankAccount.getAccountNumber().equalsIgnoreCase(accountNumber)) {
				return bankAccount;
			}
		}
		System.err.println("Bank account not present in branch");
		return null;
		
	}
	
	public List<BankAccount> getBankAccounts() {
		return this.bankAccounts;
	}

	@Override
	public String toString() {
		return "Branch [branchID=" + branchID + ", customers=" + customers + ", bankAccounts=" + bankAccounts + "]";
	}

}
