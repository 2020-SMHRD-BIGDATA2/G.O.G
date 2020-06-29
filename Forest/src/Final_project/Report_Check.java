package Final_project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Report_Check {

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
		
		Report_AssignDAO dao = new Report_AssignDAO();
        ArrayList<Report_AssignVO> list = dao.userCheck(id);
        String[] colNames = {"연번","신고번호", "신청날짜", "이름", "범죄종류 ", "신고내용", "담당지구대"}; 

        Object[][] data = new Object[list.size()][colNames.length];
        for(int i = 0; i < list.size(); i++) {
        
           String rs = dao.change_kind(list.get(i).getKind());
           String rs_police = dao.change_police(list.get(i).getPolice_team());
           String str = list.get(i).getGet_date();
           String str2 = str.substring(2,16);
           
	           data[i][0] = (i+1);
	           data[i][1] = list.get(i).getRep_num();
	           data[i][2] = str2;
	           data[i][3] = list.get(i).getName();
	           data[i][4] = rs;
	           data[i][5] = list.get(i).getContents();
	           data[i][6] = rs_police;
	           System.out.print(data[i][0] );
	           System.out.print(data[i][1]);
	           System.out.print(data[i][2] );
	           System.out.print(data[i][3]);
	           System.out.print(data[i][4]);
	           System.out.print(data[i][5]);
	           System.out.println(data[i][6]);
           
        }  

		table = new JTable(data, colNames);
		table.getColumn("연번").setPreferredWidth(3);
		table.getColumn("신고번호").setPreferredWidth(3);
		table.getColumn("신청날짜").setPreferredWidth(35);
		table.getColumn("이름").setPreferredWidth(3);
//		table.getColumn("주소").setPreferredWidth(10);
//		table.getColumn("전화번호").setPreferredWidth(10);
//		table.getColumn("이메일").setPreferredWidth(10);
		
		table.setRowHeight(30);
		table.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(55, 238, 1091, 508);
		scrollPane.setOpaque(false);
		frame.getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getViewport().setBorder(null);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\report_check.jpg";
		Image image = new ImageIcon(path).getImage();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
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
	
	public Report_Check() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		

		
		txt_search = new JTextField();
		txt_search.setBounds(251, 630, 248, 48);
		txt_search.setBorder(null);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		

	}

}
