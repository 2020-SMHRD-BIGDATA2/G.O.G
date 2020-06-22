package Login;

public class RequestVO {
	
	private String location;
	private int time;
	private String seldate;
	private int reason;
	private String ask;
	
	public RequestVO(String location, int time, String seldate, int reason, String ask) {
		this.location = location;
		this.time = time;
		this.seldate = seldate;
		this.reason = reason;
		this.ask = ask;
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
