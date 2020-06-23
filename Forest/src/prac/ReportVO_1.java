package prac;

public class ReportVO_1 {

	
	//아이디,신고정류,신고내용,증빙자료,신고날짜,신고번호
	private String id; //아이디
	private String content ; //신고내용
	private String kind; //신고종류
	private int rep_num; //신고번호
	private String data;
	private String date;
	public ReportVO_1(String id, String content, String kind, int rep_num, String data, String date) {
		super();
		this.id = id;
		this.content = content;
		this.kind = kind;
		this.rep_num = rep_num;
		this.data = data;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getRep_num() {
		return rep_num;
	}
	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	



	

}
