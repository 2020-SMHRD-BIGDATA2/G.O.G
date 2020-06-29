package Final_project;

public class CrimeVO {
	
	private String year;  // ��
	private String division; // ����
	private int kill; // ����
	private int rape; // ����,��������
	private int theft; // ����
	private int attack; // ����
	
	
	
	public CrimeVO(String year, String division, int kill, int rape, int theft, int attack) {
		super();
		this.year = year;
		this.division = division;
		this.kill = kill;
		this.rape = rape;
		this.theft = theft;
		this.attack = attack;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	public int getKill() {
		return kill;
	}


	public void setKill(int kill) {
		this.kill = kill;
	}


	public int getRape() {
		return rape;
	}


	public void setRape(int rape) {
		this.rape = rape;
	}


	public int getTheft() {
		return theft;
	}


	public void setTheft(int theft) {
		this.theft = theft;
	}


	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	
	
	
}
