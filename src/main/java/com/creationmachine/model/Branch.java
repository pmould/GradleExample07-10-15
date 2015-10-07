package com.creationmachine.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int branchId;
	
	@NotNull
	@Size(min=1,max=45)
	@Column(name="BRANCH_NAME")
	private String branchName;
	
	@NotNull
	@Size(min=0, max=45)
	@Column(name="BRANCH_LOC")
	private String branchLoc;

	
	public int getBranchId() {
		return branchId;
	}


	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getBranchLoc() {
		return branchLoc;
	}


	public void setBranchLoc(String branchLoc) {
		this.branchLoc = branchLoc;
	}


	//@OneToOne
	//@JoinColumn(name="BRANCH_MANAGER_ID")
	//private BranchManager branchManager;
	@Override
	public String toString()
	{
	    return "Branch [id=" + branchId + ", branchName=" + branchName + ", branchLoc=" + branchLoc + "]";
	}
}
