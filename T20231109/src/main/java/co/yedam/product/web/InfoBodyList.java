package co.yedam.product.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Command;
import co.yedam.product.service.ProductVO;
import co.yedam.product.serviceImpl.ProductServiceImpl;

public class InfoBodyList implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String code = req.getParameter("prodCode");
		ProductServiceImpl impl = new ProductServiceImpl();
		List<ProductVO> list = impl.selectAllList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);


		out.println(json);
	}

}
