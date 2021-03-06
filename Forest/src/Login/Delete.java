package Login;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;
	private MemberDAO dao = new MemberDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 627, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\Delete.jpg";//���� �̹���
		Image image = new ImageIcon(path).getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(611, 543,Image.SCALE_FAST)));
		lbl_image.setBounds(0, 0, 611, 543);
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_image);
		
		txt_id = new JTextField();
		txt_id.setBounds(258, 195, 198, 40);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setColumns(10);
		txt_pw.setBounds(258, 262, 198, 40);
		frame.getContentPane().add(txt_pw);
		
		JButton btn_back = new JButton("back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Main.main(null);
			}
		});
		btn_back.setBounds(488, 29, 64, 46);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		JButton btn_complete = new JButton("\uC644\uB8CC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String id = txt_id.getText();
				String pw = txt_pw.getText();
				
				int cnt = dao.delete(new MemberVO(id, pw));
				
				if (cnt>0) {
					JOptionPane.showMessageDialog(null, "ȸ��Ż�� ����", "ȸ��Ż��",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "ȸ��Ż�� ����", "ȸ��Ż��",JOptionPane.WARNING_MESSAGE);
				}
				
				frame.dispose(); // frame.setVisible(false);
				Main.main(null);
			}
		});
		btn_complete.setBounds(246, 444, 117, 29);
		btn_complete.setOpaque(false);
		frame.getContentPane().add(btn_complete);
	}

}
