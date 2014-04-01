/**
 * 
 */
package com.nihb.server.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.nihb.common.entity.IEntity;

/**
 * @author kaiwu
 *
 */
public abstract class AbstractDataAccess<E extends IEntity> implements IDataAccess<E>{
	
	public static final String ID = "id";
	public static final String CREATEDBY = "createdby"; 
	public static final String CREATEDAT = "createdAt"; 
	public static final String LASTMODIFIEDBY = "lastmodifiedby"; 
	public static final String LASTMODIFITEDAT = "lastmodifiedat"; 
	public static final String STATUS = "status"; 

	protected long currentuserid;
	
	
	protected Connection conn;
	/**
	 * Constructor
	 * @throws SQLException 
	 */
	public AbstractDataAccess(Connection conn) throws SQLException{
		this.conn = conn;
	}

	/* (non-Javadoc)
	 * @see com.zouyou.dao.IDataAccess#getConnection()
	 */
	@Override
	public Connection getConnection()  throws Exception{
		return this.conn;
	}

	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws Exception {
		this.conn.close();
		this.conn = null;
		
	}

	/* (non-Javadoc)
	 * @see com.nihb.server.dao.IDataAccess#getCurrentUserId()
	 */
	@Override
	public long getCurrentUserId() {		
		return this.currentuserid;
	}

	/* (non-Javadoc)
	 * @see com.nihb.server.dao.IDataAccess#setCurrentUserId(long)
	 */
	@Override
	public void setCurrentUserId(long userid) {
		this.currentuserid = userid;
		
	}
	
	
	
	
	
}
