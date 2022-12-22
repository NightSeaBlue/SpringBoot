package com.example.service;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList(BoardVO vo);

	// 신규 게시글 입력
	public Integer insertBoard(BoardVO vo);

	// 게시글 조회
	public BoardVO getBoard(BoardVO vo);

	// 게시글 수정
	public Integer updateBoard(BoardVO vo);

	// 게시글 삭제
	public Integer deleteBoard(BoardVO vo);
}
