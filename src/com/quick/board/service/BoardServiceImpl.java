package com.quick.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quick.board.domain.Board;
import com.quick.board.repository.BoardDAOJdbc;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boardDAOJdbc")
	private BoardDAOJdbc boardDAO;
	
	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(board);
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(board_seq);
	}

	@Override
	public Board getBoard(int board_seq) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(board_seq);
		
	}

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}
	
	

}
