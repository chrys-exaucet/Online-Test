package models.students;

public class Student  {

	
	String name , surname , grade ;
	String password;
	long  code ;
	
	public Student(String name, String surname, String grade, String password, long code) {
	
		this.name = name;
		this.surname = surname;
		this.grade = grade;
		this.password = password;
		this.code = code;
	}
	
	public Student(String name , String surname) {
		
		this.name = name ;
		this.surname = surname ;
		
	}
	
	public Student() {}

	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getSurname() {return surname;}
	public void setSurname(String surname) {this.surname = surname;}
	public String getGrade() {return grade;}
	public void setGrade(String grade) {this.grade = grade;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public long getCode() {return code;}
	public void setCode(long code) {this.code = code;}
	

}