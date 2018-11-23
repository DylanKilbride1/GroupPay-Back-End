package com.dylankilbride.grouppay.entities;

import javax.persistence.*;

@Table(name = "Users", schema = "grouppay")

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private String mobileNumber;

	public Users(String firstName, String lastName, String emailAddress, String password, String mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public Users() {
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
}