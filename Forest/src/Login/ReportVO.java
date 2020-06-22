package Login;

public class ReportVO {
	private int kind;
	private String contents;
	private String data;
	private String dates;
	
	public ReportVO(int kind, String contents, String data, String dates) {
		this.kind = kind;
		this.contents = contents;
		this.data = data;
		this.dates = dates;
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
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	
	
	
}
