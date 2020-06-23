package Login;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frame;
	private String id;
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
		
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1113, 678);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\Login_next.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1097, 639,Image.SCALE_FAST)));
		lbl_image.setBounds(0, 0, 1097, 639);
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_center = new JButton("\uD1B5\uACC4 \uC13C\uD130");
		btn_center.setBounds(64, 199, 181, 166);
		btn_center.setOpaque(false);

		frame.getContentPane().add(btn_center);
		
		JButton btn_request = new JButton("\uC21C\uCC30 \uC2E0\uBB38\uACE0");
		btn_request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();			
				Request request= new Request();
				request.setId(id);
				request.frame.setVisible(true);
			}
		});
		btn_request.setOpaque(false);
		btn_request.setBounds(307, 199, 181, 166);
		frame.getContentPane().add(btn_request);
		
		JButton btn_report = new JButton("\uBBFC\uC6D0\uAD00\uB9AC\uC13C\uD130");
		btn_report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Report report = new Report();
				report.setId(id);
				report.frame.setVisible(true);
				
			
			}
		});
		btn_report.setOpaque(false);
		btn_report.setBounds(542, 199, 181, 166);
		frame.getContentPane().add(btn_report);
		
		JButton btn_mypage = new JButton("\uB9C8\uC774 \uD398\uC774\uC9C0");
		btn_mypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btn_mypage.setOpaque(false);
		btn_mypage.setBounds(792, 199, 181, 166);
		frame.getContentPane().add(btn_mypage);

	}

}
