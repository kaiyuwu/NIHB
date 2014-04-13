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
import com.nihb.common.entity.User;
import com.nihb.common.helper.Address;
import com.nihb.common.helper.RoleMetricsType;
import com.nihb.common.helper.Status;
import com.nihb.common.helper.UserType;
import com.nihb.resource.ErrorMessages;

/**
 * @author kaiwu
 *
 */
public class UserDao extends AbstractDataAccess<User> {

	public static final String USERNAME = "username"; 
	public static final String FIRSTNAME = "firstname"; 
	public static final String LASTNAME = "lastname"; 
	public static final String TYPE = "type"; 
	public static final String PASSWORD = "password"; 
	public static final String EMAIL = "email"; 
	public static final String WEBSITE = "website"; 
	public static final String WORKPHONE = "workphone"; 
	public static final String CELLPHONE = "cellphone"; 
	public static final String COMMENTS = "comments"; 
	public static final String MAIL_ADDRESS1 = "mail_addr1"; 
	public static final String MAIL_ADDRESS2 = "mail_addr2"; 
	public static final String MAIL_UNIT = "mail_unit"; 
	public static final String MAIL_CITY = "mail_city"; 
	public static final String MAIL_PROVINCE = "mail_province"; 
	public static final String MAIL_COUNTRY = "mail_country"; 
	public static final String MAIL_POSTALCODE = "mail_postalcode"; 
	public static final String MAIL_PHONE = "mail_phone"; 
	public static final String BILL_ADDRESS1 = "bill_addr1"; 
	public static final String BILL_ADDRESS2 = "bill_addr2"; 
	public static final String BILL_UNIT = "bill_unit"; 
	public static final String BILL_CITY = "bill_city"; 
	public static final String BILL_PROVINCE = "bill_province"; 
	public static final String BILL_COUNTRY = "bill_country"; 
	public static final String BILL_POSTALCODE = "bill_postalcode"; 
	public static final String BILL_PHONE = "bill_phone"; 
	public static final String DOCTORTYPE = "doctortype"; 
	public static final String DOCTORLICENSE = "doctorlicense"; 
	public static final String NEWCLAIM = "canNewClaim"; 
	public static final String APPROVEINJURY = "canApproveInjury"; 
	public static final String EXAM = "canExam"; 
	public static final String APPROVEEXAM = "canApproveExam"; 
	public static final String GLASSES = "canGlasses"; 
	public static final String APPROVEGLASSES = "canApproveGlasses"; 
	public static final String PAYABLE = "canPayable"; 
	public static final String CRUDDOCTOR = "canCRUDDoctor"; 
	public static final String CRUDPROVIDER = "canCRUDProvider"; 
	public static final String ADDDOCTORTOPROVIDER = "canAddDoctorToProvider"; 
	public static final String CRUDNIHBUSER = "canCRUDNihbUser"; 
	
	
	static final String FIND_BY_ID="{call GetUserInfo(?)}";
	static final String FIND_BY_USERNAME="{CALL GetUserLoginInfo(?)}";
	static final String INSERT_USER="{CALL InsertUserInfo("
			 + "?," //	username		 VARCHAR(30),
			 + "?," //	firstname		 VARCHAR(50),
			 + "?," //	lastname		 VARCHAR(50),
			 + "?," //	type		 	 CHAR(1),
			 + "?," //	password		 VARCHAR(50),
			 + "?," //	email			 VARCHAR(50),
			 + "?," //	website			 VARCHAR(50),
			 + "?," //	status			 CHAR(1),
			 + "?," //	workphone		 VARCHAR(50),
			 + "?," //	cellphone		 VARCHAR(50),
			 + "?," //	comments		 VARCHAR(200),
			 + "?," //	mail_addr1		 VARCHAR(50),
			 + "?," //	mail_addr2		 VARCHAR(50),
			 + "?," //	mail_unit		 VARCHAR(10),
			 + "?," //	mail_city		 VARCHAR(50),
			 + "?," //	mail_province	 CHAR(2),
			 + "?," //	mail_country	 VARCHAR(50),
			 + "?," //	mail_postalcode	 VARCHAR(10),
			 + "?," //	mail_phone		 VARCHAR(50),
			 + "?," //	bill_addr1		 VARCHAR(50),
			 + "?," //	bill_addr2		 VARCHAR(50),
			 + "?," //	bill_unit		 VARCHAR(10),
			 + "?," //	bill_city		 VARCHAR(50),
			 + "?," //	bill_province	 CHAR(2),
			 + "?," //	bill_country	 VARCHAR(50),
			 + "?," //	bill_postalcode	 VARCHAR(10),
			 + "?," //	bill_phone		 VARCHAR(50),
			 + "?," //	doctortype		 CHAR(1),
			 + "?," //	doctorlicense	 VARCHAR(50),
			 + "?," //	canNewClaim		 TINYINT (1),
			 + "?," //	canApproveInjury TINYINT (1),
			 + "?," //	canExam		 	 TINYINT (1),
			 + "?," //	canApproveExam	 TINYINT (1),
			 + "?," //	canGlasses		 TINYINT (1),
			 + "?," //	canApproveGlasses TINYINT (1),
			 + "?," //	canPayable		 TINYINT (1),
			 + "?," //	canCRUDDoctor	 TINYINT (1),
			 + "?," //	canCRUDProvider	 TINYINT (1),
			 + "?," //	canAddDoctorToProvider TINYINT (1),
			 + "?," //	canCRUDNihbUser	 TINYINT (1),
			 + "?," //	createdby		 BIGINT,
			 + "?"  //  OUT id 			 BIGINT)
			 +")}";

	
	static final String CHANGE_PASSWORD = "{CALL ChangeUserPassword("
			+ "?,"//id 			BIGINT,
			+ "?," //password	VARCHAR(50),
			+ "?"//modifiedby  BIGINT
			+ ")}";
	static final String CHANGE_STATUS = "{CALL ChangeUserStatus("
			+ "?,"//id 			BIGINT,
			+ "?," //status 	CHAR(1),
			+ "?"//modifiedby  BIGINT
			+ ")}";
			
		    
	static final String UPDATE_USER="{CALL UpdateUserInfo("
	 + "?," //	id				 BIGINT,
	 + "?," //	firstname		 VARCHAR(50),
	 + "?," //	lastname		 VARCHAR(50),
	 + "?," //	type		 	 CHAR(1),
	 + "?," //	password		 VARCHAR(50),
	 + "?," //	email			 VARCHAR(50),
	 + "?," //	website			 VARCHAR(50),
	 + "?," //	status			 CHAR(1),
	 + "?," //	workphone		 VARCHAR(50),
	 + "?," //	cellphone		 VARCHAR(50),
	 + "?," //	comments		 VARCHAR(200),
	 + "?," //	mail_addr1		 VARCHAR(50),
	 + "?," //	mail_addr2		 VARCHAR(50),
	 + "?," //	mail_unit		 VARCHAR(10),
	 + "?," //	mail_city		 VARCHAR(50),
	 + "?," //	mail_province	 CHAR(2),
	 + "?," //	mail_country	 VARCHAR(50),
	 + "?," //	mail_postalcode	 VARCHAR(10),
	 + "?," //	mail_phone		 VARCHAR(50),
	 + "?," //	bill_addr1		 VARCHAR(50),
	 + "?," //	bill_addr2		 VARCHAR(50),
	 + "?," //	bill_unit		 VARCHAR(10),
	 + "?," //	bill_city		 VARCHAR(50),
	 + "?," //	bill_province	 CHAR(2),
	 + "?," //	bill_country	 VARCHAR(50),
	 + "?," //	bill_postalcode	 VARCHAR(10),
	 + "?," //	bill_phone		 VARCHAR(50),
	 + "?," //	doctortype		 CHAR(1),
	 + "?," //	doctorlicense	 VARCHAR(50),
	 + "?," //	canNewClaim		 TINYINT (1),
	 + "?," //	canApproveInjury TINYINT (1),
	 + "?," //	canExam		 	 TINYINT (1),
	 + "?," //	canApproveExam	 TINYINT (1),
	 + "?," //	canGlasses		 TINYINT (1),
	 + "?," //	canApproveGlasses TINYINT (1),
	 + "?," //	canPayable		 TINYINT (1),
	 + "?," //	canCRUDDoctor	 TINYINT (1),
	 + "?," //	canCRUDProvider	 TINYINT (1),
	 + "?," //	canAddDoctorToProvider TINYINT (1),
	 + "?," //	canCRUDNihbUser	 TINYINT (1),
	 + "?" //	modifiedby		 BIGINT,
	 +")}";
	
	
	public UserDao(Connection conn) throws SQLException {
		super(conn);
	}

