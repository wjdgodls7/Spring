package com.icia.board.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int bnum;
	private String bwriter;
	private String bpwd;
	private String btitle;
	private String bcontents;
	private String bdate;
	private int bhits;
}
