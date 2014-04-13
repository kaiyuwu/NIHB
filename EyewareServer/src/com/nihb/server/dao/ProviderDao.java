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
import com.nihb.common.helper.Address;
import com.nihb.common.helper.ProviderType;
import com.nihb.common.helper.Status;
import com.nihb.resource.ErrorMessages;

/**
 * @author kaiwu
 *
 */
public class ProviderDao extends AbstractDataAccess<Provider> {
	

	public static final String NAME="name";
	public static final String TYPE = "type"; 
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

	
	static final String FIND_BY_ID="{call GetProviderInfo(?)}";

	static final String INSERT_PROVIDER="{CALL InsertProviderInfo("
			 + "?," //	name		 VARCHAR(50),
			 + "?," //	type		 	 CHAR(1),
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
			 + "?," //	createdby		 BIGINT,
			 + "?"  //  OUT id 			 BIGINT)
			 +")}";

	static final String UPDATE_PROVIDER="{CALL UpdateProviderInfo("
			 + "?," //	id		 BIGINT,
 			 + "?," //	name		 VARCHAR(50),
			 + "?," //	type		 	 CHAR(1),
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
			 + "?" //	modifiedby		 BIGINT,
			 +")}";
			
	static final String CHANGE_STATUS = "{CALL ChangeProviderStatus("
			+ "?,"//id 			BIGINT,
			+ "?," //status 	CHAR(1),
			+ "?"//modifiedby  BIGINT
			+ ")}";
			


	public ProviderDao(Connection conn) throws SQLException {
		super(conn);
	}

	@Override
	public List<Provider> findAll() throws Exception {
		throw new NotImplemented();
	}

	@Override
	public List<Provider> findAllBy(String queryCondition) throws Exception {
		throw new NotImplemented();
	}

	@Override
	public Provider findById(long id) throws Exception {
		Provider provider = new Provider();
		provider.setId(id);

		CallableStatement cs = this.conn.prepareCall(FIND_BY_ID);
		cs.setLong(1, id);
		ResultSet result = cs.executeQuery();
			

		if(result.next()){
			provider = getProviderFromResult(result);
		}else{
			List<String> errors = new ArrayList<String>();
			errors.add(String.format(ErrorMessages.NO_RECORD_FOUND_BY_ID, id));
			provider.setErrorList(errors);
		}
		return provider;

	}

	@Override
	public Provider create(Provider entity) throws Exception {

		Provider provider = entity;
		CallableStatement csProvider = this.conn.prepareCall(INSERT_PROVIDER);
		int idx=1;
		csProvider.setString(idx++, provider.getName());
		csProvider.setString(idx++, Character.toString(provider.getType().Value));
		csProvider.setString(idx++, provider.getEmail());
		csProvider.setString(idx++, provider.getWebsite());
		csProvider.setString(idx++, Character.toString(provider.getStatus().Value));
		csProvider.setString(idx++, provider.getWorkphone());
		csProvider.setString(idx++, provider.getCellphone());
		csProvider.setString(idx++, provider.getComments());
		csProvider.setString(idx++, provider.getMailAddress().getAddr1());
		csProvider.setString(idx++, provider.getMailAddress().getAddr2());
		csProvider.setString(idx++, provider.getMailAddress().getUnit());
		csProvider.setString(idx++, provider.getMailAddress().getCity());
		csProvider.setString(idx++, provider.getMailAddress().getProvince());
		csProvider.setString(idx++, provider.getMailAddress().getCountry());
		csProvider.setString(idx++, provider.getMailAddress().getPostalcode());
		csProvider.setString(idx++, provider.getMailAddress().getPhone());
		csProvider.setString(idx++, provider.getBillAddress().getAddr1());
		csProvider.setString(idx++, provider.getBillAddress().getAddr2());
		csProvider.setString(idx++, provider.getBillAddress().getUnit());
		csProvider.setString(idx++, provider.getBillAddress().getCity());
		csProvider.setString(idx++, provider.getBillAddress().getProvince());
		csProvider.setString(idx++, provider.getBillAddress().getCountry());
		csProvider.setString(idx++, provider.getBillAddress().getPostalcode());
		csProvider.setString(idx++, provider.getBillAddress().getPhone());
		csProvider.setLong(idx++, this.getCurrentUserId());
		csProvider.registerOutParameter(idx, java.sql.Types.BIGINT);
		csProvider.execute();
		long pid = csProvider.getLong(idx);
		provider.setId(pid);
		return provider;
	}

