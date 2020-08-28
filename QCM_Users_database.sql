CREATE DATABASE surveyUsers	;
USE surveyUsers;

DROP TABLE IF EXISTS Students,Teachers , Surveys;

CREATE TABLE Students(
Id BIGINT PRIMARY KEY AUTO_INCREMENT,
 Name VARCHAR(50) ,
 Surname VARCHAR(50) ,
 grade VARCHAR(25) ,
 password VARCHAR(100),
 code LONG);

CREATE TABLE Teachers(
 Id BIGINT PRIMARY KEY AUTO_INCREMENT,
 Name VARCHAR(50) ,
 Surname VARCHAR(50) ,
 password VARCHAR(100),
 code LONG); 

CREATE TABLE Surveys (
 Id BIGINT PRIMARY KEY AUTO_INCREMENT , 
Theme VARCHAR(50) NOT NULL,
Author VARCHAR(50) NOT NULL,
 CreationDate Date NOT NULL ,
 Status boolean ,
 Grade VARCHAR(50) NOT NULL , 
 Duration VARCHAR(10) NOT NULL,
 Size INT NOT NULL,
 relatedQuestionTable VARCHAR(50) NOT NULL ,
 relatedResultTable VARCHAR(50) NOT NULL );