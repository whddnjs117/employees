package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import db.DBHelper;

public class EmployeesDao {
	public String login(Employees employees) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sessionEmpNo = null;
		String sql = "SELECT emp_no,first_name,last_name FROM employees WHERE emp_no = ? AND (first_name = ? AND last_name = ?)";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,employees.getEmpNo());
			stmt.setString(2, employees.getFirstName());
			stmt.setString(3,employees.getLastName());
			rs = stmt.executeQuery();
			if(rs.next()) {
				sessionEmpNo = rs.getString("emp_no");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return sessionEmpNo;
	}
	public List<Employees> selectEmployeesListByPage(int currentPage,int rowPerPage) {
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees limit ?,?";//첫번째? 어디부터 두번째? 몇개를 출력할것인지
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			int startRow = (currentPage-1)*rowPerPage; //몇부터 시작할지는 정하기위한과정
			stmt.setInt(1,startRow);
			stmt.setInt(2,rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	public int selectEmpNo(String str) {
		int empNo = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "";
		if(str.equals("max")) { //emp_no의 최대값을
			sql = "SELECT MAX(emp_no) FROM employees";
		} else if(str.equals("min")) { //최솟값을
			sql = "SELECT MIN(emp_no) FROM employees";
		}
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				empNo = rs.getInt(1); //sql이 조건에 따라 달리질수가있으므로 인덱스값을 이용
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return empNo;
	}
	public List<Employees> selectEmployeesListBetween(int begin,int end) {
		List<Employees> list = new ArrayList<Employees>(); //다형성때문에 List로 선언한다.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees WHERE emp_no BETWEEN ? AND ? ORDER BY emp_no ASC";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,begin);
			stmt.setInt(2,end);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	public List<Map<String, Object>> selectEmployeesCountGroupByGender() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); //배열안에 haspmap을 이용하여 어느이름에 어느값을 저장할지를 설정
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT gender,COUNT(gender) cnt FROM employees GROUP BY gender"; //GROUP BY는 DISTINCT(생략) 랑은 다르게 중복값을 묶어둔다고 생각하면된다.
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("gender",rs.getString("gender"));
				map.put("cnt",rs.getString("cnt"));
				list.add(map);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	public List<Employees> selectEmployListOrderBy(String order) { //오름차순또는 내림차순을위한 메서드를 생성
		System.out.println("selectEmployListOrderBy order :" + order);
		List<Employees> list = new ArrayList<Employees>(); //다형성때문에 List로 선언한다.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "";
		if(order.equals("asc")) { //오름차순으로
			sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees ORDER BY first_name ASC LIMIT 50";
		} else if(order.equals("desc")) { //내림차순으로
			sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees ORDER BY first_name DESC LIMIT 50";
		}
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	public List<Employees> selectEmployeesList(int limit) {
		System.out.println("selectEmplyeesList limit : "+limit); //값이 정상적으로 넘어오는지확인작업
		List<Employees> list = new ArrayList<Employees>(); //다형성때문에 List로 선언한다.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees LIMIT ?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, limit);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	public int selectEmployeesRowCount() {//총 몇행인지 알기위한 메서드 index servlet으로 호출
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM employees";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) { //
				count = rs.getInt("COUNT(*)");
			}
		} catch(Exception e) { // 자바의 변수 생명주기 {}
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}
}
