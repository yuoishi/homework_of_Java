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
		String view = "/WEB-INF/view/";

		if("0".equals(flg)){
			/*「受験データ一覧表示」リンククリック時の処理*/
			view += "exmanaDL.jsp";
			ArrayList<ExMana> list = ExManaDAO.show();
			request.setAttribute("exmana", list);
		}else{
			/*「受験データ登録」リンククリック時の処理*/
			view += "exmanaR.jsp";
			ArrayList<Qualification> list = QualificationDAO.show();
			request.setAttribute("qualification", list);
		}

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