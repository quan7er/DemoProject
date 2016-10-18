package cn.ymq.service;

import java.util.List;

import cn.ymq.vo.Member;

public interface IMemberService {
	public boolean add(Member vo) throws Exception;

	public List<Member> split(String column, String keyWord, int currentPage, int lineSzie) throws Exception;
}
