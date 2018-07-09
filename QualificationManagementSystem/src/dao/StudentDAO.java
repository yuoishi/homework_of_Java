package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Student;

public class StudentDAO {

	static final String CLASS = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/qualification?useSSL=false";
	static final String USER = "userQ";
	static final String PASSWORD = "password";

	/*生徒登録処理*/
	public static int register(Student student){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try{
			Class.forName(CLASS);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "insert into students (no, name, grade, class) value(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getGrade());
			pstmt.setInt(4, student.getClas());
			result = pstmt.executeUpdate();
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
		return result;
	}

	/*生徒一覧表示処理*/
	public static ArrayList<Student> show(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Student> list = new ArrayList<Student>();

		try{
			Class.forName(CLASS);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select no, name, grade, class from students";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String no = rs.getString("no");
				String name = rs.getString("name");
				int grade = rs.getInt("grade");
				int clas = rs.getInt("class");
				Student s = new Student(no, name, grade, clas);
				list.add(s);
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