	@Override
	public Provider update(Provider entity) throws Exception {

		Provider provider = entity;
		CallableStatement csProvider = this.conn.prepareCall(UPDATE_PROVIDER);
		int idx=1;
		csProvider.setLong(idx++, provider.getId());
		csProvider.setString(idx++, provider.getName());
		csProvider.setString(idx++, Character.toString(provider.getType().Value));
		csProvider.setString(idx++, provider.getEmail());
		csProvider.setString(idx++, provider.getWebsite());
		csProvider.setString(idx++, Character.toString(provider.getStatus().Value));
		csProvider.setString(idx++, provider.getWorkphone());
		csProvider.setString(idx++, provider.getCellphone());
		csProvider.setString(idx++, provider.getComments());
		csProvider.setString(idx++, provider.getMailAddress().getAddr1());
		csProvider.setString(idx++, provider.getMailAddress().getAddr2());
		csProvider.setString(idx++, provider.getMailAddress().getUnit());
		csProvider.setString(idx++, provider.getMailAddress().getCity());
		csProvider.setString(idx++, provider.getMailAddress().getProvince());
		csProvider.setString(idx++, provider.getMailAddress().getCountry());
		csProvider.setString(idx++, provider.getMailAddress().getPostalcode());
		csProvider.setString(idx++, provider.getMailAddress().getPhone());
		csProvider.setString(idx++, provider.getBillAddress().getAddr1());
		csProvider.setString(idx++, provider.getBillAddress().getAddr2());
		csProvider.setString(idx++, provider.getBillAddress().getUnit());
		csProvider.setString(idx++, provider.getBillAddress().getCity());
		csProvider.setString(idx++, provider.getBillAddress().getProvince());
		csProvider.setString(idx++, provider.getBillAddress().getCountry());
		csProvider.setString(idx++, provider.getBillAddress().getPostalcode());
		csProvider.setString(idx++, provider.getBillAddress().getPhone());
		csProvider.setLong(idx++, this.getCurrentUserId());

		csProvider.execute();
		
		return provider;
	}

	@Override
	public Provider remove(long id) throws Exception {
		Provider provider = findById(id);
		CallableStatement csProvider = this.conn.prepareCall(CHANGE_STATUS);
		int idx=1;
		csProvider.setLong(idx++, id);
		csProvider.setString(idx++, Character.toString(Status.INACTIVE.Value));
		csProvider.setLong(idx,this.getCurrentUserId());
		csProvider.execute();
		provider.setStatus(Status.INACTIVE);
		return provider;
	}
	
	
	
	static Provider getProviderFromResult(ResultSet result) throws SQLException{
		Provider provider = new Provider();
		provider.setId(result.getLong(ID));
		ProviderType providerType = ProviderType.getProviderType(result.getString(TYPE).charAt(0));
		provider.setType(providerType);
		provider.setName(result.getString(NAME));
		Status status = Status.getStatus(result.getString(STATUS).charAt(0));
		provider.setStatus(status);
		provider.setEmail(result.getString(EMAIL));
		provider.setWebsite(result.getString(WEBSITE));
		provider.setWorkphone(result.getString(WORKPHONE));
		provider.setCellphone(result.getString(CELLPHONE));
		provider.setComments(result.getString(COMMENTS));
		
		Address mailAddress = new Address();
		mailAddress.setAddr1(MAIL_ADDRESS1);
		mailAddress.setAddr2(MAIL_ADDRESS2);
		mailAddress.setUnit(MAIL_UNIT);
		mailAddress.setCity(MAIL_CITY);
		mailAddress.setProvince(MAIL_PROVINCE);
		mailAddress.setPostalcode(MAIL_POSTALCODE);
		mailAddress.setCountry(MAIL_COUNTRY);
		mailAddress.setPhone(MAIL_PHONE);
		provider.setMailAddress(mailAddress);
		
		Address billAddress = new Address();
		billAddress.setAddr1(BILL_ADDRESS1);
		billAddress.setAddr2(BILL_ADDRESS2);
		billAddress.setUnit(BILL_UNIT);
		billAddress.setCity(BILL_CITY);
		billAddress.setProvince(BILL_PROVINCE);
		billAddress.setPostalcode(BILL_POSTALCODE);
		billAddress.setCountry(BILL_COUNTRY);
		billAddress.setPhone(BILL_PHONE);
		provider.setMailAddress(mailAddress);


		User createdUser = new User();
		createdUser.setId(result.getLong(CREATEDBY));
		provider.setCreateBy(createdUser);
		provider.setCreateDate(LocalDateTime.fromDateFields(result.getDate(CREATEDAT)));
		User modifiedUser = new User();
		modifiedUser.setId(result.getLong(LASTMODIFIEDBY));
		provider.setLastModifiedBy(modifiedUser);
		provider.setLastModifiedDate(LocalDateTime.fromDateFields(result.getDate(LASTMODIFITEDAT)));
		return provider;
	}


}
