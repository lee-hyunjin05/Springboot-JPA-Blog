package com.hyunjin.blog.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.hyunjin.blog.dto.ReplySaveRequestDto;
import com.hyunjin.blog.repository.ReplyRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	private int id;	//시퀀스, auto_increment
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne	//여러개의 답변은 하나의 게시글에 존재할 수 있다.
	@JoinColumn(name = "boardId")
	private Board board;
	
	@ManyToOne	//여러개의 답변은 하나의 유저가 쓸 수 있다.
	@JoinColumn(name = "userId")
	private User user;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Override
	public String toString() {
		return "Reply [id=" + id + ", content=" + content + ", board=" + board + ", user=" + user + ", createDate="
				+ createDate + "]";
	}
}
