package Final_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Report {

	public JFrame frame;
	private JButton btn_complete;
	private ReportDAO dao = new ReportDAO();
	private JTextArea textArea;	
	private FontMake fm = new FontMake();
	private JTextField txt_file;
	private String folderPath="";
	private String id;

	
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
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fm.fontChange(ge);
		
		JLabel lblNewLabel_1 = new JLabel("* \uD3ED\uD589, \uBB34\uB2E8\uCD9C\uC785, \uC5C5\uBB34\uBC29\uD574, \uC74C\uC8FC\uC18C\uB780, \uC704\uD5D8\uD589\uC704, \uC7A5\uB09C\uC804\uD654, \uACFC\uB2E4\uB178\uCD9C \uB4F1\r\n");
		lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(84, 274, 403, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  54\uAC1C\uC758 \uD589\uC704\uAC00 \uACBD\uBC94\uC8C4\uB85C \uADDC\uC815\uB418\uC5B4 \uC788\uB2E4");
		lblNewLabel_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(87, 298, 393, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		txt_file = new JTextField();
		txt_file.setBounds(853, 215, 232, 61);
		txt_file.setBorder(null);
		frame.getContentPane().add(txt_file);
		txt_file.setColumns(10);
		

		
		String fonts[] = ge.getAvailableFontFamilyNames();
	
		
		JComboBox box_list = new JComboBox();
		box_list.setModel(new DefaultComboBoxModel(new String[] {"\uC0B4\uC778", "\uACBD\uBC94\uC8C4", "\uC131\uBC94\uC8C4.\uC131\uD3ED\uD589", "\uAE30\uD0C0"}));
		box_list.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//System.out.println(box_list.getSelectedIndex());

				
				
			}
		});
		box_list.setBounds(206, 215, 232, 61);

	
		frame.getContentPane().add(box_list);
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\crime_report.jpg";
		Image image = new ImageIcon(path).getImage();
		JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, image.SCALE_FAST)));
		lblNewLabel.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lblNewLabel);
		
		
		btn_complete = new JButton("\uC644\uB8CC\uBC84\uD2BC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int kind = box_list.getSelectedIndex();
				String contents = textArea.getText();
				String data = txt_file.getText();
				String name = "";
				
				name = dao.id_check(new ReportVO(id));
				
				
				if (textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "신고내용을 입력하세요.", "신고내용", JOptionPane.WARNING_MESSAGE);
				} else {
					int cnt = dao.take(new ReportVO(id, contents, kind, data));
					
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, name + " 님 신고 완료되었습니다. \n 담당자 배정 시 마이페이지에서 확인 가능합니다.", "신고", JOptionPane.INFORMATION_MESSAGE);
//						frame.dispose();
//						Login login = new Login();
//						login.setId(id);
//						login.frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "신고 실패", "신고", JOptionPane.WARNING_MESSAGE);
					}
					
					frame.dispose();
					Login login = new Login(true);
					login.setId(id);
					login.frame.setVisible(true);

				}
				}
		});
		btn_complete.setBackground(Color.WHITE);
		btn_complete.setBounds(480, 749, 163, 40);
		btn_complete.setOpaque(false);
		frame.getContentPane().add(btn_complete);
		
		
		
		JButton btn_back = new JButton("back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.dispose();			
				Login login = new Login(true);
				login.setId(id);
				login.frame.setVisible(true);

			}
		});
		btn_back.setBounds(1033, 43, 85, 76);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		textArea = new JTextArea();
		textArea.setBounds(87, 411, 998, 315);
		textArea.setBorder(null);
		frame.getContentPane().add(textArea);
		
		JButton btn_data = new JButton("New button");
		btn_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); // 디렉토리 설정
                 chooser.setCurrentDirectory(new File("/")); // 현재 사용 디렉토리를 지정
                 chooser.setAcceptAllFileFilterUsed(true);   // Fileter 모든 파일 적용 
                 chooser.setDialogTitle("타이틀"); // 창의 제목
                 chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // 파일 선택 모드
                 
                 FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "jpg"); // filter 확장자 추가
                 chooser.setFileFilter(filter); // 파일 필터를 추가
                 
                 int returnVal = chooser.showOpenDialog(null); // 열기용 창 오픈
                 
                 if(returnVal == JFileChooser.APPROVE_OPTION) { // 열기를 클릭 
                     folderPath = chooser.getSelectedFile().toString();
                    txt_file.setText(folderPath);

                 }else if(returnVal == JFileChooser.CANCEL_OPTION){ // 취소를 클릭
                     System.out.println("cancel"); 
                     folderPath = "";
                 }
				
			}
		});
		btn_data.setOpaque(false);
		btn_data.setBounds(1097, 215, 69, 50);
		frame.getContentPane().add(btn_data);
		
//		JLabel lblNewLabel_2 = new JLabel("  54\uAC1C\uC758 \uD589\uC704\uAC00 \uACBD\uBC94\uC8C4\uB85C \uADDC\uC815\uB418\uC5B4 \uC788\uB2E4");
//		lblNewLabel_2.setBounds(84, 305, 393, 40);
//		frame.getContentPane().add(lblNewLabel_2);
		
//		JLabel lblNewLabel_1 = new JLabel("* \uD3ED\uD589, \uBB34\uB2E8\uCD9C\uC785, \uC5C5\uBB34\uBC29\uD574, \uC74C\uC8FC\uC18C\uB780, \uC704\uD5D8\uD589\uC704, \uC7A5\uB09C\uC804\uD654, \uACFC\uB2E4\uB178\uCD9C \uB4F1\r\n  54\uAC1C\uC758 \uD589\uC704\uAC00 \uACBD\uBC94\uC8C4\uB85C \uADDC\uC815\uB418\uC5B4 \uC788\uB2E4");
//		lblNewLabel_1.setForeground(Color.WHITE);
//		lblNewLabel_1.setBounds(83, 292, 377, 50);
//		frame.getContentPane().add(lblNewLabel_1);
		
		
		
	}
	}

