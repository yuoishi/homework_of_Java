package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Student;

public class StudentDAO {
	public static int register(Student student){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qualification?useSSL=false",
					"userQ", "password");
			String sql = "insert into students (no, name, grade) value(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getGrade());
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
}