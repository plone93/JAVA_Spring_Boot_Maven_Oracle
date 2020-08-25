package com.training.mstMainte.mapper;

import java.util.List;

import com.training.mstMainte.repository.BoardVO;

public interface BoardMapper {
	public List<BoardVO> boardSelect();//상품 검색
	public int boardInsert(BoardVO boardVO);//상품 작성
	public int boardUpdate(BoardVO boardVO);//상품 편집
	public int boardDelete(BoardVO boardVO);//상품 삭제
	public BoardVO boardView(BoardVO boardVO);//상품 상세 보기
	public List<BoardVO> boardSearch(String keyword);//상품검색
	
	public int goodsNumberCheck(String goodsNumber);//상품번호 중복확인 체크
	
	public List<BoardVO> boardSelectDress(BoardVO boardVO);
	public List<BoardVO> boardSelectEat(BoardVO boardVO);
	public List<BoardVO> boardSelectEtc(BoardVO boardVO);
}
