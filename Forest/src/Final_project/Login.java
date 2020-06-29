package Final_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frame;
	private String id;
	boolean flag;

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Create the application.
	 */
	public Login(boolean flag) {
		this.flag = flag;
		initialize();

	}

	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		if (!flag) {
			Caution cau = new Caution();

			cau.main(null);
			flag = !flag;
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		String path = "C:\\Users\\SMHRD\\Desktop\\logout.jpg";// 메인 이미지
		Image image = new ImageIcon(path).getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_FAST)));
		lbl_image.setBounds(0, 0, 1200, 800);
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_image);

		JButton btn_center = new JButton("\uD1B5\uACC4 \uC13C\uD130");
		btn_center.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				Stastics_Main sta_main = new Stastics_Main();
				sta_main.setId(id);
				sta_main.frame.setVisible(true);

			}
		});
		btn_center.setBounds(78, 263, 202, 203);
		btn_center.setOpaque(false);

		frame.getContentPane().add(btn_center);

		JButton btn_request = new JButton("\uC21C\uCC30 \uC2E0\uBB38\uACE0");
		btn_request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				Request request = new Request();
				request.setId(id);
				request.frame.setVisible(true);
			}
		});
		btn_request.setOpaque(false);
		btn_request.setBounds(341, 263, 202, 203);
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
		btn_report.setBounds(604, 263, 202, 203);
		frame.getContentPane().add(btn_report);

		JButton btn_mypage = new JButton("\uB9C8\uC774 \uD398\uC774\uC9C0");
		btn_mypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				Mypage page = new Mypage();
				page.setId(id);
				page.frame.setVisible(true);

			}
		});
		btn_mypage.setOpaque(false);
		btn_mypage.setBounds(875, 263, 202, 203);
		frame.getContentPane().add(btn_mypage);

		JButton btn_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "로그아웃 하시겠습니까.", "로그아웃", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				Main.main(null);
			}
		});
		btn_logout.setOpaque(false);
		btn_logout.setBounds(498, 674, 166, 41);
		frame.getContentPane().add(btn_logout);

	}

}
