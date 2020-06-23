package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CommonButton {
	
	
	
	
	public void buttonMake(JFrame frame, JPanel panel) {
		JButton btnNewButton = new JButton("\uD648");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				frame.dispose();
				XXX_Join.main(null);
			}
		});
		
		btnNewButton.setBounds(12, 21, 69, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD0ED1");
		btnNewButton_1.setBounds(93, 21, 69, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		btnNewButton_1_1.setBounds(172, 21, 69, 40);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("\uAC8C\uC2DC\uD310");
		btnNewButton_1_1_1.setBounds(255, 21, 69, 40);
		panel.add(btnNewButton_1_1_1);
		
	}
}
