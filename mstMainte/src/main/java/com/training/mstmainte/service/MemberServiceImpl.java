package com.training.mstmainte.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.mstmainte.mapper.MemberMapper;
import com.training.mstmainte.repository.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public MemberVO loginMember(String inputId, String inputPass) {
		HashMap<String, Object> map = new HashMap<String, Object>();//<String, Object> String 타입으로 값이 변환됨 Object는 최상위로 int, String도 Object에 속함
		map.put("inputId", inputId);
		map.put("inputPass", inputPass);
		
		return memberMapper.loginMember(map);
	}

	@Override
	public MemberVO getMember(int memberNumber) {
		return memberMapper.getMember(memberNumber);
	}

}
