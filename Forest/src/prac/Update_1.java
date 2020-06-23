package prac;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Update_1 {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pwCheck;
	private JTextField txt_pw;
	private JTextField txt_adress;
	private JTextField txt_phone;
	private JTextField txt_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_1 window = new Update_1();
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
	public Update_1() {
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
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\change.jpg";//메인 이미지
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
		
		JButton btn_back1 = new JButton(" ");
		btn_back1.setBounds(259, 454, 121, 31);
		btn_back1.setOpaque(false);
		frame.getContentPane().add(btn_back1);
		
		JButton btn_complete = new JButton("");
		btn_complete.setBounds(502, 41, 72, 47);
		btn_complete.setOpaque(false);
		frame.getContentPane().add(btn_complete);
	}
}
