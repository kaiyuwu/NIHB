package com.nihb.common.helper;

public enum UserType {
	ADMIN('A'),
	NIHB('N'),
	PROVIDERADMIN('P'),
	DOCTOR('D');
	
	public final char Value;
	
	private UserType(char val){
		Value = val;
	}

	
	public static UserType getUserType(char ch){
		for(UserType ut : UserType.values()){
			if(ch == ut.Value)return ut;
		}
		return null;
	}
}
