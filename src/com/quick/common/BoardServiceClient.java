package com.quick.common;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.quick.board.domain.Board;
import com.quick.board.service.BoardService;

public class BoardServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("com/quick/common/applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		
		
	/* 	Board board = new Board();
	 	board.setTitle("�ι��� Spring + JDBC");
		board.setWriter("�̼���");
		board.setContent("�Ǽ��� ���ư���!!");
		boardService.insertBoard(board);*/
		
		List<Board> boardList = boardService.getBoardList();
		for(Board board:boardList){
			System.out.println("==>"+board.toString());
			
		}
		
		
		/*Board board = new Board();
		board = boardService.getBoard(1);
		System.out.println("==>"+board.toString());*/
		
		container.close();

	}

}
