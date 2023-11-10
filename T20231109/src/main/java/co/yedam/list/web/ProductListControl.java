package co.yedam.list.web;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.list.common.Command;
import co.yedam.list.service.ListService;
import co.yedam.list.service.ListVO;
import co.yedam.list.serviceImpl.ListServiceImpl;

public class ProductListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String path = "list/productList.tiles";
		ListService svc = new ListServiceImpl();
		List<ListVO> list = svc.boardList();
		System.out.println(list);
		
		req.setAttribute("list", list);
		
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
