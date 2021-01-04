package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int boardwriteform(BoardDTO dto) {
		return sql.insert("Board.boardwrite", dto);
	}

	public List<BoardDTO> boardlistform() {
		return sql.selectList("Board.boardList");
		
	}

	public BoardDTO boarddtail(BoardDTO bnum) {
		sql.update("Board.boarddetail", bnum);
		return bnum;
	}

	public int boarddelete(int bnum) {
		return sql.delete("Board.boarddelete",bnum);
		
	}

	public int boardupdateform(BoardDTO dto) {
		return sql.update("Board.boardupdateform",dto);
	
	}

	public int list() {
		return sql.selectOne("Board.boardlist");
	}

	public List<BoardDTO> listPaging(PageDTO pdto) {
		return sql.selectList("Board.listPaging", pdto);
	}

}
