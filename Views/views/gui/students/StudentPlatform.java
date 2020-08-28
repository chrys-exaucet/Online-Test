package views.gui.students;

import javax.swing.JFrame;



import java.awt.GridLayout;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;


import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.SystemColor;


@SuppressWarnings("serial")
public class StudentPlatform extends JFrame {

	
		
		PanelImageStudent imageFondEtudiant = new PanelImageStudent();
		private JTextField questionTitleField;
		private JComboBox<String> surveyComboBox;
		private JComboBox<Integer> forMovingComboBox;
		private JLabel  studentName , surveyTitle , labelDelay ,questionAnswered , surveySize , questionNumber, errorMessageZone;
		private JLabel lblVousAvezChoisi , labelIntitule ,  lblVoustes , lblListSurvey;
		
		private Button buttonPrevious , buttonNext , buttonSubmit ,buttonExit, buttonStartSurvey;
		private ButtonGroup group;
		private JRadioButton buttonChoice1 ,buttonChoice2 ,buttonChoice3,buttonChoice4 ;
	 
		
		
		
		
	
		public StudentPlatform() {
			
			setIconImage(Toolkit.getDefaultToolkit().getImage(StudentPlatform.class.getResource("/iconstudent.png")));
			
			setContentPane(imageFondEtudiant);

			
			setUndecorated(true);
			
			setResizable(false);
			getContentPane().setPreferredSize(new Dimension(400, 400));
			setPreferredSize(new Dimension(400, 400));
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			getContentPane().setBackground(Color.WHITE);
			getContentPane().setLayout(new GridLayout(13, 1, 0, 0));
			
			JPanel panel_1 = new JPanel();
			panel_1.setOpaque(false);
			getContentPane().add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JLabel labelConnectedIn = new JLabel(" Etudiant: ");
			labelConnectedIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
			panel_1.add(labelConnectedIn, BorderLayout.WEST);
			
			JLabel studentIcon = new JLabel("");
			studentIcon.setIcon(new ImageIcon(StudentPlatform.class.getResource("/iconstudent.png")));
			panel_1.add(studentIcon, BorderLayout.EAST);
			
			studentName = new JLabel(" ");
			studentName.setForeground(Color.BLUE);
			studentName.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panel_1.add(studentName, BorderLayout.CENTER);
			
			JPanel panel_2 = new JPanel();
			panel_2.setOpaque(false);
			getContentPane().add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			surveyComboBox = new JComboBox<String>();
			surveyComboBox.setFocusable(false);
			surveyComboBox.setToolTipText("Veuillez choisir un questionnaire");
			panel_2.add(surveyComboBox, BorderLayout.SOUTH);
			
			lblListSurvey = new JLabel("Liste des questionnaires : ");
			panel_2.add(lblListSurvey, BorderLayout.NORTH);
			lblListSurvey.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JPanel panelStartTest = new JPanel();
			panelStartTest.setOpaque(false);
			getContentPane().add(panelStartTest);
			
			JPanel panelSelectedQcm = new JPanel();
			panelSelectedQcm.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panelSelectedQcm.setOpaque(false);
			getContentPane().add(panelSelectedQcm);
			panelSelectedQcm.setLayout(new GridLayout(2, 1, 0, 0));
			
			JPanel panelChoix = new JPanel();
			FlowLayout fl_panelChoix = (FlowLayout) panelChoix.getLayout();
			fl_panelChoix.setAlignment(FlowLayout.LEFT);
			panelChoix.setOpaque(false);
			panelSelectedQcm.add(panelChoix);
			
			 lblVousAvezChoisi = new JLabel("Vous avez choisi le QCM : ");
			panelChoix.add(lblVousAvezChoisi);
			lblVousAvezChoisi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			surveyTitle = new JLabel(" ");
			surveyTitle.setForeground(new Color(0, 0, 204));
			surveyTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panelChoix.add(surveyTitle);
			
			JPanel panelIntitule = new JPanel();
			panelIntitule.setOpaque(false);
			getContentPane().add(panelIntitule);
			panelIntitule.setLayout(new GridLayout(2, 1, 0, 0));
			
			labelIntitule = new JLabel("Question : ");
			labelIntitule.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panelIntitule.add(labelIntitule);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(240, 240, 240));
			panel_3.setForeground(Color.WHITE);
			panelIntitule.add(panel_3);
			GridBagLayout gbl_panel_3 = new GridBagLayout();
			gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panel_3.rowHeights = new int[]{0, 0};
			gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_3.setLayout(gbl_panel_3);
			panel_3.setOpaque(false);
			
