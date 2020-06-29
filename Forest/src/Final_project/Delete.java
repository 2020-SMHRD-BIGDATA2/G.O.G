package Final_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Delete {

	public JFrame frame;
	private MemberDAO dao = new MemberDAO();
	private String id;
	private JPasswordField txt_pw;
	private JPasswordField txt_pwCheck;
	
	
	public void setId(String id) {
		this.id = id;
	}

	public Delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\Delete.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800,Image.SCALE_FAST)));
		lbl_image.setBounds(0, 0, 1200, 800);
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_back = new JButton("back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Mypage page = new Mypage();
				page.setId(id);
				page.frame.setVisible(true);
			}
		});
		btn_back.setBounds(1098, 47, 76, 68);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		JButton btn_complete = new JButton("\uC644\uB8CC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String pw = txt_pw.getText();
				String pwCheck = txt_pwCheck.getText();

				int cnt = dao.delete(new MemberVO(id, pw));
				
				if (!pw.equals(pwCheck)) {
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력하세요.", "비밀번호", JOptionPane.WARNING_MESSAGE);
					txt_pw.setText("");
					txt_pwCheck.setText("");
				}else {
				if (cnt>0) {
					JOptionPane.showMessageDialog(null, "회원탈퇴 성공", "회원탈퇴",JOptionPane.INFORMATION_MESSAGE);
					frame.dispose(); 
					Main.main(null);
				}else {
					JOptionPane.showMessageDialog(null, "회원탈퇴 실패", "회원탈퇴",JOptionPane.WARNING_MESSAGE);
				}
				
			}
			}
		});
		btn_complete.setBounds(530, 724, 160, 36);
		btn_complete.setOpaque(false);
		frame.getContentPane().add(btn_complete);
		
		txt_pw = new JPasswordField();
		txt_pw.setBounds(553, 310, 220, 57);
		txt_pw.setBorder(null);
		frame.getContentPane().add(txt_pw);
		
		txt_pwCheck = new JPasswordField();
		txt_pwCheck.setBorder(null);
		txt_pwCheck.setBounds(553, 425, 220, 57);
		frame.getContentPane().add(txt_pwCheck);
	}

}
