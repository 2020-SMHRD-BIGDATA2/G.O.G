package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;
	private MembersDAO dao = new MembersDAO();
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
		frame.setBounds(100, 100, 450, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 423);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBounds(99, 51, 267, 47);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setColumns(10);
		txt_pw.setBounds(99, 128, 267, 47);
		panel.add(txt_pw);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String id = txt_id.getText();
				String pw = txt_pw.getText();
//				String name = txt_name.getText();
//				int age = Integer.parseInt(txt_age.getText());
				int cnt = dao.update(new MembersVO(id,pw));
								
				if (cnt>0) {
					JOptionPane.showMessageDialog(null, "회원수정 성공", "회원수정",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "회원수정 실패", "회원수정",JOptionPane.WARNING_MESSAGE);
				}
			
				frame.dispose(); // frame.setVisible(false);
				Login.main(null);
			}
		});
		btnNewButton.setBounds(64, 361, 276, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(12, 57, 69, 34);
		panel.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("pw");
		lblPw.setBounds(12, 144, 69, 34);
		panel.add(lblPw);
	}

}
