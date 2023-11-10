package co.yedam.list.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.list.common.DataSourceMybatis;
import co.yedam.list.mapper.ListMapper;
import co.yedam.list.service.ListService;
import co.yedam.list.service.ListVO;

public class ListServiceImpl implements ListService {

	SqlSession sqlSession = DataSourceMybatis.getInstance().openSession(true);
	ListMapper mapper = sqlSession.getMapper(ListMapper.class);
	
	@Override
	public List<ListVO> boardList() {
		System.out.println(mapper.selectList());
		return mapper.selectList();
	}

	@Override
	public ListVO getList(String prodCode) {
		return mapper.select(prodCode);
	}

}
