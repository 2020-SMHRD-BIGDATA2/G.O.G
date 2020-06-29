package Final_project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class XXX_CrimeChart_Kill {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XXX_CrimeChart_Kill window = new XXX_CrimeChart_Kill();
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
	public XXX_CrimeChart_Kill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 476, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1109, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
	
		ReadCSV_Crime readCSV = new ReadCSV_Crime();
		ArrayList<CrimeVO> list = readCSV.getList();
		
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();

		int years = 15;
		for (int i = 0; i < list.size(); i = i+2) {
			
			dataset1.addValue(list.get(i).getKill(), list.get(i).getYear(), years+" 발생건수");
			dataset1.addValue(list.get(i+1).getKill(), list.get(i+1).getYear(), years+" 검거건수");
			years++;
		}
		
		JFreeChart barChart = ChartFactory.createBarChart("남구범죄현황","살인","건수",dataset1,PlotOrientation.VERTICAL, true, true, true);

		Font f = new Font("Gulim", Font.BOLD, 14);
		
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
		panel.setLayout(null);
		

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setBounds(5, 5, 1100, 450);
		chartPanel.setPreferredSize(new java.awt.Dimension(1100,450));
		panel.add(chartPanel);
		chartPanel.setLayout(null);
		
		String path = "C:\\Users\\SMHRD\\Desktop\\chart.jpg";//메인 이미지
		Image image = new ImageIcon(path).getImage();
		JLabel lbl_image = new JLabel(new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_FAST)));
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(lbl_image);

	
	
	
	
	}

}
