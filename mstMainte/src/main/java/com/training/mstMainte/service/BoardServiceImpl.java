package com.training.mstMainte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.mstMainte.mapper.BoardMapper;
import com.training.mstMainte.repository.BoardVO;

public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> boardSelect() {
		return boardMapper.boardSelect();
	}

	@Override
	public int boardInsert(BoardVO boardVO) {
		return boardMapper.boardInsert(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) {
		return boardMapper.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) {
		return boardMapper.boardDelete(boardVO);
	}

	@Override
	public BoardVO boardView(BoardVO boardVO) {
		return boardMapper.boardView(boardVO);
	}

	@Override
	public List<BoardVO> boardSearch(String keyword) {
		return boardMapper.boardSearch(keyword);
	}

	@Override
	public int goodsNumberCheck(String goodsNumber) {
		return boardMapper.goodsNumberCheck(goodsNumber);
	}

	@Override
	public List<BoardVO> boardSelectDress(BoardVO boardVO) {
		return boardMapper.boardSelectDress(boardVO);
	}

	@Override
	public List<BoardVO> boardSelectEat(BoardVO boardVO) {
		return boardMapper.boardSelectEat(boardVO);
	}

	@Override
	public List<BoardVO> boardSelectEtc(BoardVO boardVO) {
		return boardMapper.boardSelectEtc(boardVO);
	}

}
