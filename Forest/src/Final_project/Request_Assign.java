package Final_project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Request_Assign {

	public JFrame frame;
	private JTable table;
	private String id;
	private JButton btn_back;
	private JButton btn_report;
	private JButton btn_check;
	private JTextField txt_search;
	private JButton btn_request;
	private JButton btn_stastics;
	private JButton btn_manage;
	
	
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Create the application.
	 */
	public Request_Assign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		FontMake fm = new FontMake();
		fm.fontChange(GraphicsEnvironment.getLocalGraphicsEnvironment());

		
		JComboBox cb_free = new JComboBox();
		cb_free.setModel(new DefaultComboBoxModel(new String[] {"\uC591\uB9BC\uB3D9\uC790\uC728\uBC29\uBC94\uB300", "\uBD09\uC120\uB3D9\uC790\uC728\uBC29\uBC94\uB300", "\uC8FC\uC6D42\uB3D9\uC790\uC728\uBC29\uBC94\uB300", "\uC6D4\uC0B05\uB3D9\uC790\uC728\uBC29\uBC94\uB300", "\uC0AC\uC9C1\uB3D9\uC790\uC728\uBC29\uBC94\uB300"}));
		cb_free.setBounds(730, 629, 242, 51);
		frame.getContentPane().add(cb_free);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\manager_rounding.jpg";
		Image image = new ImageIcon(path).getImage();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);

		Request_AssignDAO dao = new Request_AssignDAO();
		ArrayList<Request_AssignVO> list = dao.selectAll();
		
		String[] colNames = {"연번", "신청번호", "신청날짜", "이름", "전화번호", "희망장소", "희망시간", "희망날짜 ", "순찰사유", "요청사항" };
	      
	      Object[][] data = new Object[list.size()][colNames.length];
	      for (int i = 0; i < list.size(); i++) {
	    	 String rs_reason = dao.change_reason(list.get(i).getReason());
	    	 String str = list.get(i).getGet_date();
	    	 String dates = str.substring(2,16);
	    	 String rs_time = dao.change_time(list.get(i).getTime());

	         data[i][0] = (i+1);
	         data[i][1] = list.get(i).getReq_num();
	         data[i][2] = dates;
	         data[i][3] = list.get(i).getName();
	         data[i][4] = list.get(i).getPnumber();
	         data[i][5] = list.get(i).getLocation();
	         data[i][6] = rs_time;
	         data[i][7] = list.get(i).getSeldate();
	         data[i][8] = rs_reason;
	         data[i][9] = list.get(i).getAsk();
	      }
	      
			
		table = new JTable(data, colNames);
		table.getColumn("연번").setPreferredWidth(3);
		table.getColumn("신청번호").setPreferredWidth(3);
		table.getColumn("신청날짜").setPreferredWidth(35);
		table.getColumn("이름").setPreferredWidth(3);
		table.getColumn("전화번호").setPreferredWidth(10);
		table.getColumn("희망장소").setPreferredWidth(10);
		table.getColumn("희망시간").setPreferredWidth(10);
		table.getColumn("순찰사유").setPreferredWidth(10);
		table.getColumn("요청사항").setPreferredWidth(20);
		
		
		
		table.setRowHeight(30);
		table.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 98, 1116, 485);
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
				Manager_Main ma_m = new Manager_Main();
				ma_m.setId(id);
				ma_m.frame.setVisible(true);
			}
		});
		btn_back.setBounds(1104, 10, 84, 73);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		btn_report = new JButton("New button");
		btn_report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Report_Assign rp_a = new Report_Assign();
				rp_a.setId(id);
				rp_a.frame.setVisible(true);
			}
		});
		btn_report.setBounds(180, 0, 167, 85);
		btn_report.setOpaque(false);
		frame.getContentPane().add(btn_report);
		
		btn_check = new JButton("New button");
		btn_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int free_team= cb_free.getSelectedIndex();
				int req_num = Integer.parseInt(txt_search.getText());
				
				if (txt_search.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "신청번호를 입력하세요.", "신청번호", JOptionPane.WARNING_MESSAGE);
				} else {
					int cnt = dao.take(new Request_AssignVO(id, req_num, free_team));
					
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "신청 담당 배정 완료", "신청 배정", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						Manager_Main ma_m = new Manager_Main();
						ma_m.setId(id);
						ma_m.frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "신청 담당 배정 실패", "신청 배정", JOptionPane.WARNING_MESSAGE);
					}
				}
				System.out.println("버튼클릭");
			}
		});
		btn_check.setBounds(511, 702, 173, 45);
		btn_check.setOpaque(false);
		frame.getContentPane().add(btn_check);
		
		txt_search = new JTextField();
		txt_search.setBounds(255, 633, 242, 44);
		txt_search.setBorder(null);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);

		
		btn_request = new JButton("New button");
		btn_request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Request_Assign r_a = new Request_Assign();
				r_a.setId(id);
				r_a.frame.setVisible(true);
				
			}
		});
		btn_request.setOpaque(false);
		btn_request.setBounds(351, 0, 167, 85);
		frame.getContentPane().add(btn_request);
		
		btn_stastics = new JButton("New button");
		btn_stastics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Statistics_manage stm = new Statistics_manage();
				stm.setId(id);
				stm.frame.setVisible(true);
			}
		});
		btn_stastics.setOpaque(false);
		btn_stastics.setBounds(517, 0, 173, 85);
		frame.getContentPane().add(btn_stastics);
		
		btn_manage = new JButton("New button");
		btn_manage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Member_manage me = new Member_manage();
				me.setId(id);
				me.frame.setVisible(true);
			}
		});
		btn_manage.setOpaque(false);
		btn_manage.setBounds(0, -2, 173, 85);
		frame.getContentPane().add(btn_manage);


	}
}
