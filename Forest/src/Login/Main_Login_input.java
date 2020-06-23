package Login;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main_Login_input {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Login_input window = new Main_Login_input();
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
	public Main_Login_input() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	      frame = new JFrame();
	      frame.setBounds(100, 100, 414, 252);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().setLayout(null);
	      
	      String path = "C:\\Users\\SMHRD\\Desktop\\chang.jpg";//메인 이미지
	      Image image = new ImageIcon(path).getImage();
	      JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(398, 213,Image.SCALE_FAST)));
	      lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
	      lbl_image.setBounds(0, 0, 398, 213);
	      frame.getContentPane().add(lbl_image);
	      
	      JButton btn_check = new JButton("\uD655\uC778");
	      btn_check.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		
	      	}
	      });
	      btn_check.setBounds(175, 180, 46, 33);
	      btn_check.setOpaque(false);
	      frame.getContentPane().add(btn_check);
	   
	}

}
