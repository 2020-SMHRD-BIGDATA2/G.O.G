package Final_project;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

public class Caution {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caution window = new Caution();
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
	public Caution() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 615, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\caution.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(600, 400, image.SCALE_FAST)));
		lbl_image.setBounds(0, 0, 600, 400);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_close = new JButton("New button");
		btn_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				Caution cau = new Caution();
//			     cau.frame.setVisible(false);
	
			}
		});
		btn_close.setBounds(278, 358, 44, 42);
		btn_close.setOpaque(false);
		frame.getContentPane().add(btn_close);
		

		
	
		
		
		

		
		

	
		
		
	}
}
