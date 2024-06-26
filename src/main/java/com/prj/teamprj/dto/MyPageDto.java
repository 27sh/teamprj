package com.prj.teamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyPageDto {
	private int mno;
	private int bno;
	private String title;
	private String content;
	private String name;
	private int uno;
}
