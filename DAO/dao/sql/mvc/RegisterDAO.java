package dao.sql.mvc;

import java.sql.*;

import exceptions.SQLServerException;
import models.students.Student;
import models.teachers.Teacher;

public class RegisterDAO {
	
	//  DAO class - static methods 

	/*------------------------------------------------------------------------------*/
	// enters the student in the data base
	public static final boolean registerStudent(Student student) throws SQLServerException
	{	

		String name 	= student.getName();
		String surname 	= student.getSurname();
		String grade 	= student.getGrade();
		String password = student.getPassword();
		long code 		= student.getCode();	

		boolean result =false ;
			
		Connection connection = null ;
		PreparedStatement preparedStatement = null;

		try{
			connection = DatabaseConnection.getConnection();
			String query = " INSERT INTO students(Id,Name,Surname,grade,password,code) values (NULL,?,?,?,?,?)"; //Insert student details into the table 'Students'
			preparedStatement = connection.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, grade);
			preparedStatement.setString(4, password);
			preparedStatement.setLong(5, code);

			preparedStatement.executeUpdate();  //return something different from 0 ,  if  data has been inserted into the database
			result=true;
			preparedStatement.close();

		}catch(SQLException e){	throw new SQLServerException("Une erreur s'est produite !");} // On failure, we send a message 	
		
		return result ; 

	}

	/*------------------------------------------------------------------------------*/
	// checks whether or not the couple password-code is in the student data base
	public static final boolean isStudentRegistered(String password , long code) throws SQLServerException  {	
		
		
		boolean result = false  ;

		try{

			Connection connection = DatabaseConnection.getConnection();


			String sql = " SELECT password , code FROM students WHERE  password = ? AND code =? ";
			PreparedStatement   preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, code);

			ResultSet rs =   preparedStatement.executeQuery();
			
			
			if(rs.first()) { result = true ;}	// searching whether or not the student is registered
			
			//closing resources
			rs.close();
			preparedStatement.close();
			
		} catch (SQLException e) { throw new SQLServerException("Une erreur s'est produite !"); }		// an error occurred

		return result ;

	}
	
	/*------------------------------------------------------------------------------*/
	// checks whether or not the couple password-code is in the teacher data base
	public static final boolean isTeacherRegistered(String password , long code) throws SQLServerException {		
		
		boolean result=	false ;

		try {
			Connection connection = DatabaseConnection.getConnection();
			String sql = "SELECT password , code FROM teachers WHERE password = ? AND code =?";
			PreparedStatement   preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, code);	
		
			ResultSet rs =   preparedStatement.executeQuery();
			
				if(rs.first()) { result = true ;}
				rs.close();
				preparedStatement.close();
				
				

		} catch (SQLException e) { throw new SQLServerException("Une erreur s'est produiteeeee !") ;}
		
		return result ;
	}

	// enters the teacher in the data base
	public static final boolean registerTeacher(Teacher teacher) throws SQLServerException
	{	

		String name 	= teacher.getName();
		String surname 	= teacher.getSurname();
		String password = teacher.getPassword();
		long code 		= teacher.getCode();	
		
		boolean result = false ;

		Connection connection = null ;
		PreparedStatement preparedStatement = null;

		try{
			connection = DatabaseConnection.getConnection();
			String query = "INSERT INTO teachers(Id,Name,Surname,password,code) values (NULL,?,?,?,?)"; //Insert teachers details into the table 'Students'
			preparedStatement = connection.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, password);
			preparedStatement.setLong(4, code);

			preparedStatement.executeUpdate();  //return something different from 0 ,  if  data has been inserted into the database

			result = true ;
			
			preparedStatement.close();
			

		}catch(SQLException e){	throw new SQLServerException("Une erreur s'est produite !");} // On failure, we send a message 	

		
		return result ; 
}

	
	/*------------------------------------------------------------------------------*/
	// Retrieves the informations of the student related to the given password & code
	public static final Student retrieveStudent(String studentPassword , long studentCode ) throws SQLServerException {
		
		Student student = null ;
		String name 	;
		String surname 	;
		String grade 	;
		String password ;
		long code ;	

		
		
		try{

			Connection connection = DatabaseConnection.getConnection();


			String sql = " SELECT * FROM students WHERE  password = ? AND code =? ";
			PreparedStatement   preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, studentPassword);
			preparedStatement.setLong(2,studentCode);

			ResultSet rs =   preparedStatement.executeQuery();
			
			
			if(rs.first()) { // searching whether or not the student is registered
				
				name = rs.getString(2);
				surname= rs.getString(3);
				grade =rs.getString(4);
				password = rs.getString(5);
				code= rs.getLong(6);	
				student = new Student(name , surname , grade , password , code);
			
			}		
			
			//closing resources
			rs.close();
			preparedStatement.close();
			
		} catch (SQLException e) {   throw new SQLServerException("Une erreur s'est produite !"); }		// an error occurred

		return student ;
	}
		
	/*------------------------------------------------------------------------------*/
	// Retrieves the informations of the teacher related to the given password & code
	public static final Teacher retrieveTeacher(String teacherPassword , long teacherCode ) throws SQLServerException {

		
		Teacher teacher = null ;
		
		
		String name 	;
		String surname 	;
		String password ;
		long code ;	

		
		
		try {

			Connection connection = DatabaseConnection.getConnection();


			String sql = " SELECT * FROM teachers WHERE  password = ? AND code =? ";
			PreparedStatement   preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teacherPassword);
			preparedStatement.setLong(2,teacherCode);

			ResultSet rs =   preparedStatement.executeQuery();
			
			
			if(rs.first()) { // searching whether or not the student is registered
				
				name = rs.getString(2);
				surname= rs.getString(3);
				password = rs.getString(4);
				code= rs.getLong(5);	
				teacher = new Teacher(name , surname , password , code);
			
			}		
			
			//closing resources
			rs.close();
			preparedStatement.close();
			
		} catch (SQLException e) {   throw new SQLServerException("Une erreur s'est produite !"); }		// an error occurred

		return teacher ;
	}

	
}