package views.connexion;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;


@SuppressWarnings("serial")
public class RegistrationUI extends JFrame{

	
private JTextField nameField;
private JTextField surnameField;
private JTextField codeField;
private	JTextField gradeField ;
private JPasswordField passwordField;

private JLabel errorMessage ;
private JButton buttonValider ;
private JButton buttonAnnuler ;

//creating the registration frame /view ...
public RegistrationUI() {
	getContentPane().setBackground(new Color(0, 139, 139));
	setPreferredSize(new Dimension(400, 450));		
		
	setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrationUI.class.getResource("/iconstudent.png")));
	setBackground(Color.WHITE);
	getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
	this.setTitle("Inscription Etudiant");
	
	JPanel panelBase = new JPanel();
	panelBase.setBackground(new Color(0, 206, 209));
	getContentPane().add(panelBase);
	
	
	JPanel panelLogin = new JPanel();
	panelLogin.setBackground(new Color(0, 206, 209));
	GroupLayout gl_panelBase = new GroupLayout(panelBase);
	gl_panelBase.setHorizontalGroup(
		gl_panelBase.createParallelGroup(Alignment.LEADING)
			.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
	);
	gl_panelBase.setVerticalGroup(
		gl_panelBase.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panelBase.createSequentialGroup()
				.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
				.addContainerGap())
	);
	panelLogin.setLayout(new GridLayout(7, 1, 0, 0));
	
	JPanel panelNom = new JPanel();
	panelNom.setBackground(new Color(0, 206, 209));
	panelLogin.add(panelNom);
	panelNom.setLayout(null);
	
	JLabel labelNom = new JLabel("Nom :");
	labelNom.setBounds(10, 23, 44, 14);
	panelNom.add(labelNom);
	
	nameField = new JTextField();
	nameField.setBounds(116, 20, 196, 20);
	panelNom.add(nameField);
	nameField.setColumns(10);
	
	JPanel panelPrenom = new JPanel();
	panelPrenom.setBackground(new Color(0, 206, 209));
	panelLogin.add(panelPrenom);
	panelPrenom.setLayout(null);
	
	JLabel labelPrenom = new JLabel("Pr\u00E9nom :");
	labelPrenom.setBounds(10, 23, 71, 14);
	panelPrenom.add(labelPrenom);
	
	surnameField = new JTextField();
	surnameField.setBounds(120, 20, 192, 20);
	panelPrenom.add(surnameField);
	surnameField.setColumns(10);
	
	JPanel panelClasse = new JPanel();
	panelClasse.setBackground(new Color(0, 206, 209));
	panelLogin.add(panelClasse);
	panelClasse.setLayout(null);
	
	JLabel labelClasse = new JLabel("Classe :");
	labelClasse.setBounds(10, 23, 54, 14);
	panelClasse.add(labelClasse);
	
	gradeField = new JTextField();
	gradeField.setBounds(121, 20, 190, 20);
	panelClasse.add(gradeField);
	gradeField.setColumns(10);
	
	JPanel panelPassword = new JPanel();
	panelPassword.setBackground(new Color(0, 206, 209));
	panelLogin.add(panelPassword);
	panelPassword.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Mot de passe : ");
	lblNewLabel.setBounds(10, 23, 81, 14);
	panelPassword.add(lblNewLabel);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(124, 20, 188, 20);
	panelPassword.add(passwordField);
	
	JPanel panelCode = new JPanel();
	panelCode.setBackground(new Color(0, 206, 209));
	panelLogin.add(panelCode);
	panelCode.setLayout(null);
	
	JLabel labelCode = new JLabel("Code : ");
	labelCode.setBounds(10, 33, 50, 14);
	panelCode.add(labelCode);
	
	codeField = new JTextField();
	codeField.setBounds(125, 30, 190, 20);
	codeField.setToolTipText("Ce code est \u00E0 retenir ");
	panelCode.add(codeField);
	codeField.setColumns(10);
	
	JPanel panelNotification = new JPanel();
	panelNotification.setBackground(new Color(0, 206, 209));
	panelLogin.add(panelNotification);
	panelNotification.setLayout(null);
	
	errorMessage = new JLabel();
	errorMessage.setForeground(new Color(255, 0, 0));
	errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
	errorMessage.setBounds(10, 11, 268, 33);
	panelNotification.add(errorMessage);
	
	JPanel panelValidation = new JPanel();
	panelValidation.setBackground(new Color(0, 206, 209));
	panelLogin.add(panelValidation);
	panelValidation.setLayout(null);
	
	buttonValider = new JButton("S'inscrire");
	buttonValider.setBounds(98, 35, 90, 23);
	panelValidation.add(buttonValider);
	
	buttonAnnuler = new JButton("Annuler");
	buttonAnnuler.setBounds(220, 35, 90, 23);
	panelValidation.add(buttonAnnuler);
	panelBase.setLayout(gl_panelBase);
	pack();
}
	

// methods for the controller to add listeners...
public void addButtonValiderListener(ActionListener listener) {buttonValider.addActionListener(listener);}
public void addButtonAnnulerListener(ActionListener listener) {buttonAnnuler.addActionListener(listener);}

// running the view
public void run () {this.setVisible(true);}

// getters and setters ...	
public String getNameField() {	return nameField.getText();}
public String getSurnameField() {return surnameField.getText();}
public String getPasswordField() {String password = new String(passwordField.getPassword());return password;}
public String getGradeField() {return gradeField.getText();}
public long getCodeField() {return Long.parseLong(codeField.getText());}
public String getCodeFieldInString() {return codeField.getText();}

public void setErrorMessage(String message) {errorMessage.setText(message);}

}