package com.icia.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dao.CommentDAO;
import com.icia.board.dto.CommentDTO;

@Service
public class CommnetService {

	@Autowired
	private CommentDAO cd;

	public List<CommentDTO> commentwrite(CommentDTO cdto) {
		int result = cd.commentwrite(cdto);
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		if (result>0) {
			list = cd.commentList(cdto.getCbnumber());
		}else {	
			list = null;
		}
		return list;
	}
	
	
}
