package bank.service;

import java.util.LinkedList;
import java.util.List;

import bank.model.Transaction;
import bank.util.Constants;
import bank.util.Next_;

public class SavingAccount extends BankAccount{

	public SavingAccount() {
		
		super(Next_.accNu().toString(), Constants.CURRENT_MIN_BALANCE, new Double(0.0), Constants.CURRENT_INTEREST_RATE, new LinkedList<Transaction>());
	}

	@Override
	public String getType() {
		return "Saving";
		
	}
	
}
