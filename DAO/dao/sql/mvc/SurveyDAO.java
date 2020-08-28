package dao.sql.mvc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

import exceptions.SQLServerException;
import models.students.Student;
import models.surveys.Answers;
import models.surveys.Question;
import models.surveys.Questions;
import models.surveys.Results;
import models.surveys.Survey;
import models.surveys.Surveys;

public class SurveyDAO {
		
	// The work on a survey using the CRUD format...


	/*--------------------------------------------------------------------------*/
	//adding a survey to the data base
	public static final void  createSurvey(Survey survey) throws  SQLServerException{

		// parameters
		String  theme = survey.getTheme() ;
		String  author = survey.getAuthor();
		boolean  status = survey.isStatus();
		String  grade = survey.getGrade();
		String  duration =survey.getDuration() ;		
		Questions questions = survey.getQuestions();
		int surveySize = survey.getSurveySize() ;
		// the creation date is set in the base by the  SQL instruction " NOW() "
		

		String  relatedQuestionTable="QTab"+theme.replace(" ", ""); 
		String  relatedResultTable ="RTab"+theme.replace(" ", ""); 


		// Making a transaction...

		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	// for inserting a new survey 
		PreparedStatement order = null ;	// for creating the related questions table
		PreparedStatement ps = null ;
		ResultSet rs = null ;

		try {

			connexion  = DatabaseConnection.getConnection();
			connexion.setAutoCommit(false);

			/*--------------------------------------------------------------------------*/
			// insert into the survey table
			String insertSQL = "INSERT INTO surveys (theme , author , creationDate , status , grade , duration , size, relatedQuestionTable  , relatedResultTable)"
					+ "VALUES (?,?,NOW(),?,?,?,?,?,?)";
			preparedStatement = connexion.prepareStatement(insertSQL,Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1,theme);
			preparedStatement.setString(2 ,author );
			preparedStatement.setBoolean(3,status);
			preparedStatement.setString(4,grade);
			preparedStatement.setString(5,duration);
			preparedStatement.setInt(6,surveySize);
			preparedStatement.setString(7,relatedQuestionTable);
			preparedStatement.setString(8,relatedResultTable);



			preparedStatement.executeUpdate();

			rs = preparedStatement.getGeneratedKeys() ;

			int surveyId = 0;
			if(rs.next()) 
				surveyId = rs.getInt(1);

		
			/*--------------------------------------------------------------------------*/
			// creating a new table to store questions for the related survey
			String  createQSQL = "CREATE TABLE " +relatedQuestionTable+"(Id BIGINT PRIMARY KEY AUTO_INCREMENT, surveyId BIGINT, Title VARCHAR(300),"
					+ " Answer1 VARCHAR(200), Answer2 VARCHAR(200) , Answer3 VARCHAR(200) , Answer4 VARCHAR(200) , GoodAnswer VARCHAR(200) , "
					+ "QuestionMark FLOAT , FOREIGN KEY(surveyId) REFERENCES surveys(Id) ON DELETE CASCADE)"; 
			order = connexion.prepareStatement(createQSQL);
			
			order.executeUpdate();


			/*--------------------------------------------------------------------------*/
			// adding questions to the table       
			for (Question qst : questions.getQuestions()) {
				

				String  qstTitle = qst.getTitle();
				Answers allAns = qst.getAnswers() ;
				float mark = qst.getMark();

				String sql = "INSERT INTO "+ relatedQuestionTable +"(surveyId, Title, Answer1, Answer2, Answer3, Answer4 , GoodAnswer, QuestionMark) VALUES (?,?,?,?,?,?,?,?)";
				ps = connexion.prepareStatement(sql);

				ps.setInt(1,surveyId);
				ps.setString(2,qstTitle);
				ps.setString(3, allAns.getAnswerAt(1) );
				ps.setString(4, allAns.getAnswerAt(2) );
				ps.setString(5, allAns.getAnswerAt(3) );
				ps.setString(6, allAns.getAnswerAt(4) );
				ps.setString(7, allAns.getGoodAnswer());
				ps.setFloat(8,mark );

				ps.executeUpdate();

			}

			/*--------------------------------------------------------------------------*/
			// creating a new table to store results for the related survey
			String  createRSQL = "CREATE TABLE "+ relatedResultTable +" (Id BIGINT PRIMARY KEY AUTO_INCREMENT, Nom  VARCHAR(100) , Prenom  VARCHAR(100) , Note  FLOAT ) " ;		
			order = connexion.prepareStatement(createRSQL);
			order.executeUpdate();
			/*--------------------------------------------------------------------------*/



			order.close();
			preparedStatement.close();
			connexion.commit();

		} catch (SQLException ex) {

			try {
				connexion.rollback();
			} catch (SQLException e) {
				throw new SQLServerException("une erreur s'est produite...!");
			}
		
				ex.printStackTrace();
				throw new SQLServerException("une erreur s'est produite...!");
				
		} finally {
			try {
				connexion.setAutoCommit(true);
			} catch (SQLException e) {
				throw new SQLServerException("une erreur s'est produite...!");
			}
		}
	} 

