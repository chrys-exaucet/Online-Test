package models.students;

import java.util.ArrayList;
import java.util.List;

public class Students {
	
	private List<Student> students = new ArrayList<>();
	
	public List<Student> getStudents() {	return this.students;}
	
	public void setStudents(List<Student> students) {this.students = students;}

	public void addStudent(Student sdt) { this.students.add(sdt); }
	
		
}
