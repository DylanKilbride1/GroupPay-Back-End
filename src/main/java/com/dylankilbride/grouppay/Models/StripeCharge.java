package com.dylankilbride.grouppay.Models;

public class StripeCharge {

	private String tokenId;
	private double amount;
	private String userId;
	private String groupAccountId;

	public StripeCharge(String tokenId, double amount, String userId, String groupAccountId) {
		this.tokenId = tokenId;
		this.amount = amount;
		this.userId = userId;
		this.groupAccountId = groupAccountId;
	}

	public StripeCharge(){}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGroupAccountId() {
		return groupAccountId;
	}

	public void setGroupAccountId(String groupAccountId) {
		this.groupAccountId = groupAccountId;
	}
}
