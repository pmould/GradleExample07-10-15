package com.creationmachine.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.creationmachine.model.Branch;

@Repository("BranchDao")
public class BranchDaoImpl extends AbstractDao<Integer, Branch> implements BranchDao {

	public Branch findById(int branchId) {
		return getByKey(branchId);
	}

	public void saveBranch(Branch branch) {
		persist(branch);
	}

	public void deleteBranchById(int branchId) {
		Query query = getSession().createSQLQuery("delete from Branch where ssn = :ssn");
		query.setInteger("branch", branchId);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Branch> findAllBranches() {
		Criteria criteria = createEntityCriteria();
		return (List<Branch>) criteria.list();
	}

	public Branch findBranchById(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("branchId", id));
		return (Branch) criteria.uniqueResult();
	}
}
