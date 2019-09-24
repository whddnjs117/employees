package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBHelper;

public class DeptManagerDao {
	public int selectDeptManagerRowCount() {//총 몇행인지 알기위한 메서드 index servlet으로 호출
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM dept_manager";
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
