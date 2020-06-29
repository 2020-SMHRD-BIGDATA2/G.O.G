package Final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDAO {
	
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
	
	public int join(MemberVO vo) {
		int cnt = 0;
		getConnection();		

		try {
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getName());
			psmt.setInt(4, vo.getAge());
			psmt.setInt(5, vo.getSex());
			psmt.setString(6, vo.getAddress());
			psmt.setString(7, vo.getPnumber());
			psmt.setString(8, vo.getEmail());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	public boolean pw_check(String pw) {
		
		boolean result = false;
		
		getConnection();		
		
		try {
			String sql = "select pw from member where pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			
			rs = psmt.executeQuery();

			if(rs.next()) {
				result = true; // 아이디가 존재하지 않으면 false
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
		
	}
	
	public boolean id_check(String id) {
		
		boolean result = false;
		
		getConnection();		
		
		try {
			String sql = "select id from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();

			if(rs.next()) {
				result = true; // 아이디가 존재하지 않으면 false
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
		
	}
	
	
	public boolean duplibcateIdCheck(String id) {
		
		boolean result = false;
		
		getConnection();		
		
		try {
			String sql = "select id from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();

			if(rs.next()) {
				result = true; // 아이디가 존재하지 않으면 false
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
		
	}
	
	
	
	public String login(MemberVO vo) {
		String name = null;
		
		getConnection();		

		try {
			String sql = "SELECT * from member where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			
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
	
	public ArrayList<MemberVO> selectONE(String id) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		
		getConnection();
		try {
			String sql = "SELECT * from member where id= ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id2 = id;
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				int sex = rs.getInt("SEX");
				String address = rs.getString("ADDRESS");
				String pnumber = rs.getString("PNUMBER");
				String email = rs.getString("EMAIL");
				
				MemberVO vo = new MemberVO(id2, name, age, sex, address, pnumber, email);
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

	public int delete(MemberVO vo) {
		int cnt = 0;
		
		getConnection();
		try {
	

			String sql = "delete from member where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());

			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
				
		return cnt;
	}

	public int update(MemberVO vo) {

		int cnt = 0;
		
		getConnection();
		try {
			String sql = "update member set pw= ?, address = ?, pnumber = ?, email = ? where id = ?";
//			String sql = "update member set pw= ?" + "address = ?" +  "pnumber = ?" + "email = ?" + "where id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPw());
//			if(vo.getAddress() != null) {
//				psmt.setString(2, vo.getAddress());
//			}
//			else {
//				psmt.setString(2, "select address from member where id = 1");
//			}
			psmt.setString(2, vo.getAddress());
			psmt.setString(2, vo.getAddress());
			psmt.setString(3, vo.getPnumber());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getId());

			
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return cnt;
	}
	
	public String change_sex(int sex) {
	      String mem_sex = "";
	      if (sex == 1) {
	    	  mem_sex="남자";
	      }
	         else if (sex == 2) {
	        	 mem_sex="여자";
	         }   
	       
	      return mem_sex;
	   }
	
	public ArrayList<MemberVO> selectAll() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		getConnection();
		
		try {
			String sql = "SELECT id, name, age, sex, address, pnumber, email from member" ;
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {

				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int sex = rs.getInt("sex");
				String address = rs.getString("address");
				String pnumber = rs.getString("pnumber");
				String email = rs.getString("email");
						
				MemberVO vo = new MemberVO(id, name, age, sex, address, pnumber, email);
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
