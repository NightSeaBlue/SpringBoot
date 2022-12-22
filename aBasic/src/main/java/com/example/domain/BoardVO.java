package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	private int cnt;
		
}
