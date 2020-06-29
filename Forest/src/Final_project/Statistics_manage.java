package Final_project;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Statistics_manage {

	public JFrame frame;
	private JTextField txt_file;
	private String folderPath = "";
	private String id;

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Statistics_manage() {
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
		
		txt_file = new JTextField();
		txt_file.setBounds(310, 235, 397, 62);
		frame.getContentPane().add(txt_file);
		txt_file.setColumns(10);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\manager_stastics.jpg";
		Image image = new ImageIcon(path).getImage();
		JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, image.SCALE_FAST)));
		lblNewLabel.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_data = new JButton("\uCCA8\uBD80\uD558\uAE30");
		btn_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); // 디렉토리 설정
		        chooser.setCurrentDirectory(new File("/")); // 현재 사용 디렉토리를 지정
		        chooser.setAcceptAllFileFilterUsed(true);   // Fileter 모든 파일 적용 
		        chooser.setDialogTitle("첨부할엑셀"); // 창의 제목
		        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // 파일 선택 모드
		        
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv"); // filter 확장자 추가
		        chooser.setFileFilter(filter); // 파일 필터를 추가
		        
		        int returnVal = chooser.showOpenDialog(null); // 열기용 창 오픈
		        
		        if(returnVal == JFileChooser.APPROVE_OPTION) { // 열기를 클릭 
		            folderPath = chooser.getSelectedFile().toString();
			        txt_file.setText(folderPath);
			        JOptionPane.showMessageDialog(null, "파일이 업로드 되었습니다", "업로드", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					Manager_Main ma_m = new Manager_Main();
					ma_m.setId(id);
					ma_m.frame.setVisible(true);

		        }else if(returnVal == JFileChooser.CANCEL_OPTION){ // 취소를 클릭
			        JOptionPane.showMessageDialog(null, "파일 업로드를 다시 하십시오", "업로드", JOptionPane.INFORMATION_MESSAGE);
		        	folderPath = "";
		        }
		        
//		        JOptionPane.showMessageDialog(null, "파일이 업로드 되었습니다", "업로드", JOptionPane.INFORMATION_MESSAGE);

				
				
			}
		});
		btn_data.setBounds(719, 235, 97, 62);
		btn_data.setOpaque(false);
		frame.getContentPane().add(btn_data);
		
		JButton btn_back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Manager_Main ma_m = new Manager_Main();
				ma_m.setId(id);
				ma_m.frame.setVisible(true);
				
			}
		});
		btn_back.setBounds(1107, 10, 81, 79);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		JButton btn_request = new JButton("\uC21C\uCC30\uC2E0\uBB38\uACE0\uCC3D");
		btn_request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Request_Assign r_a = new Request_Assign();
				r_a.setId(id);
				r_a.frame.setVisible(true);
				
			}
		});
		btn_request.setBounds(354, 0, 160, 89);
		btn_request.setOpaque(false);
		frame.getContentPane().add(btn_request);
		
		JButton btn_report = new JButton("\uBC94\uC8C4\uC2E0\uACE0\uCC3D");
		btn_report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Report_Assign r_a = new Report_Assign();
				r_a.setId(id);
				r_a.frame.setVisible(true);;
			}
		});
		btn_report.setBounds(174, 0, 179, 89);
		btn_report.setOpaque(false);
		frame.getContentPane().add(btn_report);
		
		JButton btn_member = new JButton("\uD68C\uC6D0\uAD00\uB9AC\uCC3D");
		btn_member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Member_manage me = new Member_manage();
				me.setId(id);
				me.frame.setVisible(true);;
				
				
			}
		});
		btn_member.setBounds(0, 0, 179, 89);
		btn_member.setOpaque(false);
		frame.getContentPane().add(btn_member);
		
		JButton btn_stastics = new JButton("\uC21C\uCC30\uC2E0\uBB38\uACE0\uCC3D");
		btn_stastics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Statistics_manage stm = new Statistics_manage();
				stm.setId(id);
				stm.frame.setVisible(true);
			}
		});
		btn_stastics.setOpaque(false);
		btn_stastics.setBounds(517, 0, 169, 89);
		frame.getContentPane().add(btn_stastics);
		
		
	}
}
