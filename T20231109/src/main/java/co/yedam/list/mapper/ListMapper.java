package co.yedam.list.mapper;

import java.util.List;

import co.yedam.list.service.ListVO;

public interface ListMapper {
	//목록보기
	public List<ListVO> selectList();
	public ListVO select(String prodCode);

}
