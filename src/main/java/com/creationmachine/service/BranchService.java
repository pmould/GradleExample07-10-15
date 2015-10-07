package com.creationmachine.service;

import java.util.List;

import com.creationmachine.model.Branch;
import com.creationmachine.model.Employee;

public interface BranchService {

	Branch findById(int id);
	
	void saveBranch(Branch branch);
	
	void updateBranch(Branch branch);
	
	void deleteBranchById(int Branch);

	List<Branch> findAllBranches(); 
	
}
