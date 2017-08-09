package com.quick.board.service;

import java.util.List;

import com.quick.board.domain.Board;

public interface BoardService {

	public void insertBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(int board);
	public Board getBoard(int board_seq);
	public List<Board> getBoardList();
	
}
