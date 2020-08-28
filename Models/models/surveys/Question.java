package models.surveys;


// Class that defines a question - with its title an the set of answers - the good answer and its mark
public class Question {
	
	
	// Attribute
	private String title ;
	private Answers answers;
	private float mark ;


	
	// Constructor 
	public Question(String title, Answers answers , float mark) {
		
		this.title = title;
		this.answers = answers;
		this.mark= mark ; 
	}
	
	public Question() {}
	
	// getters 
	public String getTitle() {return this.title;}
	public Answers getAnswers() {return this.answers;}
	public String getAnswerAt(int range ) {return this.answers.getAnswerAt(range);}
	public float getMark() {return this.mark;}
	public String getGoodAnswer() { return this.answers.getGoodAnswer(); }
	
	// Setters
	public void setTitle(String title) {this.title = title;}
	public void setAnswers(Answers answers) {this.answers = answers;}
	public void upgradeAnswerAt(int range , String element) { this.answers.upgradeAnswerAt(range, element);}
	public void setMark(float f) {this.mark = f;}

	public void clear() {
		
		this.title=null ;
		this.answers= null ;
		
		
		
	}
	
	

}
