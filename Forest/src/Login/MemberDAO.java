package Login;

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

//			if (cnt>0) {
//				System.out.println("회원가입 성공");
//			}else {
//				System.out.println("실패");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
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

	public ArrayList<MemberVO> selectONE() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		
		getConnection();
		try {
			String sql = "SELECT * from member where id= ?";
			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				int sex = rs.getInt("SEX");
				String address = rs.getString("ADDRESS");
				String pnumber = rs.getString("PNUMBER");
				String email = rs.getString("EMAIL");
				
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

	public int delete(MemberVO vo) {
		int cnt = 0;
		
		getConnection();
		try {
			String sql = "Delete from member where id = ? and pw = ?";
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
			String sql = "update member set  pw= ?, address = ?, pnumber = ?, email = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getPw());
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
	
	
	

}
