package Login;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login_chang {

	private JFrame frame;
	private FontMake fm = new FontMake();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_chang window = new Login_chang();
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
	public Login_chang() {
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
		      
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				fm.fontChange(ge);
				
				String fonts[] = ge.getAvailableFontFamilyNames();
				for (int i = 0; i < fonts.length; i++) {
					System.out.println(fonts[i]);
				}
		      
		      JLabel lblNewLabel = new JLabel("[\uB0A8\uAD6C\uC9C0\uD0B4\uC774\uC5D0 \uC624\uC2E0\uAC78 \uD658\uC601\uD569\uB2C8\uB2E4.]");
		      lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 17));
		      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel.setBounds(61, 50, 300, 45);
		      frame.getContentPane().add(lblNewLabel);
		      
		      
		      JLabel lblNewLabel_1 = new JLabel("\uB85C\uADF8\uC778 \uC131\uACF5!");
		      lblNewLabel_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 17));
		      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_1.setBounds(84, 116, 229, 45);
		      frame.getContentPane().add(lblNewLabel_1);
		      
		      
		      String path = "C:\\Users\\SMHRD\\Desktop\\chang.jpg";//¸ÞÀÎ ÀÌ¹ÌÁö
		      Image image = new ImageIcon(path).getImage();
		      JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(398, 213,Image.SCALE_FAST)));
		      lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		      lbl_image.setBounds(0, 0, 398, 213);
		      frame.getContentPane().add(lbl_image);
		      
		      JButton btn_check = new JButton("\uD655\uC778");
		      btn_check.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		frame.dispose();
					Login login = new Login();
					login.frame.setVisible(true);
		      	}
		      });
		      btn_check.setBounds(175, 180, 46, 33);
		      btn_check.setOpaque(false);
		      frame.getContentPane().add(btn_check);


		   
		
	}

}
