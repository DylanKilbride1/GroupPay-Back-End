package com.dylankilbride.grouppay.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class GroupAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "accountId")
	private long groupAccountId;

	@Column(name = "group_admin_id")
	private long adminId;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "account_description")
	private String accountDescription;

	@Column(name = "number_of_members")
	private int numberOfMembers = 0;

	@Column(name = "amount_owed")
	private BigDecimal totalAmountOwed;

	@Column(name = "amount_paid")
	private BigDecimal totalAmountPaid = new BigDecimal("0");

	@OneToOne(fetch = FetchType.EAGER,
					cascade = CascadeType.ALL)
	@JoinColumn(name = "group_image")
	private GroupImage groupImage;

	@OneToOne(fetch = FetchType.EAGER,
					cascade = CascadeType.ALL)
	@JoinColumn(name = "virtual_card_id")
	private VirtualCard virtualCard;

	public GroupAccount(long adminId, String accountName, String accountDescription, BigDecimal totalAmountOwed, BigDecimal totalAmountPaid) {
		this.adminId = adminId;
		this.accountName = accountName;
		this.accountDescription = accountDescription;
		this.totalAmountOwed = totalAmountOwed;
		this.totalAmountPaid = totalAmountPaid;
	}

	public GroupAccount(){

	}

	public GroupAccount(long adminId, String accountName, String accountDescription, BigDecimal totalAmountOwed){
		this.adminId = adminId;
		this.accountName = accountName;
		this.accountDescription = accountDescription;
		this.totalAmountOwed = totalAmountOwed;
	}

	public long getGroupAccountId() {
		return groupAccountId;
	}

	public void setGroupAccountId(long groupAccountId) {
		this.groupAccountId = groupAccountId;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public BigDecimal getTotalAmountOwed() {
		return totalAmountOwed;
	}

	public void setTotalAmountOwed(BigDecimal totalAmountOwed) {
		this.totalAmountOwed = totalAmountOwed;
	}

	public BigDecimal getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void updateAmountPaid(BigDecimal amountPaid) {
		setTotalAmountPaid(totalAmountPaid.add(amountPaid));
	}

	public void setTotalAmountPaid(BigDecimal totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}

	public GroupImage getGroupImage() {
		return groupImage;
	}

	public void setGroupImage(GroupImage groupImage) {
		this.groupImage = groupImage;
	}

//	public void addUserToGroupParticipants(User user){
//		groupMembers.add(user); //TODO This returns false but increments set size.. Why are users not being reflected in DB?
//		incrementGroupMembers ();
//	}

	public VirtualCard getVirtualCard() {
		return virtualCard;
	}

	public void setVirtualCard(VirtualCard virtualCard) {
		this.virtualCard = virtualCard;
	}

	public void incrementGroupMembers() {
		numberOfMembers++;
	}

	public void decrementGroupMembers() {
		numberOfMembers--;
	}
}