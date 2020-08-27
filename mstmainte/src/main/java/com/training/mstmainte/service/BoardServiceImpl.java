package com.training.mstmainte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.mstmainte.mapper.BoardMapper;
import com.training.mstmainte.repository.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> selectBoard() {
		return boardMapper.selectBoard();
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardMapper.updateBoard(boardVO);
	}

	@Override
	public int deleteBoard(BoardVO boardVO) {
		return boardMapper.deleteBoard(boardVO);
	}

	@Override
	public BoardVO viewBoard(BoardVO boardVO) {
		return boardMapper.viewBoard(boardVO);
	}

	@Override
	public List<BoardVO> searchBoard(String keyword) {
		return boardMapper.searchBoard(keyword);
	}

	@Override
	public int checkGoodsNumber(String goodsNumber) {
		return boardMapper.checkGoodsNumber(goodsNumber);
	}

	@Override
	public List<BoardVO> selectBoardDress(BoardVO boardVO) {
		return boardMapper.selectBoardDress(boardVO);
	}

	@Override
	public List<BoardVO> selectBoardEat(BoardVO boardVO) {
		return boardMapper.selectBoardEat(boardVO);
	}

	@Override
	public List<BoardVO> selectBoardEtc(BoardVO boardVO) {
		return boardMapper.selectBoardEtc(boardVO);
	}

}
