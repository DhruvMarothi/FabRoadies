package com.fabRoadies.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/** 
 * @author Pratik 
 * @version 1.0
 */
@Entity
@Table(name="roles")
public class Roles {
	@Id
	@Column(name="roll_id")
	private int rollid;
	@Column(name="user_type",length=15)
	private String usertype;
	@OneToMany(mappedBy="roll")
	private List<User>user;
	
	
	public int getRollid() {
		return rollid;
	}
	public void setRollid(int rollid) {
		this.rollid = rollid;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
	

}


	
/*

public int getDeptNo() {
	return deptNo;
}


public void setDeptNo(int deptNo) {
	this.deptNo = deptNo;
}


public String getDeptName() {
	return deptName;
}


public void setDeptName(String deptName) {
	this.deptName = deptName;
}


public List<Employee> getEmps() {
	return emps;
}


public void setEmps(List<Employee> emps) {
	this.emps = emps;
}



public List<Employee> getEmps() {
	return emps;
}


public void setEmps(List<Employee> emps) {
	this.emps = emps;
}
 */

//@OneToMany(mappedBy="dept")
//private List<Employee>emps;



