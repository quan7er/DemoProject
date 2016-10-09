package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.vo.Member;

public interface IMemberDAO extends IDAO<String,Member>{
	
	public boolean addMember_Role(String mid,List<Integer> rids)throws SQLException;

}
