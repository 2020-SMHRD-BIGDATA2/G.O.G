package Login;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JPasswordField;

public class Join {

	private JFrame frame;
	private JTextField txt_name;
	private JTextField txt_age;
	private JTextField txt_email;
	private JTextField txt_mailCheck;
	private JTextField txt_adress;
	private JTextField txt_phone;
	private JTextField txt_id;
	private ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	private MemberDAO dao = new MemberDAO();
	private JPasswordField txt_pw;
	private JPasswordField txt_pwCheck;
	private JButton btn_check;
	private JButton btn_mailCheck2;

	/**
	 * Launch the application.
	 */
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
		frame.setBounds(100, 100, 627, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JCheckBox ckb_man = new JCheckBox("\uB0A8");
		ckb_man.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		ckb_man.setBackground(Color.WHITE);
		ckb_man.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_man.setBounds(412, 345, 72, 45);
		frame.getContentPane().add(ckb_man);

		JCheckBox ckb_woman = new JCheckBox("\uC5EC");
		ckb_woman.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		ckb_woman.setBackground(Color.WHITE);
		ckb_woman.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_woman.setBounds(479, 345, 72, 45);
		frame.getContentPane().add(ckb_woman);

		ButtonGroup group = new ButtonGroup();
		group.add(ckb_man);
		group.add(ckb_woman);

		String path = "C:\\Users\\SMHRD\\Desktop\\login.jpg";// 메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(611, 543, Image.SCALE_FAST)));
		lbl_image.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 611, 543);
		frame.getContentPane().add(lbl_image);

		JButton btn_join = new JButton("\uAC00\uC785\uC644\uB8CC");
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = txt_id.getText();
				String pw = txt_pw.getText();
				String pwcheck = txt_pwCheck.getText();

				String name = txt_name.getText();
				int age = Integer.parseInt(txt_age.getText());
				int sex = 0;
				if (ckb_man.getText().equals("남")) {
					sex = 1; // 남 : 1
				}
				if (ckb_woman.getText().equals("여")) {
					sex = 2; // 여 : 2
				}

				String address = txt_adress.getText();
				String pnumber = txt_phone.getText();
				String email = txt_email.getText();

				if (!pw.equals(pwcheck)) {
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력하세요.", "비밀번호", JOptionPane.WARNING_MESSAGE);
					txt_pw.setText("");
					txt_pwCheck.setText("");

				} else if (txt_mailCheck.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "인증번호를 다시 입력하세요.", "이메일", JOptionPane.WARNING_MESSAGE);

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
		btn_join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_join.setBackground(Color.WHITE);
		btn_join.setBounds(268, 433, 72, 30);
		btn_join.setOpaque(false);
		frame.getContentPane().add(btn_join);

		JButton btn_mailCheck = new JButton("\uC778\uC99D\uD558\uAE30");
		btn_mailCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "인증번호가 전송되었습니다.", "인증번호", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btn_mailCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btn_mailCheck.setBackground(Color.WHITE);
		btn_mailCheck.setOpaque(false);
		btn_mailCheck.setBounds(554, 84, 57, 40);

		frame.getContentPane().add(btn_mailCheck);

		txt_name = new JTextField();
		txt_name.setBounds(133, 277, 133, 40);
		frame.getContentPane().add(txt_name);
		txt_name.setColumns(10);

		txt_age = new JTextField();
		txt_age.setBounds(133, 345, 133, 45);
		frame.getContentPane().add(txt_age);
		txt_age.setColumns(10);

		txt_email = new JTextField();
		txt_email.setBounds(412, 84, 139, 40);
		frame.getContentPane().add(txt_email);
		txt_email.setColumns(10);

		txt_mailCheck = new JTextField();
		txt_mailCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txt_mailCheck.setBounds(412, 144, 139, 44);
		frame.getContentPane().add(txt_mailCheck);
		txt_mailCheck.setColumns(10);

		txt_adress = new JTextField();
		txt_adress.setBounds(412, 214, 139, 45);
		frame.getContentPane().add(txt_adress);
		txt_adress.setColumns(10);

		txt_phone = new JTextField();
		txt_phone.setBounds(412, 277, 139, 45);
		frame.getContentPane().add(txt_phone);
		txt_phone.setColumns(10);

		btn_mailCheck2 = new JButton("\uC778\uC99D\uBC88\uD638 \uD655\uC778");
		btn_mailCheck2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "인증번호 확인가 확인되었습니다.", "인증번호", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btn_mailCheck2.setToolTipText("");
		btn_mailCheck2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_mailCheck2.setOpaque(false);
		btn_mailCheck2.setBackground(Color.WHITE);
		btn_mailCheck2.setBounds(554, 148, 57, 40);
		btn_mailCheck2.setOpaque(false);
		frame.getContentPane().add(btn_mailCheck2);

		txt_id = new JTextField();
		txt_id.setBounds(133, 82, 133, 45);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		txt_pw = new JPasswordField();
		txt_pw.setBounds(133, 144, 133, 45);
		frame.getContentPane().add(txt_pw);

		txt_pwCheck = new JPasswordField();
		txt_pwCheck.setBounds(133, 207, 133, 52);
		frame.getContentPane().add(txt_pwCheck);

		btn_check = new JButton("\uC911\uBCF5\uD655\uC778");
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
		btn_check.setOpaque(false);
		btn_check.setBackground(Color.WHITE);
		btn_check.setBounds(268, 84, 72, 40);
		frame.getContentPane().add(btn_check);

	}
}
