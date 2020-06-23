package Login;

public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private int sex;
	private String address;
	private String pnumber;
	private String email;
	
	public MemberVO() {
	}
	
	public MemberVO(String id, String pw, String address, String pnumber, String email) {
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.pnumber = pnumber;
		this.email = email;
	}
	
	
	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public MemberVO(String id, String pw, String name, int age, int sex, String address, String pnumber, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.pnumber = pnumber;
		this.email = email;
	}
	
	public MemberVO(String id, String name, int age, int sex, String address, String pnumber, String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.pnumber = pnumber;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
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
	
}
