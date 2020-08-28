package models.surveys;

import java.util.ArrayList;
import java.util.List;

public class Surveys {
	
	
private List<Survey> surveys = new ArrayList<>();
	
	public List<Survey> getSurveys() {return this.surveys;}
	public void setSurveys(List<Survey> svey) {this.surveys = svey;}
	
	public void addSurvey(Survey svy) {this.surveys.add(svy);}
	public void deleteSurvey(Survey svy) {this.surveys.remove(svy);}
	public void upgradeSurvey(int index , Survey svy) {this.surveys.set(index, svy);}
	


}
