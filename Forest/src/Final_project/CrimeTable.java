package Final_project;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CrimeTable {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrimeTable window = new CrimeTable();
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
	public CrimeTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 774, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 758, 495);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		panel.add(table);
		
		ReadCSV_Crime readCSV = new ReadCSV_Crime();
		ArrayList<CrimeVO> list = readCSV.getList();
		String[] colNames = {"발생년도", "구분", "살인", "강간,강제 추행", "절도", "폭력"}; 

//		for (int i = 0; i < list.size(); i++) {	
//		Object[][] data = {{list.get(i).getYear(),list.get(i).getDivision(),list.get(i).getKill(),
//			list.get(i).getRape(), list.get(i).getTheft(),list.get(i).getAttack()}};
//		}
		
		Object[][] data = {{list.get(0).getYear(),list.get(0).getDivision(),list.get(0).getKill(),
			list.get(0).getRape(), list.get(0).getTheft(),list.get(0).getAttack()},
			{list.get(1).getYear(),list.get(1).getDivision(),list.get(1).getKill(),
				list.get(1).getRape(), list.get(1).getTheft(),list.get(1).getAttack()}
		};
		
		panel.setLayout(new CardLayout(0, 0));
		
		table = new JTable(data, colNames);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, "name_260632652525500");

		

		
		
	}
}
