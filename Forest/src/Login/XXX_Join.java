package Login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class XXX_Join {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;
	private JTextField txt_name;
	private JTextField txt_age;
	MemberDAO dao = new MemberDAO();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join_1 window = new Join_1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public XXX_Join() {
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
		ckb_man.setBackground(Color.WHITE);
		ckb_man.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_man.setBounds(412, 345, 72, 45);
		frame.getContentPane().add(ckb_man);
		
		JCheckBox ckb_woman = new JCheckBox("\uC5EC");
		ckb_woman.setBackground(Color.WHITE);
		ckb_woman.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_woman.setBounds(479, 345, 72, 45);
		frame.getContentPane().add(ckb_woman);
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\login.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(611, 543,Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 611, 543);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_join = new JButton("");
		btn_join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_join.setBackground(Color.WHITE);
		btn_join.setBounds(268, 433, 72, 30);
		btn_join.setOpaque(false);
		frame.getContentPane().add(btn_join);
		
		btn_check = new JButton("");
		btn_check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_check.setBackground(Color.WHITE);
		btn_check.setBounds(273, 84, 67, 40);
		btn_check.setOpaque(false);
		frame.getContentPane().add(btn_check);
		
		txt_id = new JTextField();
		txt_id.setBounds(133, 124, 128, -40);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setBounds(133, 148, 133, 40);
		frame.getContentPane().add(txt_pw);
		txt_pw.setColumns(10);
		
		btn_mailCheck = new JButton("");
		btn_mailCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btn_mailCheck.setBackground(Color.WHITE);
		btn_mailCheck.setOpaque(false);
		btn_mailCheck.setBounds(554, 84, 57, 40);
		
		frame.getContentPane().add(btn_mailCheck);
		
		txt_pwCheck = new JTextField();
		txt_pwCheck.setColumns(10);
		txt_pwCheck.setBounds(133, 209, 133, 45);
		frame.getContentPane().add(txt_pwCheck);
		
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
		
		btn_mailCheck_1 = new JButton("");
		btn_mailCheck_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_mailCheck_1.setOpaque(false);
		btn_mailCheck_1.setBackground(Color.WHITE);
		btn_mailCheck_1.setBounds(554, 148, 57, 40);
		btn_mailCheck_1.setOpaque(false);
		frame.getContentPane().add(btn_mailCheck_1);
		
		
	}
}