package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelper;

import java.sql.*;
import vo.*;

public class DepartmentsDao {
	public List<Map<String, Object>> selectDepartmentsCountByDeptNo() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//sql 해석 dept_no 가같은것을 출력을한다. 조건은 퇴사일이 9999-01-01로되어있으며 count가 많은 순서대로 정렬해서 출력한다
		String sql = "select d.dept_no,d.dept_name ,count(de.dept_no) from dept_emp de inner join departments d on de.dept_no = d.dept_no where de.to_date = '9999-01-01' group by de.dept_no order by count(de.dept_no) desc";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("deptNo",rs.getString("d.dept_no"));
				map.put("deptName",rs.getString("d.dept_name"));
				map.put("count",rs.getInt("count(de.dept_no)"));
				list.add(map);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	public int selectDepartmentsRowCount() {//총 몇행인지 알기위한 메서드 index servlet으로 호출
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM departments";
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
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	public List<Departments> selectDepartmentsList() {
		List<Departments> list = new ArrayList<Departments>(); //다형성때문에 List로 선언한다.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT dept_no,dept_name FROM departments";
		try {
			conn = DBHelper.getConnection();
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
			DBHelper.close(rs, stmt, conn);
		}
		
		return list;
	}
}
