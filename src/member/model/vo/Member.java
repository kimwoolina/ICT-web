package member.model.vo;

import java.sql.Date;

//vo(value object) == do(domain object) == dto(data transfer object)
public class Member implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userId;		//회원 아이디
	private String userPwd;		//회원 암호
	private String userName;	//회원 이름
	private String gender;		//회원 성별
	private int age;		//회원 나이
	private String phone;	//회원 전화번호
	private String email;	//회원 이메일
	private String hobby;	//회원 취미
	private String etc;		//회원 기타 정보
	private java.sql.Date enrollDate;	//회원 가입 날짜
	private java.sql.Date lastModified;	//회원정보 마지막 수정날짜
	private String sqLev;  //USERS 테이블의 SQ_LEV(접속보안등급) 컬럼값 저장용
	
	public Member() {}

	public Member(String userId, String userPwd, String userName, String gender, int age, String phone, String email,
			String hobby, String etc, Date enrollDate, Date lastModified) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.hobby = hobby;
		this.etc = etc;
		this.enrollDate = enrollDate;
		this.lastModified = lastModified;
	}	

	public Member(String userId, String userPwd, String userName, String gender, int age, String phone, String email,
			String hobby, String etc, Date enrollDate, Date lastModified, String sqLev) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.hobby = hobby;
		this.etc = etc;
		this.enrollDate = enrollDate;
		this.lastModified = lastModified;
		this.sqLev = sqLev;
	}	

	public String getSqLev() {
		return sqLev;
	}

	public void setSqLev(String sqLev) {
		this.sqLev = sqLev;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public java.sql.Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(java.sql.Date lastModified) {
		this.lastModified = lastModified;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", gender=" + gender
				+ ", age=" + age + ", phone=" + phone + ", email=" + email + ", hobby=" + hobby + ", etc=" + etc
				+ ", enrollDate=" + enrollDate + ", lastModified=" + lastModified + ", sqLev=" + sqLev + "]";
	}	
}

