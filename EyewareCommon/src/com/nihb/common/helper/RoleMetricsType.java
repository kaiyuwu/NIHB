package com.nihb.common.helper;

public enum RoleMetricsType {
	CREATE_CLAIM ("Create Claim"),
	APPROVE_INJURY ("Injury Approval"),
	EXAM("Exam"),
	APPROVE_EXAM("Exam Approval"),
	GLASSES("Glasses"),
	APPROVE_GLASSES("Glasses Approval"),
	PAYABLE("Acounting Payable"),
	CRUD_DOCTOR("Doctor Edit"),
	CRUD_PROVIDER("Provider Edit"),
	ADD_DOCTOR_TO_PROVIDER("Manage Provider Doctor List"),
	CRUN_NIHB_USER("NIHB User Edit"),
	VIEW_MEMBER("View Member info");
	
	public final String Value;
	
	private RoleMetricsType(String value) {
		Value = value;
	}

}
