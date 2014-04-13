package com.nihb.common.entity;

import com.nihb.common.helper.ExamInfo;
import com.nihb.common.helper.GlassesInfo;
import com.nihb.common.helper.InjuryInfo;

public class Claim extends AbstractEntity{
	
	
	long id;
	long diand;
	boolean injury;
	InjuryInfo injuryInfo;
	
	ExamInfo examInfo;
	GlassesInfo glassesInfo;

	
	String comments;

	/**
	 * @return the diand
	 */
	public long getDiand() {
		return diand;
	}
	/**
	 * @param diand the diand to set
	 */
	public void setDiand(long diand) {
		this.diand = diand;
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
	 * @return the injury
	 */
	public boolean isInjury() {
		return injury;
	}
	/**
	 * @param injury the injury to set
	 */
	public void setInjury(boolean injury) {
		this.injury = injury;
	}
	/**
	 * @return the injuryInfo
	 */
	public InjuryInfo getInjuryInfo() {
		return injuryInfo;
	}
	/**
	 * @param injuryInfo the injuryInfo to set
	 */
	public void setInjuryInfo(InjuryInfo injuryInfo) {
		this.injuryInfo = injuryInfo;
	}
	/**
	 * @return the examInfo
	 */
	public ExamInfo getExamInfo() {
		return examInfo;
	}
	/**
	 * @param examInfo the examInfo to set
	 */
	public void setExamInfo(ExamInfo examInfo) {
		this.examInfo = examInfo;
	}
	/**
	 * @return the glassesInfo
	 */
	public GlassesInfo getGlassesInfo() {
		return glassesInfo;
	}
	/**
	 * @param glassesInfo the glassesInfo to set
	 */
	public void setGlassesInfo(GlassesInfo glassesInfo) {
		this.glassesInfo = glassesInfo;
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
	

}
