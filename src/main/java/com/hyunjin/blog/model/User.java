package com.hyunjin.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder	//빌더패턴
//ORM -> java(다른언어 포함) Object -> 테이블로 매핑해준다.
@Entity	//User클래스가 MySQL에 테이블이 생성이 된다.
//@DynamicInsert	//insert시에 null 인 필드 제외
public class User {

	@Id	//Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id;	//시퀀스, auto_increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;	//아이디
	
	@Column(nullable = false, length = 100)	//12345 -> 해쉬 (비밀번호 암호화)
  	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("'user'")	//처음 디폴트 값 유저
	//DB는 RoleType 이란게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role;	//Enum을 쓰는게 좋다	//admin, user, manager
	
	private String oauth;	//kakao, google
	
	//내가 직접 시간을 넣으려면 Timestamp.valueOf(LocalDateTime.now())
	@CreationTimestamp	//시간이 자동 입력
	private Timestamp createDate;

}
