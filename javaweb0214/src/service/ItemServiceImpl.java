package service;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import domain.Item;

public class ItemServiceImpl implements ItemService {
	private ItemDao itemDao;
	
	//생성자와 유사한 역할을 수행하는 초기화 블럭
	//인스턴스가 생성될 때 이 코드를 수행
	{
		itemDao = new ItemDao();
	}

	@Override
	public int insert(HttpServletRequest request) {
		try {
			Item item = new Item();
			
			//파라미터 인코딩
			request.setCharacterEncoding("utf-8");
			//파라미터 읽기
			String num = request.getParameter("num");
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String manufacture = request.getParameter("manufacture");
			String description = request.getParameter("description");
			
			//Dao의 매개변수 만들기
			item.setNum(Integer.parseInt(num));
			item.setName(name);
			item.setPrice(Integer.parseInt(price));
			item.setManufacture(manufacture);
			item.setDescription(description);
			
			//Dao의 메소드를 호출해서 결과를 리턴
			return itemDao.insert(item);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
}











