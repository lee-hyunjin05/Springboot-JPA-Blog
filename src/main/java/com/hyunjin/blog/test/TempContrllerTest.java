package com.hyunjin.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempContrllerTest {

	//http://localhost:8080/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("temp.home");
		//파일 리턴 기본 경로 : src/main.resources/static
		//리턴명 : /home.html
//		return "home.html";
		//풀 경로 : src/main.resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		System.out.println("img Test");
		return "/a.png";
	}

	@GetMapping("/temp/jsp")
	public String tempJsp() {
//		prefix: /WEB-INF/views/
//	    suffix: .jsp
//		풀네임 : /WEB-INF/views/test.jsp
		System.out.println("jsp Test");
//		return "/test.jsp";
		return "test";
	}
}