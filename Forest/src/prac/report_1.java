package prac;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class report_1 {

	private JFrame frame;
	private JButton btn_complete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report_1 window = new report_1();
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
	public report_1() {
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
		
		JLabel lblNewLabel_1 = new JLabel("\uCD5C\uB300 500\uC790\uC785\uB825");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(347, 165, 92, 27);
		frame.getContentPane().add(lblNewLabel_1);
	
		
		JComboBox box_list = new JComboBox();
		box_list.addItem("混牢");
		box_list.addItem("版裹了");
		box_list.addItem("己裹了.己气青");
		box_list.addItem("扁鸥");
		box_list.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//System.out.println(box_list.getSelectedIndex());
				if (box_list.getSelectedIndex() == 0 ) {
					
				}
				
				
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
		
		
		btn_complete = new JButton("");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
			}
		});
		btn_complete.setBackground(Color.WHITE);
		btn_complete.setBounds(193, 428, 97, 33);
		btn_complete.setOpaque(false);
		frame.getContentPane().add(btn_complete);
		
		
		
		JButton btn_back = new JButton("");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_back.setBounds(400, 10, 57, 40);
		btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(45, 202, 393, 198);
		frame.getContentPane().add(textArea);
		
		
		
		
		
		
	}
}
