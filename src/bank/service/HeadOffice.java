package bank.service;

import java.util.LinkedList;
import java.util.List;

import bank.model.Branch;

public class HeadOffice {
	private List<Branch> branches = new LinkedList<>();
	
	public List<Branch> getBranches() {
		return branches;
	}

	public void createBranch(){
		Branch branch = new Branch();
		System.out.println("Branch created with id :"+branch.getBranchID());
		this.branches.add(branch);
	}
	
	
	public Branch getBranchById(String branchID) {
		Branch branch_ = null;
		for(Branch b : this.branches) {
			if(b.getBranchID().equalsIgnoreCase(branchID)) {
				branch_ = b;
				break;
			}
		}
		if(branch_ == null) {
			System.err.println("ERROR : branch not found");
		}
		return branch_;//TODO : exception
	}
	
	public List<Branch> getAllBranches() {
		return this.branches;
	}

}
