package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import db.DBHelper;

public class SalariesDao {
	public Map<String, Long> selectSalariesStatistics() {
		Map<String, Long> map = new HashMap<String, Long>();
		final String sql = "SELECT COUNT(salary),SUM(salary),AVG(salary),MAX(salary),MIN(salary),STD(salary) FROM salaries";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) { //
				map.put("count",rs.getLong("COUNT(salary)"));
				map.put("sum",rs.getLong("SUM(salary)"));
				map.put("avg",rs.getLong("AVG(salary)"));
				map.put("max",rs.getLong("MAX(salary)"));
				map.put("min",rs.getLong("MIN(salary)"));
				map.put("std",rs.getLong("STD(salary)"));
			}
		} catch(Exception e) { // 자바의 변수 생명주기 {}
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return map;
	}
	public int selectSalariesRowCount() {//총 몇행인지 알기위한 메서드 index servlet으로 호출
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM salaries";
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
