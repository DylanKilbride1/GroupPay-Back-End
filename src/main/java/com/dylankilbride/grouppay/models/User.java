package com.dylankilbride.grouppay.models;

import javax.persistence.*;
import java.util.Set;

@Table(name = "User", schema = "grouppay")

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "password")
	private String password;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_image")
	private ProfileImage profileImage;

	@OneToMany(fetch = FetchType.EAGER,
	cascade = CascadeType.ALL,
	mappedBy = "user")
	private Set<Transaction> transaction;

	@ManyToMany(mappedBy="groupMembers")
	private Set<GroupAccount> groupAccounts;


	public User(String firstName, String lastName, String emailAddress, String password, String mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public User() {
	}

	public void setId(long id) {
		this.id = id;
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

	public long getId() {
		return id;
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

	dfgewfg
}