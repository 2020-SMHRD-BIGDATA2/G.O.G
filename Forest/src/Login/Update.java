package Login;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import prac.Update_1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.awt.event.ActionEvent;

public class Update {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pwCheck;
	private JTextField txt_pw;
	private JTextField txt_adress;
	private JTextField txt_phone;
	private JTextField txt_email;
	private MemberDAO dao = new MemberDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update window = new Update();
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
	public Update() {
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
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\Update.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(611, 543,Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(12, 10, 611, 543);
		frame.getContentPane().add(lbl_image);
		
		txt_id = new JTextField();
		txt_id.setBounds(270, 126, 198, 39);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		txt_pwCheck = new JTextField();
		txt_pwCheck.setColumns(10);
		txt_pwCheck.setBounds(270, 244, 198, 39);
		frame.getContentPane().add(txt_pwCheck);
		
		txt_pw = new JTextField();
		txt_pw.setBounds(270, 183, 198, 39);
		frame.getContentPane().add(txt_pw);
		txt_pw.setColumns(10);
		
		txt_adress = new JTextField();
		txt_adress.setBounds(270, 302, 198, 39);
		frame.getContentPane().add(txt_adress);
		txt_adress.setColumns(10);
		
		txt_phone = new JTextField();
		txt_phone.setBounds(270, 351, 198, 39);
		frame.getContentPane().add(txt_phone);
		txt_phone.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setBounds(270, 405, 198, 39);
		frame.getContentPane().add(txt_email);
		txt_email.setColumns(10);
		
		JButton btn_complete = new JButton("\uC644\uB8CC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txt_id.getText();
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
					Main.main(null);
				}else {
					JOptionPane.showMessageDialog(null, "회원수정 실패", "회원수정",JOptionPane.WARNING_MESSAGE);
				}
				

				}
			}
		});
		btn_complete.setBounds(259, 454, 121, 31);
		btn_complete.setOpaque(false);
		frame.getContentPane().add(btn_complete);
		
		JButton btn_back = new JButton("back");
		btn_back.setBounds(502, 41, 72, 47);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
	}

}
