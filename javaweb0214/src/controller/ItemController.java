package controller;

import java.io.IOException;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
