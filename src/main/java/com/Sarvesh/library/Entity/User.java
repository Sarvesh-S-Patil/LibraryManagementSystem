package com.Sarvesh.library.Entity;

public class User {
//	1. Id 2. Name 3. Username 4. Email 5. Password 6. Authority
	
	private int id;
	private String userName;
	private String email;
	private String password;
	private String Authority;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String userName, String email, String password, String authority) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		Authority = authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return Authority;
	}

	public void setAuthority(String authority) {
		Authority = authority;
	}
	
	
	

}
