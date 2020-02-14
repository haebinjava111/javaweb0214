package service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Item> list(HttpServletRequest request) {
		List<Item> list = new ArrayList<Item>();
		
		Item item = new Item();
		item.setNum(1);
		item.setName("사과");
		item.setPrice(5000);
		item.setManufacture("충북 청송");
		item.setDescription("비타민 C가 풍부");
		list.add(item);
		
		item = new Item();
		item.setNum(2);
		item.setName("딸기");
		item.setPrice(4000);
		item.setManufacture("충남 논산");
		item.setDescription("하우스 딸기");
		list.add(item);
		
		item = new Item();
		item.setNum(3);
		item.setName("천혜향");
		item.setPrice(8000);
		item.setManufacture("제주");
		item.setDescription("감귤보다 맛있음");
		list.add(item);
		//아이템 목록을 리턴할 때 데이터의 개수 0 이면 조회된 데이터가 없는 것입니다.
		//List는 null을 리턴하지 않도록 해야 합니다.
		//List는 반복문에 사용하기 때문에 null을 리턴하면 예외가 발생합니다.
		return list;
	}
}











