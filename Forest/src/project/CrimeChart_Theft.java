package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JPanel;
import java.awt.Color;

public class CrimeChart_Theft {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrimeChart_Theft window = new CrimeChart_Theft();
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
	public CrimeChart_Theft() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1125, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panel, 1109, SpringLayout.WEST, frame.getContentPane());
		panel.setBackground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 466, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(panel);
		
		ReadCSV_Crime readCSV = new ReadCSV_Crime();
		ArrayList<CrimeVO> list = readCSV.getList();
		
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
//		dataset1.addValue(list.get(0).getTheft(), list.get(0).getYear(), "15 발생건수");
//		dataset1.addValue(list.get(1).getTheft(), list.get(1).getYear(), "15 검거건수");
//		dataset1.addValue(list.get(2).getTheft(), list.get(2).getYear(), "16 발생건수");
//		dataset1.addValue(list.get(3).getTheft(), list.get(3).getYear(), "16 검거건수");
//		dataset1.addValue(list.get(4).getTheft(), list.get(4).getYear(), "17 발생건수");
//		dataset1.addValue(list.get(5).getTheft(), list.get(5).getYear(), "17 검거건수");
//		dataset1.addValue(list.get(6).getTheft(), list.get(6).getYear(), "18 발생건수");
//		dataset1.addValue(list.get(7).getTheft(), list.get(7).getYear(), "18 검거건수");
		
		
		int years = 15;
		for (int i = 0; i < list.size(); i = i+2) {
			
			dataset1.addValue(list.get(i).getTheft(), list.get(i).getYear(), years+" 발생건수");
			dataset1.addValue(list.get(i+1).getTheft(), list.get(i+1).getYear(), years+" 검거건수");
			years++;
		}
		
		JFreeChart barChart = ChartFactory.createBarChart("남구범죄현황","절도","건수",dataset1,PlotOrientation.VERTICAL, true, true, true);

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
		
		

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1100,450));
		panel.add(chartPanel);

		
		
		
		
		
		
	
	
	}
}
