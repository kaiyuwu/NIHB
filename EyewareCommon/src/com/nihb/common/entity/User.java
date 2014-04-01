package com.nihb.common.entity;

import java.util.List;

import com.nihb.common.helper.Address;
import com.nihb.common.helper.RoleMetricsType;
import com.nihb.common.helper.UserType;

public class User extends AbstractEntity{
	
	long id;
	String username;
	String firstname;
	String lastname;
	UserType type;
	String password;
	String email;
	String website;
	String workphone;
	String cellphone;
	String comments;
	
	Address mailAddress;
	Address billAddress;
	String doctortype;
	String doctorlicense;
	
	List<Provider> providers;
	boolean[] roleMetrics = new boolean[RoleMetricsType.values().length];
	
	
	/**
	 * @return the providers
	 */
	public List<Provider> getProviders() {
		return providers;
	}
	/**
	 * @param providers the providers to set
	 */
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the type
	 */
	public UserType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(UserType type) {
		this.type = type;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the workphone
	 */
	public String getWorkphone() {
		return workphone;
	}
	/**
	 * @param workphone the workphone to set
	 */
	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}
	/**
	 * @return the cellphone
	 */
	public String getCellphone() {
		return cellphone;
	}
	/**
	 * @param cellphone the cellphone to set
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the doctortype
	 */
	public String getDoctortype() {
		return doctortype;
	}
	/**
	 * @param doctortype the doctortype to set
	 */
	public void setDoctortype(String doctortype) {
		this.doctortype = doctortype;
	}
	/**
	 * @return the doctorlicense
	 */
	public String getDoctorlicense() {
		return doctorlicense;
	}
	/**
	 * @param doctorlicense the doctorlicense to set
	 */
	public void setDoctorlicense(String doctorlicense) {
		this.doctorlicense = doctorlicense;
	}

	/**
	 * @return the mailAddress
	 */
	public Address getMailAddress() {
		return mailAddress;
	}
	/**
	 * @param mailAddress the mailAddress to set
	 */
	public void setMailAddress(Address mailAddress) {
		this.mailAddress = mailAddress;
	}
	/**
	 * @return the billAddress
	 */
	public Address getBillAddress() {
		return billAddress;
	}
	/**
	 * @param billAddress the billAddress to set
	 */
	public void setBillAddress(Address billAddress) {
		this.billAddress = billAddress;
	}
	/**
	 * @return the roleMetrics
	 */
	public boolean[] getRoleMetrics() {
		return roleMetrics;
	}
	/**
	 * @param roleMetrics the roleMetrics to set
	 */
	public void setRoleMetrics(boolean[] roleMetrics) {
		this.roleMetrics = roleMetrics;
	}
	
	public boolean hasRole(RoleMetricsType roleMetricsType){
		return this.roleMetrics[roleMetricsType.ordinal()];
	}
	
	public void setRole(RoleMetricsType role, boolean value){
		
		this.roleMetrics[role.ordinal()] = value;
	}

}
