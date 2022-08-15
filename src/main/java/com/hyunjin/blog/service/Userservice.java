package com.hyunjin.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyunjin.blog.model.RoleType;
import com.hyunjin.blog.model.User;
import com.hyunjin.blog.repository.UserRepository;

import ch.qos.logback.core.encoder.Encoder;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();	//1234원문
		String encPassword = encoder.encode(rawPassword);	//해쉬화
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	/*
	@Transactional
	public int 회원가입(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입() : "+e.getMessage());			
		}
		return -1;
	}
	 */

	/*
	@Transactional
	public void 회원가입(User user) {
		userRepository.save(user);
	}
	*/
	
	/*
	@Transactional(readOnly = true)	// Select할 때 트랜잭션 시작, 서비스 종료시에는 트랜잭션 종료 (정합성)
//	public void 로그인(User user) {
	public User 로그인(User user) {
//		userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	*/
}
