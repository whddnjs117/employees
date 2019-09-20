package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import vo.*;

public class DepartmentsDao {
	public List<Departments> selectDepartmentsList() {
		List<Departments> list = new ArrayList<Departments>(); //다형성때문에 List로 선언한다.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT dept_no,dept_name FROM departments";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Departments departments = new Departments(); //객체를 생성한다.
				departments.setDeptNo(rs.getString("dept_no")); //객체의 필드에 값을 저장한다.
				departments.setDeptName(rs.getString("dept_name"));
				list.add(departments); //필드를저장한 객체를 동적배열에 저장한다.
			}
		} catch (Exception e) { //예외가 발생할경우를 우려해서 무슨오류가발생햇는지 출력
			e.printStackTrace();
		} finally {
			try {
				rs.close(); //예외가발생하더라고 톰켓에 누적되지않기위해 닫아준다.
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
