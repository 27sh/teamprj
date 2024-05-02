package com.prj.teamprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	/*
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Hi Team Project";
	}
	*/
	
	@RequestMapping("/")
	public String main() {
		return "index";
	}
}
