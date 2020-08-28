package views.gui.teachers;




import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.students.Student;
import models.students.Students;
import models.surveys.Results;

@SuppressWarnings("serial")
public class ModeleDynamiqueObjet extends AbstractTableModel {


	private Students studentList;								// students that have done the test
	private List<Float > notes  ;								// an array of notes 
	private final String[] entetes = {"Nom", "Prénom", "Notes"};


	public ModeleDynamiqueObjet(Results results) {

		studentList = new Students() ;
		notes = new ArrayList<Float > () ;

		for(Student sdt  : results.getResults().keySet()) {		// for each student ...
			this.studentList.addStudent(sdt);					// get the student name and surname ...
			notes.add(results.getMark(sdt));					// get his mark ...

		}

	}

	public int getRowCount() {

		return  studentList.getStudents().size();

	}


	public int getColumnCount() {
		return entetes.length;
	}


	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		switch(columnIndex){
		case 0:
			return studentList.getStudents().get(rowIndex).getName();
		case 1:
			return studentList.getStudents().get(rowIndex).getSurname();
		case 2:
			return notes.get(rowIndex);

		default:
			return null; 
		}
	}



}