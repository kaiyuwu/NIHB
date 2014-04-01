package com.nihb.server.model;

import java.util.ArrayList;
import java.util.List;

import com.nihb.common.entity.User;
import com.nihb.server.dao.DataAccessType;
import com.nihb.server.dao.UserDao;
import com.nihb.resource.ErrorMessages;

public class UserModel extends AbstractModel<UserDao, User>{

	public UserModel(){
		super(DataAccessType.USER);
	}
	
	public User changePassword(User user) throws Exception{
		this.initDao();
		User ur = this.dao.changePassword(user);
		this.closeDao();
		return ur;
	}
	
	public User login(String username, String password) throws Exception{
		User user = new User();
		this.initDao();
		user = this.dao.findByUserName(username);
		
		if(null == user){
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setErrorList(getLoginErrors());
			return user;
		}
		
		if(!user.getPassword().equals(password)){
			user.setErrorList(getLoginErrors());
		}
		this.closeDao();
		return user;
		
	}
	
	private static List<String> errors =null;
	private static List<String> getLoginErrors(){
		if(null==errors){
			errors = new ArrayList<String>();
			errors.add(ErrorMessages.LOGIN_ERROR);
		}
		
		return errors;
		
	}


}
