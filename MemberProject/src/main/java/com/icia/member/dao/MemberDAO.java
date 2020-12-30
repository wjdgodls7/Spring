package com.icia.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int insertDB(MemberDTO member) {
		return sql.insert("Member.insertDB", member);
	}
	public int selectDB(MemberDTO member) {
		int result = sql.selectOne("Member.selectDB", member);
		return result;
	}
	public List<Object> selectList() {
		
		return sql.selectList("Member.selectList");
	}
	public MemberDTO SelectDetail(String detail) {
		
		return sql.selectOne("Member.selectDetail", detail);
		
	}
	public int Delete(String del) {
		return sql.delete("Member.del", del);
		
	}
	public MemberDTO Detail(String detail) {
		return sql.selectOne("Member.select", detail);
		
	}
	public int MemberUpdate(MemberDTO dto) {
		return sql.update("Member.update", dto);
	}

}
