package com.prj.teamprj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.prj.teamprj.dto.MemberDto;
import com.prj.teamprj.dto.MyPageDto;

@Mapper
public interface ITPrjMemeberDao {
	
	public void sginUp(@Param("dto") MemberDto dto);
}
