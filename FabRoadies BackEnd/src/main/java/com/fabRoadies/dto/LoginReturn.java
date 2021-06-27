package com.fabRoadies.dto;
/**
 * Used for returning data to the user when login request is made
 * @author Dhruv Marothi
 * @version 1.0
 */
//@Entity
public class LoginReturn {
	
//	@Id

	private int roleId;
	
	private int userId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