	//Done
	public static final void  activateSurvey(Survey survey ) throws SQLServerException {
		

		String auth = survey.getAuthor();
		String theme =survey.getTheme();
		String grade =survey.getGrade();

	
		// SQL variables
		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	
	
		/*-----------------------------------*/

		try {

			connexion = DatabaseConnection.getConnection();
		
			// select  from  the surveys table
			String updateQL = " UPDATE surveys  SET status=?  WHERE Author = ? AND theme =? AND grade = ?" ;
			preparedStatement = connexion.prepareStatement(updateQL);
			preparedStatement.setBoolean(1,true);
			preparedStatement.setString(2,auth);
			preparedStatement.setString(3,theme);
			preparedStatement.setString(4,grade);
			
			preparedStatement.executeUpdate();

			

			// closing resources
			if(preparedStatement !=null) {
				preparedStatement.close();
			}


		} catch (SQLException ex) {
			
			throw new SQLServerException("une erreur s'est produite...!");

		}

		
	}
	/*--------------------------------------------------------------------------*/	
	public static final void  unActivateSurvey(Survey survey ) throws SQLServerException {
		
		

		String auth = survey.getAuthor();
		String theme =survey.getTheme();
		String grade =survey.getGrade();

	
		// SQL variables
		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	
	
		/*-----------------------------------*/

		try {

			connexion = DatabaseConnection.getConnection();
		
			// update  the surveys table
			String updateQL = " UPDATE surveys  SET status=?  WHERE Author = ? AND theme =? AND grade = ?" ;
			preparedStatement = connexion.prepareStatement(updateQL);
			preparedStatement.setBoolean(1,false);
			preparedStatement.setString(2,auth);
			preparedStatement.setString(3,theme);
			preparedStatement.setString(4,grade);
			
			preparedStatement.executeUpdate();

			

			// closing resources
			if(preparedStatement !=null) {
				preparedStatement.close();
			}


		} catch (SQLException ex) {
			
			throw new SQLServerException("une erreur s'est produite...!");

		}
		
		
	}	
	
	/*--------------------------------------------------------------------------*/	
	public static final boolean  hasStudentDoneSurvey( Student student,Survey survey ) throws SQLServerException {
		
		boolean response = false ;

		/*-----------------------------------*/

		String auth = survey.getAuthor();
		String theme =survey.getTheme();
		String grade =survey.getGrade();

		String relatedResultTable = null ;

		/*-----------------------------------*/
		String name = student.getName() ;
		String surname = student.getSurname();

		/*-----------------------------------*/

		// Making a transaction...

		// SQL variables
		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	
		PreparedStatement order = null ;	
		ResultSet resultSet = null ;
		ResultSet rs = null ;

		/*-----------------------------------*/

		try {

			connexion = DatabaseConnection.getConnection();
			connexion.setAutoCommit(false);


			// select  from  the surveys table
			String selectSQL = "SELECT * FROM  surveys WHERE Author = ? AND theme =? AND grade = ?" ;
			preparedStatement = connexion.prepareStatement(selectSQL);
			preparedStatement.setString(1,auth);
			preparedStatement.setString(2,theme);
			preparedStatement.setString(3,grade);


			resultSet =   preparedStatement.executeQuery();

			//  getting the survey related resultTable...
			if( resultSet.first() ) {relatedResultTable = resultSet.getString(10);}

			/*----------------------------------------------------------------*/
			// is the student  into the related result table ?
			if(resultSet!=null) {


				String insertSQL = "SELECT Nom,Prenom FROM " + relatedResultTable + " WHERE Nom =? AND Prenom =?";
				order = connexion.prepareStatement(insertSQL);
				order.setString(1, name);
				order.setString(2, surname);
				rs = order.executeQuery();

				if(rs.first()) {
					response= true ;
				}

			}



			connexion.commit();
			// closing resources
			if(order!=null && preparedStatement !=null) {
				order.close();
				preparedStatement.close();

			}


		} catch (SQLException ex) {
			try {
				connexion.rollback();
			} catch (SQLException e) {	throw new SQLServerException("une erreur s'est produite...!");}
			throw new SQLServerException("une erreur s'est produite...!");

		} finally {
			
			try {
				connexion.setAutoCommit(true);
				
			} catch (SQLException e) {throw new SQLServerException("une erreur s'est produite...!");}		
		}
		
		return response;

	}

