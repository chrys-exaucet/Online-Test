package views.gui.teachers;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.swing.ButtonGroup;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

@SuppressWarnings("serial")
public class SurveyCreationFrame extends JFrame{

	
	PanelImageTeacher imageAjouter = new PanelImageTeacher();
	
	//attributes
	private JTextField surveyTitle ,  questionTitle , SurveySize ,  gradeSurvey;
	private JTextField fieldChoice1 ,fieldChoice2,fieldChoice3 ,fieldChoice4 , fieldMark;
	private JRadioButton  buttonChoice1 ,  buttonChoice2 ,  buttonChoice3,  buttonChoice4;							
	private  JLabel questionNumber  ; 
	private  Button buttonValidate , buttonMain , buttonSaveSurvey , buttonNext  , buttonPrevious;
 	private ButtonGroup group ;									
 	private JLabel errorMessageValidation , errorMessageZone ,teacherName , Date ;
 
	JComboBox<Integer> hour , minutes , forMovingComboBox ;
	 

	
	//constructor
	public SurveyCreationFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SurveyCreationFrame .class.getResource("/iconteacherLarge.png")));
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Espace Professeur - Ajouter QCM");
		
		setContentPane(imageAjouter);
		getContentPane().setLayout(new GridLayout(16, 1, 0, 0));
		
		JPanel panelEntete = new JPanel();
		panelEntete.setOpaque(false);
		imageAjouter.add(panelEntete);
		panelEntete.setLayout(new BorderLayout(0, 0));
		
		JLabel labelAdd = new JLabel("");
		labelAdd.setIcon(new ImageIcon(SurveyCreationFrame .class.getResource("/add1(resized).png")));
		panelEntete.add(labelAdd);
		
		JLabel labelIcon = new JLabel("");
		labelIcon.setIcon(new ImageIcon(SurveyCreationFrame .class.getResource("/iconteacher(resized).png")));
		panelEntete.add(labelIcon, BorderLayout.EAST);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setOpaque(false);
		imageAjouter.add(panelTitle);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel labelSurveyTitle = new JLabel("  Titre du QCM :");
		labelSurveyTitle.setForeground(Color.BLACK);
		labelSurveyTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelTitle.add(labelSurveyTitle, BorderLayout.NORTH);
		
		surveyTitle = new JTextField();
		surveyTitle.setForeground(Color.BLACK);
		surveyTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		surveyTitle.setColumns(10);
		panelTitle.add(surveyTitle, BorderLayout.SOUTH);
		
		JPanel panelNbQuestions = new JPanel();
		panelNbQuestions.setOpaque(false);
		getContentPane().add(panelNbQuestions);
		panelNbQuestions.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel labelNbQuestions = new JLabel("Nombre de questions :");
		labelNbQuestions.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelNbQuestions.add(labelNbQuestions);
		
		JPanel panelField = new JPanel();
		panelField.setOpaque(false);
		panelNbQuestions.add(panelField);
		panelField.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
		
		SurveySize = new JTextField();
		panelField.add(SurveySize);
		SurveySize.setColumns(10);
		
		JPanel panelDuree = new JPanel();
		panelDuree.setOpaque(false);
		imageAjouter.add(panelDuree);
		panelDuree.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		hour = new JComboBox<Integer>();
		hour.setFocusable(false);
		hour.setEditable(true);
		hour.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0,1,2,3,4}));
		panelDuree.add(hour);
		
		JLabel lblH = new JLabel("h   :  ");
		lblH.setOpaque(true);
		lblH.setForeground(Color.RED);
		lblH.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelDuree.add(lblH);
		
		minutes = new JComboBox<Integer>();
		minutes.setFocusable(false);
		minutes.setEditable(true);
		minutes.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 5, 10, 15, 20,25, 30, 40, 45, 50, 55}));
		panelDuree.add(minutes);
		
		JLabel lblMn = new JLabel("min");
		lblMn.setOpaque(true);
		lblMn.setForeground(Color.RED);
		lblMn.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelDuree.add(lblMn);
		
		JPanel panelChoixClasse = new JPanel();
		panelChoixClasse.setOpaque(false);
		getContentPane().add(panelChoixClasse);
		panelChoixClasse.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("  Classe :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelChoixClasse.add(lblNewLabel);
		
		JPanel grade = new JPanel();
		grade.setOpaque(false);
		panelChoixClasse.add(grade);
		grade.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
		
		gradeSurvey = new JTextField();
		gradeSurvey.setForeground(Color.DARK_GRAY);
		gradeSurvey.setColumns(10);
		grade.add(gradeSurvey);									
		
		JPanel panelValidateButton = new JPanel();
		panelValidateButton.setOpaque(false);
		FlowLayout fl_panelValidateButton = (FlowLayout) panelValidateButton.getLayout();
		fl_panelValidateButton.setHgap(20);
		fl_panelValidateButton.setVgap(10);
		getContentPane().add(panelValidateButton);
		
		errorMessageValidation = new JLabel("zone de notifcations");
		errorMessageValidation.setForeground(Color.RED);
		errorMessageValidation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelValidateButton.add(errorMessageValidation);
		
		buttonValidate = new Button("Valider");
		buttonValidate.setForeground(Color.WHITE);
		buttonValidate.setBackground(new Color(0, 255, 51));
		buttonValidate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelValidateButton.add(buttonValidate);
		
		JPanel panelIntitule = new JPanel();
		panelIntitule.setOpaque(false);
		getContentPane().add(panelIntitule);
		panelIntitule.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel labelIntitule = new JLabel("  Intitul\u00E9 de la Question : ");
		labelIntitule.setForeground(Color.BLACK);
		labelIntitule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelIntitule.add(labelIntitule);
		
		JPanel panelNumeroQuestion = new JPanel();
		panelNumeroQuestion.setForeground(new Color(255, 255, 255));
		panelIntitule.add(panelNumeroQuestion);
		GridBagLayout gbl_panelNumeroQuestion = new GridBagLayout();
		gbl_panelNumeroQuestion.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelNumeroQuestion.rowHeights = new int[]{0, 0};
		gbl_panelNumeroQuestion.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelNumeroQuestion.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelNumeroQuestion.setLayout(gbl_panelNumeroQuestion);
		
		questionNumber = new JLabel("1");
		questionNumber.setBackground(new Color(255, 255, 255));
		questionNumber.setForeground(new Color(255, 0, 0));										
		questionNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_questionNumber = new GridBagConstraints();
		gbc_questionNumber.gridwidth = 2;
		gbc_questionNumber.insets = new Insets(0, 0, 0, 5);
		gbc_questionNumber.gridx = 0;
		gbc_questionNumber.gridy = 0;
		panelNumeroQuestion.add(questionNumber, gbc_questionNumber);
		
		questionTitle = new JTextField();
		questionTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_questionTitle = new GridBagConstraints();
		gbc_questionTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_questionTitle.gridx = 2;
		gbc_questionTitle.gridy = 0;
		panelNumeroQuestion.add(questionTitle, gbc_questionTitle);
		questionTitle.setColumns(10);
		
		JPanel panelChoice1 = new JPanel();
		panelChoice1.setOpaque(false);
		getContentPane().add(panelChoice1);
		panelChoice1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		
		buttonChoice1 = new JRadioButton("");
		buttonChoice1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelChoice1.add(buttonChoice1);
		
		JPanel panelChoice2 = new JPanel();
		panelChoice2.setOpaque(false);
		getContentPane().add(panelChoice2);
		panelChoice2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		
		buttonChoice2 = new JRadioButton("");
		buttonChoice2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelChoice2.add(buttonChoice2);
		
		JPanel panelChoice3 = new JPanel();
		panelChoice3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelChoice3.setOpaque(false);
		FlowLayout fl_panelChoice3 = (FlowLayout) panelChoice3.getLayout();
		fl_panelChoice3.setVgap(10);
		fl_panelChoice3.setHgap(20);
		fl_panelChoice3.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelChoice3);
		
		buttonChoice3 = new JRadioButton("");
		buttonChoice3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonChoice3.setOpaque(false);
		panelChoice3.add(buttonChoice3);
		
		JPanel panelChoice4 = new JPanel();
		panelChoice4.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panelChoice4.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(20);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		imageAjouter.add(panelChoice4);
		
		buttonChoice4 = new JRadioButton("");
		buttonChoice4.setActionCommand("Choix 4");
		buttonChoice4.setOpaque(false);
		buttonChoice4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelChoice4.add(buttonChoice4);
		
		JPanel panel = new JPanel();
	//	FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setOpaque(false);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelMark = new JPanel();
		FlowLayout fl_panelMark = (FlowLayout) panelMark.getLayout();
		fl_panelMark.setHgap(10);
		fl_panelMark.setAlignment(FlowLayout.LEFT);
		fl_panelMark.setVgap(15);
		panel.add(panelMark);
		
		JLabel labelMark = new JLabel("Point :");
		labelMark.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelMark.add(labelMark);
		
		fieldMark = new JTextField();
		fieldMark.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fieldMark.setForeground(Color.DARK_GRAY);
		fieldMark.setColumns(10);
		panelMark.add(fieldMark);
		
		JPanel panelButtons = new JPanel();
		panel.add(panelButtons);
		
		buttonPrevious = new Button("< Pr\u00E9c\u00E9dent");
		panelButtons.add(buttonPrevious);
		buttonPrevious.setFocusable(false);
		buttonPrevious.setForeground(new Color(0, 0, 0));					
		buttonPrevious.setBackground(new Color(255, 255, 255));
		buttonPrevious.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		buttonNext = new Button("Suivant >");
		panelButtons.add(buttonNext);
		buttonNext.setFocusable(false);
		buttonNext.setForeground(new Color(0, 0, 0));
		buttonNext.setBackground(new Color(255, 255, 255));
		buttonNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		forMovingComboBox = new JComboBox<Integer>();
		panelButtons.add(forMovingComboBox);
		forMovingComboBox.setFocusable(false);
	
		forMovingComboBox.setEditable(true);
		
		JPanel panelRegisterQCM = new JPanel();
		panelRegisterQCM.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelRegisterQCM.setOpaque(false);
		FlowLayout fl_panelRegisterQCM = (FlowLayout) panelRegisterQCM.getLayout();
		fl_panelRegisterQCM.setVgap(-2);
		fl_panelRegisterQCM.setHgap(45);
		getContentPane().add(panelRegisterQCM);
		
		buttonSaveSurvey = new Button("Enregistrer ");
		buttonSaveSurvey.setFocusable(false);								
		panelRegisterQCM.add(buttonSaveSurvey);
		buttonSaveSurvey.setForeground(new Color(255, 255, 255));
		buttonSaveSurvey.setBackground(new Color(0, 255, 0));
		buttonSaveSurvey.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		imageAjouter.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		teacherName = new JLabel("Formateur");
		teacherName.setForeground(new Color(139, 0, 0));
		teacherName.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(teacherName);
		
		Date = new JLabel(" Date de cr\u00E9ation ");
		Date.setHorizontalAlignment(SwingConstants.CENTER);
		Date.setForeground(new Color(128, 0, 0));
		Date.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(Date);
		
		group = new ButtonGroup();
		
		group.add(buttonChoice1);						
		
		fieldChoice1 = new JTextField();
		fieldChoice1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelChoice1.add(fieldChoice1);
		fieldChoice1.setColumns(80);
		group.add(buttonChoice2);
		
		fieldChoice2 = new JTextField();
		fieldChoice2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fieldChoice2.setColumns(80);
		panelChoice2.add(fieldChoice2);
		group.add(buttonChoice3);
		
		fieldChoice3 = new JTextField();
		fieldChoice3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fieldChoice3.setColumns(80);
		panelChoice3.add(fieldChoice3);
		group.add(buttonChoice4);
		
		fieldChoice4 = new JTextField();
		fieldChoice4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fieldChoice4.setColumns(80);
		panelChoice4.add(fieldChoice4);
		
		JPanel panelNotification = new JPanel();
		panelNotification.setOpaque(false);
		imageAjouter.add(panelNotification);
		
		errorMessageZone = new JLabel("Message de notification");
		errorMessageZone.setForeground(new Color(255, 0, 0));
		errorMessageZone.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelNotification.add(errorMessageZone);
		
		JPanel panelExit = new JPanel();
		FlowLayout fl_panelExit = (FlowLayout) panelExit.getLayout();
		fl_panelExit.setAlignment(FlowLayout.RIGHT);
		panelExit.setOpaque(false);
		imageAjouter.add(panelExit);
		
		buttonMain = new Button("Retour au menu principal");
		panelExit.add(buttonMain);
		buttonMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonMain.setFocusable(false);
		buttonMain.setForeground(Color.BLACK);
		buttonMain.setBackground(Color.WHITE);
		buttonMain.setFont(new Font("Tahoma", Font.PLAIN, 19));

		pack();
}

	
	
	
	/*-------------------------------------------------------------------------------------------*/

	// classic getters
	
	public JTextField getSurveyTitleField() {return surveyTitle;}
	public  JTextField getSurveySizeField() {return  SurveySize;}
	public JTextField getGradeSurveyField() { return gradeSurvey;}
	public JComboBox<Integer> getHourField() {return hour ;}
	public JComboBox<Integer> getMinutesField() {return minutes ;}
	
	public int getHour() {return (int) this.hour.getSelectedItem();}
	public int getMinutes() {return (int) this.minutes.getSelectedItem();}

	public void setHour(int h) { this.hour.setSelectedItem(h);}
	public void setMinutes(int m) {this.minutes.setSelectedItem(m);}



	public JRadioButton getButtonChoice1() {return buttonChoice1;}	
	public JRadioButton getButtonChoice2() {return buttonChoice2;}
	public JRadioButton getButtonChoice3() {return buttonChoice3;}	
	public JRadioButton getButtonChoice4() {return buttonChoice4;}
	public Button getButtonValidate() {return buttonValidate;}
	
	
	/*---------------------------------*/
	
	public Button getButtonSaveSurvey() {return buttonSaveSurvey;}
	public Button getButtonNext() {return buttonNext;}
	public Button getButtonPrevious() {return buttonPrevious;}

	public JTextField getQuestionTitleField() {return questionTitle;}
	public JLabel getQuestionNumberLabel (){return questionNumber;}
	public JComboBox<Integer> getForMovingcomboBox(){return forMovingComboBox ;} 
	/*--------------------------------*/
	
	public JTextField getFieldChoice1() { return this.fieldChoice1;}
	public JTextField getFieldChoice2() { return this.fieldChoice2;}
	public JTextField getFieldChoice3() { return this.fieldChoice3;}
	public JTextField getFieldChoice4() { return this.fieldChoice4;}
	public JTextField getFieldMark() { return this.fieldMark;}
	
	
