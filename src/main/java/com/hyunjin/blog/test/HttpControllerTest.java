package com.hyunjin.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(HTML 파일)
///@Controller

//사용자가 요청 -> 응답(data)
@RestController
public class HttpControllerTest {

	private static final String TAG = "HttpController Test : ";

	@GetMapping("/http/lombok")
	public String lombokTest() {
		//내가 넣는 순서를 지키지 않아도 된다
		// 내가 생성자를 통해 넣을때는 순서를 지켜야함
		Member m = Member.builder().username("hyunjin").password("1234").email("hyunjin@nate.com").build();
//		Member m = new Member(1, "hyunjin", "1234", "hyunjin@naver.com");
//		System.out.println(TAG + "getter : "+m.getId());
		System.out.println(TAG + "getter : "+m.getUsername());
//		m.setId(5000);
		m.setUsername("현진이~!~");
//		System.out.println(TAG + "setter : "+m.getId());
		System.out.println(TAG + "setter : "+m.getUsername());

		return "lombokTest 완료";
	}
	//인터넷 브라우저 요청은 무조건 get 요청만 가능하다
	//http://localhost:8080/http/get(select)
	@GetMapping("/http/get")
//	public String getTest(@RequestParam int id, @RequestParam String username) {
	public String getTest(Member m) {
		
		return "get 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	//http://localhost:8080/http/post(insert)
	@PostMapping("/http/post")	//text/plan, application/json
//	public String postTest(Member m) {
//	public String postTest(@RequestBody String text) {
	public String postTest(@RequestBody Member m) { 	// MassageConverter (스프링부트) 자동으로 맵핑
		return "post 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
//		return "post 요청 : "+text;
	}
	
	//http://localhost:8080/http/put(update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
//		return "put 요청 :"; 
		return "put 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	//http://localhost:8080/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
