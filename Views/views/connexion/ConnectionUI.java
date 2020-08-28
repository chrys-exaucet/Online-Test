package views.connexion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ConnectionUI extends JFrame{
		
	//attributes
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton buttonTeacher ,buttonStudent;
	private JButton buttonConnect , buttonRegister ;	
	
	private JTextField codeField;
	private JPasswordField passwordField;
	JLabel errorMessage ;

	/*--------------------------------------------*/
	// creating the connection frame
	public ConnectionUI() {							 
		setPreferredSize(new Dimension(530, 400));
		setResizable(false);			
		setLocation( 500,200 );
		getContentPane().setPreferredSize(new Dimension(350, 400));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConnectionUI.class.getResource("/iconstudent.png")));
		setBackground(new Color(0, 206, 209));
		getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		this.setTitle("Connexion");
		
		JPanel panelBase = new JPanel();
		panelBase.setBackground(new Color(0, 206, 209));
		getContentPane().add(panelBase);
		panelBase.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelCode = new JPanel();
		panelCode.setBackground(new Color(119, 136, 153));
		panelBase.add(panelCode);
		panelCode.setLayout(null);
		
		JLabel lblCode = new JLabel("CODE :");
		lblCode.setBounds(99, 11, 75, 19);
		lblCode.setToolTipText("Veuillez saisir votre code");
		lblCode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		panelCode.add(lblCode);
		
		codeField = new JTextField();
		codeField.setBounds(72, 43, 120, 20);
		panelCode.add(codeField);
		codeField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("MOT DE PASSE :");
		lblNewLabel.setBounds(66, 100, 136, 19);
		panelCode.add(lblNewLabel);
		lblNewLabel.setToolTipText("Veuillez saisir votre mot de passe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(72, 130, 120, 20);
		passwordField.setColumns(10);
		panelCode.add(passwordField);
		
		JPanel panelPassword = new JPanel();
		panelPassword.setBackground(new Color(119, 136, 153));
		panelBase.add(panelPassword);
		panelPassword.setLayout(null);
		
		buttonTeacher = new JRadioButton("Formateur");
		buttonTeacher.setBounds(87, 35, 85, 25);
		buttonTeacher.setFont(new Font("Tahoma", Font.ITALIC, 13));
		buttonTeacher.setBackground(new Color(119, 136, 153));
		panelPassword.add(buttonTeacher);
		buttonGroup.add(buttonTeacher);
		
		
		errorMessage = new JLabel("Veuillez vous inscrire !");
		errorMessage.setBounds(25, 72, 227, 25);
		errorMessage .setForeground(Color.RED);
		errorMessage .setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		panelPassword.add(errorMessage);
		
		buttonConnect = new JButton("Se connecter  ");
		buttonConnect.setBounds(10, 151, 120, 23);
		panelPassword.add(buttonConnect);
		
		 buttonRegister = new JButton("S'inscrire");
		 buttonRegister.setBounds(144, 151, 108, 23);
		panelPassword.add(buttonRegister);
		
		buttonStudent = new JRadioButton("Etudiant");
		buttonStudent.setBounds(87, 7, 92, 25);
		panelPassword.add(buttonStudent);
		buttonStudent.setFont(new Font("Tahoma", Font.ITALIC, 13));
		buttonStudent.setBackground(new Color(119, 136, 153));
		buttonGroup.add(buttonStudent);
	
	
		
	}
	
	/*--------------------------------------------*/
	// runs the frame
	public void run() {	pack(); setVisible(true);}
	
	/*--------------------------------------------*/
	// returns the value of the fields
	public long getCodeField() {return	Long.parseLong(codeField.getText());}
	public String getCodeFieldInString() {return codeField.getText();}
	public String getPasswordField() {String password = new String(passwordField.getPassword());return password;}
	
	/*--------------------------------------------*/
	// setter
	public void setErrorMessage(String message) {errorMessage.setText(message);}
	
	/*--------------------------------------------*/
	// listeners
	public void addButtonConnectListener(ActionListener listener) { buttonConnect.addActionListener(listener);}
	public void addButtonRegisterListener(ActionListener listener) {buttonRegister.addActionListener(listener);}

	/*--------------------------------------------*/
	// checkers for the button group of users 
	public ButtonModel selectedUserButton()  {return  buttonGroup.getSelection();};	// Sees the selected button in the group 
	public boolean isButtonTeacherSelected() {return  buttonTeacher.isSelected();}		
	public boolean isButtonStudentSelected() {return  buttonStudent.isSelected();}
	
	
}
