package Final_project;

public class Request_AssignVO {

	private String id;
	private int free_team;
	private int req_num;
	private String get_date;
	private String name;
	private String pnumber;
	private String location;
	private int time;
	private String seldate;
	private int reason;
	private String ask;
	private String req_reason;
	private String req_time;
	private String req_free_team;
	
	
	public Request_AssignVO(int req_num, String name, String seldate, int time, String location, String pnumber, int reason, int free_team){
		
		this.req_num = req_num;
		this.name = name;
		this.seldate = seldate;
		this.time = time;
		this.location = location;
		this.pnumber = pnumber;
		this.reason = reason;
		this.free_team = free_team;
		
		
	}
	
	public Request_AssignVO(String id, int req_num, int free_team) {
		
		this.id = id;
		this.req_num = req_num;
		this.free_team = free_team;
		
	}
	
	
	public Request_AssignVO(int req_num, String get_date, String name, String pnumber, String location, String req_time,
			String seldate, String req_reason, String ask) {
		this.req_num = req_num;
		this.get_date = get_date;
		this.name = name;
		this.pnumber = pnumber;
		this.location = location;
		this.req_time = req_time;
		this.seldate = seldate;
		this.req_reason = req_reason;
		this.ask = ask;
	}
	
	
	public Request_AssignVO(int req_num, String get_date, String name, String pnumber, String location, int time,
			String seldate, int reason, String ask) {
		this.req_num = req_num;
		this.get_date = get_date;
		this.name = name;
		this.pnumber = pnumber;
		this.location = location;
		this.time = time;
		this.seldate = seldate;
		this.reason = reason;
		this.ask = ask;
	}

	public Request_AssignVO(String id, int free_team, int req_num, String get_date, String name, String pnumber,
			String location, int time, String seldate, int reason, String ask) {
		this.id = id;
		this.free_team = free_team;
		this.req_num = req_num;
		this.get_date = get_date;
		this.name = name;
		this.pnumber = pnumber;
		this.location = location;
		this.time = time;
		this.seldate = seldate;
		this.reason = reason;
		this.ask = ask;
	}
	
	

	public String getReq_free_team() {
		return req_free_team;
	}

	public void setReq_free_team(String req_free_team) {
		this.req_free_team = req_free_team;
	}

	public String getReq_time() {
		return req_time;
	}

	public void setReq_time(String req_time) {
		this.req_time = req_time;
	}

	public String getReq_reason() {
		return req_reason;
	}

	public void setReq_reason(String req_reason) {
		this.req_reason = req_reason;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFree_team() {
		return free_team;
	}

	public void setFree_team(int free_team) {
		this.free_team = free_team;
	}

	public int getReq_num() {
		return req_num;
	}

	public void setReq_num(int req_num) {
		this.req_num = req_num;
	}

	public String getGet_date() {
		return get_date;
	}

	public void setGet_date(String get_date) {
		this.get_date = get_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getSeldate() {
		return seldate;
	}

	public void setSeldate(String seldate) {
		this.seldate = seldate;
	}

	public int getReason() {
		return reason;
	}

	public void setReason(int reason) {
		this.reason = reason;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	
	
	
	
}
