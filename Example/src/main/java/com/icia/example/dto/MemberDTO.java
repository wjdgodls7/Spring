package com.icia.example.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberDTO {
	private String mid;
	private String mpwd;
	private String mname;
	private String mphone;
	private String memail;
	private String mbirth;
	private MultipartFile mfile;
	private String mfilename;
	
}
