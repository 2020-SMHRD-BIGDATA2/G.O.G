package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MembersDAO {
	
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
	
	public int join(MembersVO vo) {
		int cnt = 0;
		getConnection();		

		try {
			String sql = "INSERT INTO MEMBERS VALUES(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getName());
			psmt.setInt(4, vo.getAge());

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

	public String login(MembersVO vo) {
		String name = null;
		
		getConnection();		

		try {
			String sql = "SELECT * from members where id = ? and pw = ?";
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

	public ArrayList<MembersVO> selectONE() {
		ArrayList<MembersVO> list = new ArrayList<MembersVO>();
		
		getConnection();
		try {
			String sql = "SELECT * from members where = ?";
			psmt = conn.prepareStatement(sql);
			psmt.
			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				int sex = rs.getInt("SEX");
				String address = rs.getString("ADDRESS");
				String pnumber = rs.getString("PNUMBER");
				String email = rs.getString("EMAIL");
				
				MembersVO vo = new MembersVO(id, name, age, sex, address, pnumber, email);
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

	public int delete(MembersVO vo) {
		int cnt = 0;
		
		getConnection();
		try {
			String sql = "Delete from members where id = ? and pw = ?";
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

	public int update(MembersVO vo) {

		int cnt = 0;
		
		
		getConnection();
		try {
			String sql = "update members set  pw= ? where id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getPw());
			psmt.setString(2, vo.getId());

			
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return cnt;
	}
	
	
	

}
