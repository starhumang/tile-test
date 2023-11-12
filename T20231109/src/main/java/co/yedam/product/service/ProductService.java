package co.yedam.product.service;

import java.util.List;

public interface ProductService {
	
	//목록보기, 상세조회
	public List<ProductVO> selectAllList();
	public ProductVO selectList(String prodCode);
}
