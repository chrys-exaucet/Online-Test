package views.gui.teachers;

import javax.swing.JFrame;


import java.awt.GridLayout;

import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.border.MatteBorder;



import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class TeacherPlatform extends JFrame {

	Button buttonStatut , buttonDelete , buttonUpdate , buttonResults , buttonAdd , buttonStatutOff;
	JButton buttonExit ;
	JLabel teacherName , errorMessageZone ;
	JComboBox<String > surveyComboBox ;

	
	// constructing the platform
	public TeacherPlatform() {
		
		
			setIconImage(Toolkit.getDefaultToolkit().getImage(TeacherPlatform.class.getResource("/iconteacher.png")));
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setLocation(350, 30);
			setSize(700, 700);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("app-Gestion des Qestionnaires");
			getContentPane().setLayout(new GridLayout(10, 1, 0, 0));
			
			JPanel panelConnectedIn = new JPanel();
			panelConnectedIn.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			panelConnectedIn.setBackground(new Color(255, 255, 255));
			getContentPane().add(panelConnectedIn);
			panelConnectedIn.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel = new JLabel(" Espace Professeur");
			lblNewLabel.setForeground(new Color(25, 25, 112));
			lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 24));
			panelConnectedIn.add(lblNewLabel, BorderLayout.WEST);
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(TeacherPlatform.class.getResource("/iconteacherLarge.png")));
			panelConnectedIn.add(lblNewLabel_3, BorderLayout.EAST);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLocation(new Point(400, 400));
			panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			panel_2.setBackground(Color.WHITE);
			getContentPane().add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_1 = new JLabel(" Vous \u00EAtes connect\u00E9 en tant que : ");
			lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 22));
			panel_2.add(lblNewLabel_1, BorderLayout.WEST);
			
			teacherName = new JLabel("Nom du formateur");
			teacherName.setForeground(new Color(128, 0, 0));
			teacherName.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel_2.add(teacherName, BorderLayout.CENTER);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			getContentPane().add(panel_3);
			panel_3.setLayout(new GridLayout(1, 2, 0, 0));
			
			JPanel panelMenuQcm = new JPanel();
			panelMenuQcm.setBackground(new Color(135, 206, 235));
			panel_3.add(panelMenuQcm);
			panelMenuQcm.setLayout(new GridLayout(2, 0, 0, 0));
			
			JLabel surveyList = new JLabel("Liste des QCM disponibles");
			surveyList.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panelMenuQcm.add(surveyList);
			
			 surveyComboBox = new JComboBox<String>();
			panelMenuQcm.add(surveyComboBox);
			
			JPanel panelAddQcm = new JPanel();
			panelAddQcm.setBackground(SystemColor.textHighlight);
			getContentPane().add(panelAddQcm);
			panelAddQcm.setLayout(new GridLayout(1, 2, 0, 0));
			
			JPanel panel_4 = new JPanel();
			panelAddQcm.add(panel_4);
			panel_4.setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panel_6 = new JPanel();
			panel_6.setBackground(Color.WHITE);
			panel_4.add(panel_6);
			panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			
			JPanel panelButtonAdd = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelButtonAdd.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setVgap(25);
			panelButtonAdd.setLocation(new Point(100, 100));
			panelButtonAdd.setFont(new Font("Tahoma", Font.PLAIN, 30));
			panelButtonAdd.setBackground(Color.WHITE);
			panel_4.add(panelButtonAdd);
			
			JLabel label = new JLabel("");
			panelButtonAdd.add(label);
			label.setIcon(new ImageIcon(TeacherPlatform.class.getResource("/add1(resized).png")));
			
			buttonAdd = new Button("Ajouter");
			buttonAdd.setForeground(new Color(255, 255, 255));
			buttonAdd.setBackground(Color.DARK_GRAY);
			buttonAdd.setFocusable(false);
			panelButtonAdd.add(buttonAdd);
			
			JPanel panelDelQcm = new JPanel();
			panelDelQcm.setBackground(new Color(135, 206, 235));
			getContentPane().add(panelDelQcm);
			panelDelQcm.setLayout(new GridLayout(1, 2, 0, 0));
			
			JPanel panel5 = new JPanel();
			panelDelQcm.add(panel5);
			panel5.setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panel_10 = new JPanel();
			panel_10.setLocation(new Point(100, 100));
			panel_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
			panel_10.setBackground(Color.WHITE);
			panel5.add(panel_10);
			panel_10.setLayout(null);
			
			JPanel panelButtonDel = new JPanel();
			FlowLayout flowLayout_1 = (FlowLayout) panelButtonDel.getLayout();
			flowLayout_1.setAlignment(FlowLayout.LEFT);
			panelButtonDel.setLocation(new Point(100, 100));
			panelButtonDel.setFont(new Font("Tahoma", Font.PLAIN, 30));
			panelButtonDel.setBackground(Color.WHITE);
			panel5.add(panelButtonDel);
			
			JLabel lblNewLabel_2 = new JLabel("");
			panelButtonDel.add(lblNewLabel_2);
			lblNewLabel_2.setIcon(new ImageIcon(TeacherPlatform.class.getResource("/del(resized).png")));
			
			buttonDelete = new Button("Supprimer");
			buttonDelete.setForeground(Color.WHITE);
			buttonDelete.setFocusable(false);
			buttonDelete.setBackground(Color.DARK_GRAY);
			panelButtonDel.add(buttonDelete);
			
			JPanel panelQcmUpdt = new JPanel();
			panelQcmUpdt.setBackground(new Color(135, 206, 235));
			getContentPane().add(panelQcmUpdt);
			panelQcmUpdt.setLayout(new GridLayout(1, 2, 0, 0));			
			
			JPanel panel_5 = new JPanel();
			panelQcmUpdt.add(panel_5);
			panel_5.setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panel11 = new JPanel();
			panel11.setLocation(new Point(100, 100));
			panel11.setFont(new Font("Tahoma", Font.PLAIN, 30));
			panel11.setBackground(Color.WHITE);
			panel_5.add(panel11);
			panel11.setLayout(null);
			
			JPanel panelButtonUpdt = new JPanel();
			FlowLayout flowLayout_2 = (FlowLayout) panelButtonUpdt.getLayout();
			flowLayout_2.setAlignment(FlowLayout.LEFT);
			panelButtonUpdt.setLocation(new Point(100, 100));
			panelButtonUpdt.setFont(new Font("Tahoma", Font.PLAIN, 30));
			panelButtonUpdt.setBackground(Color.WHITE);
			panel_5.add(panelButtonUpdt);
			
			JLabel lblNewLabel_4 = new JLabel("");
			panelButtonUpdt.add(lblNewLabel_4);
			lblNewLabel_4.setIcon(new ImageIcon(TeacherPlatform.class.getResource("/maj(resized).png")));
			
			buttonUpdate = new Button("Mettre \u00E0 jour");
			buttonUpdate.setForeground(Color.BLACK);
			buttonUpdate.setFocusable(false);
			buttonUpdate.setBackground(Color.DARK_GRAY);
			panelButtonUpdt.add(buttonUpdate);
			
			JPanel panelMarks = new JPanel();
			panelMarks.setBackground(Color.WHITE);
			getContentPane().add(panelMarks);
			panelMarks.setLayout(new GridLayout(1, 2, 0, 0));
			
			JPanel panel_7 = new JPanel();
			panel_7.setBackground(Color.WHITE);
			panelMarks.add(panel_7);
			panel_7.setLayout(null);
			
			JPanel panelButtonMarks = new JPanel();
			FlowLayout flowLayout_4 = (FlowLayout) panelButtonMarks.getLayout();
			flowLayout_4.setAlignment(FlowLayout.LEFT);
			panelButtonMarks.setFont(new Font("Tahoma", Font.PLAIN, 30));
			panelButtonMarks.setBackground(Color.WHITE);
			panelMarks.add(panelButtonMarks);
			
			JLabel labelMarks = new JLabel("");
			panelButtonMarks.add(labelMarks);
			labelMarks.setIcon(new ImageIcon(TeacherPlatform.class.getResource("/Marks.jpg")));
			
			buttonResults = new Button("Consulter les notes");
			buttonResults.setForeground(Color.WHITE);
			buttonResults.setFocusable(false);
			buttonResults.setBackground(Color.DARK_GRAY);
			panelButtonMarks.add(buttonResults);
			
			JPanel panelStatut = new JPanel();
			panelStatut.setBackground(Color.WHITE);
			getContentPane().add(panelStatut);
			panelStatut.setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panelStatut.add(panel);
			
			JPanel panel_1 = new JPanel();
			FlowLayout flowLayout_3 = (FlowLayout) panel_1.getLayout();
			flowLayout_3.setAlignment(FlowLayout.LEFT);
			flowLayout_3.setVgap(25);
			panel_1.setBackground(Color.WHITE);
			panel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
			panelStatut.add(panel_1);
			
			buttonStatut = new Button("Activer ");
			panel_1.add(buttonStatut);
			
			buttonStatutOff = new Button("D\u00E9sactiver ");
			panel_1.add(buttonStatutOff);
			
			JPanel panelNotifications = new JPanel();
			panelNotifications.setForeground(Color.RED);
			FlowLayout flowLayout_5 = (FlowLayout) panelNotifications.getLayout();
			flowLayout_5.setVgap(20);
			panelNotifications.setBackground(Color.WHITE);
			getContentPane().add(panelNotifications);
			
			errorMessageZone = new JLabel("");
			errorMessageZone.setForeground(Color.RED);
			errorMessageZone.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panelNotifications.add(errorMessageZone);
			
			
			
			JPanel panelExit = new JPanel();
			FlowLayout fl_panelExit = (FlowLayout) panelExit.getLayout();
			fl_panelExit.setHgap(4);
			fl_panelExit.setVgap(45);
			panelExit.setSize(new Dimension(500, 5));
			panelExit.setBackground(Color.WHITE);
			getContentPane().add(panelExit);
			
			buttonExit = new JButton("Quitter l'application");
			buttonExit.setFocusable(false);
			buttonExit.setForeground(new Color(0, 0, 0));
			buttonExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
			buttonExit.setBackground(Color.LIGHT_GRAY);
			panelExit.add(buttonExit);
			
			
		}
		
		
	// listeners
	public void addButtonExitListener(ActionListener listener) { buttonExit.addActionListener(listener);}
	public void addButtonAddListener(ActionListener listener) {buttonAdd.addActionListener(listener);}
	public void addButtonUpdateListener(ActionListener listener) {buttonUpdate.addActionListener(listener);}
	public void addButtonDeleteListener(ActionListener listener) {buttonDelete.addActionListener(listener);}
	public void addButtonStatutListener(ActionListener listener) { buttonStatut.addActionListener(listener);}
	public void addButtonStatutOffListener(ActionListener listener) { buttonStatutOff.addActionListener(listener);}
	public void addButtonResultsListener(ActionListener listener) { buttonResults.addActionListener(listener);}


		
	//getters & setters
	public String  getTeacherName() {return teacherName.getText();}
	public void setTeacherName(String  thisName) {	this.teacherName.setText(thisName);}
	public JComboBox<String> getSurveyComboBox() {return surveyComboBox;}
	public void setErrorMessageZone(String errorMessageZone) {  this.errorMessageZone.setText(errorMessageZone);}
	public String getErrorMessageZone() { return  this.errorMessageZone.getText();}
	


	//runs the frame
	public void run() {	
  	  //UIManager 
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }

        SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				setVisible(true);
			}
		});

    	
	}
	
	
	
	
	
}

