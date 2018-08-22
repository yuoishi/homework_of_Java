package test;

import dao.LoginDAO;
import dto.Login;

public class LoginDAOTest {

	public static void main(String[] args) {
//		Login login = new Login("a", "a", "天野昭");
//		int row = LoginDAO.register(login);
//		if(row > 0){
//			System.out.println("テスト成功");
//		}else{
//			System.out.println("テスト失敗");
//		}
//		Login test = LoginDAO.search("a", "a");
//		System.out.println(test.getId());
//		System.out.println(test.getPw());
//		System.out.println(test.getName());
		String pw = LoginDAO.hash("admin");
		System.out.println(pw);
		Login test = LoginDAO.search("admin", pw);
		System.out.println(test.getName());
	}
}
