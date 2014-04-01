/**
 * 
 */
package com.nihb.server.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.mysql.jdbc.NotImplemented;
import com.nihb.common.entity.Provider;
import com.nihb.common.entity.User;
import com.nihb.common.entity.UserProviderRelation;
import com.nihb.common.helper.ProviderType;
import com.nihb.common.helper.UserType;

/**
 * @author kaiwu
 *
 */
public class UserProviderRelationDao extends AbstractDataAccess<UserProviderRelation> {


 	
	public static final String USERID = "userid"; 
	public static final String USERFIRSTNAME = "userfirstname"; 
	public static final String USERLASTNAME = "userlastname";
	public static final String PROVIDERID="providerid";
	public static final String PROVIDERNAME = "providername";
	public static final String USERTYPE ="usertype";
	public static final String PROVIDERTYPE = "providertype";
	public static final String USERNAME = "username";
	public static final String DOCTORTYPE = "doctortype"; 

	
	static final String FIND_BY_USERID="{call GetUserProviderRelationByUserId(?)}";
	static final String FIND_BY_PROVIDERID="{CALL GetUserProviderRelationByProviderId(?)}";
	static final String INSERT_RELATION="{CALL InsertUserProviderRelation("
		     + "?," // userid			BIGINT,
		     + "?," // providerid		BIGINT,
		     + "?," // providername	VARCHAR(50),
			 + "?," // userfirstname		 VARCHAR(50),
			 + "?," // userlastname		 VARCHAR(50),
			 + "?," // usertype		 	 CHAR(1),
			 + "?," // doctortype		 	 CHAR(1),
			 + "?," // proviertype		 	 CHAR(1),
			 + "?," //	username		 VARCHAR(30),
			 + "?," //	createdby		 BIGINT,
			 + "?"  //  OUT id 			 BIGINT)
			 +")}";

	
	static final String DELETE_RELATION = "{CALL DeleteUserProviderRelation(?)}";

	static final String GET_BY_USERID = "{CALL GetUserProviderRelationByUserId(?)}";
	static final String GET_BY_PROVIDERID = "{CALL GetUserProviderRelationByProviderId(?)}";
	
 	
	public UserProviderRelationDao(Connection conn) throws SQLException {
		super(conn);
	}

	@Override
	public List<UserProviderRelation> findAll() throws Exception {
		throw new NotImplemented();
	}

	@Override
	public List<UserProviderRelation> findAllBy(String queryCondition)
			throws Exception {
		throw new NotImplemented();
	}

	@Override
	public UserProviderRelation findById(long id) throws Exception {
		throw new NotImplemented();
	}
	
	public List<UserProviderRelation> findByUserId(long userId) throws Exception{
		CallableStatement cs = this.conn.prepareCall(FIND_BY_USERID);
		return find(cs,userId);
	}
	public List<UserProviderRelation> findByProviderId(long providerId) throws Exception{
		CallableStatement cs = this.conn.prepareCall(FIND_BY_PROVIDERID);
		return find(cs,providerId);
	}
	
	
	private List<UserProviderRelation> find(CallableStatement cs, long id) throws Exception{
		cs.setLong(1, id);
		ResultSet result = cs.executeQuery();
		List<UserProviderRelation> uprs = new ArrayList<UserProviderRelation>();
		
		while(result.next()){
			UserProviderRelation upr = getRelationFromResult(result);
			uprs.add(upr);
		}
		return uprs;
		
	}

	@Override
	public UserProviderRelation create(UserProviderRelation entity)
			throws Exception {
		UserProviderRelation userProviderRelation = entity;
		CallableStatement csUserProviderRelation= this.conn.prepareCall(INSERT_RELATION);
		int idx=1;
		csUserProviderRelation.setLong(idx++, userProviderRelation.getUser().getId());
		csUserProviderRelation.setLong(idx++, userProviderRelation.getProvider().getId());
		csUserProviderRelation.setString(idx++, userProviderRelation.getProvider().getName());
		csUserProviderRelation.setString(idx++, userProviderRelation.getUser().getFirstname());
		csUserProviderRelation.setString(idx++, userProviderRelation.getUser().getLastname());
		csUserProviderRelation.setString(idx++, Character.toString(userProviderRelation.getUser().getType().Value));
		csUserProviderRelation.setString(idx++, userProviderRelation.getUser().getDoctortype());
		csUserProviderRelation.setString(idx++, Character.toString(userProviderRelation.getProvider().getType().Value));
		csUserProviderRelation.setString(idx++, userProviderRelation.getUser().getUsername());
		csUserProviderRelation.setLong(idx++, this.getCurrentUserId());
		csUserProviderRelation.registerOutParameter(idx, java.sql.Types.BIGINT);
		csUserProviderRelation.execute();
		long id = csUserProviderRelation.getLong(idx);
		userProviderRelation.setId(id);
		return userProviderRelation;
	}

	@Override
	public UserProviderRelation update(UserProviderRelation entity)
			throws Exception {
		throw new NotImplemented();
	}

	@Override
	public UserProviderRelation remove(long id) throws Exception {
		CallableStatement csUser = this.conn.prepareCall(DELETE_RELATION);
		int idx=1;
		csUser.setLong(idx, id);
		csUser.execute();
		return null;
	}
	
	static UserProviderRelation getRelationFromResult(ResultSet result) throws SQLException{
		UserProviderRelation upr = new UserProviderRelation();
		upr.setId(result.getLong(ID));
		User user = new User();
		user.setId(result.getLong(USERID));
		user.setUsername(result.getString(USERNAME));
		user.setFirstname(result.getString(USERFIRSTNAME));
		user.setLastname(result.getString(USERLASTNAME));
		UserType userType = UserType.getUserType(result.getString(USERTYPE).charAt(0));
		user.setType(userType);
		user.setDoctortype(result.getString(DOCTORTYPE));
		upr.setUser(user);
		
		Provider provider = new Provider();
		provider.setId(result.getLong(PROVIDERID));
		provider.setName(result.getString(PROVIDERNAME));
		ProviderType providerType = ProviderType.getProviderType(result.getString(PROVIDERTYPE).charAt(0));
		provider.setType(providerType);
		upr.setProvider(provider);
		
		User createdUser = new User();
		createdUser.setId(result.getLong(CREATEDBY));
		upr.setCreateBy(createdUser);
		upr.setCreateDate(LocalDateTime.fromDateFields(result.getDate(CREATEDAT)));
		
		User modifiedUser = new User();
		modifiedUser.setId(result.getLong(LASTMODIFIEDBY));
		upr.setLastModifiedBy(modifiedUser);
		upr.setLastModifiedDate(LocalDateTime.fromDateFields(result.getDate(LASTMODIFITEDAT)));
		
		return upr;
	}


}
