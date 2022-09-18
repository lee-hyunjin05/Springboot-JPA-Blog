package com.hyunjin.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyunjin.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
