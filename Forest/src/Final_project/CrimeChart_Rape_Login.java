package Final_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CrimeChart_Rape_Login {

	public JFrame frame;
	private FontMake fm = new FontMake();
	private String id;
	
	
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Create the application.
	 */
	public CrimeChart_Rape_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fm.fontChange(ge);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 185, 1200, 480);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
	
		ReadCSV_Crime readCSV = new ReadCSV_Crime();
		ArrayList<CrimeVO> list = readCSV.getList();
		
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();

		int years = 15;
		for (int i = 0; i < list.size(); i = i+2) {
			
			dataset1.addValue(list.get(i).getRape(), list.get(i).getYear(), years+" 발생건수");
			dataset1.addValue(list.get(i+1).getRape(), list.get(i+1).getYear(), years+" 검거건수");
			years++;
		}
		
		JFreeChart barChart = ChartFactory.createBarChart("남구범죄현황","강간/강제 추행","건수",dataset1,PlotOrientation.VERTICAL, true, true, true);

		
		Font f = new Font("나눔바른고딕", Font.BOLD, 14);
		
		// 그래프 제목에 한글 인코딩
		barChart.getTitle().setFont(f);
		
		// x축 y축 한글적용
		CategoryPlot plot1 = barChart.getCategoryPlot();	
		// x축 한글
		plot1.getDomainAxis().setLabelFont(f);
		plot1.getDomainAxis().setTickLabelFont(f);
		// y축 한글
		plot1.getRangeAxis().setLabelFont(f);
		plot1.getRangeAxis().setTickLabelFont(f);
		
		

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1100,450));
		panel.add(chartPanel);
		chartPanel.setLayout(null);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\chart.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lbl_image);
		
		JButton btn_back = new JButton("New button");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Stastics_Main sta_ma = new Stastics_Main();
				sta_ma.setId(id);
				sta_ma.frame.setVisible(true);			}
		});
		btn_back.setBounds(1092, 36, 92, 86);
	    btn_back.setOpaque(false);
		frame.getContentPane().add(btn_back);
	}

}
