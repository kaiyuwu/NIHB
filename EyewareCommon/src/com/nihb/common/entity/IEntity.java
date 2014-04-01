package com.nihb.common.entity;

import java.util.List;

import org.joda.time.LocalDateTime;

import com.nihb.common.helper.Status;

public interface IEntity {

	/**
	 * @return the createDate
	 */
	LocalDateTime getCreateDate();
	
	/**
	 * @param createDate the createDate to set
	 */
	void setCreateDate(LocalDateTime createDate);

	/**
	 * @return the createBy
	 */
	IEntity getCreateBy();

	/**
	 * @param createBy the createBy to set
	 */
	void setCreateBy(IEntity createBy);
	
	/**
	 * @return the lastModifiedDate
	 */
	LocalDateTime getLastModifiedDate();

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	void setLastModifiedDate(LocalDateTime lastModifiedDate);

	/**
	 * @return the lastModifiedBy
	 */
	IEntity getLastModifiedBy();

	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	void setLastModifiedBy(IEntity lastModifiedBy);
	
	/**
	 * @return the errorList
	 */
	List<String> getErrorList();

	/**
	 * @param errorList the errorList to set
	 */
	void setErrorList(List<String> errorList);

	/**
	 * @return the status
	 */
	public Status getStatus();
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status);


}
