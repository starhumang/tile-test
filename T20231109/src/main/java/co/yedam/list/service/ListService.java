package co.yedam.list.service;

import java.util.List;

public interface ListService {
	
	//목록조회
	public List<ListVO> boardList();
	public ListVO getList(String prodCode);

}
