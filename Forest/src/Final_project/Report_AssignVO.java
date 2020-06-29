package Final_project;

public class Report_AssignVO {
	
	private String id;
	private int police_team;
	private String name;
	private String address;
	private String pnumber;
	private String email;
	private int kind;
	private String contents;
	private String data;
	private int rep_num;
	private String get_date;
	private String rep_kind;
	private String rep_police_team;
	
	
	
	public Report_AssignVO(String id, int rep_num, int police_team) {
		this.id = id;
		this.rep_num = rep_num;
		this.police_team = police_team;
	}
	
	public Report_AssignVO(int rep_num, String get_date, String name, int kind, String pnumber, String contents, int police_team) {
	
		this.rep_num = rep_num;
		this.get_date = get_date;
		this.name = name;
		this.kind = kind;
		this.pnumber = pnumber;
		this.contents = contents;
		this.police_team = police_team;
		
	}
	

	public Report_AssignVO(int rep_num, String get_date, String name, String address, String pnumber,
			String email, String rep_kind, String contents, String data) {
		this.name = name;
		this.address = address;
		this.pnumber = pnumber;
		this.email = email;
		this.rep_kind = rep_kind;
		this.contents = contents;
		this.data = data;
		this.rep_num = rep_num;
		this.get_date = get_date;
	}
	
	public Report_AssignVO(int rep_num, String get_date, String name, String address, String pnumber,
			String email, int kind, String contents, String data) {
		this.name = name;
		this.address = address;
		this.pnumber = pnumber;
		this.email = email;
		this.kind = kind;
		this.contents = contents;
		this.data = data;
		this.rep_num = rep_num;
		this.get_date = get_date;
	}
	
	public Report_AssignVO(String id, int police_team, String name, String address, String pnumber,
			String email, int kind, String contents, String data, int rep_num, String get_date) {
		this.id = id;
		this.police_team = police_team;
		this.name = name;
		this.address = address;
		this.pnumber = pnumber;
		this.email = email;
		this.kind = kind;
		this.contents = contents;
		this.data = data;
		this.rep_num = rep_num;
		this.get_date = get_date;
	}
	
	


	public String getRep_police_team() {
		return rep_police_team;
	}

	public void setRep_police_team(String rep_police_team) {
		this.rep_police_team = rep_police_team;
	}

	public void setRep_kind(String rep_kind) {
		this.rep_kind = rep_kind;
	}

	public String getRep_kind() {
		return rep_kind;
	}

	public void setRep_reason(String rep_kind) {
		this.rep_kind = rep_kind;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getPolice_team() {
		return police_team;
	}
	public void setPolice_team(int police_team) {
		this.police_team = police_team;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getRep_num() {
		return rep_num;
	}
	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}
	public String getGet_date() {
		return get_date;
	}
	public void setGet_date(String get_date) {
		this.get_date = get_date;
	}
	
	
	
	
}
