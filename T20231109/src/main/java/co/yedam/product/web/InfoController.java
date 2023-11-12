package co.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.service.ProductVO;
import co.yedam.product.serviceImpl.ProductServiceImpl;

public class InfoController implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String path ="info/infoBody.tiles";
		String code = req.getParameter("prodCode");
		System.out.println(code);
		ProductServiceImpl impl = new ProductServiceImpl();
		ProductVO vo = impl.selectList(code);
		List<ProductVO> list = impl.selectAllList();
		req.setAttribute("vo", vo);
		req.setAttribute("list", list);

		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
