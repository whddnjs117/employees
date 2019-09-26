package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
@WebServlet("/employees/getEmployeesCountByGender")

public class GetEmployeesCountByGenderServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //처음으로 요청할때 받아온다
		
		if(session.getAttribute("sessionEmpNo") == null) { //처음으로 접속이거나 로그인을 하지않으면 반응한다.
			response.sendRedirect(request.getContextPath()+"/login");
			return; //밑에있는 메서드를 실행시키지않기위해서 return으로 실행을 종료
		}
		employeesDao = new EmployeesDao();
		List<Map<String, Object>> list = employeesDao.selectEmployeesCountGroupByGender();
		
		request.setAttribute("list",list);
		
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesCountByGender.jsp").forward(request, response);
	}


}
