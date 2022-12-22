package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public Integer register(MemberVO vo) {
		int result = dao.register(vo);
		System.out.println("회원가입 서비스 실행");
		return result;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		MemberVO result = dao.login(vo);
		System.out.println("로그인 서비스 실행");
		return result;
	}

}
