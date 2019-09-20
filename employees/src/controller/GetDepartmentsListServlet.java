package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import vo.*;


@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		departmentsDao = new DepartmentsDao();
		List<Departments> list = departmentsDao.selectDepartmentsList(); //메서드를 호출하여 동적배열에 저장한다.
		
		request.setAttribute("list",list); //속성을 이용하여 넘겨받을수 있게 list라는 이름에 list 변수를 저장한다.
		
		//jsp파일에 값을 넘겨주기위해서 연결한다.
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);
	}


}
