package Final_project;

import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Update {

	public JFrame frame;
	private JTextField txt_adress;
	private JTextField txt_phone;
	private JTextField txt_email;
	private MemberDAO dao = new MemberDAO();
	public String id;
	private JPasswordField txt_pw;
	private JPasswordField txt_pwCheck;
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Create the application.
	 */
	public Update() {
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
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\Update.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800,Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lbl_image);
		
		txt_adress = new JTextField();
		txt_adress.setBounds(596, 382, 226, 62);
		txt_adress.setBorder(null);
		frame.getContentPane().add(txt_adress);
		txt_adress.setColumns(10);
		
		txt_phone = new JTextField();
		txt_phone.setBounds(596, 460, 226, 56);
		txt_phone.setBorder(null);
		frame.getContentPane().add(txt_phone);
		txt_phone.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setBounds(596, 531, 226, 56);
		txt_email.setBorder(null);
		frame.getContentPane().add(txt_email);
		txt_email.setColumns(10);
		
		JButton btn_complete = new JButton("\uC644\uB8CC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pw = txt_pw.getText();
				String pwcheck = txt_pwCheck.getText();
				String address = txt_adress.getText();
				String pnumber = txt_phone.getText();
				String email = txt_email.getText();
				
				
				int cnt = dao.update(new MemberVO(id,pw,address,pnumber,email));
				
				if (!pw.equals(pwcheck)) {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인하세요.", "비밀번호", JOptionPane.WARNING_MESSAGE);
					txt_pw.setText("");
					txt_pwCheck.setText("");

				} else {
				if (cnt>0) {
					JOptionPane.showMessageDialog(null, "회원수정 성공", "회원수정",JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					Login login = new Login(true);
					login.setId(id);
					login.frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "회원수정 실패", "회원수정",JOptionPane.WARNING_MESSAGE);
				}
				

				}
			}
		});
		btn_complete.setBounds(567, 700, 164, 43);
		btn_complete.setOpaque(false);
		frame.getContentPane().add(btn_complete);
		
		JButton btn_back = new JButton("back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Mypage page = new Mypage();
				page.setId(id);
				page.frame.setVisible(true);
				
			}
		});
		btn_back.setBounds(1095, 47, 93, 86);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		txt_pw = new JPasswordField();
		txt_pw.setBounds(596, 232, 226, 56);
		txt_pw.setBorder(null);
		frame.getContentPane().add(txt_pw);
		
		txt_pwCheck = new JPasswordField();
		txt_pwCheck.setBounds(596, 310, 226, 56);
		txt_pwCheck.setBorder(null);
		frame.getContentPane().add(txt_pwCheck);
	}
}
