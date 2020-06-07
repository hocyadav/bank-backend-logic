package bank.model;
/**
 * 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class Transaction {
	public String transactionID;
	public Double amount;
	public String type;
	
	public Transaction() {
		
	}
	
	public Transaction(String transactionID, Double amount, String type) {
		//super();
		this.transactionID = transactionID;
		this.amount = amount;
		this.type = type;
	}
	
	
	public String getTransactionID() {
		return transactionID;
	}
	public Double getAmount() {
		return amount;
	}
	public String getType() {
		return type;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", amount=" + amount + ", type=" + type + "]";
	}
	
}
