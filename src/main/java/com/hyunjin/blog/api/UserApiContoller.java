package com.hyunjin.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyunjin.blog.dto.ResponseDto;
import com.hyunjin.blog.model.RoleType;
import com.hyunjin.blog.model.User;
import com.hyunjin.blog.service.Userservice;

@RestController
public class UserApiContoller {

	@Autowired
	private Userservice userservice;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {	//username, email, password
		System.out.println("UserApiContoller : save 호출됨");
//		return new ResponseDto<Integer>(200, 1);
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		//실제로 DB에 insert를 하고 아래에서 return이 되면 되요.
		user.setRole(RoleType.USER);
		int result = userservice.회원가입(user);
//		return new ResponseDto<Integer>(HttpStatus.OK, 1);	//자바오브젝트 JSON으로 변환해서 리턴 (Jackson)
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);	//자바오브젝트 JSON으로 변환해서 리턴 (Jackson)
	}
	
}
