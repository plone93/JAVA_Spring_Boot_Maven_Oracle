package com.training.mstmainte.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
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
	public void uploadFile(List<MultipartFile> files, String fileName) throws IOException {
		/*지정 경로에 파일만 저장함*/
		for(MultipartFile file : files) {
			if(file.isEmpty()) { //파일이 업로드 되지 않았다면
				continue;
			} else {//파일이 업로드 되었다면
				byte[] bytes = file.getBytes();		
				Path path = Paths.get(UPLOAD_PATH + fileName); //경로 + 파일이름
				Files.write(path, bytes);
			}

			//String pathSTR = UPLOAD_PATH + file.getOriginalFilename(); x
			//System.out.println(path); //.\src\main\resources\static\images\201097.jpg
			//System.out.println(pathSTR); // ./src/main/resources/static/images/201097.jpg, Files.write 메소드가 인식못함 x
			
			/*  //OR (이방식은 C드라이브 부터 경로를 지정해 줘야함)
			String UPLOAD_PATH1 = "C:\\test";
			File saveFile = new File(UPLOAD_PATH1, fileName);
			try {
				//둘 중 하나
				file.transferTo(saveFile);
				FileCopyUtils.copy(file.getBytes(), saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/
		}
		
	}

}
