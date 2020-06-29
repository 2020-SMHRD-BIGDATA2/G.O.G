package Final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Request_AssignDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	public int cnt;
	
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
	
	
	public String change_reason(int reason) {
		String req_reason = "";
		if (reason == 0) {
			req_reason="범죄발생 전력 (절도피해, 바바리맨 출몰 등)";
		}
			else if (reason == 1) {
				req_reason="불안을 유발하는 지리적 환경특성 (인적이 드문 골목길 등)";
			}	
			else if (reason == 2) {
				req_reason = "불안을 유발하는 인적 특정 (노숙인, 취객, 비행청소년 등)";
			}
			else if (reason == 3) {
				req_reason = "무질서 행위 빈발 (소음,교통법규 등 질서위반행위)";
			}
			else if (reason == 4) {
				req_reason = "기타사유";

			}
		
		return req_reason;
	}
	
	public String change_free_team(int free_team) {
		String req_free_team = "";
		if (free_team == 0) {
			req_free_team="양림동자율방범대)";
		}
			else if (free_team == 1) {
				req_free_team="봉선동자율방범대";
			}	
			else if (free_team == 2) {
				req_free_team = "주월2동자율방범대";
			}
			else if (free_team == 3) {
				req_free_team = "월산5동자율방범대";
			}
			else if (free_team == 4) {
				req_free_team = "사직동자율방범대";

			}
		
		
		return req_free_team;
	}
	
	public String change_time(int time) {
		String req_time = "";
		if (time == 0) {
			req_time="24:00~02:00";	
		}
			else if (time == 1) {
				req_time="02:00~04:00";
			}	
			else if (time == 2) {
				req_time = "04:00~06:00";
			}
			else if (time == 3) {
				req_time = "06:00~08:00";
			}
			else if (time == 4) {
				req_time = "08:00~10:00";
			}
			else if (time == 5) {
				req_time = "10:00~12:00";
			}			
			else if (time == 6) {
				req_time = "12:00~14:00";
			}	
			else if (time == 7) {
				req_time = "14:00~16:00";
			}
			else if (time == 8) {
				req_time = "16:00~18:00";
			}
			else if (time == 9) {
				req_time = "18:00~20:00";
			}
			else if (time == 10) {
				req_time = "20:00~22:00";
			}
			else if (time == 11) {
				req_time = "22:00~24:00";
			}			
			
		return req_time;
	}
	
	public ArrayList<Request_AssignVO> selectAll() {
		ArrayList<Request_AssignVO> list = new ArrayList<Request_AssignVO>();
		
		
		getConnection();
		try {
			String sql = "select r.req_num, r.get_date, m.name, m.pnumber, r.location, r.time, r.seldate, r.reason, r.ask from member m, request r where m.id = r.request_id";
			psmt = conn.prepareStatement(sql);						
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int req_num = rs.getInt("req_num");
				String get_date = rs.getString("get_date");
				String name = rs.getString("name");
				String pnumber = rs.getString("pnumber");
				String location = rs.getString("location");
				int time = rs.getInt("time");						
				String seldate = rs.getString("seldate");
				int reason = rs.getInt("reason");
				String ask = rs.getString("ask");	
				
				Request_AssignVO vo = new Request_AssignVO(req_num, get_date, name, pnumber, location, time, seldate, reason, ask);
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
	
	public int take(Request_AssignVO vo){ 
		cnt = 0;
		getConnection();
		
		try {

//			String sql = "INSERT INTO request_assign VALUES('"+vo.getId()+"',"+vo.getReq_num()+","+vo.getFree_team()+")";
			String sql = "INSERT INTO request_assign VALUES(?,?,?)";
			
			psmt = conn.prepareStatement(sql);
//			System.out.println(vo.getId()+", "+vo.getReq_num()+", "+vo.getFree_team());
			psmt.setString(1, vo.getId());
			psmt.setInt(2, vo.getReq_num());
			psmt.setInt(3, vo.getFree_team());
			
			cnt = psmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}


		
		return cnt;	
		
	}
	
	public ArrayList<Request_AssignVO> userCheck(String id) {
		ArrayList<Request_AssignVO> list = new ArrayList<Request_AssignVO>();
//		Report rc = new Report();
		
		getConnection();
		try {
			String sql = "select r.req_num, m.name, r.seldate, r.time,  r.location, m.pnumber, m.email, r.reason, rq.free_team  from request r, member m, request_assign rq where r.request_id = m.id and r.req_num = rq.req_as_num and m.id = ?";
			
			
			psmt = conn.prepareStatement(sql);	
			
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				int rep_num = rs.getInt("req_num");
				String name = rs.getString("name");
				String seldate = rs.getString("seldate");
				int time = rs.getInt("time");
				String location = rs.getString("location");
				String pnumber = rs.getString("pnumber");
				int reason = rs.getInt("reason");
				int free_team = rs.getInt("free_team");
				
				Request_AssignVO vo = new Request_AssignVO(rep_num, name, seldate, time, location, pnumber, reason, free_team);
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
	
	
	
	
	
}
