package Final_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mypage {

	public JFrame frame;
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
   public Mypage() {
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
      String path = "C:\\Users\\SMHRD\\Desktop\\mypage.jpg";
      Image image = new ImageIcon(path).getImage();
      JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, image.SCALE_FAST)));
      lblNewLabel.setBounds(0, 0, 1200, 800);
      frame.getContentPane().add(lblNewLabel);
      
      JButton btn_rep_assign = new JButton("\uBC94\uC8C4\uC2E0\uACE0 \uB0B4\uC5ED\uD655\uC778");
      btn_rep_assign.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            
            frame.dispose();
            Report_Check reC = new Report_Check();
            reC.setId(id);
            reC.frame.setVisible(true);
            
         }
      });
      btn_rep_assign.setBounds(157, 274, 192, 145);
      btn_rep_assign.setOpaque(false);
      frame.getContentPane().add(btn_rep_assign);
      
      JButton btn_req_assaign = new JButton("\uC21C\uCC30 \uC2E0\uCCAD \uB0B4\uC5ED \uD655\uC778");
      btn_req_assaign.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            frame.dispose();
            Request_Check re = new Request_Check();
            re.setId(id);
            re.frame.setVisible(true);
         
         }
      });
      btn_req_assaign.setBounds(503, 274, 197, 145);
      btn_req_assaign.setOpaque(false);
      
      frame.getContentPane().add(btn_req_assaign);
      
      JButton btn_update = new JButton("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
      btn_update.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            frame.dispose();
            Update update = new Update();
            update.setId(id);
            update.frame.setVisible(true);
         }
      });
      btn_update.setBounds(850, 274, 197, 145);
      btn_update.setOpaque(false);
      frame.getContentPane().add(btn_update);
      
      JButton btn_back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
      btn_back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Login login = new Login(true);
            login.setId(id);
            login.frame.setVisible(true);
            
         }
      });
      btn_back.setBounds(1098, 33, 87, 91);
      btn_back.setOpaque(false);
      frame.getContentPane().add(btn_back);
      
      
   }
}
