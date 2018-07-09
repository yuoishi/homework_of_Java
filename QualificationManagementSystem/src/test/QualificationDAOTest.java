package test;

import java.util.ArrayList;

import dao.QualificationDAO;
import dto.Qualification;

public class QualificationDAOTest {

	public static void main(String[] args) {
		int row = QualificationDAO.register(1301, "OracleJavaSilver", 2);
		if(row > 0){
			System.out.println("テスト成功");
		}else{
			System.out.println("テスト失敗");
		}
		ArrayList<Qualification> list = QualificationDAO.show();
		for(Qualification q : list){
			System.out.print(q.getId() + " ");
			System.out.print(q.getName() + " ");
			System.out.print(q.getGrade() + " \n");
		}
	}
}