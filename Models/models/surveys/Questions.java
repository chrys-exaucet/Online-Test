package models.surveys;

import java.util.ArrayList;
import java.util.List;



public class Questions {
	
private List<Question> questions = new ArrayList<>();
	
	public List<Question> getQuestions() {return questions;}
	
	public void setQuestions(List<Question> qst) {this.questions = qst;}
	public void addQuestion(Question qst ) {this.questions.add(qst);}
	public void deleteQuestion(Question qst) {this.questions.remove(qst);}
	public void deleteQuestion(int index) {this.questions.remove(getQuestion(index));}
	
	public void updateQuestion(int index , Question qst) {this.questions.set(index, qst);}
	public Question getQuestion(int index){   return  this.questions.get(index) ; }
	public void clear () {this.questions.clear();}
	
}
