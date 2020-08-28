package surveyLauncher;

import controllers.connexion.ConnexionController;

 class QCMLauncher {

	public static void main(String[] args)  { 
		
				QCMLauncher.run();
	}  

	public static void run() {ConnexionController controller =new ConnexionController();controller.run();}

}