package service;

import dao.ItemDao;

public class ItemServiceImpl implements ItemService {
	private ItemDao itemDao;
	
	//생성자와 유사한 역할을 수행하는 초기화 블럭
	//인스턴스가 생성될 때 이 코드를 수행
	{
		itemDao = new ItemDao();
	}
}
