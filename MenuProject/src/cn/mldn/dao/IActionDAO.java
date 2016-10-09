package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.vo.Action;

public interface IActionDAO extends IDAO<Integer, Action> {
	
	public List<Action> findByRole(Integer rid) throws SQLException;

}
