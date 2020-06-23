package Login;

public class RequestVO {
	
	private String id;
	private String location;
	private String time;
	private String seldate;
	private int reason;
	private String ask;
	private String get_date;
	private int req_num;
	
	public RequestVO(String id, String location, String time, String seldate, int reason, String ask) {
		this.id = id;
		this.location = location;
		this.time = time;
		this.seldate = seldate;
		this.reason = reason;
		this.ask = ask;

	}
	
	public RequestVO(String id, String location, String time, String seldate, int reason, String ask,
			String get_date, int req_num) {
		this.id = id;
		this.location = location;
		this.time = time;
		this.seldate = seldate;
		this.reason = reason;
		this.ask = ask;
		this.get_date = get_date;
		this.req_num = req_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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

	public String getGet_date() {
		return get_date;
	}

	public void setGet_date(String get_date) {
		this.get_date = get_date;
	}

	public int getReq_num() {
		return req_num;
	}

	public void setReq_num(int req_num) {
		this.req_num = req_num;
	}
	
	
	
	
	
	
}
