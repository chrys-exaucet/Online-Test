package models.teachers;


public class Teacher {

	String name , surname , password;
	long  code ;
	
	
	public Teacher( String name, String surname, String password, long code) {
		
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.code = code;
	}

	public Teacher() {}

	public String getName() {return name;}
	public void setName(String n) {this.name = n;}
	public String getSurname() {return surname;}
	public void setSurname(String surn) {this.surname = surn;}
	public String getPassword() {return password;}
	public void setPassword(String pwd) {	this.password =  pwd;}
	public long getCode() {	return code;}
	public void setCode(long c) {this.code = c;}
}
