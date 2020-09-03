package com.training.mstmainte.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.training.mstmainte.repository.MemberVO;

@Mapper
public interface MemberMapper {
	public MemberVO loginMember(HashMap<String, Object> map);
	public MemberVO getMember(int memberNumber);
}
