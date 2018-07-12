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
		String flg = request.getParameter("flg");

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
			int row = ExManaDAO.register(exmana);
		}

		/*学生データを登録する処理*/
		if("sR".equals("flg")){
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			int grade = Integer.parseInt(request.getParameter("grade"));
			int clas = Integer.parseInt(request.getParameter("class"));

			Student student = new Student(no, name, grade, clas);
			int row = StudentDAO.register(student);
		}

		/*資格データを登録する処理*/
		if("qR".equals("flg")){
			int qId = Integer.parseInt(request.getParameter("qid"));
			String qName = request.getParameter("qname");
			int qGrade = Integer.parseInt(request.getParameter("qgrade"));

			Qualification qualification = new Qualification(qId, qName, qGrade);
			int row = QualificationDAO.register(qId, qName, qGrade);
		}

		String view = "/WEB-INF/view/main.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Login login = LoginDAO.search(id, pw);

		HttpSession hs = request.getSession();
		if(id.equals(login.getId()) && pw.equals(login.getPw())){
			/*ログインに成功したらスコープにユーザ情報を登録*/
			hs.setAttribute("login", login);
			doGet(request, response);
		}else{
			/*ログインに失敗したらトップページに戻す*/
			String view = "/WEB-INF/view/top.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}