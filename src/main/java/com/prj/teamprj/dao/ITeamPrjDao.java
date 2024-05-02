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
	
	public MyPageDto getMyMnoPage(@Param("mno") String mno);
	//mno 본인이 쓴 게시글 list
	
	public MyPageDto getMyUnoPage(@Param("uno") String uno);
	//uno, 언급된 글 list
	
	public void detailWrite(@Param("dto") MyPageDto dto);
	//detail 내 uno를 활용한 write
}
