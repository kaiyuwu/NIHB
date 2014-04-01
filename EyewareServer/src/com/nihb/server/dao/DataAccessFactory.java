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
public class DataAccessFactory {
	
	@SuppressWarnings("unchecked")
	public static <T extends IDataAccess<? extends IEntity>> T getDataAccess(DataAccessType type, Connection connection) throws SQLException{
		switch(type){
		case USER:
			return (T) new UserDao(connection);
		case PROVIDER:
			return (T) new ProviderDao(connection);
		case USERPROVIDER:
			return (T) new UserProviderRelationDao(connection);
		case CLAIM:
			return (T) new ClaimDao(connection);
		case MEMBER:
			return (T) new MemberDao(connection);
		default:
			return null;
		}
	}

}
