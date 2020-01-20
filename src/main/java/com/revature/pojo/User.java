package com.revature.pojo;

public class User {
	private int userid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private boolean employee_role;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isEmployee_role() {
		return employee_role;
	}

	public void setEmployee_role(boolean employee_role) {
		this.employee_role = employee_role;
	}

	//Sign up Constructor
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.employee_role = false;
	}
	
	
	//Read all user
	public User(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.employee_role = employee_role;
	}
	
	
}
