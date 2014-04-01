package com.nihb.server.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import com.nihb.resource.DataBaseConfig;

public class ConnectionPool {
	
	
	private volatile static ConnectionPool eyewareConnectionPool = null;
	private volatile static ConnectionPool pharmacyConnectionPool = null;
	private BasicDataSource eyewareDataSource;
	private BasicDataSource pharmacyDataSource;
	
	
	private ConnectionPool(){
		eyewareDataSource =  new BasicDataSource();

		eyewareDataSource.setDriverClassName(DataBaseConfig.DRIVER_CLASS_NAME);
		eyewareDataSource.setUrl(DataBaseConfig.URL);
		eyewareDataSource.setUsername(DataBaseConfig.USERNAME);
		eyewareDataSource.setPassword(DataBaseConfig.PASSWORD);
		
		eyewareDataSource.setMaxActive(DataBaseConfig.CONNECTION_POOL_MAX_ACTIVE);
		eyewareDataSource.setMaxWait(DataBaseConfig.CONNECTION_POOL_MAX_WAIT);
		eyewareDataSource.setMaxIdle(DataBaseConfig.CONNECTION_POOL_MAX_IDLE);

		
		pharmacyDataSource = new BasicDataSource();
		
		pharmacyDataSource.setDriverClassName(DataBaseConfig.DRIVER_CLASS_NAME);
		pharmacyDataSource.setUrl(DataBaseConfig.URL);
		pharmacyDataSource.setUsername(DataBaseConfig.USERNAME);
		pharmacyDataSource.setPassword(DataBaseConfig.PASSWORD);
		
		pharmacyDataSource.setMaxActive(DataBaseConfig.CONNECTION_POOL_MAX_ACTIVE);
		pharmacyDataSource.setMaxWait(DataBaseConfig.CONNECTION_POOL_MAX_WAIT);
		pharmacyDataSource.setMaxIdle(DataBaseConfig.CONNECTION_POOL_MAX_IDLE);
		

	}

	public static ConnectionPool getEyewareConnectionPoolInstance(){
		if(null == eyewareConnectionPool){
			synchronized (ConnectionPool.class) {
				if(null == eyewareConnectionPool){
					eyewareConnectionPool = new ConnectionPool();
				}
			}
		}
		return eyewareConnectionPool;
	}
	
	public static ConnectionPool getPharmacyConnectionPoolInstance(){
		if(null == pharmacyConnectionPool){
			synchronized (ConnectionPool.class) {
				if(null == pharmacyConnectionPool){
					pharmacyConnectionPool = new ConnectionPool();
				}
			}
		}
		return pharmacyConnectionPool;
	}
	
	
	public Connection getEyewareConnection() throws SQLException{
		return eyewareDataSource.getConnection();
	}
	
	public Connection getPharmacyConnection() throws SQLException{
		return pharmacyDataSource.getConnection();
	}
}
