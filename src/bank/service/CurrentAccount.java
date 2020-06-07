package bank.service;

import java.util.LinkedList;
import java.util.List;

import bank.model.Transaction;
import bank.util.Constants;
import bank.util.Next_;

public class CurrentAccount extends BankAccount{

	public CurrentAccount() {

		super(Next_.accNu().toString(), 
				Constants.SAVING_MIN_BALANCE, 
				new Double(0.0), 
				Constants.SAVING_INTEREST_RATE, 
				new LinkedList<Transaction>());

	}

	@Override
	public String getType() {
		return "Current";//TODO : constant
	}
}
