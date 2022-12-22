package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// 넘겨받은 결과를 변수에 담아서 보냄
		List<BoardVO> list = boardDAO.getBoardList(vo);
		System.out.println("보드 리스트 출력 서비스");
		System.out.println("리스트 갯수 : "+list.size());
		return list;
	}

	@Override
	public Integer insertBoard(BoardVO vo) {
		int result = boardDAO.insertBoard(vo);
		System.out.println(" 새 게시글 입력 서비스 실행 ");
		return result;
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		BoardVO result = boardDAO.getBoard(vo);
		System.out.println("게시글 조회 서비스 실행");
		return result;
	}

	@Override
	public Integer updateBoard(BoardVO vo) {
		int result = boardDAO.updateBoard(vo);
		System.out.println("게시글 수정 서비스 실행");
		return result;
	}

	@Override
	public Integer deleteBoard(BoardVO vo) {
		int result=boardDAO.deleteBoard(vo);
		System.out.println("게시글 삭제 서비스 실행");
		return result;
	}

}
