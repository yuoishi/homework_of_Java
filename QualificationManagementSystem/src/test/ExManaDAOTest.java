package test;

import java.util.ArrayList;

import dao.ExManaDAO;
import dto.ExMana;

public class ExManaDAOTest {

	public static void main(String[] args) {
//		ExMana exmana = new ExMana("2018-7-2", "4181103", "安倍晋三", "基本情報技術者試験", "不合格");
//		int result = ExManaDAO.register(exmana);
//		if(result != 0){
//			System.out.println("テスト成功");
//		}else{
//			System.out.println("テスト失敗");
//		}
		ArrayList<ExMana> list = ExManaDAO.show(1, 0);
		for(ExMana exmana : list){
			System.out.print(exmana.getDate() + " ");
			System.out.print(exmana.getSno() + " ");
			System.out.print(exmana.getSname() + " ");
			System.out.print(exmana.getQname() + " ");
			System.out.print(exmana.getSorf());
			System.out.println();
		}
	}
}