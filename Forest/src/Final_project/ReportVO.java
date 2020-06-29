package Final_project;

public class ReportVO {
	
	//���̵�,�Ű�����,�Ű���,�����ڷ�,�Ű�¥,�Ű��ȣ
	private String id; //���̵�
	private String contents ; //�Ű���
	private int kind; //�Ű�����
	private int rep_num; //�Ű��ȣ
	private String data;
	private String get_date;
	
	public ReportVO(String id) {
		this.id = id;
	}
	
	public ReportVO(String id, String contents, int kind, String data) {
		this.id = id;
		this.contents = contents;
		this.kind = kind;
		this.data = data;
	}
	
	public ReportVO(String id, String contents, int kind, int rep_num, String data, String get_date) {
		this.id = id;
		this.contents = contents;
		this.kind = kind;
		this.rep_num = rep_num;
		this.data = data;
		this.get_date = get_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
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
		return get_date;
	}
	public void setDate(String get_date) {
		this.get_date = get_date;
	}
	
	
	
}
