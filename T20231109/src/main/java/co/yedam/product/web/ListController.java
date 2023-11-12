package co.yedam.product.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.service.ProductVO;
import co.yedam.product.serviceImpl.ProductServiceImpl;

public class ListController implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String path = "list/body.tiles";
		//위 페이지로 보냄
		ProductServiceImpl impl = new ProductServiceImpl();
		List<ProductVO> list = new ArrayList<>();
		list = impl.selectAllList();
		req.setAttribute("list", list);
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
