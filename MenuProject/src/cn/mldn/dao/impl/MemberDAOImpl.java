package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IMemberDAO;
import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.util.vo.Member;

public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {

	@Override
	public Member findById(String id) throws SQLException {
		Member vo = null;
		String sql = "SELECT mid,password,name,sflag FROM member WHERE mid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		if (rs.next()) {
			vo = new Member();
			vo.setMid(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setSflag(rs.getInt(4));
		}
		return vo;
	}

	@Override
	public boolean doCreate(Member vo) throws SQLException {
		String sql = "INSERT INTO member (mid,password,name,sflag) VALUES (?,?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getMid());
		super.pstmt.setString(2, vo.getPassword());
		super.pstmt.setString(3, vo.getName());
		super.pstmt.setInt(4, 0);
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Member vo) throws SQLException {
		String sql = "UPDATE member SET password=?,name=?,sflag=? WHERE mid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getPassword());
		super.pstmt.setString(2, vo.getName());
		super.pstmt.setInt(3, vo.getSflag());
		super.pstmt.setString(4, vo.getMid());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Member> findAll() throws SQLException {
		List<Member> all = new ArrayList<Member>();
		String sql = "SELECT mid,password,name,sflag FROM member";
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Member vo = new Member();
			vo.setMid(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setSflag(rs.getInt(4));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Member> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		List<Member> all = new ArrayList<Member>();
		String sql = "SELECT mid,password,name,sflag FROM member limit ?,?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, currentPage);
		super.pstmt.setInt(2, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Member vo = new Member();
			vo.setMid(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setSflag(rs.getInt(4));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Member> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		List<Member> all = new ArrayList<Member>();
		String sql = "SELECT mid,password,name,sflag FROM member WHERE " + column + " LIKE ? LIMIT ?,?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, keyWord);
		super.pstmt.setInt(2, currentPage);
		super.pstmt.setInt(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Member vo = new Member();
			vo.setMid(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setSflag(rs.getInt(4));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMember_Role(String mid,List<Integer> rids) throws SQLException {
		String sql = "INSERT INTO member_role (mid,rid) VALUES (?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		Iterator<Integer> iter = rids.iterator();
		while(iter.hasNext()){
			super.pstmt.setString(1,mid);
			super.pstmt.setInt(2,iter.next());
			super.pstmt.addBatch();
		}

		int result [] =  super.pstmt.executeBatch();
		for(int x=0;x<result.length;x++){
			if(result[x] == 0){
				return false;
			}
		}
		return true;
	}

}
