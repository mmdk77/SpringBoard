package com.quick.board.repository;

import java.util.List;

import com.quick.board.domain.Board;

public interface BoardDAO {

	public void insertBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(int board_seq);
	public Board getBoard(int board_seq);
	public List<Board> getBoardList();
	
}
