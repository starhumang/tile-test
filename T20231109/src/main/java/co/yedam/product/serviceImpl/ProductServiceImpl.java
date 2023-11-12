package co.yedam.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSourceMybatis;
import co.yedam.product.mapper.ProductMapper;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
	SqlSession sqlSession = DataSourceMybatis.getInstance().openSession(true);
	//true는 자동커밋
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
	//ListMapper.java 사용함
	
	@Override
	public List<ProductVO> selectAllList() {
		return mapper.getAllList();
	}

	@Override
	public ProductVO selectList(String prodCode) {		
		return mapper.getList(prodCode);
	}

}
