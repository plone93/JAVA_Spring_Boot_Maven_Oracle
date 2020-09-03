package com.training.mstmainte.service;

import com.training.mstmainte.repository.MemberVO;

public interface MemberService {
	public MemberVO loginMember(String inputId, String inputPass);//로그인, 
	public MemberVO getMember(int memberNumber);//
}
