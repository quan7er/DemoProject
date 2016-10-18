package cn.ymq.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.ymq.dao.IMemberDAO;
import cn.ymq.service.IMemberService;
import cn.ymq.vo.Member;

@Component
public class MemberServiceImpl implements IMemberService {
	@Resource
	private IMemberDAO memberDAO;
	
	@Override
	public boolean add(Member vo) throws Exception {
		return this.memberDAO.doCreate(vo);
	}

	@Override
	public List<Member> split(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("column", column);
		map.put("keyWord", keyWord);
		map.put("start", (currentPage-1)*lineSize);
		map.put("lineSize", lineSize);
		return this.memberDAO.findAllSplit(map);
	}

}
