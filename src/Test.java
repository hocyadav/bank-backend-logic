import java.util.List;

import bank.model.Branch;
import bank.model.Customer;
import bank.service.BankAccount;
import bank.service.HeadOffice;

public class Test {
	public static void main(String[] args) {
		HeadOffice headOffice = new HeadOffice();
		//create 2 branch
		headOffice.createBranch(); headOffice.createBranch();
		System.out.println(headOffice.getAllBranches());
		
		//get all branch
		Branch branch = headOffice.getBranchById("1");
		System.out.println(branch);
		
		//create bank account : in rest also done
		branch.createBankAccount("988ABc", "saving", new Double(40000));//call customer create api
		branch.createBankAccount("988ABc", "current", new Double(60200));
		branch.createBankAccount("988ABd", "current", new Double(60200));
		
		//test all bank account in a branch
		List<BankAccount> bankAccounts = branch.getBankAccounts();
		System.out.println(bankAccounts);
		
		//test bank account by pan
		Customer customerByPanNumber = branch.getCustomerByPanNumber("988abc");
		System.out.println(customerByPanNumber);
		Customer customerByPanNumber2 = branch.getCustomerByPanNumber("988abd");
		System.out.println(customerByPanNumber2);
		
		//txn test : get bank account obj -> do txn
		BankAccount bankAccount = bankAccounts.get(0);
		System.out.println(bankAccount);
		BankAccount bankAccount1 = bankAccounts.get(1);
		System.out.println(bankAccount1);
		
		bankAccount.deposit(new Double(1000));
		bankAccount.deposit(new Double(20000));
		System.out.println(bankAccount);
		
		bankAccount.withdraw(new Double(20000));
		System.out.println(bankAccount);
		
	}

}
