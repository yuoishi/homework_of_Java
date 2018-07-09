package test;

import dao.StudentDAO;
import dto.Student;

public class StudentDAOTest {

	public static void main(String[] args) {
		Student student = new Student("4181141", "テストです", 1, 1);
		int result = StudentDAO.register(student);
		if(result != 0){
			System.out.println("テスト成功");
		}else{
			System.out.println("テスト失敗");
		}
	}
}