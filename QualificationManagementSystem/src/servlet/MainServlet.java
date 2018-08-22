package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExManaDAO;
import dao.LoginDAO;
import dao.QualificationDAO;
import dao.StudentDAO;
import dto.ExMana;
import dto.Login;
import dto.Qualification;
import dto.Student;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/view/";

		String flg = request.getParameter("flg");
		int row = -1;

		/*受験データを登録する処理*/
		if("emR".equals(flg)){
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");

			/*0埋め*/
			if(Integer.parseInt(month) < 10){
				month = "0" + month;
			}
			if(Integer.parseInt(day) < 10){
				day = "0" + day;
			}

			String date = year + "-" + month + "-" + day;
			String no = request.getParameter("no");
			String qName = request.getParameter("qname");
			String sorf = request.getParameter("sorf");

			ExMana exmana = new ExMana(date, no, null, qName, sorf);
			row = ExManaDAO.register(exmana);
		}

		/*学生データを登録する処理*/
		if("sR".equals(flg)){
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			int grade = Integer.parseInt(request.getParameter("grade"));
			int clas = Integer.parseInt(request.getParameter("class"));

			Student student = new Student(no, name, grade, clas);
			row = StudentDAO.register(student);
		}

		/*資格データを登録する処理*/
		if("qR".equals(flg)){
			int qId = Integer.parseInt(request.getParameter("qid"));
			String qName = request.getParameter("qname");
			int qGrade = Integer.parseInt(request.getParameter("qgrade"));

			Qualification qualification = new Qualification(qId, qName, qGrade);
			row = QualificationDAO.register(qId, qName, qGrade);
		}

		/*アカウントデータを登録する処理*/
		if("aR".equals(flg)){
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String tName = request.getParameter("tname");

			Login account = new Login(id, pw, tName);
			row = LoginDAO.register(account);
		}

		/*登録完了したか確認*/
		if(row > 0){
			request.setAttribute("flg", flg);
			view += "registrationCompletion.jsp";
		}else if(row == 0){
			request.setAttribute("flg", flg);
			view += "registrationError.jsp";
		}else{
			view += "main.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String password = LoginDAO.hash(pw);
		Login login = LoginDAO.search(id, password);

		String view = "/WEB-INF/view/";

		HttpSession hs = request.getSession();
		if(id.equals(login.getId()) && password.equals(login.getPw())){
			/*ログインに成功したらスコープにユーザ情報を登録*/
			hs.setAttribute("login", login);
			view += "main.jsp";
		}else{
			/*ログインに失敗したらトップページに戻す*/
			view += "top.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}