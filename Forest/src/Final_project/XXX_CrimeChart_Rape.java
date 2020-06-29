package Final_project;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JPanel;

public class XXX_CrimeChart_Rape {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XXX_CrimeChart_Rape window = new XXX_CrimeChart_Rape();
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
	public XXX_CrimeChart_Rape() {
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
			
			dataset1.addValue(list.get(i).getRape(), list.get(i).getYear(), years+" �߻��Ǽ�");
			dataset1.addValue(list.get(i+1).getRape(), list.get(i+1).getYear(), years+" �˰ŰǼ�");
			years++;
		}
		
		JFreeChart barChart = ChartFactory.createBarChart("����������Ȳ","����/���� ����","�Ǽ�",dataset1,PlotOrientation.VERTICAL, true, true, true);

		Font f = new Font("Gulim", Font.BOLD, 14);
		
		// �׷��� ���� �ѱ� ���ڵ�
		barChart.getTitle().setFont(f);
		
		// x�� y�� �ѱ�����
		CategoryPlot plot1 = barChart.getCategoryPlot();	
		// x�� �ѱ�
		plot1.getDomainAxis().setLabelFont(f);
		plot1.getDomainAxis().setTickLabelFont(f);
		// y�� �ѱ�
		plot1.getRangeAxis().setLabelFont(f);
		plot1.getRangeAxis().setTickLabelFont(f);
		
		

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1100,450));
		panel.add(chartPanel);

	
	
	
	
	
	
	}
}
