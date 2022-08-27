package com.hyunjin.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyunjin.blog.config.auth.PrincipalDetail;
import com.hyunjin.blog.dto.ResponseDto;
import com.hyunjin.blog.model.RoleType;
import com.hyunjin.blog.model.User;
import com.hyunjin.blog.service.UserService;

@RestController
public class UserApiContoller {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	/*
	@Autowired
	private HttpSession session;
	*/
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {	//username, email, password
		System.out.println("UserApiContoller : save 호출됨");
		user.setRole(RoleType.USER);
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);	//자바오브젝트 JSON으로 변환해서 리턴 (Jackson)
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){		
		userService.회원수정(user);
		
		//여기서는 트랜잭션이 종료되기 때문에 DB값은 변경이 됐음.
		//하지만 세션값은 변경되지 않은 상태이기 때문에 우리가 직접 세션값을 변경해 줄것임.
		//세션등록
		
//		String encPassword = encoder.encode(user.getPassword());
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), encPassword));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	/*
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user
									, @AuthenticationPrincipal PrincipalDetail principal
									, HttpSession session){
		userService.회원수정(user);
		//여기서는 트랜잭션이 종료되기 때문에 DB값은 변경이 됐음.
		//하지만 세션값은 변경되지 않은 상태이기 때문에 우리가 직접 세션값을 변경해 줄것임.
		Authentication authentication = 
				new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	*/
	
	
	/*
//	@PostMapping("/auth/join")
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {	//username, email, password
		System.out.println("UserApiContoller : save 호출됨");
//		return new ResponseDto<Integer>(200, 1);
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		//실제로 DB에 insert를 하고 아래에서 return이 되면 되요.
		user.setRole(RoleType.USER);
//		int result = userservice.회원가입(user);
		userService.회원가입(user);
//		return new ResponseDto<Integer>(HttpStatus.OK, 1);	//자바오브젝트 JSON으로 변환해서 리턴 (Jackson)
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);	//자바오브젝트 JSON으로 변환해서 리턴 (Jackson)
	}
	*/
	
	/*
	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
	public ResponseDto<Integer> login(@RequestBody User user){
		System.out.println("UserApiController : login 호출됨");
		User principal = userService.로그인(user);	//principal (접근주체)
		
		if(principal != null) {
			session.setAttribute("principal", principal);
		}
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	*/
	
	//스프링 시큐리티 이용해서 로그인
	
}
