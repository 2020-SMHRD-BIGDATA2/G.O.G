package Final_project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Request_Check {

	public JFrame frame;
	private JTable table;
	private String id;
	private JButton btn_back;
	private JTextField txt_search;
	private Report_AssignDAO dao = new Report_AssignDAO();
	
	public void setId(String id) {
		this.id = id;
		
		FontMake fm = new FontMake();
		fm.fontChange(GraphicsEnvironment.getLocalGraphicsEnvironment());
		
		String path = "C:\\Users\\SMHRD\\Desktop\\request_check.jpg";
		Image image = new ImageIcon(path).getImage();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		Request_AssignDAO dao = new Request_AssignDAO();
        ArrayList<Request_AssignVO> list = dao.userCheck(id);
        String[] colNames = {"연번", "신청번호", "이름", "희망날짜", "희망시간", "희망주소", "전화번호", "순찰사유", "담당자율방범대"}; 

        Object[][] data = new Object[list.size()][colNames.length];
        for(int i = 0; i < list.size(); i++) {
        	String rs_reason = dao.change_reason(list.get(i).getReason());
        	String rs_time = dao.change_time(list.get(i).getTime());
        	String rs_free_team = dao.change_free_team(list.get(i).getFree_team());
           
           data[i][0] = (i+1);
           data[i][1] = list.get(i).getReq_num();
           data[i][2] = list.get(i).getName();
           data[i][3] = list.get(i).getSeldate();
           data[i][4] = rs_time;
           data[i][5] = list.get(i).getLocation();
           data[i][6] = list.get(i).getPnumber();
           data[i][7] = rs_reason;
           data[i][8] = rs_free_team;
        }  

		table = new JTable(data, colNames);
//		table.getColumn("연번").setPreferredWidth(3);
////		table.getColumn("신고번호").setPreferredWidth(3);
//		table.getColumn("신청날짜").setPreferredWidth(35);
//		table.getColumn("이름").setPreferredWidth(3);
//		table.getColumn("주소").setPreferredWidth(10);
//		table.getColumn("전화번호").setPreferredWidth(10);
//		table.getColumn("이메일").setPreferredWidth(10);
////		table.getColumn("범죄종류").setPreferredWidth(30);
//		table.getColumn("신고내용").setPreferredWidth(10);
//		table.getColumn("첨부자료").setPreferredWidth(10);

		
		
		
		table.setRowHeight(30);
		table.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(55, 238, 1091, 508);
		scrollPane.setOpaque(false);
		frame.getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getViewport().setBorder(null);

		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_FAST)));
		lbl_image.setBounds(0, 0, 1200, 800);
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_image);
		
		btn_back = new JButton("New button");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Mypage mp = new Mypage();
				mp.setId(id);
				mp.frame.setVisible(true);
			}
		});
		btn_back.setBounds(1090, 38, 82, 75);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		
		
	}
	
	public Request_Check() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		FontMake fm = new FontMake();
//		fm.fontChange(GraphicsEnvironment.getLocalGraphicsEnvironment());
//		
//		String path = "C:\\Users\\SMHRD\\Desktop\\request_check.jpg";
//		Image image = new ImageIcon(path).getImage();
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().setLayout(null);
//		
//		Request_AssignDAO dao = new Request_AssignDAO();
//        ArrayList<Request_AssignVO> list = dao.userCheck(id);
//        String[] colNames = {"연번", "신청번호", "이름", "희망날짜", "희망시간", "희망주소", "전화번호", "순찰사유", "담당자율방범대"}; 
////        Object[][] data = {{list.get(0).getRep_num(),list.get(0).getGet_date(),list.get(0).getName(),list.get(0).getAddress(),list.get(0).getPnumber(),list.get(0).getEmail(),list.get(0).getKind(),list.get(0).getContents(),list.get(0).getData()}};
//
//        Object[][] data = new Object[list.size()][colNames.length];
//        for(int i = 0; i < list.size(); i++) {
//        	String rs_reason = dao.change_reason(list.get(i).getReason());
//        	String rs_time = dao.change_time(list.get(i).getTime());
//           String str = list.get(i).getGet_date();
//           String str2 = str.substring(2,16);
//           
//           data[i][0] = (i+1);
//           data[i][1] = list.get(i).getReq_num();
//           data[i][3] = list.get(i).getName();
//           data[i][4] = list.get(i).getSeldate();
//           data[i][5] = rs_time;
//           data[i][6] = list.get(i).getLocation();
//           data[i][7] = list.get(i).getPnumber();
//           data[i][8] = rs_reason;
//           data[i][9] = list.get(i).getFree_team();
//           
//        }  
//
//		table = new JTable(data, colNames);
//		table.getColumn("연번").setPreferredWidth(3);
//		table.getColumn("신고번호").setPreferredWidth(3);
//		table.getColumn("신청날짜").setPreferredWidth(35);
//		table.getColumn("이름").setPreferredWidth(3);
//		table.getColumn("주소").setPreferredWidth(10);
//		table.getColumn("전화번호").setPreferredWidth(10);
//		table.getColumn("이메일").setPreferredWidth(10);
////		table.getColumn("범죄종류").setPreferredWidth(30);
//		table.getColumn("신고내용").setPreferredWidth(10);
//		table.getColumn("첨부자료").setPreferredWidth(10);
//
//		
//		
//		
//		table.setRowHeight(30);
//		table.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
//
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(55, 238, 1091, 508);
//		scrollPane.setOpaque(false);
//		frame.getContentPane().add(scrollPane);
//		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane.getViewport().setOpaque(false);
//		scrollPane.getViewport().setBorder(null);
//
//		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_FAST)));
//		lbl_image.setBounds(0, 0, 1200, 800);
//		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
//		frame.getContentPane().add(lbl_image);
//		
//		btn_back = new JButton("New button");
//		btn_back.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				frame.dispose();
//				Mypage mp = new Mypage();
//				mp.setId(id);
//				mp.frame.setVisible(true);
//			}
//		});
//		btn_back.setBounds(1090, 38, 82, 75);
//		btn_back.setOpaque(false);
//		frame.getContentPane().add(btn_back);
		
		txt_search = new JTextField();
		txt_search.setBounds(251, 630, 248, 48);
		txt_search.setBorder(null);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		
	}
}
