package Login;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;

public class List {

	private JFrame frame;
	private MembersDAO dao = new MembersDAO();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List window = new List();
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
	public List() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 456, 407);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		ArrayList<MembersVO> member = dao.selectAll();
		
		// member라는 arraylilst에 들어있는 값 중에 이름만 가지고 와서 model에 추가르 함
		for (int i = 0; i < member.size(); i++) {
			model.addElement(member.get(i).getName());
		}
		
		JList list = new JList(model);
		list.setBounds(38, 26, 389, 358);
		panel.add(list);
	
		
	}
}
