package com.training.mstmainte.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.training.mstmainte.repository.BoardVO;

public interface BoardService {
	public List<BoardVO> selectBoard();//상품 검색
	public int insertBoard(BoardVO boardVO);//상품 작성
	public int updateBoard(BoardVO boardVO);//상품 편집
	public int deleteBoard(BoardVO boardVO);//상품 삭제
	public BoardVO viewBoard(BoardVO boardVO);//상품 상세 보기
	public List<BoardVO> searchBoard(String keyword);//상품검색
	
	public int checkGoodsNumber(String goodsNumber);//상품번호 중복확인 체크
	
	public List<BoardVO> selectBoardDress(BoardVO boardVO);
	public List<BoardVO> selectBoardEat(BoardVO boardVO);
	public List<BoardVO> selectBoardEtc(BoardVO boardVO);
	
	public void uploadFile(List<MultipartFile> files, String fileName) throws IOException;//파일업로드
}
