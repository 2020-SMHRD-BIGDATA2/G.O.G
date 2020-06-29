package Final_project;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Chart.CrimeVO;
import Chart.ReadCSV_Crime;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class XXXX_Request_Assign {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XXXX_Request_Assign window = new XXXX_Request_Assign();
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
	public XXXX_Request_Assign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1216, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 89, 1103, 547);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		table = new JTable();
		panel.add(table, "name_411859529015600");
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, "name_411859533599500");
		
		
		Request_AssignDAO dao = new Request_AssignDAO();
		ArrayList<Request_AssignVO> list = dao.selectAll();
		String[] colNames = {"신청번호", "신청날짜", "이름", "전화번호", "장소", "시간", "날짜 ", "순찰사유", "요청사항"}; 
		
		Object[][] data = {{list.get(0).getReq_num(),list.get(0).getGet_date(),list.get(0).getName(),list.get(0).getPnumber(),
			list.get(0).getLocation(), list.get(0).getTime(),list.get(0).getSeldate(),list.get(0).getReason(),list.get(0).getAsk()}
		};
		
		
		String path = "C:\\Users\\SMHRD\\Desktop\\Request_Assign.jpg";
		Image image = new ImageIcon(path).getImage();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800,Image.SCALE_FAST)));
		lbl_image.setBounds(0, 0, 1200, 800);
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_image);
		
	}
}
