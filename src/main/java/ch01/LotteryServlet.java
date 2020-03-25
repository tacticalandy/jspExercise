package ch01;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LotteryServlet
 */
@WebServlet("/ch01/LotteryServlet")
public class LotteryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8"); //說明傳送到本程式之資料的內碼
			String name = request.getParameter("visitor"); //讀取瀏覽器送來的資料("visitor")
			if (name == null || name.trim().length() == 0) {
				name = "訪客";  //如果讀不到使用者輸入的資料，將變數name設為"訪客"
			}
			LotteryBean lottery = new LotteryBean();
			lottery.setLowerBound(1);
			lottery.setUpperBound(49);
			lottery.setBallNumber(6);
			Collection coll = lottery.getLuckyNumbers();
			request.setAttribute("visitName", name);
			request.setAttribute("luckyNumber", coll);
			RequestDispatcher rd = request.getRequestDispatcher("/ch01/goodLuck.jsp");
			rd.forward(request, response);
			return;
			
		} catch (UnsupportedEncodingException e) {
			throw new ServletException(e);
		}
		
	}
}
