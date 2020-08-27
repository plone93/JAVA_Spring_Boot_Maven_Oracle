package com.training.mstmainte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.mstmainte.repository.BoardVO;
import com.training.mstmainte.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String boardList(BoardVO boardVO,
							Model model) {
		String url = "/board/board_list";
		
		List<BoardVO> boardList = boardService.selectBoard();
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	@RequestMapping(value = "/boardListDress", method = RequestMethod.GET)
	public String boardListDress(BoardVO boardVO,
							Model model) {
		String url = "/board/board_list";
		String goods_id = "衣類";
		
		boardVO.setGoodsId(goods_id);
		List<BoardVO> boardList = boardService.selectBoardDress(boardVO);
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	@RequestMapping(value = "/boardListEat", method = RequestMethod.GET)
	public String boardListEat(BoardVO boardVO,
							Model model) {
		String url = "/board/board_list";
		String goods_id = "食品";
		
		boardVO.setGoodsId(goods_id);
		List<BoardVO> boardList = boardService.selectBoardEat(boardVO);
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	@RequestMapping(value = "/boardListEtc", method = RequestMethod.GET)
	public String boardList_ETC(BoardVO boardVO,
							Model model) {
		String url = "/board/board_list";
		String goods_id = "他";
		
		boardVO.setGoodsId(goods_id);
		List<BoardVO> boardList = boardService.selectBoardEtc(boardVO);
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	/*作成*/
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertBoard() {
		String url = "/board/insert_board";
		
		return url;
	}
	
	@RequestMapping(value = "/insertedBoard", method = RequestMethod.POST)
	public String insertedBoard(BoardVO boardVO) {
		String url = "redirect:/board/boardList"; // 리다이렉트는 컨트롤러 내 맵핑 주소
		boardService.insertBoard(boardVO);
		
		return url;
	}
	
	/*編集*/
	@RequestMapping(value = "/editboard", method = RequestMethod.GET)
	public String editBoard(BoardVO boardVO,
					   Model model) {
		String url = "/board/edit_board";
		
		boardVO = boardService.viewBoard(boardVO);
		model.addAttribute("boardVO", boardVO);
		
		return url;
	}
	
	@RequestMapping(value = "/editedBoard", method = RequestMethod.POST)
	public String editedBoard(BoardVO boardVO) {
		String url = "redirect:/board/boardList"; // BoardList메서드 실행
		boardService.updateBoard(boardVO);//수정시 날짜 갱신 필요
		return url;
	}
	
	/*削除*/
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(BoardVO boardVO) {
		String url = "redirect:/board/boardList"; // BoardList메서드 실행
		boardService.deleteBoard(boardVO);
		return url;
	}
	/*검색*/
	@RequestMapping(value = "/board/searchBoard", method = RequestMethod.POST)
	public String searchBoard(@RequestParam("keyword")String keyword,
							  Model model) {
		String url = "/board/board_list"; // BoardList메서드 실행
		
		List<BoardVO> boardList = boardService.searchBoard(keyword);
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	/*중복체크*/
	@ResponseBody
	@RequestMapping(value = "/checkGoodsNumber", method = RequestMethod.POST)
	public int checkGoodsNumber(@RequestParam("goodsNumber")String goodsNumber) {
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		check = boardService.checkGoodsNumber(goodsNumber);
		
		if(check >= 1) {
			result = 1;//중복이 검색됨
		} else if(check == 0) {
			check = 0;//중복이 검색안됨
		}
		
		return result;
	}
}
