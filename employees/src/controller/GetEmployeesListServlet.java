package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.*;
import model.*;


@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
  private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int limit = 10;
		if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		System.out.println("GetEmployeesListServlet limit : "+limit);// 넘겨받은 값이 몇인지 확인하는 작업
		employeesDao = new EmployeesDao();
		List<Employees> list = employeesDao.selectEmployeesList(limit);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
	}


}
