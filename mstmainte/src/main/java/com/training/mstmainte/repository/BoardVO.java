package com.training.mstmainte.repository;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	private String goodsNumber; //상품코드
	private String goodsName; //상품명
	private String goodsId; //상품 아이디(구분)
	private Integer goodsPrice;  //단가
	private int goodsCost;//원가
	private String fileName; //파일이름
	private Timestamp insertDate; //등록일자
	private Timestamp updateDate; //갱신일자
	
}