	/*--------------------------------------------------------------------------*/	
	public static final void  markStudentForSurvey( Student student,Survey survey,float studentMark ) throws SQLServerException {
		
		String auth = survey.getAuthor();
		String theme =survey.getTheme();
		String grade =survey.getGrade();
		
		String relatedResultTable = null ;
		
		
		String name = student.getName() ;
		String surname = student.getSurname();
		
		// Making a transaction...

		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	// for inserting a new survey 
		PreparedStatement order = null ;	// for the retrieval of the related questions table
		ResultSet resultSet = null ;
		
		try {

			connexion = DatabaseConnection.getConnection();
			connexion.setAutoCommit(false);


			// select  from  the surveys table
			String selectSQL = "SELECT * FROM  surveys WHERE Author = ? AND theme =? AND grade = ?" ;
			preparedStatement = connexion.prepareStatement(selectSQL);
			preparedStatement.setString(1,auth);
			preparedStatement.setString(2,theme);
			preparedStatement.setString(3,grade);
			

			resultSet =   preparedStatement.executeQuery();
			
		//  getting the survey related resultTable...
			if( resultSet.first() ) {relatedResultTable = resultSet.getString(10);}
			
	
			/*----------------------------------------------------------------*/
		// adding the student and his mark into the related result table	
			if(resultSet!=null) {
				
				
				String insertSQL = "INSERT INTO " + relatedResultTable+ " values (NULL,?,?,?) ";
				order = connexion.prepareStatement(insertSQL);
				order.setString(1, name);
				order.setString(2, surname);
				order.setFloat(3,studentMark);		
				order.executeUpdate();
				
			}
			
			
			
			connexion.commit();
			// closing resources
			if(order!=null && preparedStatement !=null) {
				order.close();
				preparedStatement.close();

			}


		} catch (SQLException ex) {
			try {
				connexion.rollback();
			} catch (SQLException e) {	throw new SQLServerException("une erreur s'est produite...!");}
			
			throw new SQLServerException("une erreur s'est produite...!");
		
		} finally {
			try {
				connexion.setAutoCommit(true);
			} catch (SQLException e) {throw new SQLServerException("une erreur s'est produite...!");}		
		}
		
	}