			questionNumber = new JLabel("1");
			questionNumber.setForeground(Color.RED);
			questionNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
			questionNumber.setBackground(SystemColor.menu);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.gridwidth = 2;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 0;
			panel_3.add(questionNumber, gbc_label);
			
			questionTitleField = new JTextField();
			questionTitleField.setEditable(false);
			questionTitleField.setSelectedTextColor(SystemColor.infoText);
			questionTitleField.setForeground(new Color(0, 0, 0));
			questionTitleField.setBackground(SystemColor.menu);
			questionTitleField.setText("");
			
			questionTitleField.setFont(new Font("Tahoma", Font.PLAIN, 13));
			questionTitleField.setColumns(10);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 0;
			panel_3.add(questionTitleField, gbc_textField);
			
			JPanel panelChoice1 = new JPanel();
			panelChoice1.setBackground(new Color(240, 240, 240));
			panelChoice1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			FlowLayout fl_panelChoice1 = (FlowLayout) panelChoice1.getLayout();
			fl_panelChoice1.setAlignment(FlowLayout.LEFT);
			panelChoice1.setOpaque(false);
			getContentPane().add(panelChoice1);
			
			buttonChoice1 = new JRadioButton("");
			buttonChoice1.setOpaque(false);
			buttonChoice1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			
			
			panelChoice1.add(buttonChoice1);
			
			JPanel panelChoice2 = new JPanel();
			FlowLayout fl_panelChoice2 = (FlowLayout) panelChoice2.getLayout();
			fl_panelChoice2.setAlignment(FlowLayout.LEFT);
			panelChoice2.setOpaque(false);
			getContentPane().add(panelChoice2);
			
			buttonChoice2 = new JRadioButton("");
			buttonChoice2.setOpaque(false);
			buttonChoice2.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panelChoice2.add(buttonChoice2);
			
			JPanel panelChoice3 = new JPanel();
			FlowLayout fl_panelChoice3 = (FlowLayout) panelChoice3.getLayout();
			fl_panelChoice3.setAlignment(FlowLayout.LEFT);
			panelChoice3.setOpaque(false);
			getContentPane().add(panelChoice3);
			
			buttonChoice3 = new JRadioButton("");
			buttonChoice3.setOpaque(false);
			buttonChoice3.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panelChoice3.add(buttonChoice3);
			
			JPanel panelChoice4 = new JPanel();
			FlowLayout fl_panelChoice4 = (FlowLayout) panelChoice4.getLayout();
			fl_panelChoice4.setAlignment(FlowLayout.LEFT);
			panelChoice4.setOpaque(false);
			getContentPane().add(panelChoice4);
			
			buttonChoice4 = new JRadioButton("");
			buttonChoice4.setOpaque(false);
			buttonChoice4.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panelChoice4.add(buttonChoice4);
			
			JPanel panelDelay = new JPanel();
			panelDelay.setOpaque(false);
			
			JPanel panelNext = new JPanel();
			FlowLayout flowLayout_1 = (FlowLayout) panelNext.getLayout();
			flowLayout_1.setHgap(20);
			panelNext.setOpaque(false);
			panelNext.setFont(new Font("Tahoma", Font.PLAIN, 11));
			getContentPane().add(panelNext);
			
			buttonPrevious = new Button("< Pr\u00E9c\u00E9dent");
			buttonPrevious.setForeground(Color.BLACK);
			buttonPrevious.setFont(new Font("Tahoma", Font.PLAIN, 18));
			buttonPrevious.setFocusable(false);
			buttonPrevious.setBackground(Color.WHITE);
			panelNext.add(buttonPrevious);
			
