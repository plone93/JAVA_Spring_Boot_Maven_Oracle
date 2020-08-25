package com.training.mstMainte.repository;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private String goodsNumber; //상품코드
	private String goodsName; //상품명
	private String goodsId; //상품 아이디(구분)
	private int goodsPrice;  //단가
	private int goodsCost;//원가
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp insertDate; //등록일자
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp updateDate; //갱신일자
	
}
