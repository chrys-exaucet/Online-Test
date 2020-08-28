package views.gui.teachers;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.students.Student;
import models.surveys.Results;





@SuppressWarnings("serial")
public class SurveyResultsExporter  extends JFrame {


	// prints the JFileChooser exporter
	public void export(Results rslt) {

		//UIManager 
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { }

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				showSaveFileDialog(rslt );
			}
		});


	}	


	/*-------------------------------------------------------------------------------------------*/


	// creates a JFileChooser for the export
	private void showSaveFileDialog(Results results ) {								
		JFileChooser fileChooser = new JFileChooser();



		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(" CSV File /.csv ", "csv"));
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.setDialogTitle("Entrez le nom  du fichier");
		int userSelection = fileChooser.showSaveDialog(this);



		if (userSelection == JFileChooser.APPROVE_OPTION) {

			File fileToSave = fileChooser.getSelectedFile() ;


			try {	

				fileToSave.createNewFile();		

				// creating an empty file...							
				exportSurveyResults(fileToSave.getAbsolutePath(), results);	// writing on it 
				JOptionPane.showMessageDialog(null , " Fichier bien exporté ! ");


			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "Echec de l'exportation ! ", "Message d'erreur", 0);
			}

		}
	}

	/*-------------------------------------------------------------------------------------------*/


	// Does the proper export of the results to the given CSV file  path 
	private void exportSurveyResults(String path ,Results results ) throws IOException {

		Path userPath = Paths.get(path);
		String name ;
		String surname ;
		Float mark ; 



		Files.write(userPath, String.format("Noms,Prenoms,Notes %n").getBytes());

		for(Student sdt  : results.getResults().keySet()) {	// for each student ...
			name =sdt.getName();						// get the name 
			surname = sdt.getSurname();					// get the surname
			mark = results.getMark(sdt);				// get the mark
			String line = name +","+ surname+", " + mark +"%n" ; // print the line 								

			Files.write(userPath, String.format(line).getBytes(),APPEND);

		}


	}


}


		
	

	
	
	
	
	
	
	
	
	