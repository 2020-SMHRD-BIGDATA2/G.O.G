package Final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequestDAO {
	
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
			if (rs!=null) {
				rs.close();
			}
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
	
	public int take(RequestVO vo){ // 신청완료
		cnt = 0;
		
		getConnection();
		
		try {

			String sql = "INSERT INTO request VALUES(?,?,?,?,?,?,sysdate,req_seq.nextval)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getLocation());
			psmt.setInt(3, vo.getTime());
			psmt.setString(4, vo.getSeldate());
			psmt.setInt(5, vo.getReason());
			psmt.setString(6, vo.getAsk());
			
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;	
		
	}
	
	public String id_check(RequestVO vo) {
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
	

//	public int delete(RequestVO vo) {
//		int cnt = 0;
//		
//		getConnection();
//		try {
//			String sql = "Delete from members where id = ? and pw = ?";
//			psmt = conn.prepareStatement(sql);
////			psmt.setString(1, vo.getId());
////			psmt.setString(2, vo.getPw());
//
//			cnt = psmt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//				
//		return cnt;
//	}
	
}
