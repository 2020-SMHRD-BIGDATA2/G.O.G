package Final_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Final_project.Main;
import Final_project.MemberVO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Join {

	private JFrame frame;
	private JButton btn_phoneck1;
	private JButton btn_phoneck2;
	private JTextField txt_id;
	private JTextField txt_name;
	private JTextField txt_Age;
	private JTextField txt_email;
	private JTextField txt_adress;
	private JTextField txt_phone;
	private JTextField txt_phoneck;
	private MemberDAO dao = new MemberDAO();
	private JPasswordField txt_pw;
	private JPasswordField txt_pwCheck;
	public int sex = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join window = new Join();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Join() {
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
		
		JCheckBox ckb_woman = new JCheckBox("\uC5EC");
		ckb_woman.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sex = 2;
			}
		});

		ckb_woman.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_woman.setBackground(Color.WHITE);
		ckb_woman.setBounds(864, 542, 72, 59);
		frame.getContentPane().add(ckb_woman);
		
		JCheckBox ckb_man = new JCheckBox("\uB0A8");
		ckb_man.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sex = 1;
			}
		});
		ckb_man.setBackground(Color.WHITE);
		ckb_man.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_man.setBounds(799, 542, 72, 59);
		frame.getContentPane().add(ckb_man);
		
		ButtonGroup group = new ButtonGroup();
		group.add(ckb_man);
		group.add(ckb_woman);
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\join.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800,Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_join = new JButton("");
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = txt_id.getText();
				String pw = txt_pw.getText();
				String pwcheck = txt_pwCheck.getText();
				
				String name = txt_name.getText();
				int age = Integer.parseInt(txt_Age.getText());
			
//				String man = ckb_man.getText();
//				String woman = ckb_woman.getText();
//				
//				int change = 0;
//				if(man.equals("남")) {
//				 change = 1; // 남 : 1
//				}
//				else if(woman.equals("여")) {
//					change = 2; // 여 : 2
//				}
//				sex = change;
//				if (ckb_man.getText().equals("남")) {
//					sex = 1; // 남 : 1
//				}
//				else if (ckb_woman.getText().equals("여")) {
//					sex = 2; // 여 : 2
//				}
				String address = txt_adress.getText();
				String pnumber = txt_phone.getText();
				String email = txt_email.getText();
				
		
				if (!pw.equals(pwcheck)) {
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력하세요.", "비밀번호", JOptionPane.WARNING_MESSAGE);
					txt_pw.setText("");
					txt_pwCheck.setText("");

				} else if (txt_phoneck.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "인증번호를 다시 입력하세요.", "휴대전화", JOptionPane.WARNING_MESSAGE);

				} else {

					int cnt = dao.join(new MemberVO(id, pw, name, age, sex, address, pnumber, email));

					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "회원가입 성공", "회원가입", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입", JOptionPane.WARNING_MESSAGE);
					}

					frame.dispose();
					Main.main(null);
				}
				
			}
		});
		btn_join.setBackground(Color.WHITE);
		btn_join.setBounds(479, 749, 165, 40);
		btn_join.setOpaque(false);
		frame.getContentPane().add(btn_join);
		
		JButton btn_check = new JButton("");
		btn_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txt_id.getText();
				boolean result = dao.duplibcateIdCheck(id);
				if (result == true) {
					JOptionPane.showMessageDialog(null, "사용중인 아이디 입니다.", "아이디", JOptionPane.WARNING_MESSAGE);
					txt_id.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "아이디 사용이 가능합니다.", "아이디", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});

		btn_check.setBackground(Color.WHITE);
		btn_check.setBounds(423, 214, 83, 59);
		btn_check.setOpaque(false);
		frame.getContentPane().add(btn_check);
		
		btn_phoneck2 = new JButton("");
		btn_phoneck2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btn_phoneck2.setBackground(Color.WHITE);
		btn_phoneck2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "인증번호 확인가 확인되었습니다.", "인증번호", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btn_phoneck2.setOpaque(false);
		btn_phoneck2.setBounds(1028, 464, 83, 59);
		
		frame.getContentPane().add(btn_phoneck2);
		
		btn_phoneck1 = new JButton("");
		btn_phoneck1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "인증번호가 전송되었습니다.", "인증번호", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btn_phoneck1.setOpaque(false);
		btn_phoneck1.setBackground(Color.WHITE);
		btn_phoneck1.setBounds(1028, 379, 83, 59);
		btn_phoneck1.setOpaque(false);
		frame.getContentPane().add(btn_phoneck1);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(195, 214, 216, 65);
		txt_id.setBorder(null);
		frame.getContentPane().add(txt_id);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(195, 458, 216, 65);
		txt_name.setBorder(null);
		frame.getContentPane().add(txt_name);
		
		txt_Age = new JTextField();
		txt_Age.setColumns(10);
		txt_Age.setBounds(195, 542, 216, 65);
		txt_Age.setBorder(null);
		frame.getContentPane().add(txt_Age);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(800, 209, 216, 65);
		txt_email.setBorder(null);
		frame.getContentPane().add(txt_email);
		
		txt_adress = new JTextField();
		txt_adress.setColumns(10);
		txt_adress.setBounds(800, 296, 216, 65);
		txt_adress.setBorder(null);
		frame.getContentPane().add(txt_adress);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(800, 379, 216, 65);
		txt_phone.setBorder(null);
		frame.getContentPane().add(txt_phone);
		
		txt_phoneck = new JTextField();
		txt_phoneck.setColumns(10);
		txt_phoneck.setBounds(800, 458, 216, 65);
		txt_phoneck.setBorder(null);
		frame.getContentPane().add(txt_phoneck);
		
		JButton btn_back = new JButton("New button");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btn_back.setBounds(1096, 38, 78, 80);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		txt_pw = new JPasswordField();
		txt_pw.setBounds(195, 296, 216, 65);
		txt_pw.setBorder(null);
		frame.getContentPane().add(txt_pw);
		
		txt_pwCheck = new JPasswordField();
		txt_pwCheck.setBounds(195, 379, 216, 65);
		txt_pwCheck.setBorder(null);
		frame.getContentPane().add(txt_pwCheck);
		
		
		
		
	}
}
