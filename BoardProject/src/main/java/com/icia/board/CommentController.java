package com.icia.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.board.dto.CommentDTO;
import com.icia.board.service.CommnetService;

@Controller
@RequestMapping("/comment/*")
public class CommentController {

	@Autowired
	private CommnetService cs;
	
	@RequestMapping(value="commentwrites")
	public @ResponseBody List<CommentDTO> commentwrite(@ModelAttribute CommentDTO cdto){
		List<CommentDTO> list = cs.commentwrite(cdto);
		return list;
	}
}
