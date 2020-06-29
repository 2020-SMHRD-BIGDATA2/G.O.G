package Final_project;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Stastics_Main {

	public JFrame frame;
	private String id;
	
	
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Create the application.
	 */
	public Stastics_Main() {
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
		String path = "C:\\Users\\SMHRD\\Desktop\\crime_stastics.jpg";
		Image image = new ImageIcon(path).getImage();
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, image.SCALE_FAST)));
		lblNewLabel.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_murder = new JButton("\uC0B4\uC778");
		btn_murder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.dispose();
				CrimeChart_Kill_Login a_k = new CrimeChart_Kill_Login();
				a_k.setId(id);
				a_k.frame.setVisible(true);
				
			}
		});
		btn_murder.setBounds(92, 293, 202, 174);
		btn_murder.setOpaque(false);
		frame.getContentPane().add(btn_murder);
		
		JButton btn_attack = new JButton("\uD3ED\uB825");
		btn_attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				CrimeChart_Attack_Login a_l = new CrimeChart_Attack_Login();
				a_l.setId(id);
				a_l.frame.setVisible(true);
				
				
			}
		});
		btn_attack.setBounds(339, 293, 202, 174);
		btn_attack.setOpaque(false);
		frame.getContentPane().add(btn_attack);
		
		JButton btn_sexcrime = new JButton("\uAC15\uAC04,\uC131\uCD94\uD589");
		btn_sexcrime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				CrimeChart_Rape_Login r_l = new CrimeChart_Rape_Login();
				r_l.setId(id);
				r_l.frame.setVisible(true);
								
			}
		});
		btn_sexcrime.setBounds(614, 293, 202, 174);
		btn_sexcrime.setOpaque(false);
		frame.getContentPane().add(btn_sexcrime);
		
		JButton btn_theft = new JButton("\uC808\uB3C4");
		btn_theft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.dispose();
				CrimeChart_Theft_Login T_l = new CrimeChart_Theft_Login();
				T_l.setId(id);
				T_l.frame.setVisible(true);
			}
		});
		btn_theft.setBounds(907, 293, 202, 174);
		btn_theft.setOpaque(false);
		frame.getContentPane().add(btn_theft);
		
		JButton btn_back = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Login login = new Login(true);
				login.setId(id);
				login.frame.setVisible(true);
			}
		});
		btn_back.setBounds(1095, 45, 78, 77);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
	}

}
