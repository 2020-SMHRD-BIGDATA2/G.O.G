package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberManagement {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagement window = new MemberManagement();
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
	public MemberManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 431, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 415, 390);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btn_update = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_update.setBounds(96, 46, 210, 54);
		panel.add(btn_update);
		
		JButton btn_delete = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		btn_delete.setBounds(96, 126, 210, 54);
		panel.add(btn_delete);
		
		JButton btn_request = new JButton("\uC2E0\uCCAD\uC5EC\uBD80\uD655\uC778");
		btn_request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_request.setBounds(96, 282, 210, 54);
		panel.add(btn_request);
		
		JButton btn_report = new JButton("\uC2E0\uACE0\uC5EC\uBD80\uD655\uC778");
		btn_report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_report.setBounds(96, 202, 210, 54);
		panel.add(btn_report);
	}
}
