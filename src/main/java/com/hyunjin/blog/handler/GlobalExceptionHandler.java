package com.hyunjin.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.hyunjin.blog.dto.ResponseDto;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

//	@ExceptionHandler(value = IllegalArgumentException.class)
	@ExceptionHandler(value = Exception.class)
//	public String handleArgumentException(IllegalArgumentException e) {
	public ResponseDto<String> handleArgumentException(IllegalArgumentException e) {
//		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());	//자바오브젝트 JSON으로 변환해서 리턴 (Jackson)
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());	//자바오브젝트 JSON으로 변환해서 리턴 (Jackson)
//		return"<h1>"+e.getMessage()+"</h1>";
	}
	
}