	@Override
	public List<User> findAll() throws Exception {
		throw new NotImplemented();
	}

	@Override
	public List<User> findAllBy(String queryCondition) throws Exception {
		throw new NotImplemented();
	}

	@Override
	public User findById(long id) throws Exception {
		User user = new User();
		user.setId(id);

		CallableStatement cs = this.conn.prepareCall(FIND_BY_ID);
		cs.setLong(1, id);
		ResultSet result = cs.executeQuery();
			

		if(result.next()){
			user = getUserFromResult(result);
		}else{
			List<String> errors = new ArrayList<String>();
			errors.add(String.format(ErrorMessages.NO_RECORD_FOUND_BY_ID, id));
			user.setErrorList(errors);
		}
		return user;

	}

	@Override
	public User create(User entity) throws Exception {
		User user = entity;
		CallableStatement csUser = this.conn.prepareCall(INSERT_USER);
		int idx=1;
		csUser.setString(idx++, user.getUsername());
		csUser.setString(idx++, user.getFirstname());
		csUser.setString(idx++, user.getLastname());
		csUser.setString(idx++, Character.toString(user.getType().Value));
		csUser.setString(idx++, user.getPassword());
		csUser.setString(idx++, user.getEmail());
		csUser.setString(idx++, user.getWebsite());
		csUser.setString(idx++, Character.toString(user.getStatus().Value));
		csUser.setString(idx++, user.getWorkphone());
		csUser.setString(idx++, user.getCellphone());
		csUser.setString(idx++, user.getComments());
		csUser.setString(idx++, user.getMailAddress().getAddr1());
		csUser.setString(idx++, user.getMailAddress().getAddr2());
		csUser.setString(idx++, user.getMailAddress().getUnit());
		csUser.setString(idx++, user.getMailAddress().getCity());
		csUser.setString(idx++, user.getMailAddress().getProvince());
		csUser.setString(idx++, user.getMailAddress().getCountry());
		csUser.setString(idx++, user.getMailAddress().getPostalcode());
		csUser.setString(idx++, user.getMailAddress().getPhone());
		csUser.setString(idx++, user.getBillAddress().getAddr1());
		csUser.setString(idx++, user.getBillAddress().getAddr2());
		csUser.setString(idx++, user.getBillAddress().getUnit());
		csUser.setString(idx++, user.getBillAddress().getCity());
		csUser.setString(idx++, user.getBillAddress().getProvince());
		csUser.setString(idx++, user.getBillAddress().getCountry());
		csUser.setString(idx++, user.getBillAddress().getPostalcode());
		csUser.setString(idx++, user.getBillAddress().getPhone());
		csUser.setString(idx++, user.getDoctortype());
		csUser.setString(idx++, user.getDoctorlicense());
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.CREATE_CLAIM));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.APPROVE_INJURY));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.EXAM));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.APPROVE_EXAM));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.GLASSES));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.APPROVE_GLASSES));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.PAYABLE));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.CRUD_DOCTOR));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.CRUD_PROVIDER));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.ADD_DOCTOR_TO_PROVIDER));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.CRUN_NIHB_USER));
		csUser.setLong(idx++, this.getCurrentUserId());
		csUser.registerOutParameter(idx, java.sql.Types.BIGINT);
		csUser.execute();
		long uid = csUser.getLong(idx);
		user.setId(uid);
		return user;
	}

	@Override
	public User update(User entity) throws Exception {
		User user = entity;
		CallableStatement csUser = this.conn.prepareCall(UPDATE_USER);
		int idx=1;
		csUser.setLong(idx++, user.getId());
		csUser.setString(idx++, user.getFirstname());
		csUser.setString(idx++, user.getLastname());
		csUser.setString(idx++, Character.toString(user.getType().Value));
		csUser.setString(idx++, user.getPassword());
		csUser.setString(idx++, user.getEmail());
		csUser.setString(idx++, user.getWebsite());
		csUser.setString(idx++, Character.toString(user.getStatus().Value));
		csUser.setString(idx++, user.getWorkphone());
		csUser.setString(idx++, user.getCellphone());
		csUser.setString(idx++, user.getComments());
		csUser.setString(idx++, user.getMailAddress().getAddr1());
		csUser.setString(idx++, user.getMailAddress().getAddr2());
		csUser.setString(idx++, user.getMailAddress().getUnit());
		csUser.setString(idx++, user.getMailAddress().getCity());
		csUser.setString(idx++, user.getMailAddress().getProvince());
		csUser.setString(idx++, user.getMailAddress().getCountry());
		csUser.setString(idx++, user.getMailAddress().getPostalcode());
		csUser.setString(idx++, user.getMailAddress().getPhone());
		csUser.setString(idx++, user.getBillAddress().getAddr1());
		csUser.setString(idx++, user.getBillAddress().getAddr2());
		csUser.setString(idx++, user.getBillAddress().getUnit());
		csUser.setString(idx++, user.getBillAddress().getCity());
		csUser.setString(idx++, user.getBillAddress().getProvince());
		csUser.setString(idx++, user.getBillAddress().getCountry());
		csUser.setString(idx++, user.getBillAddress().getPostalcode());
		csUser.setString(idx++, user.getBillAddress().getPhone());
		csUser.setString(idx++, user.getDoctortype());
		csUser.setString(idx++, user.getDoctorlicense());
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.CREATE_CLAIM));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.APPROVE_INJURY));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.EXAM));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.APPROVE_EXAM));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.GLASSES));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.APPROVE_GLASSES));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.PAYABLE));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.CRUD_DOCTOR));
		csUser.setBoolean(idx++, user.hasRole(RoleMetricsType.CRUD_PROVIDER));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.ADD_DOCTOR_TO_PROVIDER));
		csUser.setBoolean(idx++,  user.hasRole(RoleMetricsType.CRUN_NIHB_USER));
		csUser.setLong(idx++, this.getCurrentUserId());

		csUser.execute();
		
		return user;
	}

	@Override
	public User remove(long id) throws Exception {
		User user = findById(id);
		CallableStatement csUser = this.conn.prepareCall(CHANGE_STATUS);
		int idx=1;
		csUser.setLong(idx++, id);
		csUser.setString(idx++, Character.toString(Status.INACTIVE.Value));
		csUser.setLong(idx,this.currentuserid);
		csUser.execute();
		user.setStatus(Status.INACTIVE);
		return user;
	}
	
	public User changePassword(User entity) throws Exception{
		User user = entity;
		CallableStatement csUser = this.conn.prepareCall(CHANGE_PASSWORD);
		int idx=1;
		csUser.setLong(idx++, user.getId());
		csUser.setString(idx++, user.getPassword());
		csUser.setLong(idx,this.currentuserid);
		csUser.execute();
		return user;
		
	}
	
	public User findByUserName(String username) throws Exception{
		
		User user = new User();
		CallableStatement cs = this.conn.prepareCall(FIND_BY_USERNAME);
		cs.setString(1, username);
		ResultSet result = cs.executeQuery();
		

		if(result.next()){
			user = getUserFromResult(result);
		}else{
			List<String> errors = new ArrayList<String>();
			errors.add(String.format(ErrorMessages.NO_RECORD_FOUND_BY_USERNAME, username));
			user.setErrorList(errors);
		}
			
		return user;

	}
	
	
	static User getUserFromResult(ResultSet result) throws SQLException{
		User user = new User();
		user.setId(result.getLong(ID));
		UserType userType = UserType.getUserType(result.getString(TYPE).charAt(0));
		user.setType(userType);
		user.setUsername(result.getString(USERNAME));
		Status status = Status.getStatus(result.getString(STATUS).charAt(0));
		user.setStatus(status);
		user.setPassword(PASSWORD);
//		if(!forLogin){
			user.setFirstname(result.getString(FIRSTNAME));
			user.setLastname(result.getString(LASTNAME));
			user.setEmail(result.getString(EMAIL));
			user.setWebsite(result.getString(WEBSITE));
			user.setWorkphone(result.getString(WORKPHONE));
			user.setCellphone(result.getString(CELLPHONE));
			user.setComments(result.getString(COMMENTS));
			
			Address mailAddress = new Address();
			mailAddress.setAddr1(MAIL_ADDRESS1);
			mailAddress.setAddr2(MAIL_ADDRESS2);
			mailAddress.setUnit(MAIL_UNIT);
			mailAddress.setCity(MAIL_CITY);
			mailAddress.setProvince(MAIL_PROVINCE);
			mailAddress.setPostalcode(MAIL_POSTALCODE);
			mailAddress.setCountry(MAIL_COUNTRY);
			mailAddress.setPhone(MAIL_PHONE);
			user.setMailAddress(mailAddress);
			
			Address billAddress = new Address();
			billAddress.setAddr1(BILL_ADDRESS1);
			billAddress.setAddr2(BILL_ADDRESS2);
			billAddress.setUnit(BILL_UNIT);
			billAddress.setCity(BILL_CITY);
			billAddress.setProvince(BILL_PROVINCE);
			billAddress.setPostalcode(BILL_POSTALCODE);
			billAddress.setCountry(BILL_COUNTRY);
			billAddress.setPhone(BILL_PHONE);
			user.setMailAddress(mailAddress);

			user.setDoctortype(result.getString(DOCTORTYPE));
			user.setDoctorlicense(result.getString(DOCTORLICENSE));
			
			user.setRole(RoleMetricsType.CREATE_CLAIM,result.getBoolean(NEWCLAIM));
			user.setRole(RoleMetricsType.APPROVE_INJURY, result.getBoolean(APPROVEINJURY));
			user.setRole(RoleMetricsType.EXAM, result.getBoolean(EXAM));
			user.setRole(RoleMetricsType.APPROVE_EXAM, result.getBoolean(APPROVEEXAM));
			user.setRole(RoleMetricsType.GLASSES,result.getBoolean(GLASSES));
			user.setRole(RoleMetricsType.APPROVE_GLASSES, result.getBoolean(APPROVEGLASSES));
			user.setRole(RoleMetricsType.PAYABLE, result.getBoolean(PAYABLE));
			user.setRole(RoleMetricsType.CRUD_DOCTOR,result.getBoolean(CRUDDOCTOR) );
			user.setRole(RoleMetricsType.CRUD_PROVIDER, result.getBoolean(CRUDPROVIDER));
			user.setRole(RoleMetricsType.ADD_DOCTOR_TO_PROVIDER, result.getBoolean(ADDDOCTORTOPROVIDER));
			user.setRole(RoleMetricsType.CRUN_NIHB_USER, result.getBoolean(CRUDNIHBUSER));
	
			User createdUser = new User();
			createdUser.setId(result.getLong(CREATEDBY));
			user.setCreateBy(createdUser);
			user.setCreateDate(LocalDateTime.fromDateFields(result.getDate(CREATEDAT)));
			User modifiedUser = new User();
			modifiedUser.setId(result.getLong(LASTMODIFIEDBY));
			user.setLastModifiedBy(modifiedUser);
			user.setLastModifiedDate(LocalDateTime.fromDateFields(result.getDate(LASTMODIFITEDAT)));
			
//		}
		return user;
	}
	
}
