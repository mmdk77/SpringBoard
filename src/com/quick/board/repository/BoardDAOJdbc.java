package com.quick.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.quick.board.common.JdbcManager;
import com.quick.board.domain.Board;

@Repository("boardDAOJdbc")
public class BoardDAOJdbc implements BoardDAO {

	private final String BOARD_INSERT = "insert into board(board_seq,title,writer,content) values(board_seq.nextval,?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where board_seq=?";
	private final String BOARD_DELETE = "delete board where board_seq=?";
	private final String BOARD_GET = "select * from board where board_seq=?";
	private final String BOARD_LIST = "select * from board order by board_seq desc";

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("==>JDBC insert 扁瓷 贸府");

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt);
		}

	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("==>JDBC update 扁瓷 贸府");

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoard_seq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt);
		}
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("==>JDBC delete 扁瓷 贸府");

		Board board = new Board();

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, board.getBoard_seq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt);
		}
	}

	@Override
	public Board getBoard(int board_seq) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("==>JDBC selectOne 扁瓷 贸府");

		Board board = new Board();

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(BOARD_GET);
			pstmt.setInt(1, board_seq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt, rs);
		}
		return board;

	}

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("==>JDBC selectAll 扁瓷 贸府");

		List<Board> boardList = new ArrayList<Board>();

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt, rs);
		}
		return boardList;
	}

}
