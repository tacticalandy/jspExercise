package ch05_03;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessMemberServlet
 */
@WebServlet("/ch05_03/member.do")
public class ProcessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定義存放錯誤訊息的Collection物件
		Map<String,String> errorMessage = new HashMap<String,String>();
		request.setAttribute("ErrorMsg", errorMessage);
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者輸入的資料
		String id = request.getParameter("mId");
		// 檢查使用者所輸入的資料是否為空值
		if (id == null || id.trim().length() == 0) {
			errorMessage.put("id","帳號欄必須輸入");
		}
		String password = request.getParameter("pswd");
		if (password == null || password.trim().length() == 0) {
			errorMessage.put("password","密碼欄必須輸入");
		}
		String name = request.getParameter("mName");
		if (name == null || name.trim().length() == 0) {
			errorMessage.put("name","姓名欄必須輸入");
		}
		String address = request.getParameter("mAddress");
		if (address == null || address.trim().length() == 0) {
			errorMessage.put("address","地址欄必須輸入");
		}
		String phone = request.getParameter("mPhone");

		String bday = request.getParameter("mBirthday");
		java.sql.Date date = null;
		if (bday != null && bday.trim().length() > 0) {
			try {
				date = java.sql.Date.valueOf(bday);
			} catch (IllegalArgumentException e) {
				errorMessage.put("bday","生日欄格式錯誤");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Timestamp ts = new Timestamp(System.currentTimeMillis());

		String weight = request.getParameter("mWeight");
		double dWeight = -1;
		if (weight != null && weight.trim().length() > 0) {
			try {
				dWeight = Double.parseDouble(weight.trim());
			} catch (NumberFormatException e) {
				errorMessage.put("weight","體重欄必須為數值");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/ch05_03/insertMemberForm.jsp");
			rd.forward(request, response);
			return;
		}
		HttpSession session = request.getSession();
		// 封裝輸入的資料
		MemberBean mb = new MemberBean(id, name, password, address, phone, date, ts, dWeight);
		// 把資料寫出並跳轉頁面
		try {
			MemberService service = new MemberService();
			service.insertMember(mb);
//			request.setAttribute("memberBean", mb);
			// 依照執行的結果挑選適當的view元件，送回相關訊息
//			RequestDispatcher rd = request.getRequestDispatcher("/ch05_03/InsertMemberSuccess.jsp");
//			rd.forward(request, response);
			// 用forward轉址的缺點在於轉移是在服務器內運作，使用者的瀏覽器網址不會更改
			// 當使用者按下重新整理(F5)時會導致重新傳送請求，造成二次insertMember
			// 然後因為沒有用forward移交資料給InsertMemberSuccess.jsp
			// 要另外用session來儲存需要顯示的訊息
			session.setAttribute("memberBean", mb);
			response.sendRedirect("InsertMemberSuccess.jsp");
			return;
		} catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 || e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.put("id","帳號重複，請重新輸入帳號");
			} else {
				errorMessage.put("exception","資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ch05_03/insertMemberForm.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
