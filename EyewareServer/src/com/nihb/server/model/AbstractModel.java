/**
 * 
 */
package com.nihb.server.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nihb.common.entity.IEntity;
import com.nihb.server.dao.ConnectionPool;
import com.nihb.server.dao.DataAccessFactory;
import com.nihb.server.dao.DataAccessType;
import com.nihb.server.dao.IDataAccess;

/**
 * @author kaiwu
 *
 */
public abstract class AbstractModel<T extends IDataAccess<E>, E extends IEntity> implements IModel<E> {
	
	DataAccessType daoType = null;
	T dao = null;
	Connection connection;
	
	protected AbstractModel(DataAccessType daoType){
		this.daoType = daoType;
	}
	
	
	protected void initDao() throws SQLException{
		this.connection = ConnectionPool.getEyewareConnectionPoolInstance().getEyewareConnection();
		this.dao =  DataAccessFactory.getDataAccess(this.daoType, connection);
	}

	protected void initDao(Connection connection) throws SQLException{
		this.connection = connection;
		this.dao =  DataAccessFactory.getDataAccess(this.daoType, connection);
	}

	protected void closeDao() throws Exception{
		this.dao.close();
	}

	/* (non-Javadoc)
	 * @see com.zouyou.model.IModel#findAll()
	 */
	@Override
	public List<E> findAll() throws Exception {
		this.initDao();
		List<E> list = dao.findAll();
		this.closeDao(); 
		return list;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.model.IModel#findAllBy(java.lang.String)
	 */
	@Override
	public List<E> findAllBy(String queryCondition) throws Exception {
		this.initDao();
		List<E> list =  dao.findAllBy(queryCondition);
		this.closeDao();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.model.IModel#findById(long)
	 */
	@Override
	public E findById(long id) throws Exception {
		this.initDao();
		E entity =  this.dao.findById(id);
		this.closeDao();
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.model.IModel#create(com.zouyou.entity.E)
	 */
	@Override
	public E create(E entity) throws Exception {
		return  this.create(entity, true);
		
	}

	/* (non-Javadoc)
	 * @see com.zouyou.model.IModel#update(com.zouyou.entity.E)
	 */
	@Override
	public E update(E entity) throws Exception {
		return this.update(entity, true);
	}


	/* (non-Javadoc)
	 * @see com.zouyou.model.IModel#remove(long)
	 */
	@Override
	public E remove(long id) throws Exception {
		return this.remove(id, true);
	}


	/* (non-Javadoc)
	 * @see com.zoyoou.model.IModel#create(com.zoyoou.common.entity.IEntity, boolean)
	 */
	@Override
	public E create(E entity, boolean autoDao) throws Exception {
		if(autoDao){
			try{
				this.initDao();
				this.connection.setAutoCommit(false);
				entity = this.dao.create(entity);
				return entity;
			}finally{
				this.connection.commit();
				this.closeDao();
				
			}			
		}else 
			return this.dao.create(entity);	}


	/* (non-Javadoc)
	 * @see com.zoyoou.model.IModel#update(com.zoyoou.common.entity.IEntity, boolean)
	 */
	@Override
	public E update(E entity, boolean autoDao) throws Exception {
		if(autoDao){
			try{
				this.initDao();
				this.connection.setAutoCommit(false);
				entity = this.dao.update(entity);
				return entity;
			}finally{
				this.connection.commit();
				this.closeDao();
			}
		}else
			return this.dao.update(entity);

	}


	/* (non-Javadoc)
	 * @see com.zoyoou.model.IModel#remove(long, boolean)
	 */
	@Override
	public E remove(long id, boolean autoDao) throws Exception {
		if(autoDao){
			try{
				this.initDao();
				this.connection.setAutoCommit(false);
				E entity = this.dao.remove(id);
				return entity;			
			}finally{
				this.connection.commit();
				this.closeDao();
			}
			
		}else{
			return this.dao.remove(id);
		}
	
	}
	
	
	
}
