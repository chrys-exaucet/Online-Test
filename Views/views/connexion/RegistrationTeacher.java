package views.connexion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class RegistrationTeacher extends JFrame {


	
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField codeField;
	private JPasswordField passwordField;
	
	private JLabel errorMessage ;
	
	private JButton buttonValider ;
	private JButton buttonAnnuler ;
	
	public RegistrationTeacher() {
		setResizable(false);
		getContentPane().setPreferredSize(new Dimension(450, 403));
		getContentPane().setBackground(new Color(0, 206, 209));
		
	
			setBackground(new Color(0, 206, 209));
			getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
			this.setTitle("Inscription Formateur");
			
			JPanel panelBase = new JPanel();
			panelBase.setPreferredSize(new Dimension(405, 403));
			panelBase.setBackground(new Color(169, 169, 169));
			getContentPane().add(panelBase);
			
			
			JPanel panelLogin = new JPanel();
			panelLogin.setBackground(new Color(169, 169, 169));
			GroupLayout gl_panelBase = new GroupLayout(panelBase);
			gl_panelBase.setHorizontalGroup(
				gl_panelBase.createParallelGroup(Alignment.TRAILING)
					.addComponent(panelLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
			);
			gl_panelBase.setVerticalGroup(
				gl_panelBase.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelBase.createSequentialGroup()
						.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE))
			);
			panelLogin.setLayout(new GridLayout(6, 1, 0, 0));
			
			JPanel panelNom = new JPanel();
			panelNom.setBackground(new Color(169, 169, 169));
			panelLogin.add(panelNom);
			panelNom.setLayout(null);
			
			JLabel labelNom = new JLabel("Nom :");
			labelNom.setBounds(30, 20, 54, 14);
			panelNom.add(labelNom);
			
			nameField = new JTextField();
			nameField.setBounds(94, 17, 351, 20);
			panelNom.add(nameField);
			nameField.setColumns(10);
			
			JPanel panelPrenom = new JPanel();
			panelPrenom.setBackground(new Color(169, 169, 169));
			panelLogin.add(panelPrenom);
			panelPrenom.setLayout(null);
			
			JLabel label = new JLabel("Pr\u00E9nom :");
			label.setBounds(25, 20, 61, 14);
			panelPrenom.add(label);
			
			surnameField = new JTextField();
			surnameField.setBounds(96, 17, 338, 20);
			panelPrenom.add(surnameField);
			surnameField.setColumns(10);
			
			JPanel panelPassword = new JPanel();
			panelPassword.setBackground(new Color(169, 169, 169));
			panelLogin.add(panelPassword);
			panelPassword.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Mot de passe : ");
			lblNewLabel.setBounds(0, 20, 94, 14);
			panelPassword.add(lblNewLabel);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(94, 17, 346, 20);
			panelPassword.add(passwordField);
			
			JPanel panelCode = new JPanel();
			panelCode.setBackground(new Color(169, 169, 169));
			panelLogin.add(panelCode);
			panelCode.setLayout(null);
			
			JLabel labelCode = new JLabel("Code : ");
			labelCode.setBounds(30, 33, 54, 14);
			panelCode.add(labelCode);
			
			codeField = new JTextField();
			codeField.setBounds(94, 30, 345, 20);
			codeField.setToolTipText("Ce code est \u00E0 retenir ");
			panelCode.add(codeField);
			codeField.setColumns(10);
			
			JPanel panelNotification = new JPanel();
			panelNotification.setBackground(new Color(169, 169, 169));
			panelLogin.add(panelNotification);
			panelNotification.setLayout(null);
			
			errorMessage = new JLabel();
			errorMessage.setBounds(86, 20, 299, 17);
			errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
			errorMessage.setForeground(new Color(139, 0, 0));
			panelNotification.add(errorMessage);
			
			JPanel panelValidation = new JPanel();
			panelValidation.setBackground(new Color(169, 169, 169));
			panelLogin.add(panelValidation);
			panelValidation.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 35));
			
			 buttonValider = new JButton("S'inscrire");
			panelValidation.add(buttonValider);
			
			 buttonAnnuler = new JButton("Annuler");
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

	public long getCodeField() {return Long.parseLong(codeField.getText());}
	public String getCodeFieldInString() {return codeField.getText();}


	public void setErrorMessage(String message) { errorMessage.setText(message);}
	
	
	}
	

