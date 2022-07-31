package com.hyunjin.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@Data	//getter + setter
//@AllArgsConstructor	//생성자
@NoArgsConstructor	// 빈생성자
//@RequiredArgsConstructor	//final 붙은 애들에 대한 생성자
public class Member {
//	final 불변성
//	private final int id;
//	private final String username;
//	private final String password;
//	private final String email;
	private int id;
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	//오버로딩
	/*
	public Member(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	*/
	
	
	
}
