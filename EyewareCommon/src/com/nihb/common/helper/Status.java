package com.nihb.common.helper;

public enum Status {
	//User and provider status 
	ACTIVE('A'),
	INACTIVE('I'),
	DELETED('D'),
	//Payment status 
	PAID('P'),
	NOT_PAIP('N'),
	PENDING('W'),
	APPROVED('V'),
	//Claim state status
	INJURY_PENDING('1'),
	REJECTED('2'),
	EXAM_APPROVED('3'),
	EXAM_AMOUNT_PENDING('4'),
	GLASSES_APPROVED('5'),
	GLASSES_AMOUNT_PENDING('6'),
	PAYMENT_PENDING('7'),
	PAYMENT_EXAM_ONLY('8'),
	PAYMENT_GLASSES_ONLY('9'),
	PAYMENT_PAIP('M');

	
	

	
	public final char Value;
	
	private Status(char val){
		Value = val;
	}
	
	public static Status getStatus(char ch){
		for(Status st: Status.values()){
			if(ch == st.Value)return st;
		}
		return null;
	}
	
	public static Status getStatus(String str){
		switch(str.toUpperCase()){
		case "PENDING":
			return Status.PENDING;
		case "REJECTED":
			return Status.REJECTED;
		case "APPROVED":
			return Status.APPROVED;
		default: 
				return null;
		}
	}
	
	public static String getName(char val){
		switch(val){
		case 'W':
		case 'w':
			return Status.PENDING.name();
		case 'R':
		case 'r':
			return Status.REJECTED.name();
		case 'A':
		case 'a':
			return Status.APPROVED.name();
		default:
			return null;
		}
	}
}
