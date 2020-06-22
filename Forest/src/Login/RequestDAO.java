package Login;

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
	
	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
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
	
	public ArrayList<RequestVO> selectONE() {
		ArrayList<RequestVO> list = new ArrayList<RequestVO>();
		
		getConnection();
		try {
			String sql = "SELECT * from members where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String location = rs.getString("LOCATION");
				int time = Integer.parseInt(rs.getString("TIME"));
				String seldate = rs.getString("seldate");
				int reason = Integer.parseInt(rs.getString("reason"));
				String ask = rs.getString("ask");
				
				RequestVO vo = new RequestVO(location, time, seldate, reason, ask);
				list.add(vo);
			}		
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	public int delete(RequestVO vo) {
		int cnt = 0;
		
		getConnection();
		try {
			String sql = "Delete from members where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getId());
//			psmt.setString(2, vo.getPw());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
				
		return cnt;
	}
	
}
