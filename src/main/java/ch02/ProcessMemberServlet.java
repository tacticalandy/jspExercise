package ch02;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessMemberServlet
 */
@WebServlet("/ch02/member.do")
public class ProcessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者輸入的資料
		String id = request.getParameter("mId");
		String password = request.getParameter("pswd");
		String name = request.getParameter("mName");
		String address = request.getParameter("mAddress");
		String phone = request.getParameter("mPhone");

		String bday = request.getParameter("mBirthday");
		java.sql.Date date = null;
		try {
			date = java.sql.Date.valueOf(bday);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Timestamp ts = new Timestamp(System.currentTimeMillis());

		String weight = request.getParameter("mWeight");
		double dWeight = -1;
		try {
			dWeight = Double.parseDouble(weight.trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		//封裝輸入的資料
		MemberBean mb =
				new MemberBean(id, name, password, address, phone, date, ts, dWeight);
		//把資料寫出並跳轉頁面
		try {
			MemberFileIO mfio = new MemberFileIO("c:\\JSP\\data\\member.dat");
			mfio.insertMember(mb);
			request.setAttribute("memberBean", mb);
			RequestDispatcher rd =
					request.getRequestDispatcher("/ch02/InsertMemberSuccess.jsp");
			rd.forward(request, response);
			return;
		} catch (IOException e) {
			RequestDispatcher rd =
					request.getRequestDispatcher("/ch02/InsertMemberError.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
