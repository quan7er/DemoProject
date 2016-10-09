package cn.mldn.dao;

import java.sql.SQLException;

import cn.mldn.util.vo.Emp;

public interface IEmpDAO extends IDAO<Integer, Emp> {

	public Emp findByEmp(String empno) throws SQLException;
}
