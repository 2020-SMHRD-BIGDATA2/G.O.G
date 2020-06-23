package Login;

public class Report_AssignVO {
	
	private String id;
	private int rep_num;
	private int police_team;
	
	public Report_AssignVO(String id, int rep_num, int police_team) {
		this.id = id;
		this.rep_num = rep_num;
		this.police_team = police_team;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRep_num() {
		return rep_num;
	}

	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}

	public int getPolice_team() {
		return police_team;
	}

	public void setPolice_team(int police_team) {
		this.police_team = police_team;
	}
	
	
	
	
}
