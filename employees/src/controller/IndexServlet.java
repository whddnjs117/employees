package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private DeptManagerDao deptManagerDao;
	private DeptEmpDao deptEmpDao;
	private TitlesDao titlesDao;
	private SalariesDao salariesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//EmployeesDao employeesDao = new EmployeesDao();
		this.employeesDao = new EmployeesDao();
		int employeesRowCount = employeesDao.selectEmployeesRowCount();
		
		departmentsDao = new DepartmentsDao();
		int departmentsRowCount = departmentsDao.selectDepartmentsRowCount();
		
		deptManagerDao = new DeptManagerDao();
		int deptManagerRowCount = deptManagerDao.selectDeptManagerRowCount();
		
		deptEmpDao = new DeptEmpDao();
		int deptEmpRowCount = deptEmpDao.selectDeptEmpRowCount();
		
		titlesDao = new TitlesDao();
		int titlesRowCount = titlesDao.selectTitlesRowCount();
		
		salariesDao = new SalariesDao();
		int salariesRowCount = salariesDao.selectSalariesRowCount();
		
		// /WEB-INF/views/index.jsp
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		//rd.forward(request, response); 
		
		request.setAttribute("employeesRowCount", employeesRowCount);
		request.setAttribute("departmentsRowCount", departmentsRowCount);
		request.setAttribute("deptManagerRowCount", deptManagerRowCount);
		request.setAttribute("deptEmpRowCount", deptEmpRowCount);
		request.setAttribute("titlesRowCount", titlesRowCount);
		request.setAttribute("salariesRowCount",salariesRowCount);
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