	/*--------------------------------------------------------------------------*/	
	// retrieving surveys by criteria 
	public static final Surveys  getAllSurveysByAuthor(String auth) throws  SQLServerException {

		Surveys surveys = new Surveys() ;
		Survey survey ;

		/*-----------------------*/
		String relatedQuestionTable; 
		String relatedResultTable ; 
		List<String> rqt = new ArrayList<>();
		List<String> rrt  = new ArrayList<>();

		Question question ;
		Questions questions ;
		String title ;

		Answers answers = new Answers();
		String answ1 ;
		String answ2 ;
		String answ3 ;
		String answ4 ;
		String gdans ;

		float mark ;

		/*----------------------*/

		// survey parameters
		String  theme;
		String  author ;
		boolean  status;
		String  grade ;
		String  duration ;		

		int surveySize  ; 
		Date creationDate ;

		// Making a transaction...

		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	// for inserting a new survey 
		PreparedStatement order = null ;	// for the retrieval of the related questions table
		ResultSet resultSet = null ;
		ResultSet rs = null ;


		try {

			connexion = DatabaseConnection.getConnection();
			connexion.setAutoCommit(false);


			// select  from  the surveys table
			String selectSQL = "SELECT * FROM  surveys WHERE Author =?" ;
			preparedStatement = connexion.prepareStatement(selectSQL);
			preparedStatement.setString(1,auth);

			rs =   preparedStatement.executeQuery();

			while( rs.next() ) { //  getting the survey details ...
				
				survey = new Survey() ;

				//retrieving the survey details...
				theme= rs.getString(2);
				author= rs.getString(3);
				creationDate = rs.getDate(4);
				status = rs.getBoolean(5);
				grade= rs.getString(6);
				duration= rs.getString(7);
				surveySize = rs.getInt(8);
				// ... and the related tables
				relatedQuestionTable = rs.getString(9);
				relatedResultTable= rs.getString(10);



				// filling the survey 
				survey.setTheme(theme);
				survey.setAuthor(author);
				survey.setCreationDate(creationDate);
				survey.setStatus(status);
				survey.setGrade(grade);
				survey.setDuration(duration);
				survey.setSurveySize(surveySize);


				surveys.addSurvey(survey);
				rqt.add(relatedQuestionTable);
				rrt.add(relatedResultTable) ;
				
				

			}

			if (rs!=null) {
				int index =	0 ;
				for(Survey svy : surveys.getSurveys()) {

					 questions = new Questions() ;
					String select2SQL = "SELECT * FROM " + rqt.get(index) ;

					order = connexion.prepareStatement(select2SQL);
					resultSet = order.executeQuery();

					while(resultSet.next()) {


						title = resultSet.getString(3);

						answ1 = resultSet.getString(4);
						answ2 = resultSet.getString(5);
						answ3 = resultSet.getString(6);
						answ4 = resultSet.getString(7);
						gdans =	resultSet.getString(8);

						mark = 	resultSet.getFloat(9) ;

						answers = new Answers (answ1,answ2,answ3,answ4,gdans);
						question = new Question(title, answers, mark);
						questions.addQuestion(question);

						
					}

					svy.setQuestions(questions);
					index++ ;


				}


			}

			connexion.commit();
			if(order!=null && preparedStatement !=null) {
				order.close();
				preparedStatement.close();

			}


		} catch (SQLException ex) {
			try {
				connexion.rollback();
			} catch (SQLException e) {throw new SQLServerException("une erreur s'est produite...!");}
			
			throw new SQLServerException("une erreur s'est produite...!");
		
		} finally {
			try {
				connexion.setAutoCommit(true);
			} catch (SQLException e) {throw new SQLServerException("une erreur s'est produite...!");}		
		}

		return surveys;

	}
	/*--------------------------------------------------------------------------*/	
	public static final Surveys getAllSurveysByGrade(String specifiedGrade) throws SQLServerException {
	
	
	
		Surveys surveys = new Surveys() ;
		Survey survey ;

		/*-----------------------*/
		String relatedQuestionTable; 
		String relatedResultTable ; 
		List<String> rqt = new ArrayList<>();
		List<String> rrt  = new ArrayList<>();

		Question question ;
		Questions questions;
		String title ;

		Answers answers = new Answers();
		String answ1 ;
		String answ2 ;
		String answ3 ;
		String answ4 ;
		String gdans ;

		float mark ;

		/*----------------------*/

		// survey parameters
		String  theme;
		String  author ;
		boolean  status;
		String  grade ;
		String  duration ;		

		int surveySize  ; 
		Date creationDate ;

		// Making a transaction...

		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	// for inserting a new survey 
		PreparedStatement order = null ;	// for the retrieval of the related questions table
		ResultSet resultSet = null ;
		ResultSet rs = null ;


		try {

			connexion = DatabaseConnection.getConnection();
			connexion.setAutoCommit(false);


			// select  from  the surveys table
			String selectSQL = "SELECT * FROM  surveys WHERE Grade = ? " ;
			preparedStatement = connexion.prepareStatement(selectSQL);
			preparedStatement.setString(1,specifiedGrade);

			rs =   preparedStatement.executeQuery();

			while( rs.next() ) { //  getting the survey details ...
				
				
				survey = new Survey() ;

				//retrieving the survey details...
				theme= rs.getString(2);
				author= rs.getString(3);
				creationDate = rs.getDate(4);
				status = rs.getBoolean(5);
				grade= rs.getString(6);
				duration= rs.getString(7);
				surveySize = rs.getInt(8);
				// ... and the related tables
				relatedQuestionTable = rs.getString(9);
				relatedResultTable= rs.getString(10);



				// filling the survey 
				survey.setTheme(theme);
				survey.setAuthor(author);
				survey.setCreationDate(creationDate);
				survey.setStatus(status);
				survey.setGrade(grade);
				survey.setDuration(duration);
				survey.setSurveySize(surveySize);


				surveys.addSurvey(survey);
				rqt.add(relatedQuestionTable);
				rrt.add(relatedResultTable) ;
				
			}

			if (rs!=null) {
				int index =	0 ;
				for(Survey svy : surveys.getSurveys()) {
					
					questions = new Questions();

					String select2SQL = "SELECT * FROM " + rqt.get(index) ;

					order = connexion.prepareStatement(select2SQL);
					resultSet = order.executeQuery();

					while(resultSet.next()) {
						
						
					
					

						title = resultSet.getString(3);

						answ1 = resultSet.getString(4);
						answ2 = resultSet.getString(5);
						answ3 = resultSet.getString(6);
						answ4 = resultSet.getString(7);
						gdans =	resultSet.getString(8);

						mark = 	resultSet.getFloat(9) ;

						
						answers = new Answers (answ1,answ2,answ3,answ4,gdans);
						question = new Question(title, answers, mark);		
						questions.addQuestion(question);
						
					

					}
					
				
					svy.setQuestions(questions);
					index++ ;

				}


			}

			connexion.commit();
			if(order!=null && preparedStatement !=null) {
				order.close();
				preparedStatement.close();

			}


		} catch (SQLException ex) {
			try {
				connexion.rollback();
			} catch (SQLException e) {throw new SQLServerException("une erreur s'est produite...!");}
			
		
			throw new SQLServerException("une erreur s'est produite...!");
			
		
		} finally {
			try {
				connexion.setAutoCommit(true);
			} catch (SQLException e) {throw new SQLServerException("une erreur s'est produite...!");}		
		}

		return surveys;
	
	
	}
	
