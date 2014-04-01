package com.nihb.common.entity;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.LocalDateTime;

import com.nihb.common.helper.Status;

public abstract class AbstractEntity implements IEntity{
	private List<String> errorList;
    private LocalDateTime createDate;
    private IEntity createBy;
    private LocalDateTime lastModifiedDate;
    private IEntity lastModifiedBy;
    private Status status;
	
    
    
	/* (non-Javadoc)
	 * @see com.nihb.common.entity.IEntity#getStatus()
	 */
	@Override
	public Status getStatus() {
		return this.status;
	}

	/* (non-Javadoc)
	 * @see com.nihb.common.entity.IEntity#setStatus(com.nihb.common.helper.Status)
	 */
	@Override
	public void setStatus(Status status) {
		this.status=status;
		
	}

	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#getCreateDate()
	 */
	@Override
	@JsonIgnore
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#setCreateDate()
	 */
	@Override
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#getCreateBy()
	 */
	@Override
	@JsonIgnore
	public IEntity getCreateBy() {
		return createBy;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#setCreateBy()
	 */
	@Override
	public void setCreateBy(IEntity  createBy) {
		this.createBy = createBy;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#getLastModifiedDate()
	 */
	@Override
	@JsonIgnore
	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#setLastModifiedDate()
	 */
	@Override
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#getLastModifiedBy()
	 */
	@Override
	@JsonIgnore
	public IEntity getLastModifiedBy() {
		return lastModifiedBy;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#setLastModifiedBy()
	 */
	@Override
	public void setLastModifiedBy(IEntity lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#getErrorList()
	 */
	@Override
	public List<String> getErrorList() {
		return this.errorList;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.entity.IEntity#setErrorList()
	 */
	@Override
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;

	}

}
