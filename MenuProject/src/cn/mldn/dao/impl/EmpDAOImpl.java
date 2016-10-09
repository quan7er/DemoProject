package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IEmpDAO;
import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.util.vo.Emp;
import cn.mldn.util.vo.Role;

public class EmpDAOImpl extends AbstractDAO implements IEmpDAO{

	@Override
	public boolean doCreate(Emp vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Emp vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Emp findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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

	@Override
	public Emp findByEmp(String empno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
