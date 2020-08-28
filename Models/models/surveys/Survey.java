package models.surveys;

import java.util.Date;
// import java.text.DateFormat;

public class Survey {
	
	private String  theme ;
	private String  author ;
	private Date  creationDate ;
	private boolean status ;
	private String  grade ;
	private String  duration ;		
	private Questions questions ;
	private int surveySize ;
	
	/*-----------------------------------------------------------*/
	
	
	public Survey(String theme, String author, Date creationDate, boolean status, String grade, String duration,
			Questions questions, int surveySize) {
		this.theme = theme;
		this.author = author;
		this.creationDate = creationDate;
		this.status = status;
		this.grade = grade;
		this.duration = duration;
		this.questions = questions;
		this.surveySize = surveySize;
	}
	
	
	public Survey() {}
	
	/*-----------------------------------------------------------*/
	
	public String getTheme() {return this.theme;}
	public void setTheme(String theme) {this.theme = theme;}
	
	public String getAuthor() {return this.author;}
	public void setAuthor(String author) {this.author = author;}
	
	public Date getCreationDate() {return this.creationDate;}
	public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}
	
	public boolean isStatus() {	return this.status;}
	public void setStatus(boolean status) {	this.status = status;}
	
	public String getGrade() {	return this.grade;}
	public void setGrade(String grade) {this.grade = grade;}
	
	public String getDuration() {return this.duration;}
	public void setDuration(String duration) {this.duration = duration;}
	
	public Questions getQuestions() {return this.questions;}
	public void setQuestions(Questions q) {this.questions = q;}
	
	public int getSurveySize() {return this.surveySize;}
	public void setSurveySize(int surveySize) {this.surveySize = surveySize;}
	
	

}
