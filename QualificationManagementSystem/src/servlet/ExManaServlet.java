package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExManaDAO;
import dao.QualificationDAO;
import dto.ExMana;
import dto.Qualification;

/**
 * Servlet implementation class ExManaServlet
 */
@WebServlet("/ExMana")
public class ExManaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExManaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flg = request.getParameter("flg");
		String scope = request.getParameter("scope");
		String extraction = request.getParameter("extraction");

		String view = "/WEB-INF/view/";

		if("0".equals(flg)){
			if("scope".equals(scope)){
				/*学年・クラスごとに一覧を管理する処理*/
				int grade = Integer.parseInt(request.getParameter("grade"));
				int clas = Integer.parseInt(request.getParameter("class"));
				ArrayList<ExMana> list = ExManaDAO.show(grade, clas);
				request.setAttribute("exmana", list);
			}else if("extraction".equals(extraction)){
				/*指定した資格の合格者のみ抽出する処理*/
				String qName = request.getParameter("qname");
				ArrayList<ExMana> list = ExManaDAO.show(qName);
				request.setAttribute("exmana", list);
			}else{
				/*「受験データ一覧表示」リンククリック時の処理*/
				ArrayList<ExMana> list = ExManaDAO.show();
				request.setAttribute("exmana", list);
			}

			view += "exmanaDL.jsp";
		}else{
			/*「受験データ登録」リンククリック時の処理*/
			view += "exmanaR.jsp";
		}

		ArrayList<Qualification> qList = QualificationDAO.show();
		request.setAttribute("qualification", qList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}