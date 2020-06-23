package Login;

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
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Request {

	public JFrame frame;
	private JTextField txt_location;
	private JTextField txt_date;
	private JTextField txt_time;
	private String id;
	private RequestDAO dao = new RequestDAO();
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Request() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox cb_reason = new JComboBox();
		cb_reason.setBackground(Color.WHITE);
		cb_reason.setForeground(new Color(0, 0, 0));
		cb_reason.setModel(new DefaultComboBoxModel(new String[] {"\uBC94\uC8C4\uBC1C\uC0DD \uC804\uB825 (\uC808\uB3C4\uD53C\uD574, \uBC14\uBC14\uB9AC\uB9E8 \uCD9C\uBAB0 \uB4F1)", "\uBD88\uC548\uC744 \uC720\uBC1C\uD558\uB294 \uC9C0\uB9AC\uC801 \uD658\uACBD\uD2B9\uC131 (\uC778\uC801\uC774 \uB4DC\uBB38 \uACE8\uBAA9\uAE38 \uB4F1)", "\uBD88\uC548\uC744 \uC720\uBC1C\uD558\uB294 \uC778\uC801 \uD2B9\uC815 (\uB178\uC219\uC778, \uCDE8\uAC1D, \uBE44\uD589\uCCAD\uC18C\uB144 \uB4F1)", "\uBB34\uC9C8\uC11C \uD589\uC704 \uBE48\uBC1C (\uC18C\uC74C,\uAD50\uD1B5\uBC95\uADDC \uB4F1 \uC9C8\uC11C\uC704\uBC18\uD589\uC704)", "\uAE30\uD0C0\uC0AC\uC720"}));
		cb_reason.setBounds(101, 173, 338, 30);
		frame.getContentPane().add(cb_reason);
		
		
		JLabel lbl_ask = new JLabel("500\uC790 \uC774\uD558\uB85C \uC785\uB825\uD558\uC138\uC694");
		lbl_ask.setFont(new Font("굴림", Font.PLAIN, 12));
		lbl_ask.setForeground(Color.WHITE);
		lbl_ask.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ask.setBounds(272, 224, 167, 34);
		frame.getContentPane().add(lbl_ask);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\Request.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(484, 461, Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 484, 461);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_back = new JButton("back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				frame.dispose();
				Login login = new Login();
				login.frame.setVisible(true);

			}
		});
		btn_back.setBounds(391, 24, 59, 40);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(52, 257, 381, 163);
		frame.getContentPane().add(textArea);
		
		JButton btn_complete = new JButton("\uC644\uB8CC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String location = txt_location.getText();
				String time = txt_time.getText();
				String seldate = txt_date.getText();
				int reason = cb_reason.getSelectedIndex();
				String ask = textArea.getText();
				
				if (textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "신청내용을 입력하세요.", "신청내용", JOptionPane.WARNING_MESSAGE);
				} else {
					int cnt = dao.take(new RequestVO(id, location, time, seldate, reason, ask));
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "신청 완료", "신청", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						Main.main(null);
					} else {
						JOptionPane.showMessageDialog(null, "신청 실패", "신청", JOptionPane.WARNING_MESSAGE);
					}

				
				frame.dispose();
				Main.main(null);
			}
		}
		});
		btn_complete.setOpaque(false);
		btn_complete.setBounds(201, 428, 85, 23);
		frame.getContentPane().add(btn_complete);
		
		txt_location = new JTextField();
		txt_location.setBounds(101, 78, 98, 34);
		frame.getContentPane().add(txt_location);
		txt_location.setColumns(10);
		
		txt_date = new JTextField();
		txt_date.setColumns(10);
		txt_date.setBounds(101, 128, 98, 34);
		frame.getContentPane().add(txt_date);
		
		txt_time = new JTextField();
		txt_time.setColumns(10);
		txt_time.setBounds(347, 78, 98, 34);
		frame.getContentPane().add(txt_time);

		

	
		
		
		
		
		
	}
}
