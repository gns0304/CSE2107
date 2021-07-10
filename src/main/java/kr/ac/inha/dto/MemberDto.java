package kr.ac.inha.dto;

public class MemberDto {
	private String id; 
	private String pw; 
	private String nickname; 
	private String name; 
	private String mail; 
	private String hello;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getHello() {
		return hello;
	}
	public void setHello(String hello) {
		this.hello = hello;
	}
	@Override
	public String toString() {
		return "memberDto [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", name=" + name + ", mail=" + mail
				+ ", hello=" + hello + "]";
	}
	
	
}
