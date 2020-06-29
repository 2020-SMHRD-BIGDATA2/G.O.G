package Final_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.ws.Response;

import oracle.net.ns.SessionAtts;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Main {

	public JFrame frame;
	private JTextField txt_id;
	private JPasswordField txt_pw;
	private MemberDAO dao = new MemberDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Main() {
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
		
		String path = "C:\\Users\\SMHRD\\Desktop\\before_login.jpg";//���� �̹���
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_stt = new JButton("New button");
		btn_stt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Stastics_Main2.main(null);
			}
		});
	
		btn_stt.setSelectedIcon(null);
		btn_stt.setBackground(Color.WHITE);
		btn_stt.setBounds(80, 264, 198, 202);
		btn_stt.setOpaque(false);
		frame.getContentPane().add(btn_stt);
		
		
		JLabel lbl_image_1 = new JLabel((Icon) null);
		lbl_image_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image_1.setBounds(-38, 0, 1135, 639);
		
		frame.getContentPane().add(lbl_image_1);
		
		JButton btn_car = new JButton("\uC21C\uCC30\uC2E0\uBB38\uACE0");
		btn_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showMessageDialog(null, "�α����� �ʿ��մϴ�.", "�α���", JOptionPane.WARNING_MESSAGE);
				
				
			}
		});

		btn_car.setBackground(Color.WHITE);
		btn_car.setBounds(344, 265, 198, 201);
		btn_car.setOpaque(false);
		frame.getContentPane().add(btn_car);
		
		JButton btn_call = new JButton("\uBBFC\uC6D0\uAD00\uB9AC\uC13C\uD130");
		btn_call.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showMessageDialog(null, "�α����� �ʿ��մϴ�.", "�α���", JOptionPane.WARNING_MESSAGE);
								
			}
		});
		btn_call.setBackground(Color.WHITE);
		btn_call.setBounds(602, 264, 198, 202);
		btn_call.setOpaque(false);
		frame.getContentPane().add(btn_call);
		
		JButton btn_people = new JButton("\uB9C8\uC774 \uD398\uC774\uC9C0");
		btn_people.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "�α����� �ʿ��մϴ�.", "�α���", JOptionPane.WARNING_MESSAGE);

			}
		});

		btn_people.setBackground(Color.WHITE);
		btn_people.setBounds(875, 264, 198, 202);
		btn_people.setOpaque(false);
		frame.getContentPane().add(btn_people);
		
		txt_id = new JTextField();
		txt_id.setBounds(528, 524, 220, 53);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		txt_id.setBorder(null);
		
		JButton btn_login = new JButton("New button");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = "";
				String id = txt_id.getText();
				String pw = txt_pw.getText();
				name = dao.login(new MemberVO(id,pw));
				
//				boolean idresult = dao.id_check(id);
//				boolean pwresult = dao.pw_check(pw);
//
//				if(idresult == false && pwresult == false) {
//					JOptionPane.showMessageDialog(null, "���Ե� ȸ���� �ƴմϴ�.", "�α���", JOptionPane.WARNING_MESSAGE);
//					txt_id.setText("");
//					txt_pw.setText("");
//				} else if (idresult == false) {					
//					JOptionPane.showMessageDialog(null, "���̵� �ٽ� �Է��ϼ���.", "���̵�", JOptionPane.WARNING_MESSAGE);
//					txt_id.setText("");
//				} else if(pwresult == false) {
//					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� �Է��ϼ���.", "��й�ȣ", JOptionPane.INFORMATION_MESSAGE);
//					txt_pw.setText("");
//				} 
				
				if (id.equals("manager") && pw.equals("12345")) {
					JOptionPane.showMessageDialog(null, "�����ڴ� ȯ���մϴ�.", "�α���", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					Manager_Main manager = new Manager_Main();
					manager.setId(id);
					manager.frame.setVisible(true);
				} else if (name != null ) { // �α��� ����!
					JOptionPane.showMessageDialog(null, name + "�� ȯ���մϴ�.", "�α���", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();									
					Login login = new Login();
					login.setId(id);
					login.frame.setVisible(true);
				
				}  else {
					JOptionPane.showMessageDialog(null, "���Ե� ȸ���� �ƴմϴ�.", "�α���", JOptionPane.WARNING_MESSAGE);
					txt_id.setText("");
					txt_pw.setText("");
				}
				
				
			}
		});
		btn_login.setBackground(Color.WHITE);
		btn_login.setBounds(410, 684, 161, 60);
		btn_login.setOpaque(false);
		frame.getContentPane().add(btn_login);
		
		JButton btn_join = new JButton("New button");
		btn_join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Join.main(null);
			}
		});
		btn_join.setBackground(Color.WHITE);
		btn_join.setBounds(583, 695, 165, 43);
		btn_join.setOpaque(false);
		frame.getContentPane().add(btn_join);
		
		txt_pw = new JPasswordField();
		txt_pw.setBounds(528, 605, 220, 53);
		txt_pw.setBorder(null);
		frame.getContentPane().add(txt_pw);
		
		
		
		
	}
}
