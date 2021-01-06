package com.icia.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.example.dto.MemberDTO;

@Repository
public class ExampleDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int memberjoin(MemberDTO mdto) {
		return sql.insert("Member.memberjoin", mdto);
		
	}

	public int idoverlap(String mid) {
		return sql.selectOne("Member.idoverlap",mid);
	}
	
}
