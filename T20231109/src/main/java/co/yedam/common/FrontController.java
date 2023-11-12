  

package co.yedam.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.product.service.ProductVO;
import co.yedam.product.serviceImpl.ProductServiceImpl;
import co.yedam.product.web.InfoBodyList;
import co.yedam.product.web.InfoController;
import co.yedam.product.web.ListController;

public class FrontController extends HttpServlet {

	Map<String, Command> map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
		map.put("/productList.do", new ListController());//new 생성자
		map.put("/productInfo.do", new InfoController());
		map.put("/infoBodyList.do", new InfoBodyList());
		
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service");
		
		// 연습용(이렇게 쓰면 각 요청마다 적어야 하는데 요청이 하나만 들어오더라도 전체 다 실행되기 때문에 위의 맵으로 뭉쳐야 함)
//		ListServiceImpl impl = new ListServiceImpl();
//		List<ListVO> list = new ArrayList<>();
//		list = impl.selectAllList();
//		PrintWriter out = resp.getWriter();
//		out.print(list);
		
		//요청정보의 한글 인코딩 방식
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI(); //현재주소 = /T20231109/main.do
		System.out.println(uri);
		String context = req.getServletContext().getContextPath();//현재 주소에서 현재 프로젝트의 이름 = T20231109
		String page = uri.substring(context.length());//현재주소에서 프로젝트명 뒤부터 끝까지 잘라냄 = /main.do
		Command controller = map.get(page);
		controller.execute(req, resp);
	}
}
