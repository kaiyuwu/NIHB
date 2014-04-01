package com.nihb.server.dao;

import java.sql.Connection;
import java.util.List;

import com.nihb.common.entity.IEntity;



public interface IDataAccess<E extends IEntity> extends AutoCloseable{
	
	List<E> findAll() throws Exception;
	List<E> findAllBy(String queryCondition) throws Exception;
	E findById(long id)  throws Exception;
	E create(E entity) throws Exception;
	E update(E entity) throws Exception;
	E remove(long id) throws Exception;
	Connection getConnection() throws Exception;

	long getCurrentUserId();
	void setCurrentUserId(long userid);
	
}
