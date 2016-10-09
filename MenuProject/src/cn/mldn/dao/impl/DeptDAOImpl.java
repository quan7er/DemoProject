package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.util.vo.Dept;

public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {

	@Override
	public Dept findById(String id) throws SQLException {
		Dept vo = null;
		String sql = "SELECT deptno,dname,maxnum,currnum FROM dept WHERE deptno = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		if (rs.next()) {
			vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setMaxnum(rs.getInt(3));
			vo.setCurrnum(rs.getInt(4));
		}
		return vo;
	}

	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		String sql = "INSERT INTO dept (dname,maxnum,currnum) VALUES (?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getDname());
		super.pstmt.setInt(2, vo.getMaxnum());
		super.pstmt.setInt(3, vo.getCurrnum());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Dept vo) throws SQLException {
		String sql = "UPDATE dept SET dname=?,maxnum=?,currnum=? WHERE deptno = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getDname());
		super.pstmt.setInt(2, vo.getMaxnum());
		super.pstmt.setInt(3, vo.getCurrnum());
		super.pstmt.setInt(4, vo.getDeptno());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all = new ArrayList<Dept>();
		String sql = "SELECT deptno,dname,maxnum,currnum FROM dept";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Dept vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setMaxnum(rs.getInt(3));
			vo.setCurrnum(rs.getInt(4));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Dept> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		List<Dept> all = new ArrayList<Dept>();
		String sql = "SELECT deptno,dname,maxnum,currnum FROM dept limit ?,?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, currentPage);
		super.pstmt.setInt(2, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Dept vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setMaxnum(rs.getInt(3));
			vo.setCurrnum(rs.getInt(4));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Dept> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		List<Dept> all = new ArrayList<Dept>();
		String sql = "SELECT deptno,dname,maxnum,currnum FROM dept WHERE " + column + " LIKE ? LIMIT ?,?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, keyWord);
		super.pstmt.setInt(2, currentPage);
		super.pstmt.setInt(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Dept vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setMaxnum(rs.getInt(3));
			vo.setCurrnum(rs.getInt(4));
			all.add(vo);
		}
		return all;
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
