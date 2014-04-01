package com.nihb.common.helper;

import org.joda.time.DateTime;

public class InjuryInfo {
	DateTime injuryDate;
	String injuryPlace;
	String injuryOther;
	boolean otherInjuryPlan;
	String otherInjuryPlanName;
	String otherInjuryClaimNumber;
	NihbDecimal otherInjuryClaimAmount;

	ApprovalInfo approvalInfo;
	
	public InjuryInfo() {

	}

	/**
	 * @return the injuryDate
	 */
	public DateTime getInjuryDate() {
		return injuryDate;
	}

	/**
	 * @param injuryDate the injuryDate to set
	 */
	public void setInjuryDate(DateTime injuryDate) {
		this.injuryDate = injuryDate;
	}

	/**
	 * @return the injuryPlace
	 */
	public String getInjuryPlace() {
		return injuryPlace;
	}

	/**
	 * @param injuryPlace the injuryPlace to set
	 */
	public void setInjuryPlace(String injuryPlace) {
		this.injuryPlace = injuryPlace;
	}

	/**
	 * @return the injuryOther
	 */
	public String getInjuryOther() {
		return injuryOther;
	}

	/**
	 * @param injuryOther the injuryOther to set
	 */
	public void setInjuryOther(String injuryOther) {
		this.injuryOther = injuryOther;
	}

	/**
	 * @return the otherInjuryPlan
	 */
	public boolean isOtherInjuryPlan() {
		return otherInjuryPlan;
	}

	/**
	 * @param otherInjuryPlan the otherInjuryPlan to set
	 */
	public void setOtherInjuryPlan(boolean otherInjuryPlan) {
		this.otherInjuryPlan = otherInjuryPlan;
	}

	/**
	 * @return the otherInjuryPlanName
	 */
	public String getOtherInjuryPlanName() {
		return otherInjuryPlanName;
	}

	/**
	 * @param otherInjuryPlanName the otherInjuryPlanName to set
	 */
	public void setOtherInjuryPlanName(String otherInjuryPlanName) {
		this.otherInjuryPlanName = otherInjuryPlanName;
	}

	/**
	 * @return the otherInjuryClaimNumber
	 */
	public String getOtherInjuryClaimNumber() {
		return otherInjuryClaimNumber;
	}

	/**
	 * @param otherInjuryClaimNumber the otherInjuryClaimNumber to set
	 */
	public void setOtherInjuryClaimNumber(String otherInjuryClaimNumber) {
		this.otherInjuryClaimNumber = otherInjuryClaimNumber;
	}

	/**
	 * @return the otherInjuryClaimAmount
	 */
	public NihbDecimal getOtherInjuryClaimAmount() {
		return otherInjuryClaimAmount;
	}

	/**
	 * @param otherInjuryClaimAmount the otherInjuryClaimAmount to set
	 */
	public void setOtherInjuryClaimAmount(NihbDecimal otherInjuryClaimAmount) {
		this.otherInjuryClaimAmount = otherInjuryClaimAmount;
	}

	/**
	 * @return the approvalInfo
	 */
	public ApprovalInfo getApprovalInfo() {
		return approvalInfo;
	}

	/**
	 * @param approvalInfo the approvalInfo to set
	 */
	public void setApprovalInfo(ApprovalInfo approvalInfo) {
		this.approvalInfo = approvalInfo;
	}
	
	

}
