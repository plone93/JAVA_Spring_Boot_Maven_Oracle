package com.training.mstmainte.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.training.mstmainte.mapper.BoardMapper;
import com.training.mstmainte.repository.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	//private static String UPLOAD_PATH = "./images/";
	private static String UPLOAD_PATH = "./src/main/resources/static/images/";
	
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
	
	@Override
	public void uploadFile(List<MultipartFile> files) throws IOException {
		/*지정 경로에 파일만 저장함*/
		for(MultipartFile file : files) {
			if(file.isEmpty()) { //파일이 업로드 되지 않았다면
				continue;
			}
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_PATH + file.getOriginalFilename()); //경로 + 파일이름
			System.out.println(path+"---------"+bytes);
			Files.write(path, bytes);
		}
		
	}

}
