package com.nihb.common.helper;


public class GlassesInfo {
	
	ApprovalInfo approvalInfo;

	EyeCheckInfo opticianCheckInfo;
	
	GlassesDetail glassesDetail;

	PaymentInfo paymentInfo;

	public GlassesInfo() {
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
	 * @return the opticianCheckInfo
	 */
	public EyeCheckInfo getOpticianCheckInfo() {
		return opticianCheckInfo;
	}

	/**
	 * @param opticianCheckInfo the opticianCheckInfo to set
	 */
	public void setOpticianCheckInfo(EyeCheckInfo opticianCheckInfo) {
		this.opticianCheckInfo = opticianCheckInfo;
	}

	/**
	 * @return the glassesDetail
	 */
	public GlassesDetail getGlassesDetail() {
		return glassesDetail;
	}

	/**
	 * @param glassesDetail the glassesDetail to set
	 */
	public void setGlassesDetail(GlassesDetail glassesDetail) {
		this.glassesDetail = glassesDetail;
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
