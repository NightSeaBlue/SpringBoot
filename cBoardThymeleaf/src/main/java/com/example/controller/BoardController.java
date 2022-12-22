package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// 선택한 페이지로 이동
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) {
		return "/board/"+step;
	}
	
	/*
	 * 함수명 : getBoardList
	 * 인자 : BoardVO , Model
	 * 역할 : BoardVO를 전달해, 모든 BoardVO를 List에 담아와 Model에 전달함 
	 * 
	 */
	
	@RequestMapping("/getBoardList")
	public void getBoardList(Model m) {
		BoardVO vo = new BoardVO();	// 역할은 당장은 없음, 사용할지도 모르므로
		List<BoardVO> list = boardService.getBoardList(vo);
		System.out.println("보드 리스트 호출 요청");
		System.out.println("리스트 호출 결과 : "+list.size());
		m.addAttribute("boardList",list);
	}
	
	/*
	 * 함수명 : saveBoard
	 * 인자 : BoardVO
	 * 역할 : 정해진 폼에 입력된 인자를 BoardVO 형태로 전달해 DB에 입력
	 * 
	 */
	@RequestMapping("/saveBoard")
	public String saveBoard(BoardVO vo) {
		int result = boardService.insertBoard(vo);
		System.out.println(result+"행 만큼 새로운 게시글 입력");
		return "redirect:getBoardList";
	}
	
	/*
	 * 함수명 : getBoard 
	 * 인자 : BoardVO
	 * 역할 : 글번호를 전달받아 일치하는 정보가 있는경우 VO 형태로 리턴
	 * 
	 */
	@RequestMapping("/getBoard")
	public void getBoard(BoardVO vo, Model m) {
		BoardVO result = boardService.getBoard(vo);
		m.addAttribute("board", result);
		System.out.println(result.getSeq()+"번 게시글 조회");
	}
	
	/*
	 * 함수명 : updateBoard
	 * 인자 : boardVO
	 * 역할 : 정해진 폼에 입력한 데이터를 전달받아 DB 수정 
	 *  
	 */
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		Integer result=boardService.updateBoard(vo);
		System.out.println(result+"행 만큼 게시글 수정");
		return "redirect:getBoard?seq="+vo.getSeq();
	}
	
	/*
	 * 함수명 : deleteBoard
	 * 인자 : BoardVO
	 * 역할 : 글번호를 전달받아, 일치하는 정보가 있는경우 DB에서 데이터 삭제 
	 *  
	 */
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		Integer result=boardService.deleteBoard(vo);
		System.out.println(result+"회 만큼 게시글 삭제");
		return "redirect:getBoardList";
	}
	
}
