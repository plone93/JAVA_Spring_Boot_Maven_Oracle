package com.training.mstMainte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.mstMainte.repository.BoardVO;
import com.training.mstMainte.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	
	@RequestMapping(value = "/Board/BoardList", method = RequestMethod.GET)
	public String boardList(BoardVO boardVO,
							Model model) {
		String url = "/Board/BoardList";
		
		List<BoardVO> boardList = boardService.boardSelect();
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	@RequestMapping(value = "/Board/BoardList_Dress", method = RequestMethod.GET)
	public String boardList_Dress(BoardVO boardVO,
							Model model) {
		String url = "/Board/BoardList";
		String goods_id = "衣類";
		
		boardVO.setGoodsId(goods_id);
		List<BoardVO> boardList = boardService.boardSelectDress(boardVO);
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	@RequestMapping(value = "/Board/BoardList_Eat", method = RequestMethod.GET)
	public String boardList_Eat(BoardVO boardVO,
							Model model) {
		String url = "/Board/BoardList";
		String goods_id = "食品";
		
		boardVO.setGoodsId(goods_id);
		List<BoardVO> boardList = boardService.boardSelectEat(boardVO);
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	@RequestMapping(value = "/Board/BoardList_ETC", method = RequestMethod.GET)
	public String boardList_ETC(BoardVO boardVO,
							Model model) {
		String url = "/Board/BoardList";
		String goods_id = "他";
		
		boardVO.setGoodsId(goods_id);
		List<BoardVO> boardList = boardService.boardSelectEtc(boardVO);
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	/*作成*/
	@RequestMapping(value = "/Board/BoardInsert", method = RequestMethod.GET)
	public String boardInsert() {
		String url = "/Board/BoardInsert";
		
		return url;
	}
	
	@RequestMapping(value = "/Board/BoardInserted", method = RequestMethod.POST)
	public String boardInserted(BoardVO boardVO) {
		String url = "redirect:/Board/BoardList"; // BoardList메서드 실행
		boardService.boardInsert(boardVO);
		System.out.println(boardVO.getGoodsId());
		return url;
	}
	
	/*編集*/
	@RequestMapping(value = "/Board/BoardUpdate", method = RequestMethod.GET)
	public String boardUpdate(BoardVO boardVO,
							  Model model) {
		String url = "/Board/BoardUpdate";
		
		boardVO = boardService.boardView(boardVO);
		model.addAttribute("boardVO", boardVO);
		
		return url;
	}
	
	@RequestMapping(value = "/Board/BoardUpdated", method = RequestMethod.POST)
	public String boardUpdated(BoardVO boardVO) {
		String url = "redirect:/Board/BoardList"; // BoardList메서드 실행
		boardService.boardUpdate(boardVO);//수정시 날짜 갱신 필요
		return url;
	}
	
	/*削除*/
	@RequestMapping(value = "/Board/BoardDelete", method = RequestMethod.GET)
	public String boardDelete(BoardVO boardVO) {
		String url = "redirect:/Board/BoardList"; // BoardList메서드 실행
		boardService.boardDelete(boardVO);
		return url;
	}
	/*검색*/
	@RequestMapping(value = "/Board/BoardSearch", method = RequestMethod.POST)
	public String boardSearch(@RequestParam("keyword")String keyword,
							  Model model) {
		String url = "/Board/BoardList"; // BoardList메서드 실행
		
		List<BoardVO> boardList = boardService.boardSearch(keyword);
		model.addAttribute("boardList", boardList);
		
		return url;
	}
	
	/*중복체크*/
	@ResponseBody
	@RequestMapping(value = "/Board/goods_cd_check", method = RequestMethod.POST)
	public int GoodsNumberCheck(@RequestParam("goods_number")String goods_number) {
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		check = boardService.goodsNumberCheck(goods_number);
		
		if(check >= 1) {
			result = 1;//중복이 검색됨
		} else if(check == 0) {
			check = 0;//중복이 검색안됨
		}
		
		return result;
	}
}
