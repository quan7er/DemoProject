package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IActionDAO;
import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.util.vo.Action;

public class ActionDAOImpl extends AbstractDAO implements IActionDAO {
	
	@Override
	public List<Action> findByRole(Integer rid) throws SQLException {
		List<Action> all = new ArrayList<Action>();
		String sql = "SELECT actid,title,flag FROM action WHERE actid IN ("
				+ " SELECT actid FROM role_action WHERE rid=?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, rid);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Action vo = new Action();
			vo.setActid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setFlag(rs.getString(3));
			all.add(vo);
		}
		return all;
	}
	
	@Override
	public Action findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doCreate(Action vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Action vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Action> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Action> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Action> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
