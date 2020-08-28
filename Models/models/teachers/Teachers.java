package models.teachers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




@SuppressWarnings("serial")
public class Teachers implements Serializable {

	
	private List<Teacher> teachers = new ArrayList<>();
	
	public List<Teacher> getTeachers() {
		return teachers;
	}
	
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public void addTeacher(Teacher sdt) { this.teachers.add(sdt); }
	

}