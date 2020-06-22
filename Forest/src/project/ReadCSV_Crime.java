package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV_Crime {
	
	public ArrayList<CrimeVO> getList(){
		
//	public static void main(String[] args) {
		
	
	ArrayList<CrimeVO> list = new ArrayList<CrimeVO>();
	
	File file = new File("C:\\Users\\SMHRD\\Desktop\\DEV\\1차 프로젝트\\남부경찰서년도통합(csv).csv");

	try {
		Scanner sc = new Scanner(file);
		sc.nextLine();
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] value = line.split(",");
			String year = value[0];
			String division = value[1];
			int kill = Integer.parseInt(value[2]);
			int rape = Integer.parseInt(value[3]);
			int theft = Integer.parseInt(value[4]);
			int attack = Integer.parseInt(value[5]);
			list.add(new CrimeVO(year, division, kill, rape, theft, attack));
						
		}
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i).getYear() + " ");
//			System.out.print(list.get(i).getDivision()+ " ");
//			System.out.print(list.get(i).getKill()+ " ");
//			System.out.print(list.get(i).getRape()+ " ");
//			System.out.print(list.get(i).getTheft()+ " ");
//			System.out.print(list.get(i).getAttack()+ " ");
//			System.out.println();
//		}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return list;
	
}
}