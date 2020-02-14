package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Item;
import service.ItemService;
import service.ItemServiceImpl;

@WebServlet({"/item/*", "/el/*"})
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//템플릿 메소드 패턴으로 만들어진 클래스는
	//변수는 인터페이스 타입으로 선언하고 인스턴스는 클래스 타입으로 생성해서 대입
	private ItemService itemService;
       
    public ItemController() {
        super();
        itemService = new ItemServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//분기를 위해서 필요한 데이터를 가져오기
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		String method = request.getMethod();
		
		//포워딩에 사용하기 위한 변수
		RequestDispatcher dispatcher = null;
		//단순 페이지 이동은 포워딩 하는 것이 좋습니다.
		if(command.equals("/item/insert") && method.equals("GET")) {
			//현재 URL이 /item/insert 라서 WebContent 디렉토리로 이동할려면 item을 제거해야 해서
			//../를 추가하고 views/insert.jsp로 포워딩
			//WebContent/views/insert.jsp 파일이 존재해야 합니다.
			dispatcher = request.getRequestDispatcher("../views/insert.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/item/insert") && method.equals("POST")) {
			//작업을 수행해야 하는 경우는 Service의 메소드를 호출
			itemService.insert(request);
			//결과 페이지로 이동 - 삽입, 삭제, 갱신은 반드시 리다이렉트로 이동
			//자신의 요청이 /item/insert 이므로 /item/list로 갈때는 공통된 부분은 제외하고 설정
			response.sendRedirect("./list");
		}else if(command.equals("/item/list") && method.equals("GET")) {
			//데이터를 검색해서 조회해야 하는 경우는 데이터를 검색하고 그 결과를 request에 저장하고
			//결과 페이지로 포워딩
			List<Item> list = itemService.list(request);
			request.setAttribute("list", list);
			
			dispatcher = request.getRequestDispatcher("../views/list.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/el/disp")) {
			//데이터 저장
			request.setAttribute("msg", "Hello EL");
			//List, Map, Item 클래스의 객체를 저장
			List<String> list = new ArrayList<String>();
			list.add("List");
			list.add("Set");
			list.add("Map");
			
			//Map 객체를 생성
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("Encapsulation", "클래스와 인스턴스를 만드는 것");
			map.put("Inheritance", "상위 클래스의 모든 것을 하위 클래스가 물려받는 것");
			map.put("Polymorphism",
					"동일한 코드가 대입되는 인스턴스에 따라 다른 메소드를 호출하는 것");
			
			//DTO 객체를 생성
			Item item = new Item();
			item.setNum(1);
			item.setName("딸기");
			item.setPrice(4000);
			item.setManufacture("충남 논산");
			item.setDescription("하우스에서 생성");
			
			//데이터 저장
			request.setAttribute("list", list);
			request.setAttribute("map", map);
			request.setAttribute("item", item);
			
			dispatcher = request.getRequestDispatcher("../views/disp.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/el/datadisplay")) {
			//전달하는 데이터
			request.setAttribute("message", "Hello Message");
			
			//출력할 페이지
			dispatcher = request.getRequestDispatcher("../views/data.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/el/jstl") && method.equals("GET")) {
			//출력할 페이지
			dispatcher = request.getRequestDispatcher("../views/jstl.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




