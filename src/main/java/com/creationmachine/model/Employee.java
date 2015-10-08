package com.creationmachine.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;



import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "EMPLOYEE")
public class Employee
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "role", nullable = false)
    private String role;
 
    //@ManyToOne
    //@JoinTable(name="department_id")
	@NotFound(action=NotFoundAction.IGNORE)
    @Size(min = 3, max = 20)
    @Column(name = "Department", nullable = true)
    private String department;

/*    //@ManyToOne
    //@NotEmpty
    @Size(min = 3, max = 20)
    @Column(name = "branch", unique = true, nullable = false)
    private String branch;*/

    @OneToOne(mappedBy="employee")
    @NotFound(action=NotFoundAction.IGNORE)
   // @Size(min = 3, max = 20)
   /* @Column(name = "branch", unique = true, nullable = false)*/
    private Branch branch;
    
	@NotNull
    @Size(min = 3, max = 50)
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    //@NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "JOINING_DATE", nullable = true)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningDate;

    @NotNull
    @Digits(integer = 8, fraction = 2)
    @Column(name = "SALARY", nullable = false)
    private BigDecimal salary;

    @NotEmpty
    @Column(name = "SSN", unique = true, nullable = false)
    private String ssn;
    
/*    @ManyToOne
    @NotFound(action=NotFoundAction.IGNORE)
    private Manager manager;*/

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public LocalDate getJoiningDate()
    {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate)
    {
        this.joiningDate = joiningDate;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }
    
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
/*	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}*/

	@Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        }
        else if (!ssn.equals(other.ssn))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Employee [id=" + id + ", first_name=" + firstName + ", last_name=" + lastName + ", joiningDate=" + joiningDate + ", salary=" + salary + ", ssn=" + ssn + ",role=" + role + /*", branch=" + branch +*/ ",department=" + department + "]";
    }

}
