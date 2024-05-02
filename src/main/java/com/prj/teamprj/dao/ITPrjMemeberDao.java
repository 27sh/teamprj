package com.prj.teamprj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.prj.teamprj.dto.MemberDto;
import com.prj.teamprj.dto.MyPageDto;

@Mapper
public interface ITPrjMemeberDao {
	
	public void signUp(@Param("dto") MemberDto dto);
	//회원가입 (insert into team_member)
	
	public MemberDto select(@Param("id") String id, @Param("pw") String pw);
	//로그인 (select * from team_member)

}
