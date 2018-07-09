package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ExMana;

public class ExManaDAO {

	/*受験データ登録処理*/
	public static int register(ExMana exmana){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qualification?useSSL=false",
					"userQ", "password");
			String sql = "insert into exmana (date, sno, qname, sorf) value(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, exmana.getDate());
			pstmt.setString(2, exmana.getSno());
			pstmt.setString(3, exmana.getQname());
			pstmt.setString(4, exmana.getSorf());
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

	/*受験データ一覧表示処理*/
	public static ArrayList<ExMana> show(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ExMana> list = new ArrayList<ExMana>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qualification?useSSL=false",
					"userQ", "password");
			String sql = "select date, sno, name as sname, qname, sorf from exmana, students where sno = no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String date = rs.getString("date");
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String qname = rs.getString("qname");
				String sorf = rs.getString("sorf");
				ExMana exmana = new ExMana(date, sno, sname, qname, sorf);
				list.add(exmana);
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

	/*学年・クラスごとに一覧を表示処理*/
	public static ArrayList<ExMana> show(int grade, int clas){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ExMana> list = new ArrayList<ExMana>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qualification?useSSL=false",
					"userQ", "password");
			String sql = "select date, sno, name as sname, qname, sorf from exmana, students where sno = no";
			if(grade != 0){
				sql += " and grade = ?";
			}
			if(clas != 0){
				sql += " and class = ?";
			}
			pstmt = con.prepareStatement(sql);
			int idx = 1;
			if(grade != 0){
				pstmt.setInt(idx++, grade);
			}
			if(clas != 0){
				pstmt.setInt(idx, clas);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				String date = rs.getString("date");
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String qname = rs.getString("qname");
				String sorf = rs.getString("sorf");
				ExMana exmana = new ExMana(date, sno, sname, qname, sorf);
				list.add(exmana);
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

	/*資格の合格者のみ表示処理*/
	public static ArrayList<ExMana> show(String qname){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ExMana> list = new ArrayList<ExMana>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qualification?useSSL=false",
					"userQ", "password");
			String sql = "select date, sno, name as sname from exmana, students where sno = no and qname = ? and sorf = \"合格\"";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qname);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String date = rs.getString("date");
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				ExMana exmana = new ExMana(date, sno, sname, qname, "合格");
				list.add(exmana);
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