	//getting the results of a survey
	public static final Results getSurveyResults(Survey survey) throws SQLServerException {
		
		String auth = survey.getAuthor();
		String theme =survey.getTheme();
		String grade =survey.getGrade();
		
		String relatedResultTable = null ;
		
		Results surveyResults = new Results(); 
		Student student ; 
		
		
			
		// Making a transaction...

		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	// for inserting a new survey 
		PreparedStatement order = null ;	// for the retrieval of the related questions table
		ResultSet resultSet = null ;
		ResultSet rs = null ;
		
		try {

			connexion = DatabaseConnection.getConnection();
			connexion.setAutoCommit(false);


			// select  from  the surveys table
			String selectSQL = "SELECT * FROM  surveys WHERE Author = ? AND theme =? AND grade = ?" ;
			preparedStatement = connexion.prepareStatement(selectSQL);
			preparedStatement.setString(1,auth);
			preparedStatement.setString(2,theme);
			preparedStatement.setString(3,grade);
			
			resultSet =   preparedStatement.executeQuery();
			
		//  getting the survey related resultTable...
			if( resultSet.first() ) {relatedResultTable = resultSet.getString(10);}
			
	
			/*----------------------------------------------------------------*/
		// getting all the students and their marks from related survey result table	
			if(resultSet!=null) {
				

				String select2SQL = "SELECT Nom , Prenom , Note FROM " + relatedResultTable ;
				order = connexion.prepareStatement(select2SQL);
				rs = order.executeQuery();


				while (rs.next()) {
							
					student = new Student(rs.getString(1) ,  rs.getString(2) ) ;
					surveyResults.getResults().put(student, rs.getFloat(3)) ;

					
				}

			}

			
			
			connexion.commit();
			// closing resources
			if(order!=null && preparedStatement !=null) {
				order.close();
				preparedStatement.close();

			}


		} catch (SQLException ex) {
			try {
				connexion.rollback();
			} catch (SQLException e) {	throw new SQLServerException("une erreur s'est produite...!");}
			
			ex.printStackTrace();
			throw new SQLServerException("une erreur s'est produite...!");
		
		} finally {
			try {
				connexion.setAutoCommit(true);
			} catch (SQLException e) {throw new SQLServerException("une erreur s'est produite...!");}		
		}
		
		return surveyResults;
		
		
	}
		
