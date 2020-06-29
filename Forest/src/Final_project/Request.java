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
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Request {

	public JFrame frame;
	private JTextField txt_location;
	private JTextField txt_date;
	private String id;
	private RequestDAO dao = new RequestDAO();
	private FontMake fm = new FontMake();
 
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
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		FontMake fm = new FontMake();
		fm.fontChange(GraphicsEnvironment.getLocalGraphicsEnvironment());
		
		JLabel lbl_label = new JLabel("ex) \uB144-\uC6D4-\uC77C(2020-01-01)");
		lbl_label.setForeground(Color.WHITE);
//		lbl_label.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				lbl_label.setVisible(false);
//			}
//		});
		
		
		
		lbl_label.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_label.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
		lbl_label.setBounds(335, 217, 218, 62);
		frame.getContentPane().add(lbl_label);

		txt_date = new JTextField();
		txt_date.setColumns(10);
		txt_date.setBounds(171, 218, 152, 62);
		txt_date.setBorder(null);
		frame.getContentPane().add(txt_date);
		
		txt_location = new JTextField();
		txt_location.setBounds(171, 146, 159, 62);
		txt_location.setBorder(null);
		frame.getContentPane().add(txt_location);
		txt_location.setColumns(10);
		
		JComboBox cb_reason = new JComboBox();
		cb_reason.setBackground(Color.WHITE);
		cb_reason.setForeground(new Color(0, 0, 0));
		cb_reason.setModel(new DefaultComboBoxModel(new String[] {"\uBC94\uC8C4\uBC1C\uC0DD \uC804\uB825 (\uC808\uB3C4\uD53C\uD574, \uBC14\uBC14\uB9AC\uB9E8 \uCD9C\uBAB0 \uB4F1)", "\uBD88\uC548\uC744 \uC720\uBC1C\uD558\uB294 \uC9C0\uB9AC\uC801 \uD658\uACBD\uD2B9\uC131 (\uC778\uC801\uC774 \uB4DC\uBB38 \uACE8\uBAA9\uAE38 \uB4F1)", "\uBD88\uC548\uC744 \uC720\uBC1C\uD558\uB294 \uC778\uC801 \uD2B9\uC815 (\uB178\uC219\uC778, \uCDE8\uAC1D, \uBE44\uD589\uCCAD\uC18C\uB144 \uB4F1)", "\uBB34\uC9C8\uC11C \uD589\uC704 \uBE48\uBC1C (\uC18C\uC74C,\uAD50\uD1B5\uBC95\uADDC \uB4F1 \uC9C8\uC11C\uC704\uBC18\uD589\uC704)", "\uAE30\uD0C0\uC0AC\uC720"}));
		cb_reason.setBounds(171, 290, 542, 56);
		frame.getContentPane().add(cb_reason);
		
		JComboBox cb_time = new JComboBox();
		cb_time.setModel(new DefaultComboBoxModel(new String[] {"24:00~02:00", "02:00~04:00", "04:00~06:00", "06:00~08:00", "08:00~10:00", "10:00~12:00", "12:00~14:00", "14:00~16:00", "16:00~18:00", "18:00~20:00", "20:00~22:00", "22:00~24:00"}));
		cb_time.setBounds(833, 146, 159, 62);
		frame.getContentPane().add(cb_time);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\rounding_report.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_back = new JButton("back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				frame.dispose();
				Login login = new Login(true);
				login.frame.setVisible(true);

			}
		});
		btn_back.setBounds(1086, 41, 90, 73);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(87, 410, 1003, 314);
		textArea.setBorder(null);
		frame.getContentPane().add(textArea);
		
		JButton btn_complete = new JButton("\uC644\uB8CC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String location = txt_location.getText();
				int time = cb_time.getSelectedIndex();
				String seldate = txt_date.getText();
				int reason = cb_reason.getSelectedIndex();
				String ask = textArea.getText();
				String name = "";
				
				name = dao.id_check(new RequestVO(id));
				
				if (textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "신청내용을 입력하세요.", "신청내용", JOptionPane.WARNING_MESSAGE);
				} else {
					int cnt = dao.take(new RequestVO(id, location, time, seldate, reason, ask));
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, name + "님 신청 완료되었습니다. \n 담당자 배정 시 마이페이지에서 확인 가능합니다.", "신청", JOptionPane.INFORMATION_MESSAGE);
//						frame.dispose();
//						Login login = new Login();
//						login.setId(id);
//						login.frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "신청 실패", "신청", JOptionPane.WARNING_MESSAGE);
					}

				
				frame.dispose();
				Login login = new Login(true);
				login.setId(id);
				login.frame.setVisible(true);			}
		}
		});
		btn_complete.setOpaque(false);
		btn_complete.setBounds(480, 751, 159, 33);
		frame.getContentPane().add(btn_complete);
		
//		txt_location = new JTextField();
//		txt_location.setBounds(171, 146, 159, 62);
////		txt_location.setBorder(null);
//		frame.getContentPane().add(txt_location);
//		txt_location.setColumns(10);
		


		


		

	
		
		
		
		
		
	}
}
