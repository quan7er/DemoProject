package cn.mldn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.dao.IActionDAO;
import cn.mldn.dao.IDeptDAO;
import cn.mldn.dao.IEmpDAO;
import cn.mldn.dao.impl.ActionDAOImpl;
import cn.mldn.dao.impl.DeptDAOImpl;
import cn.mldn.dao.impl.EmpDAOImpl;
import cn.mldn.service.IDeptService;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.util.vo.Action;
import cn.mldn.util.vo.Dept;
import cn.mldn.util.vo.Role;

public class DeptServiceImpl implements IDeptService {

	@Override
	public boolean add(Dept vo) throws Exception {
		IDeptDAO deptDAO = DAOFactory.getInstance(DeptDAOImpl.class);

		return false;
	}

	@Override
	public boolean edit(Dept vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dept get(String mid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		IDeptDAO deptDAO = DAOFactory.getInstance(DeptDAOImpl.class);
		map.put("allDepts", deptDAO.findAllSplit(currentPage, lineSize));
		map.put("allCount", deptDAO.getAllCount());
		return map;
	}

	@Override
	public List<Dept> list() throws Exception {
		IDeptDAO deptDAO = DAOFactory.getInstance(DeptDAOImpl.class);
		return deptDAO.findAll();
	}
}