	/*--------------------------------------------------------------------------*/	
	public static final void  deleteSurvey(Survey survey) throws SQLServerException {
		

		String auth = survey.getAuthor();
		String theme =survey.getTheme();
		String grade =survey.getGrade();

		String relatedQuestionTable = null ;
		String relatedResultTable = null ;

		/*-----------------------------------*/

		// Making a transaction...

		// SQL variables
		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	
		PreparedStatement order = null ;	
		ResultSet resultSet = null ;


		/*-----------------------------------*/

		try {

			connexion = DatabaseConnection.getConnection();
			connexion.setAutoCommit(false);


			// select the survey to delete from  the surveys table
			String selectSQL = "SELECT * FROM  surveys WHERE Author = ? AND theme =? AND grade = ?" ;
			preparedStatement = connexion.prepareStatement(selectSQL);
			preparedStatement.setString(1,auth);
			preparedStatement.setString(2,theme);
			preparedStatement.setString(3,grade);


			resultSet =   preparedStatement.executeQuery();

			//  getting the survey related resultTable...
			if( resultSet.first() ) {
				relatedQuestionTable = resultSet.getString(9);
				relatedResultTable = resultSet.getString(10);

			}
			
		
			/*----------------------------------------------------------------*/
			// deleting the related result & question tables	
			if(resultSet!=null) {

				String deleteSQL = " DELETE FROM surveys WHERE Author = ? AND theme =? AND grade = ? "  ;
				preparedStatement = connexion.prepareStatement(deleteSQL);
				preparedStatement.setString(1,auth);
				preparedStatement.setString(2,theme);
				preparedStatement.setString(3,grade);
				preparedStatement.executeUpdate();



				String dropSQL = "DROP TABLE " + relatedQuestionTable ;
				order = connexion.prepareStatement(dropSQL);
				order.executeUpdate();


				String drop2SQL = "DROP TABLE " + relatedResultTable ;
				order = connexion.prepareStatement(drop2SQL);
				order.executeUpdate();

			}

			connexion.commit();
			// closing resources
			if(order!=null && preparedStatement !=null) {
				order.close();
				preparedStatement.close();
			}


		} catch (SQLException ex) {
			try {
				connexion.rollback();
			} catch (SQLException e) {	throw new SQLServerException("une erreur s'est produite...!");}
			throw new SQLServerException("une erreur s'est produite...!");

		} finally {

			try {
				connexion.setAutoCommit(true);
			} catch (SQLException e) {throw new SQLServerException("une erreur s'est produite...!");}		
		}

	}
	/*--------------------------------------------------------------------------*/
	//Updating a survey
	public static final void updateSurvey(Survey modified) throws SQLServerException {
		
		
		
		// parameters
		
		/*-------------------------------------------------------------------------------------*/
		
		String oldRelatedQuestionTable = null ;


		
		String oldAuth = modified.getAuthor();
		String oldTheme =modified.getTheme();
		String oldGrade =modified.getGrade();


		String  duration =modified.getDuration() ;		
		Questions questions = modified.getQuestions();
		int surveySize = modified.getSurveySize() ;
		// the creation date is set in the base by the  SQL instruction " NOW() "

		

		/*-------------------------------------------------------------------------------------*/


				// Making a transaction...

				Connection connexion = null ;
				PreparedStatement preparedStatement = null ,ps = null , order = null  ;
				ResultSet resultSet = null ;
			


				try {

					connexion  = DatabaseConnection.getConnection();
					connexion.setAutoCommit(false);
					
					
					// select  from  the surveys table
					String selectSQL = " SELECT * FROM  surveys WHERE Author = ? AND theme =? AND grade = ? " ;
					preparedStatement = connexion.prepareStatement(selectSQL);
					preparedStatement.setString(1,oldAuth);
					preparedStatement.setString(2,oldTheme);
					preparedStatement.setString(3,oldGrade);


					resultSet =   preparedStatement.executeQuery();

					//  getting the survey related resultQuestion...
					if( resultSet.first() ) {
						
						oldRelatedQuestionTable = resultSet.getString(9);
					
						
					}

					/*----------------------------------------------------------------*/
					
					if(resultSet!=null) {
					// updating the survey details
					String updatetSQL = "UPDATE SET surveys creationDate = NOW() , status=? , duration =? , size=? "
							
							+ " WHERE Author =? AND grade = ? AND theme =? " ;
					
					ps = connexion.prepareStatement(updatetSQL);

					ps.setBoolean(1,false);
					ps.setString(2 ,duration );
					ps.setInt(3,surveySize);
					
					ps.setInt(4,surveySize);
					ps.setString(5 ,oldAuth );
					ps.setString(6 ,oldGrade );
					ps.setString(7 ,oldTheme );
					
					ps.executeUpdate();

					
					
					
					/*--------------------------------------------------------------------------*/
					// adding/updating questions to the table       
					for (Question qst : questions.getQuestions()) {
						

						String  qstTitle = qst.getTitle();
						Answers allAns = qst.getAnswers() ;
						float mark = qst.getMark();

						String sqlUpdate = " UPDATE "+ oldRelatedQuestionTable +" SET  Title=?, Answer1=?, Answer2=?, Answer3=?, Answer4=? , GoodAnswer=?, QuestionMark=? ";
						
						 order= connexion.prepareStatement(sqlUpdate);

					
						 order.setString(2,qstTitle);
						 order.setString(3, allAns.getAnswerAt(1) );
						 order.setString(4, allAns.getAnswerAt(2) );
						 order.setString(5, allAns.getAnswerAt(3) );
						 order.setString(6, allAns.getAnswerAt(4) );
						 order.setString(7, allAns.getGoodAnswer());
						 order.setFloat(8,mark );

						 order.executeUpdate();

					}
					
					}

					/*-----------------------------------------------------------------------------*/


					order.close();
					ps.close();
					preparedStatement.close();
					connexion.commit();

				} catch (SQLException ex) {

					try {
						connexion.rollback();
					} catch (SQLException e) {
						throw new SQLServerException("une erreur s'est produite...!");
					}
				
						ex.printStackTrace();
						throw new SQLServerException("une erreur s'est produite...!");
						
				} finally {
					try {
						connexion.setAutoCommit(true);
					} catch (SQLException e) {
						throw new SQLServerException("une erreur s'est produite...!");
					}
				}
			} 


