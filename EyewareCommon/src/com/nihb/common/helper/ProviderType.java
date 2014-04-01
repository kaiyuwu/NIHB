package com.nihb.common.helper;

public enum ProviderType {
	NIHB('A'),
	PROVIDER('P');
	
	public final char Value;
	
	private ProviderType(char val){
		Value = val;
	}

	
	public static ProviderType getProviderType(char ch){
		for(ProviderType ut : ProviderType.values()){
			if(ch == ut.Value)return ut;
		}
		return null;
	}

}