			buttonNext = new Button("Suivant >");
			buttonNext.setForeground(Color.BLACK);
			buttonNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
			buttonNext.setFocusable(false);
			buttonNext.setBackground(Color.WHITE);
			panelNext.add(buttonNext);
			
			forMovingComboBox = new JComboBox<Integer>();
			forMovingComboBox.setFocusable(false);
			forMovingComboBox.setEditable(true);
			forMovingComboBox.setToolTipText("Se d\u00E9placer vers une question pr\u00E9cise");
			forMovingComboBox.setForeground(Color.BLACK);
			forMovingComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
			forMovingComboBox.setBackground(Color.WHITE);
			panelNext.add(forMovingComboBox);
			panelDelay.setBackground(Color.WHITE);
			getContentPane().add(panelDelay);
			panelDelay.setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panelDelay.add(panel);
			panel.setLayout(new GridLayout(2, 1, 0, 0));
			
			labelDelay = new JLabel(" ");
			labelDelay.setForeground(Color.RED);
			labelDelay.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel.add(labelDelay);
			
			JPanel panel_4 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel_4.setOpaque(false);
			panel.add(panel_4);
			
			lblVoustes = new JLabel("Questions r\u00E9pondues : ");
			lblVoustes.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_4.add(lblVoustes);
			
			questionAnswered = new JLabel(" ");
			questionAnswered.setForeground(Color.RED);
			questionAnswered.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel_4.add(questionAnswered );
			
			surveySize = new JLabel(" ");
			surveySize.setForeground(Color.RED);
			surveySize.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_4.add(surveySize);
			
			JPanel panelExit = new JPanel();
			
			JPanel panelNotification = new JPanel();
			panelNotification.setOpaque(false);
			getContentPane().add(panelNotification);
			panelNotification.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			errorMessageZone = new JLabel("Message de Notification ");
			errorMessageZone.setForeground(Color.RED);
			errorMessageZone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			panelNotification.add(errorMessageZone);
			FlowLayout fl_panelExit = (FlowLayout) panelExit.getLayout();
			fl_panelExit.setAlignment(FlowLayout.RIGHT);
			panelExit.setOpaque(false);
			getContentPane().add(panelExit);
			
			
			
			
			
			 buttonSubmit = new Button("Soumettre");
			 buttonSubmit.setFocusable(false);
			 buttonSubmit.setForeground(Color.BLACK);
			 buttonSubmit.setBackground(Color.GREEN);
			 buttonSubmit.setVisible(false);
			 buttonSubmit.setFont(new Font("Dialog", Font.PLAIN, 24));
			 panelExit.add( buttonSubmit);
			
			buttonExit = new Button("Quitter");
			buttonExit.setFocusable(false);
			buttonExit.setBackground(Color.RED);
			buttonExit.setForeground(Color.WHITE);
			
			
			
			group = new ButtonGroup();
			
			group.add(buttonChoice1);
			group.add(buttonChoice2);
			group.add(buttonChoice3);
			group.add(buttonChoice4);
			
			
			buttonExit.setFont(new Font("Dialog", Font.PLAIN, 24));
			panelExit.add(buttonExit);
			setVisible(true);
			
			buttonStartSurvey = new Button("Commencer le test");
			buttonStartSurvey.setFocusable(false);
			buttonStartSurvey.setFont(new Font("Dialog", Font.PLAIN, 24));
			panelStartTest.add(buttonStartSurvey);
			