	/*-------------------------------------------------------------------------*/
	// exporting the results directly from MySQL workbench... it only works if one changes its mySQL property secure_file_priv...
	public static final void exportResultsTo(String path ,Survey survey) throws SQLServerException {
		
		
		String auth = survey.getAuthor();
		String theme =survey.getTheme();
		String grade =survey.getGrade();
		
		
		
		String relatedResultsTable = null ; 
		
		
		Connection connexion = null ;
		PreparedStatement preparedStatement = null ;	// for inserting a new survey 
		PreparedStatement order = null ;	// for the retrieval of the related results table
		ResultSet resultSet = null ;
		

		// Making a transaction...

		try {

			connexion = DatabaseConnection.getConnection();
			connexion.setAutoCommit(false);


			// select  from  the surveys table
			String selectSQL = "SELECT * FROM  surveys WHERE Author = ? AND theme =? AND grade = ?" ;
			preparedStatement = connexion.prepareStatement(selectSQL);
			preparedStatement.setString(1,auth);
			preparedStatement.setString(2,theme);
			preparedStatement.setString(3,grade);
			
			
			resultSet =   preparedStatement.executeQuery();
			
		//  getting the survey related resultTable...
			if( resultSet.first() ) {relatedResultsTable = resultSet.getString(10);}
			
	
			/*----------------------------------------------------------------*/
		// exporting all the students and their marks from related survey result table	to the chosen CSV file
			
			if(resultSet!=null) {
				
				 String select2SQL = "SELECT Nom, Prenom INTO OUTFILE  "
			                +"'"+ path +"'"
			                + " FIELDS TERMINATED BY ',' "
			                + " FROM " + relatedResultsTable; 
				 
				
				order = connexion.prepareStatement(select2SQL);
				order.execute();    
	           
	           
			}    
			
			
			connexion.commit();
			
			
			// closing resources
			if(order!=null && preparedStatement !=null) {
				order.close();
				preparedStatement.close();

			}


		} catch (SQLException ex) {
			try {
				connexion.rollback();
			} catch (SQLException e) {	throw new SQLServerException("une erreur s'est produite...!");}
			
			ex.printStackTrace();
			throw new SQLServerException("une erreur s'est produite...!");
		
		} finally {
			try {
				connexion.setAutoCommit(true);
			} catch (SQLException e) {throw new SQLServerException("une erreur s'est produite...!");}		
		}
}}