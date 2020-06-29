package Final_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manager_Main {

	public JFrame frame;
	private String id;
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Manager_Main() {
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
		
		String path = "C:\\Users\\SMHRD\\Desktop\\main_manager.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_user = new JButton("New button");
		btn_user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				Member_manage man = new Member_manage();
				man.setId(id);
				man.frame.setVisible(true);
				
			}
		});
		btn_user.setBounds(0, 0, 173, 73);
		btn_user.setOpaque(false);
		frame.getContentPane().add(btn_user);
		
		JButton btn_crime = new JButton("New button");
		btn_crime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Report_Assign re_as = new Report_Assign();
				re_as.setId(id);
				re_as.frame.setVisible(true);
			}
		});
		btn_crime.setBounds(172, 0, 173, 73);
		btn_crime.setOpaque(false);
		frame.getContentPane().add(btn_crime);
		
		JButton btn_soonchal = new JButton("New button");
		btn_soonchal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Request_Assign req_as = new Request_Assign();
				req_as.setId(id);
				req_as.frame.setVisible(true);
			}
		});
		btn_soonchal.setBounds(343, 0, 173, 73);
		btn_soonchal.setOpaque(false);
		frame.getContentPane().add(btn_soonchal);
		
		JButton btn_stastics = new JButton("New button");
		btn_stastics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Statistics_manage stm = new Statistics_manage();
				stm.setId(id);
				stm.frame.setVisible(true);
			}
		});
		btn_stastics.setBounds(514, 0, 161, 73);
		btn_stastics.setOpaque(false);
		frame.getContentPane().add(btn_stastics);
		
		JButton btn_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Main.main(null);
			}
		});
		btn_logout.setBounds(1020, 21, 168, 37);
		btn_logout.setOpaque(false);
		frame.getContentPane().add(btn_logout);
		

	}

}
