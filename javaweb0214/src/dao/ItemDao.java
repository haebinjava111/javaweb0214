package dao;

import domain.Item;

public class ItemDao {
	//데이터 삽입, 삭제, 갱신은 리턴타입이 int(영향받은 행의 개수)
	//삽입과 갱신은 매개변수가 Domain 클래스 1개
	//삭제는 상황에 따라 다르지만 대부분 기본키 1개
	public int insert(Item item) {
		//return 데이터 삽입 메소드;
		return 1;
	}
}
