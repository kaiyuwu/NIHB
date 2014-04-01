package com.nihb.common.helper;


public class ExamInfo {
	
	EyeCheckInfo doctorInfo;
	ApprovalInfo approvalInfo;
	Prescription prescription;
	PaymentInfo paymentInfo;
	
	public ExamInfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the doctorInfo
	 */
	public EyeCheckInfo getDoctorInfo() {
		return doctorInfo;
	}

	/**
	 * @param doctorInfo the doctorInfo to set
	 */
	public void setDoctorInfo(EyeCheckInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
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

	/**
	 * @return the prescription
	 */
	public Prescription getPrescription() {
		return prescription;
	}

	/**
	 * @param prescription the prescription to set
	 */
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	/**
	 * @return the paymentInfo
	 */
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	/**
	 * @param paymentInfo the paymentInfo to set
	 */
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	
	
	
		
}
