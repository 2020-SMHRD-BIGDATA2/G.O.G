package Login;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Report {

	public JFrame frame;
	private JButton btn_complete;
	private ReportDAO dao = new ReportDAO();
	private JTextArea textArea;	
	private String id;
	private FontMake fm = new FontMake();

	
	public void setId(String id) {
		this.id = id;
	}
	

	
	public Report() {
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
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fm.fontChange(ge);
		
		String fonts[] = ge.getAvailableFontFamilyNames();
		for (int i = 0; i < fonts.length; i++) {
			System.out.println(fonts[i]);
		}
		
		JLabel lblNewLabel_1 = new JLabel("\uCD5C\uB300 500\uC790\uC785\uB825");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(317, 165, 92, 27);
		frame.getContentPane().add(lblNewLabel_1);
	
		
		JComboBox box_list = new JComboBox();
		box_list.setModel(new DefaultComboBoxModel(new String[] {"\uC0B4\uC778", "\uACBD\uBC94\uC8C4", "\uC131\uBC94\uC8C4.\uC131\uD3ED\uD589", "\uAE30\uD0C0"}));
		box_list.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//System.out.println(box_list.getSelectedIndex());

				
				
			}
		});
		box_list.setBounds(97, 94, 103, 40);

	
		frame.getContentPane().add(box_list);
		
		JComboBox box_list2 = new JComboBox();
		box_list2.setModel(new DefaultComboBoxModel(new String[] {"\uD30C\uC77C \uC785\uB825."}));
		box_list2.setBounds(336, 94, 103, 40);
		frame.getContentPane().add(box_list2);
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\complain.jpg";
		Image image = new ImageIcon(path).getImage();
		JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(500, 500, image.SCALE_FAST)));
		lblNewLabel.setBounds(0, 0, 484, 461);
		frame.getContentPane().add(lblNewLabel);
		
		
		btn_complete = new JButton("\uC644\uB8CC\uBC84\uD2BC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int kind = box_list.getSelectedIndex();
				String contents = textArea.getText();
				String data = box_list2.getSelectedItem().toString();
				
				if (textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "신고내용을 입력하세요.", "신고내용", JOptionPane.WARNING_MESSAGE);
				} else {
					int cnt = dao.take(new ReportVO(id, contents, kind, data));
					
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "신고 완료", "신고", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						Login login = new Login();
						login.frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "신고 실패", "신고", JOptionPane.WARNING_MESSAGE);
					}

				}
				}
		});
		btn_complete.setBackground(Color.WHITE);
		btn_complete.setBounds(193, 428, 97, 33);
		btn_complete.setOpaque(false);
		frame.getContentPane().add(btn_complete);
		
		
		
		JButton btn_back = new JButton("back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.dispose();
				Login login = new Login();
				login.frame.setVisible(true);

			}
		});
		btn_back.setBounds(400, 10, 57, 40);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		textArea = new JTextArea();
		textArea.setBounds(45, 202, 393, 198);
		frame.getContentPane().add(textArea);
		
	}
	}

