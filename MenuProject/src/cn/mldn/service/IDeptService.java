package cn.mldn.service;

import java.util.List;
import java.util.Map;

import cn.mldn.util.vo.Dept;

public interface IDeptService {
	
	public boolean add(Dept vo) throws Exception;
	
	public boolean edit(Dept vo) throws Exception;
	
	public Dept get(String mid)throws Exception;
	
	public List<Dept> list()throws Exception;
	
	public Map<String,Object> list(int currentPage,int lineSize) throws Exception;
}
