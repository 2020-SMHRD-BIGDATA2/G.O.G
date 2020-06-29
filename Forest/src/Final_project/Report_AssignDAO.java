package Final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Report_AssignDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
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
	private void close() { // 닫는기능
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
//	살인
//	경범죄
//	성범죄.성폭행
//	기타
	 public String change_kind(int kind) {
	      String rep_kind = "";
	      if (kind == 0) {
	    	  rep_kind="살인";
	      }
	         else if (kind == 1) {
	        	 rep_kind="경범죄";
	         }  
	         else if (kind == 2) {
	        	 rep_kind = "성범죄,성폭행";
	         }
	         else if (kind == 3) {
	        	 rep_kind = "기타 ";
	         }
	       
	      return rep_kind;
	   }
	 
	 public String change_police(int police_team) {
	      String rep_police_team = "";
	      if (police_team == 0) {
	    	  rep_police_team="백운지구대";
	      }
	         else if (police_team == 1) {
	        	 rep_police_team="광림지구대";
	         }  
	         else if (police_team == 2) {
	        	 rep_police_team = "효덕지구대";
	         }
	         else if (police_team == 3) {
	        	 rep_police_team = "양림파출소 ";
	         }	
	         else if (police_team == 4) {
	        	 rep_police_team = "주월파출수 ";
	         }	
	         else if (police_team == 5) {
	        	 rep_police_team = "대촌파출소 ";
	         }
	      
	      return rep_police_team;
	   }
	 
	 
	public int assign(Report_AssignVO vo) {
		
		int cnt = 0;
		getConnection();
		try {
			String sql = "INSERT INTO report_assign VALUES(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getId());
			psmt.setInt(2, vo.getRep_num());
			psmt.setInt(3, vo.getPolice_team());

			cnt = psmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
		
	}
	public ArrayList<Report_AssignVO> selectAll() {
		ArrayList<Report_AssignVO> list = new ArrayList<Report_AssignVO>();

		
		getConnection();
		try {
			String sql = "SELECT m.name, m.address, m.pnumber, m.email, r.kind, r.contents, r.data, r.get_date, r.rep_num from report r, member m where r.report_id = m.id";
			psmt = conn.prepareStatement(sql);			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {

				int rep_num = rs.getInt("rep_num");
				String get_date = rs.getString("get_date");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String pnumber = rs.getString("pnumber");
				String email = rs.getString("email");
				int kind = rs.getInt("kind");
				String contents = rs.getString("contents");
				String data = rs.getString("data");
				
				Report_AssignVO vo = new Report_AssignVO(rep_num, get_date, name, address, pnumber, email, kind, contents, data);
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
	
	public int take(Report_AssignVO vo){ // 신고완료
		int cnt = 0 ;
		
		getConnection();
		
		try {

			String sql = "INSERT INTO report_assign VALUES(?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setInt(2, vo.getRep_num());
			psmt.setInt(3, vo.getPolice_team());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
		
	}
	
	public ArrayList<Report_AssignVO> userCheck(String id) {
		ArrayList<Report_AssignVO> list = new ArrayList<Report_AssignVO>();
//		Report rc = new Report();
		
		getConnection();
		try {
			String sql = "select r.rep_num, r.get_date, m.name, m.pnumber, r.kind, r.contents, ra.police_team from report r, member m, report_assign ra where r.report_id = m.id and r.rep_num = ra.rep_as_num and m.id = ?";
			
			
			psmt = conn.prepareStatement(sql);	
//			rc.setId(id);		
//			psmt.setString(1, id);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				int rep_num = rs.getInt("rep_num");
				String get_date = rs.getString("get_date");
				String name = rs.getString("name");
				String pnumber = rs.getString("pnumber");
				int kind = rs.getInt("kind");
				String contents = rs.getString("contents");
				int police_team = rs.getInt("police_team");

				Report_AssignVO vo = new Report_AssignVO(rep_num, get_date, name, kind, pnumber, contents, police_team);
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
