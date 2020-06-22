package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
	
public class Login {
	
	private JFrame frame;
	private JTextField txt_id;
	private JPasswordField txt_pw;
	MembersDAO dao = new MembersDAO();
	private JButton btn_delete;
	String name = "";
	private CommonButton cb = new CommonButton();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Login() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 383, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 367, 497);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBounds(63, 83, 231, 40);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JButton btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id = txt_id.getText();
				String pw = txt_pw.getText();
				name = dao.login(new MembersVO(id,pw));
				if (name != null) { // 로그인 성공!
					JOptionPane.showMessageDialog(null, name + "님 환영합니다.", "로그인", JOptionPane.INFORMATION_MESSAGE);
					btn_delete.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btn_login.setBounds(63, 254, 231, 40);
		panel.add(btn_login);
		
		JButton btn_join = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Join.main(null);
			}
		});
		btn_join.setBounds(63, 304, 231, 40);
		panel.add(btn_join);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(4, 75, 47, 40);
		panel.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setBounds(4, 169, 47, 40);
		panel.add(lblPw);
		
		txt_pw = new JPasswordField();
		txt_pw.setBounds(63, 168, 231, 41);
		panel.add(txt_pw);
		
		btn_delete = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Delete.main(null);
			}
		});
		
		btn_delete.setBounds(63, 354, 231, 40);
		panel.add(btn_delete);
		btn_delete.setVisible(false); // 앞에 있는 컴포넌트가 시각화될지말지 유무를 결정하는 메소드
		
		
		JButton btn_update = new JButton("\uD68C\uC6D0\uC218\uC815");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Update.main(null);
			}
		});
		btn_update.setBounds(63, 404, 231, 40);
		panel.add(btn_update);
		
//		cb.buttonMake(frame, panel);

	}
}
