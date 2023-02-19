 package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.Reply;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.repository.UserRepository;

@Service
public class BoardService {
	
	 @Autowired
     private BoardRepository boardRepository;
	 
	 @Autowired
	 private ReplyRepository replyRepository; 
    
	 @Transactional
	public void write(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly=true)
	public Page<Board> writeList(Pageable pageable){
		return  boardRepository.findAll(pageable); 
	}
	 
	@Transactional(readOnly=true)
	public Board details(int id) {
		return boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("Failed to find writing");
		});
	}
	
	@Transactional
	public void deleteWriting(int id) {
		boardRepository.deleteById(id);
	}
     
	@Transactional
	public void updateWriting(int id,Board requestBoard) {
		Board board = boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("Failed to find writing");
		});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}  
	
	@Transactional
	public void writeReply(User user,int boardId, Reply requestReply) {
		Board board = boardRepository.findById(boardId).orElseThrow(()->{
			return new IllegalArgumentException("Failed to find  ");
		});
		requestReply.setBoard(board);
		requestReply.setUser(user);
		replyRepository.save(requestReply);
	}
	
	@Transactional
	public void deleteReply(int replyId) {
		replyRepository.deleteById(replyId); 
	}
}
