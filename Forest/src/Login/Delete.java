package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	private MembersDAO dao = new MembersDAO();
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
		frame.setBounds(100, 100, 450, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 366);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBounds(124, 59, 215, 44);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setColumns(10);
		txt_pw.setBounds(124, 146, 215, 44);
		panel.add(txt_pw);
		
		JButton btn_delete = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txt_id.getText();
				String pw = txt_pw.getText();
				
				int cnt = dao.delete(new MembersVO(id, pw));
				
				if (cnt>0) {
					JOptionPane.showMessageDialog(null, "È¸¿øÅ»Åð ¼º°ø", "È¸¿øÅ»Åð",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "È¸¿øÅ»Åð ½ÇÆÐ", "È¸¿øÅ»Åð",JOptionPane.WARNING_MESSAGE);
				}
				
				frame.dispose(); // frame.setVisible(false);
				Login.main(null);
				
			}
		});
		btn_delete.setBounds(78, 258, 238, 55);
		panel.add(btn_delete);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(26, 61, 72, 38);
		panel.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setBounds(26, 146, 72, 38);
		panel.add(lblPw);
	}

}
