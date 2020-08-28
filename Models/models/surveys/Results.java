package models.surveys;

import java.util.HashMap;

import models.students.Student;

public class Results {
	
	

	private HashMap <Student ,Float > results = new  HashMap <Student ,Float >() ;

	public  HashMap<Student, Float> getResults(){
		
		return this.results ;
	}
	
	
	public Results() {}
	
	
	public Results(Results r ) {
		results.putAll(r.getResults());
	}
	
	public Student getStudent(int index ) { 
	Student student = null ;	
	
	 int i=0 ;
		for ( Student sdt : results.keySet() ) {
			
			if(index == i) {
		student = sdt ; break ;
			}
		else{
			i++ ;
		}
		
	}
		
		return student ;
		
		}
		
		
	public Float getMark(Student sdt) {return results.get(sdt) ;}
		
		
	
	
	
	
	
}
