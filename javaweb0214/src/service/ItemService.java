package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.Item;

public interface ItemService {
	//데이터 삽입을 위한 메소드
	//Service는 Controller로 부터 request를 넘겨받아서 클라이언트의 데이터를 읽고
	//작업을 수행한 후 리턴을 합니다.
	public int insert(HttpServletRequest request);
	
	//아이템 목록을 가져오는 메소드
	public List<Item> list(HttpServletRequest request);
}





