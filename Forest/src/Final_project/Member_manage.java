package Final_project;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Member_manage {

	public JFrame frame;
	private JTable table;
	private String id;
	
	
	public void setId(String id) {
		this.id = id;
	}
	

	/**
	 * Create the application.
	 */
	public Member_manage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		FontMake fm = new FontMake();
		fm.fontChange(GraphicsEnvironment.getLocalGraphicsEnvironment());
		
		MemberDAO dao = new MemberDAO();
	    ArrayList<MemberVO> list = dao.selectAll();


		String[] colNames = {"아이디","이름","나이","성별","주소","전화번호","이메일"}; 
		

	      Object[][] data = new Object[list.size()][colNames.length];
	      for(int i = 0; i < list.size(); i ++) {
	    	  String rs = dao.change_sex(list.get(i).getSex());
	    	  
	    	  data[i][0] = list.get(i).getId();
	    	  data[i][1] = list.get(i).getName();
	    	  data[i][2] = list.get(i).getAge();
	    	  data[i][3] = rs;
	    	  data[i][4] = list.get(i).getAddress();
	    	  data[i][5] = list.get(i).getPnumber();
	    	  data[i][6] = list.get(i).getEmail();
	      }
		

		table = new JTable(data, colNames);
		table.setBounds(51, 141, 1110, 571);
		frame.getContentPane().add(table);
		
		table.getColumn("아이디").setPreferredWidth(3);
		table.getColumn("이름").setPreferredWidth(3);
		table.getColumn("나이").setPreferredWidth(35);
		table.getColumn("성별").setPreferredWidth(3);
		table.getColumn("주소").setPreferredWidth(10);
		table.getColumn("전화번호").setPreferredWidth(10);
		table.getColumn("이메일").setPreferredWidth(10);
		
		table.setRowHeight(30);
		table.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 98, 1116, 487);
		scrollPane.setOpaque(false);
		frame.getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getViewport().setBorder(null);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\manager_manage.jpg";
		Image image = new ImageIcon(path).getImage();
		JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, image.SCALE_FAST)));
		lblNewLabel.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				Manager_Main ma = new Manager_Main();
				ma.setId(id);
				ma.frame.setVisible(true);
				
			}
		});
		btn_back.setBounds(1106, 10, 82, 73);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		JButton btn_statistics = new JButton("\uD1B5\uACC4\uAD00\uB9AC\uCC3D");
		btn_statistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();			
			Statistics_manage sma = new Statistics_manage();
			sma.setId(id);
			sma.frame.setVisible(true);
			}
		});
		btn_statistics.setBounds(517, 0, 168, 83);
		btn_statistics.setOpaque(false);
		frame.getContentPane().add(btn_statistics);
		
		JButton btn_request = new JButton("\uC21C\uCC30\uC2E0\uBB38\uACE0\uCC3D");
		btn_request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Request_Assign ra = new Request_Assign();
				ra.setId(id);
				ra.frame.setVisible(true);
			}
		});
		btn_request.setBounds(352, 0, 168, 83);
		btn_request.setOpaque(false);
		frame.getContentPane().add(btn_request);
		
		JButton btn_report = new JButton("\uBC94\uC8C4\uC2E0\uACE0\uCC3D");
		btn_report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Report_Assign re = new Report_Assign();
				re.setId(id);
				re.frame.setVisible(true);
			}
		});
		btn_report.setBounds(178, 0, 175, 83);
		btn_report.setOpaque(false);
		frame.getContentPane().add(btn_report);
		
		JButton btn_manage = new JButton("\uBC94\uC8C4\uC2E0\uACE0\uCC3D");
		btn_manage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Member_manage me = new Member_manage();
				me.setId(id);
				me.frame.setVisible(true);
			}
		});
		btn_manage.setOpaque(false);
		btn_manage.setBounds(0, 0, 175, 83);
		frame.getContentPane().add(btn_manage);
		
		
	}
}
