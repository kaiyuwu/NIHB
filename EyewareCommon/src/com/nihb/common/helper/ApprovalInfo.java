package com.nihb.common.helper;

import org.joda.time.DateTime;

import com.nihb.common.entity.User;

public class ApprovalInfo {

	Status approvalStatus;
	User approvalBy;
	DateTime approvedAt;
	String approvalNumber;
	String denialReason;
	
	public ApprovalInfo() {
	}

	/**
	 * @return the approvalStatus
	 */
	public Status getApprovalStatus() {
		return approvalStatus;
	}

	/**
	 * @param approvalStatus the approvalStatus to set
	 */
	public void setApprovalStatus(Status approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	/**
	 * @return the approvalBy
	 */
	public User getApprovalBy() {
		return approvalBy;
	}

	/**
	 * @param approvalBy the approvalBy to set
	 */
	public void setApprovalBy(User approvalBy) {
		this.approvalBy = approvalBy;
	}

	/**
	 * @return the approvedAt
	 */
	public DateTime getApprovedAt() {
		return approvedAt;
	}

	/**
	 * @param approvedAt the approvedAt to set
	 */
	public void setApprovedAt(DateTime approvedAt) {
		this.approvedAt = approvedAt;
	}

	/**
	 * @return the approvalNumber
	 */
	public String getApprovalNumber() {
		return approvalNumber;
	}

	/**
	 * @param approvalNumber the approvalNumber to set
	 */
	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}

	/**
	 * @return the denialReason
	 */
	public String getDenialReason() {
		return denialReason;
	}

	/**
	 * @param denialReason the denialReason to set
	 */
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	

}
