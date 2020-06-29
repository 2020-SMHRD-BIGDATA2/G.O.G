package Final_project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;

public class Report_Assign {

	public JFrame frame;
	private JTable table;
	private String id;
	private JButton btn_back;
	private JButton btn_request;
	private JTextField txt_search;
	private JComboBox cb_police;
	private Report_AssignDAO dao = new Report_AssignDAO();
	private JButton btn_report;
	private JButton btn_manage;
	private JButton btn_stastics;
	private JButton btn_check;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Report_Assign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cb_police = new JComboBox();
		cb_police.setModel(new DefaultComboBoxModel(new String[] {"\uBC31\uC6B4\uC9C0\uAD6C\uB300", "\uAD11\uB9BC\uC9C0\uAD6C\uB300", "\uD6A8\uB355\uC9C0\uAD6C\uB300", "\uC591\uB9BC\uD30C\uCD9C\uC18C", "\uC8FC\uC6D4\uD30C\uCD9C\uC218", "\uB300\uCD0C\uD30C\uCD9C\uC18C"}));
		cb_police.setBounds(727, 630, 248, 48);
		frame.getContentPane().add(cb_police);
		
		FontMake fm = new FontMake();
		fm.fontChange(GraphicsEnvironment.getLocalGraphicsEnvironment());
		
		String path = "C:\\Users\\SMHRD\\Desktop\\manager_report.jpg";
		Image image = new ImageIcon(path).getImage();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		Report_AssignDAO dao = new Report_AssignDAO();
        ArrayList<Report_AssignVO> list = dao.selectAll();
        String[] colNames = {"����","�Ű��ȣ", "��û��¥", "�̸�", "�ּ�", "��ȭ��ȣ", "�̸���", "�������� ", "�Ű���", "÷���ڷ�"}; 
//        Object[][] data = {{list.get(0).getRep_num(),list.get(0).getGet_date(),list.get(0).getName(),list.get(0).getAddress(),list.get(0).getPnumber(),list.get(0).getEmail(),list.get(0).getKind(),list.get(0).getContents(),list.get(0).getData()}};

        Object[][] data = new Object[list.size()][colNames.length];
        for(int i = 0; i < list.size(); i++) {
           String rs = dao.change_kind(list.get(i).getKind());
           String str = list.get(i).getGet_date();
           String str2 = str.substring(2,16);
           
           data[i][0] = (i+1);
           data[i][1] = list.get(i).getRep_num();
           data[i][2] = str2;
           data[i][3] = list.get(i).getName();
           data[i][4] = list.get(i).getAddress();
           data[i][5] = list.get(i).getPnumber();
           data[i][6] = list.get(i).getEmail();
           data[i][7] = rs;
           data[i][8] = list.get(i).getContents();
           data[i][9] = list.get(i).getData();
           
        }  

		table = new JTable(data, colNames);
		table.getColumn("����").setPreferredWidth(3);
		table.getColumn("�Ű��ȣ").setPreferredWidth(3);
		table.getColumn("��û��¥").setPreferredWidth(35);
		table.getColumn("�̸�").setPreferredWidth(3);
		table.getColumn("�ּ�").setPreferredWidth(10);
		table.getColumn("��ȭ��ȣ").setPreferredWidth(10);
		table.getColumn("�̸���").setPreferredWidth(10);
//		table.getColumn("��������").setPreferredWidth(30);
		table.getColumn("�Ű���").setPreferredWidth(10);
		table.getColumn("÷���ڷ�").setPreferredWidth(10);

		
		
		
		table.setRowHeight(30);
		table.setFont(new Font("�����ٸ����", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 98, 1116, 487);
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
				Manager_Main manager = new Manager_Main();
				manager.setId(id);
				manager.frame.setVisible(true);
				
			}
		});
		btn_back.setBounds(1106, 10, 82, 75);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		btn_request = new JButton("New button");
		btn_request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Request_Assign  rq_a = new Request_Assign();
				rq_a.setId(id);
				rq_a.frame.setVisible(true);
			}
		});
		btn_request.setBounds(352, 0, 164, 87);
		btn_request.setOpaque(false);
		frame.getContentPane().add(btn_request);
		
		txt_search = new JTextField();
		txt_search.setBounds(251, 630, 248, 48);
		txt_search.setBorder(null);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		
		btn_report = new JButton("New button");
		btn_report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Report_Assign r_a = new Report_Assign();
				r_a.setId(id);
				r_a.frame.setVisible(true);
				
			}
		});
		btn_report.setOpaque(false);
		btn_report.setBounds(176, 0, 177, 87);
		frame.getContentPane().add(btn_report);
		
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
		btn_manage.setBounds(0, 0, 177, 87);
		frame.getContentPane().add(btn_manage);
		
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
		btn_stastics.setBounds(519, 0, 168, 87);
		frame.getContentPane().add(btn_stastics);
		
		btn_check = new JButton("New button");
		btn_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int police_team= cb_police.getSelectedIndex();
				int rep_num = Integer.parseInt(txt_search.getText());
								
				if (txt_search.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�Ű��ȣ�� �Է��ϼ���.", "�Ű��ȣ", JOptionPane.WARNING_MESSAGE);
				} else {
					int cnt = dao.take(new Report_AssignVO(id, rep_num, police_team));
					
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "�Ű� ��� ���� �Ϸ�", "�Ű� ����", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						Manager_Main ma_m = new Manager_Main();
						ma_m.setId(id);
						ma_m.frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "�Ű� ��� ���� ����", "�Ű� ����", JOptionPane.WARNING_MESSAGE);
					}
					Manager_Main ma_m = new Manager_Main();
					ma_m.setId(id);
					
				}
			}
		});
		btn_check.setBounds(519, 701, 169, 40);
		btn_check.setOpaque(false);
		frame.getContentPane().add(btn_check);
		

		

		


	

}
}
