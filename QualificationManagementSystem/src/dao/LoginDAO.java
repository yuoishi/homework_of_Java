package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Login;

public class LoginDAO {

	/*ユーザ登録処理*/
	public static int register(Login login){
		Connection con = null;
		PreparedStatement pstmt = null;
		int row = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qualification?useSSL=false",
					"userQ", "password");
			String sql = "insert into login (id, pw, name) value(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPw());
			pstmt.setString(3, login.getName());
			row = pstmt.executeUpdate();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null){
					pstmt.close();
				}
			}catch(SQLException e){

			}

			try{
				if(con != null){
					con.close();
				}
			}catch(SQLException e){

			}
		}
		return row;
	}

	/*ユーザ検索処理*/
	public static Login search(String id, String pw){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Login login = new Login();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qualification?useSSL=false",
					"userQ", "password");
			String sql = "select id, pw, name from login where id = ? and pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			rs.next();
			login.setId(rs.getString("id"));
			login.setPw(rs.getString("pw"));
			login.setName(rs.getString("name"));
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
			}catch(SQLException e){

			}

			try{
				if(pstmt != null){
					pstmt.close();
				}
			}catch(SQLException e){

			}

			try{
				if(con != null){
					con.close();
				}
			}catch(SQLException e){

			}
		}
		return login;
	}
}
