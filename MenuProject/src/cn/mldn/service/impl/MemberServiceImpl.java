package cn.mldn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.dao.IActionDAO;
import cn.mldn.dao.IMemberDAO;
import cn.mldn.dao.IEmpDAO;
import cn.mldn.dao.impl.ActionDAOImpl;
import cn.mldn.dao.impl.MemberDAOImpl;
import cn.mldn.dao.impl.EmpDAOImpl;
import cn.mldn.exception.MemberInvalidatePasswordException;
import cn.mldn.exception.MemberInvalidateRoleException;
import cn.mldn.exception.MemberNoExistsException;
import cn.mldn.service.IMemberService;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.util.vo.Action;
import cn.mldn.util.vo.Member;
import cn.mldn.util.vo.Role;

public class MemberServiceImpl implements IMemberService {

	@Override
	public boolean add(Member vo) throws Exception {
		IMemberDAO memberDAO = DAOFactory.getInstance(MemberDAOImpl.class);
		if(memberDAO.findById(vo.getMid()) == null){
			return memberDAO.doCreate(vo);
		}
		return false;
	}

	@Override
	public boolean edit(Member vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> login(String mid, String password) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		IMemberDAO memberDAO = DAOFactory.getInstance(MemberDAOImpl.class);
		Member member = null;
		try {
			member = memberDAO.findById(mid);
			if(member == null){
				throw new MemberNoExistsException("用户不存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MemberNoExistsException("用户不存在！");
		}
		if(member.getPassword().equals(password)){
			flag = true;
//			IEmpDAO roleDAO = DAOFactory.getInstance(EmpDAOImpl.class);
//				try {
//					Role role = roleDAO.findByMember(mid);
//					List<Action> allAction = null;
//					if(role == null){
//						throw new MemberInvalidateRoleException("用户角色分配错误！");
//					}else{
//						IActionDAO actionDAO = DAOFactory.getInstance(ActionDAOImpl.class);
//						allAction = actionDAO.findByRole(role.getRid());
//						role.setActions(allAction);
//						member.setRole(role);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
		} else {
			throw new MemberInvalidatePasswordException("密码错误！");
		}
		map.put("flag", flag);
		map.put("member", member);
		return map;
	}

	@Override
	public Member get(String mid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		IMemberDAO memberDAO = DAOFactory.getInstance(MemberDAOImpl.class);
		map.put("allMembers", memberDAO.findAllSplit(currentPage, lineSize));
		map.put("allCount", memberDAO.getAllCount());
		return map;
	}

	@Override
	public List<Member> list() throws Exception {
		IMemberDAO memberDAO = DAOFactory.getInstance(MemberDAOImpl.class);
		return memberDAO.findAll();
	}

	@Override
	public boolean addMember_Role(String mid,List<Integer> rids) throws Exception {
		return DAOFactory.getInstance(MemberDAOImpl.class).addMember_Role(mid, rids);
	}

}
