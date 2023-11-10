package co.yedam.list.service;

import lombok.Data;

@Data
public class ListVO {
	private String prodCode;
	private String prodName;
	private String prodDesc;
	private int price;
	private int offPrice;
	private int likeIt;
	private String prodImage;
	
	
}