/*------------------------------------------------------------------------------------------*/	
		
	




	// useful methods for the controller
	/*--------------------------------------------------------------------------------------*/	
	public String getSurveyTitle() {return surveyTitle.getText();}
	public void setSurveyTitle(String surveyTitle) { this.surveyTitle.setText(surveyTitle);}


	public String  getQuestionTitle() {return this.questionTitle.getText();}
	public void setQuestionTitle(String questionTitle) {this.questionTitle.setText(questionTitle);}


	public  String getDate() {return Date.getText();}
	public void setDate( String  date) {this.Date.setText(date);}

	
	public  int getSurveySize() {return Integer.parseUnsignedInt(this.SurveySize.getText());}
	public void setSurveySize(int i) {this.SurveySize.setText(String.valueOf(i));}


	public  String getGradeSurvey() {return gradeSurvey.getText();}
	public void setGradeSurvey(String gradeSurvey) {this.gradeSurvey.setText(gradeSurvey);}
	
	
	public int getQuestionNumber() {return Integer.parseUnsignedInt(this.questionNumber.getText());}
	public void setQuestionNumber(int questionNumber) {this.questionNumber.setText(String.valueOf(questionNumber));}
	
	
	/*-------------------------------------------------------------------------------*/
	
	// setting and getting texts of TextFields
	public void setTextChoice1 (String text) {this.fieldChoice1.setText(text);}
	public String getTextChoice1() { return this.fieldChoice1.getText();}


	public void setTextChoice2(String text) {this.fieldChoice2.setText(text);}
	public String getTextChoice2() { return this.fieldChoice2.getText();}


	public void setTextChoice3(String text) {this.fieldChoice3.setText(text);}
	public String getTextChoice3() { return this.fieldChoice3.getText();}


	public void setTextChoice4(String text) {this.fieldChoice4.setText(text);}
	public String getTextChoice4() { return this.fieldChoice4.getText();}

	public void setMark(float mark) {this.fieldMark.setText(String.valueOf(mark));}
	public float getMark() {return Float.parseFloat(this.fieldMark.getText());}
	
	/*-----------------------------------------------------------------------------------------*/
	
	// methods  adding listeners
	public void addButtonValidateListener( ActionListener listener) {this.buttonValidate.addActionListener(listener);}
	public void addButtonMainListener(ActionListener listener) {this.buttonMain.addActionListener(listener);}
	public void addButtonSaveSurveyListener(ActionListener listener) {this.buttonSaveSurvey.addActionListener(listener);}
	public void addButtonNextListener( ActionListener listener) {this.buttonNext.addActionListener(listener);}
	public void addButtonPreviousListener(ActionListener listener) {this.buttonPrevious.addActionListener(listener);}
	public void addForMovingComboBoxListener(ItemListener listener) {this.forMovingComboBox.addItemListener(listener);}
	public void addSurveySizeKeyListener(KeyListener listener) { this.SurveySize.addKeyListener(listener);}
		
			
	/*-------------------------------------------------------------------------------------------*/
	// returns the selected button
	public JRadioButton getSelectedButton() { 
		
		JRadioButton jrdb = null ;

		List<JRadioButton>  list = new ArrayList<JRadioButton>() ;

		list.add(buttonChoice1);
		list.add(buttonChoice2);
		list.add(buttonChoice3);
		list.add(buttonChoice4);

		for (JRadioButton rdb : list) { if( rdb.isSelected() ) { jrdb = rdb ; break;} }

		return jrdb ;	
	}	
	
	public void clearGroupSelection() {this.group.clearSelection();}
	/*-------------------------------------------------------------------------------------------*/
	
	public void setErrorMessageZone(String  errorMessageZone) {this.errorMessageZone.setText(errorMessageZone);}
	public void setErrorMessageValidation(String  errorMessageZone) {this.errorMessageValidation.setText(errorMessageZone);}
	
	
	/*-------------------------------------------------------------------------------------------*/
	
	public String getTeacherName() {return teacherName.getText();}
	public void setTeacherName(String teacherName) {this.teacherName.setText(teacherName);}
	/*-------------------------------------------------------------------------------------------*/
	public void run() {setVisible(true);}
	
	
}