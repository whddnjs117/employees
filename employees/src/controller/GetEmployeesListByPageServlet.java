package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;


@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		int rowPerPage= 10; //기본값을 설정
		if(request.getParameter("rowPerPage") != null) { //아무것도 넘겨받아온값이 있을때
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		int currentPage=1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		List<Employees> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		
		int lastPage = employeesDao.selectEmployeesRowCount(); //전체행의 갯수를 읽는 메서드를 가져와서 마지막페이지에는 다음버튼이 출력되지않기위한 변수
		if(lastPage%rowPerPage==0) {
			lastPage = lastPage/rowPerPage; //마지막페이지랑 맞아떨어질때
		} else {
			lastPage = (lastPage/rowPerPage)+1; //마지막페이지랑 나눠떨어지지않을때
		}
		request.setAttribute("list",list);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
		
		System.out.println("getEmpoyeesListByPage currnetPage : "+currentPage);
	}

}
