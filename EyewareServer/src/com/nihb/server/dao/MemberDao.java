/**
 * 
 */
package com.nihb.server.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nihb.common.entity.Member;

/**
 * @author kaiwu
 *
 */
public class MemberDao extends AbstractDataAccess<Member> {

	public MemberDao(Connection conn) throws SQLException {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Member> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllBy(String queryCondition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member create(Member entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member update(Member entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member remove(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
