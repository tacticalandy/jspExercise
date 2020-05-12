package ch05_01;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ch05_01/ProduceDataServlet")
public class ProduceDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 本程式將產生資料，然後轉交給JSP，由JSP顯示出來。
		// 第一份資料為字串物件，它將會以"Customer"為識別字串，存放在request範圍(requestScope)
		String str1 = "史努比先生";
		request.setAttribute("Customer", str1);
		
		// 第二份資料為JavaBean物件，它將會以"PB"為識別字串，存放在request範圍(requestScope)
		ProductBean pb0 = new ProductBean("A0001", "橡皮擦", 15.0, 0.15);
		request.setAttribute("PB", pb0);
		
		// 第三份資料為Map物件，它將會以"MapKey"為識別字串，存放在request範圍(requestScope)
		Map<String , ProductBean>  map = new HashMap<String, ProductBean>();
		ProductBean pb1 = new ProductBean("H0251", "2B鉛筆", 12.0, 0.10);
		ProductBean pb2 = new ProductBean("H0252", "藍色原子筆", 15.0, 0.12);
		map.put("key001", pb1);
		map.put("key002", pb2);
		request.setAttribute("MapKey", map);
		RequestDispatcher rd = request.getRequestDispatcher("/ch05_01/ShowData.jsp");
		rd.forward(request, response);
		return;	
	}
}