		//	pack();
			
				}
		
		
		/*--------------------------------------------------------------------------------*/
		// classic getters and setters
		public JComboBox<String> getSurveyComboBox() {return surveyComboBox;}
		
		public Button getButtonStartSurvey() {return buttonStartSurvey;}

		public JLabel getLabelChosenSurvey() {return lblVousAvezChoisi ;}
		public JLabel getLabelIntitule() {return labelIntitule ;}
		public JLabel getLabelVousEtes() {return lblVoustes;}
		public JLabel getLabelListSurvey() {return lblListSurvey;}	
		
		public JTextField getQuestionTitleField() {return questionTitleField;}
		public JLabel getQuestionNumberLabel (){return questionNumber;}
		

		public JRadioButton getButtonChoice1() {return buttonChoice1;}	
		public JRadioButton getButtonChoice2() {return buttonChoice2;}
		public JRadioButton getButtonChoice3() {return buttonChoice3;}	
		public JRadioButton getButtonChoice4() {return buttonChoice4;}



		public Button getButtonNext() {return buttonNext;}
		public Button getButtonPrevious() {return buttonPrevious;}
		public JComboBox<Integer> getForMovingcomboBox(){return forMovingComboBox ;} 
		

		public Button getButtonSubmit() {return	buttonSubmit;}
		public Button getButtonExit() {return	buttonExit;}
		
		
		
		/*-----------------------------------------------------------------------------------------*/
		// useful methods
		public void setStudentName(String name) {this.studentName.setText(name);}
		
		
		public void setSurveyTitle(String surveyTitle) { this.surveyTitle.setText(surveyTitle);}
		public void setSurveySize(int qAnswered , int svySize) { this.surveySize.setText(qAnswered+"/"+svySize);}
		
		public void setQuestionTitle(String title) {this.questionTitleField.setText(title);}
		public int getQuestionNumber() {return Integer.parseUnsignedInt(this.questionNumber.getText());}
		public void setQuestionNumber(int number) {this.questionNumber.setText(String.valueOf(number));}
		
		public void setTiming(String countdown ) { this.labelDelay.setText(countdown);}
		
		public void setErrorMessageZone(String errorMessage) {  this.errorMessageZone.setText(errorMessage);}
		public String getErrorMessageZone() { return  this.errorMessageZone.getText();}
		
		
		/*---------------------------------------------------------------------------------------*/
		// setting and getting texts of Java buttons 
		public  String getTextButtonChoice1() {return buttonChoice1.getText();}
		public void setTextButtonChoice1( String buttonChoice1) {this.buttonChoice1.setText(buttonChoice1);}

		public  String getTextButtonChoice2() {return buttonChoice2.getText();}
		public void setTextButtonChoice2( String buttonChoice2) {this.buttonChoice2.setText(buttonChoice2);}

		public  String getTextButtonChoice3() {return buttonChoice3.getText();}
		public void setTextButtonChoice3( String buttonChoice3) {this.buttonChoice3.setText(buttonChoice3);}

		
		public  String getTextButtonChoice4() {return buttonChoice4.getText();}
		public void setTextButtonChoice4( String buttonChoice4) {this.buttonChoice4.setText(buttonChoice4);}
		
		
		/*-----------------------*/
		
		// returns the selected button
		public JRadioButton getSelectedButton() { 
			
			JRadioButton jrdb = null ;

			List<JRadioButton>  list = new ArrayList<JRadioButton>() ;
			list.clear();

			list.add(buttonChoice1);
			list.add(buttonChoice2);
			list.add(buttonChoice3);
			list.add(buttonChoice4);

			for (JRadioButton rdb : list) { if( rdb.isSelected() ) { jrdb = rdb ; break;} }

			return jrdb ;	
		}	
		
		public void clearGroupSelection() {this.group.clearSelection();}
		
		/*-----------------------------------------------------------------------------------------*/
		
		// methods  adding listeners
		public void addButtonStartSurveyListener( ActionListener listener) {this.buttonStartSurvey.addActionListener(listener);}
		public void addButtonExitListener(ActionListener listener) {this.buttonExit.addActionListener(listener);}
		public void addButtonSubmitSurveyListener(ActionListener listener) {this.buttonSubmit.addActionListener(listener);}
		public void addButtonNextListener( ActionListener listener) {this.buttonNext.addActionListener(listener);}
		public void addButtonPreviousListener(ActionListener listener) {this.buttonPrevious.addActionListener(listener);}
		
		public void addForMovingComboBoxListener(ItemListener listener) {this.forMovingComboBox.addItemListener(listener);}

			
		/*---------------------------------------------------------------------------------*/
		
		public void run() {	this.setVisible(true);}
	
}
