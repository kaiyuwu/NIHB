package com.nihb.common.helper;

import com.nihb.common.entity.Provider;
import com.nihb.common.entity.User;

public class EyeCheckInfo {

	Provider provider;
	User doctor;
	String comments;
	String nihbComments;
	

	public EyeCheckInfo() {
	}


	/**
	 * @return the provider
	 */
	public Provider getProvider() {
		return provider;
	}


	/**
	 * @param provider the provider to set
	 */
	public void setProvider(Provider provider) {
		this.provider = provider;
	}


	/**
	 * @return the doctor
	 */
	public User getDoctor() {
		return doctor;
	}


	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(User doctor) {
		this.doctor = doctor;
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
	 * @return the nihbComments
	 */
	public String getNihbComments() {
		return nihbComments;
	}


	/**
	 * @param nihbComments the nihbComments to set
	 */
	public void setNihbComments(String nihbComments) {
		this.nihbComments = nihbComments;
	}
	

}
