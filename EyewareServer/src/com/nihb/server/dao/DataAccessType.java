/**
 * 
 */
package com.nihb.server.dao;

/**
 * @author kaiwu
 *
 */
public enum DataAccessType {
	USER(1),
	PROVIDER(2),
	USERPROVIDER(3),
	CLAIM(4),
	MEMBER(5);
	
	
	public final int Value;
	private DataAccessType(int value){
		this.Value = value;
	}

}
