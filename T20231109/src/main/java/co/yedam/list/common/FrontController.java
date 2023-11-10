package co.yedam.list.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.list.web.ProductListControl;

public class FrontController extends HttpServlet {

	Map<String, Command>map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		//목록화면
		map.put("/productList.do", new ProductListControl());	
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getServletContext().getContextPath();
		System.out.println(context);
		String page = uri.substring(context.length());
		System.out.println(page);
		System.out.println("map.get(page) = "+ map.get(page));
		
		Command controller = map.get(page);
		controller.execute(req, resp);
	}
}
