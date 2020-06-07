package bank.service;

import java.util.LinkedList;
import java.util.List;

import bank.model.Transaction;
import bank.util.Next_;

public abstract class BankAccount {

	private String accountNumber;
	private Double minimumBalance;
	private Double currentBalance;
	private Double interestRate;
	public List<Transaction> listOfTxns;


	public BankAccount(String accountNumber, Double minimumBalance, Double currentBalance, Double interestRate,
			List<Transaction> listOfTxns) {
		super();
		this.accountNumber = accountNumber;
		this.minimumBalance = minimumBalance;
		this.currentBalance = currentBalance;
		this.interestRate = interestRate;
		this.listOfTxns = listOfTxns;
	}

	//service method
	public void withdraw(Double amount) {
		//check with current balance
		if(amount == 0) {
			System.out.println("Insert num > 0");
			return;
		}
		if(amount > this.getCurrentBalance()) {//TODO : exception
			System.out.println("ERROR: withdraw : amount less than currentBalance");
			return;
		}else {
			System.out.println("old "+this.listOfTxns);

			System.out.println("INFO: withdraw");
			//update current balance
			this.currentBalance -= amount;

			//add new txn in txn list : type withdraw
			Transaction txn = new Transaction(Next_.txnID().toString(), amount,"withdraw");
			this.listOfTxns.add(txn);

			System.out.println("new "+this.listOfTxns);

		}
	}

	public void deposit(Double amount) {

		if(amount < 0) {
			System.out.println("ERROR : negative number , enter numb > 0");
			return;
		} else {
			//			System.out.println("old "+this.listOfTxns);
			System.out.println("INFO: deposit");
			this.currentBalance += amount;
			Transaction transaction = new Transaction(Next_.txnID().toString(), amount, "deposit");
			this.listOfTxns.add(transaction);
			System.out.println("new "+this.listOfTxns);
		}

	}

	public List<Transaction> getTransactionHistory() {
		return this.listOfTxns;
	}
	//service
	public List<Transaction> getMiniStatement() {
		//this.listOfTxns.stream().limit(10).collect(Collector.)
		List<Transaction> tenList = new LinkedList();
		int temp = (this.listOfTxns.size() >= 10) ? 10 : this.listOfTxns.size();
		System.out.println("mini statment size "+temp);
		for(int i = 0; i < temp; i++) {
			tenList.add(this.listOfTxns.get(i));
		}
		return tenList;
	}
	public Double getMinimumBalance() {
		return this.minimumBalance;
	}
	public Double getCurrentBalance() {
		return this.currentBalance;
	}
	public Double getInterestRate() {
		return this.interestRate;
	}

	public String getAccountNumber() {//my own method
		return this.accountNumber;
	}

	public abstract String getType();

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", minimumBalance=" + minimumBalance
				+ ", currentBalance=" + currentBalance + ", interestRate=" + interestRate + ", listOfTxns=" + listOfTxns
				+ "]";
	}

}
