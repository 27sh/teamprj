package com.prj.teamprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prj.teamprj.dao.ITPrjMemberDao;
import com.prj.teamprj.dao.ITeamPrjDao;
import com.prj.teamprj.dto.MemberDto;
import com.prj.teamprj.dto.MyPageDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MyController {
	
	
	@Autowired
	private ITeamPrjDao dao;
	
	@Autowired
	private ITPrjMemberDao mdao;
	
	@Autowired
	HttpServletRequest request;
	
	
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
	//member회원가입
	@RequestMapping("/memberForm") //회원가입화면
	public String memberForm() {
		
		return "memberForm";
	}
	@RequestMapping("/member") //회원가입기능
	public String member(MemberDto dto) {
		//id pw name 받아와서 등록
		mdao.signUp(dto);
				
		//회원가입 완료후 로그인페이지로
		return "redirect:loginForm";
	}
	
	//로그인페이지
	@RequestMapping("/loginForm") //로그인 화면
	public String loginForm() {
		
		return "loginForm";
	}
	@RequestMapping("/login") //로그인 기능
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
						
		MemberDto mdto = mdao.select(id, pw);
		String msg="";
		if(mdto == null) {
			msg = "회원정보가 없습니다.";
			model.addAttribute("msg", msg);
			//로그인 실패시 로그인화면으로 돌려보냄
			return "loginForm";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("mno",mdto.getMno());
			session.setAttribute("id",mdto.getId());
			session.setAttribute("pw",mdto.getPw());
			session.setAttribute("name",mdto.getName());
			
			//로그인 성공시 List보러가기
			return "redirect:boardList";
			
		}
	}
	
	//boardList페이지
	@RequestMapping("/boardList") //List 화면
	public String boardList(Model model) {
		
		model.addAttribute("list", dao.getList());
		
		return "boardList";
	}
	
	//boardWrite페이지
	@RequestMapping("/boardWrite") //게시글 등록화면
	public String boardWrite() {
		
		return "boardWrite";
	}
	
	@RequestMapping("/write")//게시글 등록기능
	public String write(MyPageDto dto) {
		
		dao.write(dto);
		//등록했으니 List보러가기
		return "redirect:boardList";
	}
	
	//boardDetail페이지(상세페이지)
	@RequestMapping("/boardDetail")
	public String boardDetail(@RequestParam("bno") String bno, Model model) {
		
		model.addAttribute("bno", dao.getDto(bno));
		
		return "boardDetial";
	}
	
	//boardDelete 삭제
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("bno") String bno, Model model) {
	
		model.addAttribute("bno", dao.getDto(bno));
		
		//삭제했으니 확인하러 List보러가기
		return "redirect:boardList";
	}
	///////////////////////////////////////////////////////////
	//MyPage
	@RequestMapping("/myPage")
	public String mypage(Model model,@RequestParam("mno") String mno, @RequestParam("uno") String uno) {
		//mno 본인이 쓴 게시물
		model.addAttribute("mymno",dao.getMyMnoPage(mno));
		//uno 본인이 언급된 게시물
		model.addAttribute("myuno",dao.getMyUnoPage(uno));
		
		return "myPage";
	}
	
	
	
	 	
}
