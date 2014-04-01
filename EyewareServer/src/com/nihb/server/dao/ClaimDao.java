/**
 * 
 */
package com.nihb.server.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nihb.common.entity.Claim;

/**
 * @author kaiwu
 *
 */
public class ClaimDao extends AbstractDataAccess<Claim> {

	public ClaimDao(Connection conn) throws SQLException {
		super(conn);
	}

	@Override
	public List<Claim> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claim> findAllBy(String queryCondition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim create(Claim entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim update(Claim entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim remove(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
