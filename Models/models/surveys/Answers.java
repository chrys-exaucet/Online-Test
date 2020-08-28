package models.surveys;

import java.util.ArrayList;
import java.util.List;

public class Answers {

private List<String> answers = new ArrayList<>();



public Answers(String answer1 ,String answer2 ,String answer3 , String answer4 ,String gdanswer) {
	
	this.answers.add(0, gdanswer);
	this.answers.add(1,answer1);
	this.answers.add(2,answer2);
	this.answers.add(3,answer3);
	this.answers.add(4,answer4);
	
	
}

public Answers() {}





// getters
public List<String> getAllAnswers() {return this.answers;}
public String  getAnswerAt(int range ) {return this.answers.get(range) ;}
public String getGoodAnswer() {return this.answers.get(0);}

//setters
public void setAnswers(List<String> answ) { this.answers = answ;}	
public void upgradeAnswerAt(int range , String element ) {this.answers.set(range, element) ;}


}
