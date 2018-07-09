package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Qualification;

public class QualificationDAO {

	static final String CLASS = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/qualification?useSSL=false";
	static final String USER = "userQ";
	static final String PASSWORD = "password";

	/*資格登録処理*/
	public static int register(int id, String name, int grade){
		Connection con = null;
		PreparedStatement pstmt = null;
		int row = 0;

		try{
			Class.forName(CLASS);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "insert into qualification (id, name, grade) value(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, grade);
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

	/*資格一覧表示処理*/
	public static ArrayList<Qualification> show(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Qualification> list = new ArrayList<Qualification>();

		try{
			Class.forName(CLASS);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select id, name, grade from qualification";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int grade = rs.getInt("grade");
				Qualification q = new Qualification(id, name, grade);
				list.add(q);
			}
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
		return list;
	}
}
