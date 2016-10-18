package cn.ymq.dao;

import java.util.List;
import java.util.Map;

import cn.ymq.vo.Member;

public interface IMemberDAO {
	public boolean doCreate(Member vo);

	public List<Member> findAllSplit(Map<String,Object> params);
}
