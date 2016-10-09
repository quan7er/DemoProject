package cn.mldn.service;

import java.util.List;
import java.util.Map;

import cn.mldn.util.vo.Member;

public interface IMemberService {
	
	public boolean add(Member vo) throws Exception;
	
	public boolean edit(Member vo) throws Exception;
	
	public boolean addMember_Role(String mid,List<Integer> rids) throws Exception;
	
	public Map<String,Object> login(String mid, String password) throws Exception;
	
	public Member get(String mid)throws Exception;
	
	public List<Member> list()throws Exception;
	
	public Map<String,Object> list(int currentPage,int lineSize) throws Exception;
}
