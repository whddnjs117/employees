package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;

public class TitlesDao {
	public List<String> selecTitlesListDistinct() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT DISTINCT title FROM titles"; //중복된값이 있으면 다시 출력하지않는 쿼리문
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) { //
				list.add(rs.getString("title")); //title을 출력된것을 list 변수에 문자열로 (배열) 저장한다.
			}
		} catch(Exception e) { // 자바의 변수 생명주기 {}
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	public int selectTitlesRowCount() {//총 몇행인지 알기위한 메서드 index servlet으로 호출
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM titles";
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
