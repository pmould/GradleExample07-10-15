package com.creationmachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creationmachine.dao.BranchDaoImpl;
import com.creationmachine.dao.EmployeeDao;
import com.creationmachine.model.Branch;
import com.creationmachine.model.Employee;

@Service("branchService")
@Transactional
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchDaoImpl dao;

    public Branch findById(int branchId) {
	return dao.findById(branchId);
    }
    public void saveBranch(Branch branch) {
	dao.saveBranch(branch);
    }
    /*
     * Since the method is running with Transaction, No need to call hibernate
     * update explicitly. Just fetch the entity from db and update it with
     * proper values within transaction. It will be updated in db once
     * transaction ends.
     */
    public void updateBranch(Branch branch) {
	Branch entity = dao.findById(branch.getBranchId());
	if (entity != null) {
		entity.setBranchName(branch.getBranchName());
		entity.setBranchLoc(branch.getBranchLoc());
    }
    }

    public void deleteBranchById(int branchId) {
	dao.deleteBranchById(branchId);
    }

    public List<Branch> findAllBranches() {
	return dao.findAllBranches();
    }
}
