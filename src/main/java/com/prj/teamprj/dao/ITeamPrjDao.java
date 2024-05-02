package com.prj.teamprj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.prj.teamprj.dto.MyPageDto;

@Mapper
public interface ITeamPrjDao {
	
	public List<MyPageDto> getList();

	public void write(@Param("dto") MyPageDto dto);

	public MyPageDto getDto(@Param("bno") String bno);

	public void delete(@Param("bno") String bno);
}
