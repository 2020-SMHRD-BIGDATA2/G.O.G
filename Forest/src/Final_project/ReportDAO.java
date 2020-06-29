package Final_project;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt;
	
	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "system";
			String db_pw = "12345";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public int take(ReportVO vo){ // 신고완료
		cnt = 0 ;
		
		getConnection();
		
		try {

			String sql = "INSERT INTO report VALUES(?,?,?,?,sysdate,rep_seq.nextval)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setInt(2, vo.getKind());
			psmt.setString(3, vo.getContents());
			psmt.setString(4, vo.getData());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		
		return cnt;
	}
	
	public String id_check(ReportVO vo) {
		String name = null;
		
		getConnection();		

		try {
			String sql = "SELECT * from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return name;
	}
	
	}

