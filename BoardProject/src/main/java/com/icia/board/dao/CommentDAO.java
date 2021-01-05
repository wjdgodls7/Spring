package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.CommentDTO;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate sql;
	public int commentwrite(CommentDTO cdto) {
		
		return sql.insert("Comment.commentwrite",cdto);
	}
	public List<CommentDTO> commentList(int cbnum) {
		return sql.selectList("Comment.commentlist",cbnum);
	}

}
