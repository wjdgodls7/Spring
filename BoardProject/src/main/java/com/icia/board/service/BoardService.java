package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dao.CommentDAO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.CommentDTO;
import com.icia.board.dto.PageDTO;
@Service
public class BoardService {
	ModelAndView mav;
	@Autowired
	private BoardDAO dao;
	@Autowired
	private CommentDAO cdao;

	public ModelAndView boardwriteform(BoardDTO dto) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile bfile = dto.getBfile();
		String bfilename = bfile.getOriginalFilename();
		bfilename = System.currentTimeMillis() +"_" + bfilename;
		String filepath = "C:\\Users\\GG\\Documents\\Spring\\BoardProject\\src\\main\\webapp\\resources\\uploadFile\\" + bfilename;
		if (!bfile.isEmpty()) {
			bfile.transferTo(new File(filepath));	
		}
		dto.setBfilename(bfilename);
		int result =  dao.boardwriteform(dto);
		if (result>0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("Fail");
		}
		return mav;
	}

//	public ModelAndView boardlistform() {
//		mav = new ModelAndView();
//		List<BoardDTO> list = dao.boardlistform();
//		mav.addObject("list", list);
//		mav.setViewName("BoardList");
//		return mav;
//	}

	public ModelAndView boarddtail(BoardDTO bnum, int page) {
		mav = new ModelAndView();
		BoardDTO result = dao.boarddtail(bnum);
		List<CommentDTO> cdto = cdao.commentList(bnum.getBnum());
		mav.addObject("result", cdto);
		mav.addObject("list", result);
		mav.addObject("page",page);
		mav.setViewName("BoardDetail");

		return mav;
	}

	public ModelAndView boarddelete(int bnum) {
		mav = new ModelAndView();
		int result = dao.boarddelete(bnum);
		if (result>0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("Fail");
		}
		return mav;
	}

	public ModelAndView boardupdateform(BoardDTO dto) {
		mav = new ModelAndView();
		int result = dao.boardupdateform(dto);
		if (result>0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("Fail");
		}
		return mav;
	}

	//페이징 처리용 상수 선언
	private static final int PAGE_LIMIT = 3;	//한 페이지에 보여질 글 갯수
	private static final int BLOCK_LIMIT = 3;	//한화면에 보여질 페이지 갯수
	
	public ModelAndView boardpaging(int page) {
	mav = new ModelAndView();
	int list = dao.list();
	int startRow = (page - 1) * PAGE_LIMIT + 1;
	int endRow = (page) * PAGE_LIMIT;
	
	PageDTO pdto = new PageDTO();
	pdto.setStartRow(startRow);
	pdto.setEndRow(endRow);
	List<BoardDTO> boardlist = dao.listPaging(pdto);
	//ceil ==> 소숫점이 존재하면 올림
	int maxPage = (int)(Math.ceil((double)list/PAGE_LIMIT));
	int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
	//1, 4, 7, 10(BLOCK_LIMIT =3)일 경우
	int endPage = startPage + BLOCK_LIMIT - 1;
	//3, 6, 9, 12(BLOCK_LIMIT=3)일 경우
	if (endPage > maxPage)
		endPage = maxPage;
	pdto.setPage(page);
	pdto.setStartPage(startPage);
	pdto.setEndPage(endPage);
	pdto.setMaxPage(maxPage);
	
	mav.addObject("paging",pdto);
	mav.addObject("list",boardlist);
	mav.setViewName("BoardList");
	return mav;
	}

	public ModelAndView boardSerch(String serchtype, String keyword,int page) {
		mav = new ModelAndView();
		int list = dao.list();
		int startRow = (page - 1) * PAGE_LIMIT + 1;
		int endRow = (page) * PAGE_LIMIT;
		
		PageDTO pdto = new PageDTO();
		pdto.setStartRow(startRow);
		pdto.setEndRow(endRow);
		List<BoardDTO> boardlist = dao.listPaging(pdto);
		//ceil ==> 소숫점이 존재하면 올림
		int maxPage = (int)(Math.ceil((double)list/PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		//1, 4, 7, 10(BLOCK_LIMIT =3)일 경우
		int endPage = startPage + BLOCK_LIMIT - 1;
		//3, 6, 9, 12(BLOCK_LIMIT=3)일 경우
		if (endPage > maxPage)
			endPage = maxPage;
		pdto.setPage(page);
		pdto.setStartPage(startPage);
		pdto.setEndPage(endPage);
		pdto.setMaxPage(maxPage);
		List<BoardDTO> serchlist = dao.boardSerch(serchtype,keyword);
		mav.addObject("paging",pdto);
		mav.addObject("list", serchlist);
		mav.setViewName("BoardList");
		return mav;
	}

}
