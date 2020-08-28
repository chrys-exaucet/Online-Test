package views.gui.teachers;


	import java.awt.BorderLayout;

	import java.awt.event.ActionEvent;

	import javax.swing.AbstractAction;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import models.surveys.Results;

	@SuppressWarnings("serial")
	public class SurveyResultsPrinter extends JFrame {
	
		private ModeleDynamiqueObjet modele;
	    private JTable tableau;
	    private Results results ;
	    
	 
	    public  SurveyResultsPrinter(Results rslt) {
	       
	      
	        this.results = rslt ;
	        modele = new ModeleDynamiqueObjet(results);
	        tableau = new JTable(modele);
	       
	    	
	        setTitle("Resultats du QCM...");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	        
	        JPanel boutons = new JPanel();
	        
	        boutons.add(new JButton(new ExportAction()));
	        boutons.add(new JButton(new ExitAction()));
	 
	        getContentPane().add(boutons, BorderLayout.SOUTH);
	        
	        pack();
	    }
	 
	   
	   
	    private class ExportAction extends AbstractAction {
	        private ExportAction() {super("Exporter vers csv"); }
	 
	       
			@Override
			public void actionPerformed(ActionEvent e)
			{
	          SurveyResultsExporter exporter = new SurveyResultsExporter() ;
	          exporter.export(results);
				
			}
	    }
	 
	    private class ExitAction extends AbstractAction {
	        private ExitAction() {super("Quitter");}
	        
	        public void actionPerformed(ActionEvent e) { dispose();}
	        
	    }
	    
	    
	    
	    
	    
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