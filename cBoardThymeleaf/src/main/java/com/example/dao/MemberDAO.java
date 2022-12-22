package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.MemberVO;

@Mapper
public interface MemberDAO {

	// 회원가입
	public Integer register(MemberVO vo);
	// 로그인
	public MemberVO login(MemberVO vo);
	
}
