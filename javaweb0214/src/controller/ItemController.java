package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ItemService;
import service.ItemServiceImpl;

@WebServlet("/item/*")
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
		if(command.contentEquals("/item/insert") && method.equals("GET")) {
			//현재 URL이 /item/insert 라서 WebContent 디렉토리로 이동할려면 item을 제거해야 해서
			//../를 추가하고 views/insert.jsp로 포워딩
			//WebContent/views/insert.jsp 파일이 존재해야 합니다.
			dispatcher = request.getRequestDispatcher("../views/insert.jsp");
			dispatcher.forward(request, response);
		}else if(command.contentEquals("/item/insert") && method.equals("POST")) {
			//작업을 수행해야 하는 경우는 Service의 메소드를 호출
			itemService.insert(request);
			//결과 페이지로 이동 - 삽입, 삭제, 갱신은 반드시 리다이렉트로 이동
			//자신의 요청이 /item/insert 이므로 /item/list로 갈때는 공통된 부분은 제외하고 설정
			response.sendRedirect("./list");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




