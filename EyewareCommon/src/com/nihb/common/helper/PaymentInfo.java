package com.nihb.common.helper;

import org.joda.time.LocalDateTime;

import com.nihb.common.entity.User;

public class PaymentInfo {
	NihbDecimal amount;
	NihbDecimal copay_amount;
	Tax tax;
	Status paymentStatus;
	User paymentBy;
	LocalDateTime paymentAt;
	String invoiceNumber;
	

	public PaymentInfo() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the amount
	 */
	public NihbDecimal getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(NihbDecimal amount) {
		this.amount = amount;
	}


	/**
	 * @return the copay_amount
	 */
	public NihbDecimal getCopay_amount() {
		return copay_amount;
	}


	/**
	 * @param copay_amount the copay_amount to set
	 */
	public void setCopay_amount(NihbDecimal copay_amount) {
		this.copay_amount = copay_amount;
	}


	/**
	 * @return the tax
	 */
	public Tax getTax() {
		return tax;
	}


	/**
	 * @param tax the tax to set
	 */
	public void setTax(Tax tax) {
		this.tax = tax;
	}


	/**
	 * @return the paymentStatus
	 */
	public Status getPaymentStatus() {
		return paymentStatus;
	}


	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(Status paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	/**
	 * @return the paymentBy
	 */
	public User getPaymentBy() {
		return paymentBy;
	}


	/**
	 * @param paymentBy the paymentBy to set
	 */
	public void setPaymentBy(User paymentBy) {
		this.paymentBy = paymentBy;
	}


	/**
	 * @return the paymentAt
	 */
	public LocalDateTime getPaymentAt() {
		return paymentAt;
	}


	/**
	 * @param paymentAt the paymentAt to set
	 */
	public void setPaymentAt(LocalDateTime paymentAt) {
		this.paymentAt = paymentAt;
	}


	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}


	/**
	 * @param invoiceNumber the invoiceNumber to set
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	

}
