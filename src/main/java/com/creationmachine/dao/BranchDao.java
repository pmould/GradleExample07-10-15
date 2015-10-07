package com.creationmachine.dao;

import java.util.List;

import com.creationmachine.model.Branch;
import com.creationmachine.model.Employee;

public interface BranchDao {

	Branch findById(int branchId);

	void saveBranch(Branch branch);
	
	void deleteBranchById(int branchId);
	
	List<Branch> findAllBranches();

}
