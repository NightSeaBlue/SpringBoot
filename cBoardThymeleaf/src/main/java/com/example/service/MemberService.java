package com.example.service;

import com.example.domain.MemberVO;


public interface MemberService {

	// 회원가입
	public Integer register(MemberVO vo);

	// 로그인
	public MemberVO login(MemberVO vo);

}
