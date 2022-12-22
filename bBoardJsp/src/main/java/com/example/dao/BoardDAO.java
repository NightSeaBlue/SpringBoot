package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.BoardVO;

@Mapper
public interface BoardDAO {
	// 게시글 전체 리턴
	public List<BoardVO> getBoardList(BoardVO vo);
	// 신규 게시글 입력
	public Integer insertBoard(BoardVO vo);
	// 게시글 조회
	public BoardVO getBoard(BoardVO vo);
	// 게시글 수정
	public Integer updateBoard(BoardVO vo);
	// 게시글 삭제
	public Integer deleteBoard(BoardVO vo);
}

/*
 * 기본적인 구조라면,
 * 인터페이스를 구현한 클래스 BoardDAOImpl.java
 * 해당 클래스에 Repository 지정
 *  
 */

/*
 *	Mapper Annotation을 활용해 interface를 다이렉트로 매퍼와 연결할 수 있음.
 *	Mapper 의 namespace를 DAO 와 일치시키고 id 는 Mapper Key, ResultType은 VO와 맞추되 별칭을 부여해서 사용하는 것이 대수 
 */
