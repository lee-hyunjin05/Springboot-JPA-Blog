package com.hyunjin.blog.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//auto_increment;
	private int id;

	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob	//대용량 데이터
	private String content;	//섬머노트 라이브러리 <html>태그가 섞여서 디자인이됨
	
//	@ColumnDefault("0")
	private int count;	//조회수

//	private int userId;
	
	@ManyToOne(fetch = FetchType.EAGER)	//many = Board, User = one	: 한명의 유저는 여러개의 게시글을 쓸 수 있다.
	@JoinColumn(name="userId")
	private User user;	//DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	//lazy : 필요하때 떙겨옴 지연로딩
	//eager : 즉시로딩
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)	//하나의 게시글 여러개의 댓글, mapby : 연관관계의 주인이 아니다 (FK가 아님) DB에 컬럼을 만들지 마셈 
	private List<Reply> reply;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
}
