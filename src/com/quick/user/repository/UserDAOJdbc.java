package com.quick.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.quick.common.JdbcManager;
import com.quick.user.domain.User;

@Repository("userDAO")
public class UserDAOJdbc implements UserDAO {

	private final String USER_INSERT = "insert into users(id,pwd,name,role) values(?,?,?,?)";
	private final String USER_UPDATE = "update users set pwd=?, name=? where id=? and pwd=?";
	private final String USER_DELETE = "delete users where id=? and pwd=?";
	private final String USER_GET = "select * from users where id=? and pwd=?";
	private final String USER_LIST = "select * from users order by id asc";

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println("==>JDBC insert 기능 처리");

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(USER_INSERT);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getRole());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt);
		}
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println("==>JDBC update 기능 처리");

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(USER_UPDATE);		
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getId());			//ID & PWD 일치 할 경우 정보 변경(?)
			pstmt.setString(4, user.getPwd());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt);
		}

	}

	@Override
	public void deleteUser(String id, String pwd) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println("==>JDBC delete 기능 처리");

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(USER_DELETE);		
			pstmt.setString(1, id);			
			pstmt.setString(2, pwd);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt);
		}

	}

	@Override
	public User getUser(String id, String pwd) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("==>JDBC selectOne 기능 처리");

		User user = new User();

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(USER_GET);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pwd"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt, rs);
		}

		return user;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("==>JDBC selectAll 기능 처리");

		List<User> userList = new ArrayList<User>();

		try {
			con = JdbcManager.getConnetion();
			pstmt = con.prepareStatement(USER_LIST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pwd"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));

				userList.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcManager.close(con, pstmt, rs);
		}
		return userList;
	}

}
