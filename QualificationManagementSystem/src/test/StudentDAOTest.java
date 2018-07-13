package test;

import java.util.ArrayList;

import dao.StudentDAO;
import dto.Student;

public class StudentDAOTest {

	public static void main(String[] args) {
		Student student = new Student("4181142", "テスト2", 1, 1);
		int result = StudentDAO.register(student);
		if(result != 0){
			System.out.println("テスト成功");
		}else{
			System.out.println("テスト失敗");
		}
		ArrayList<Student> list = StudentDAO.show();
		for(Student s : list){
			System.out.print(s.getNo() + " ");
			System.out.print(s.getName() + " ");
			System.out.print(s.getGrade() + " ");
			System.out.print(s.getClas() + " \n");
		}
	}
}