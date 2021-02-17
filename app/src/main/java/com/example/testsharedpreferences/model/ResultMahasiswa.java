package com.example.testsharedpreferences.model;

import com.google.gson.annotations.SerializedName;

public class ResultMahasiswa{

	@SerializedName("password")
	private String password;

	@SerializedName("role")
	private String role;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("username")
	private String username;

	public String getPassword(){
		return password;
	}

	public String getRole(){
		return role;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getUsername(){
		return username;
	}
}