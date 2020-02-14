package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿을 호출할 URL 패턴을 설정
//auth 디렉토리가 포함된 URL을 처리 - 최근에는 디렉토리 패턴을 많이 사용
@WebServlet({"/auth/*"})
public class DoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통된 URL을 제거한 사용자 요청 경로와 전송방식을 출력
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		//요청방식 확인
		String method = request.getMethod();
		
		//Controller에서는 URL 과 Method를 이용해서 요청을 구분해서 처리
		//Spring에서는 이 작업까지를 해서 우리는 작성만 하면 됩니다.
		
		response.getWriter().append("<h3>" + command + ":" + 
				method +"</h3>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}








