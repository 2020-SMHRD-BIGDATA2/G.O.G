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

public class Join {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;
	private JTextField txt_name;
	private JTextField txt_age;
	MembersDAO dao = new MembersDAO();
	private CommonButton cb = new CommonButton();
	
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
		frame.setBounds(100, 100, 383, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 367, 497);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBounds(84, 75, 226, 40);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setColumns(10);
		txt_pw.setBounds(84, 159, 226, 40);
		panel.add(txt_pw);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(84, 241, 226, 40);
		panel.add(txt_name);
		
		txt_age = new JTextField();
		txt_age.setColumns(10);
		txt_age.setBounds(84, 315, 226, 40);
		panel.add(txt_age);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txt_id.getText();
				String pw = txt_pw.getText();
				String name = txt_name.getText();
				int age = Integer.parseInt(txt_age.getText());
				int cnt = dao.join(new MembersVO(id,pw,name,age));
				
				if (cnt>0) {
					JOptionPane.showMessageDialog(null, "회원가입 성공", "회원가입",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입",JOptionPane.WARNING_MESSAGE);
				}
				
				frame.dispose(); // frame.setVisible(false);
				Login.main(null);
				
			}
		});
		btnNewButton.setBounds(68, 404, 204, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(15, 74, 57, 40);
		panel.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setBounds(15, 159, 57, 40);
		panel.add(lblPw);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(15, 241, 57, 40);
		panel.add(lblName);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(15, 315, 57, 40);
		panel.add(lblAge);
	
		cb.buttonMake(frame, panel);
	}

}
