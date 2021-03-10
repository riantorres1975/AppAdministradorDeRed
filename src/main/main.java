package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent raiz = FXMLLoader.load(getClass().getResource("interfazApp.fxml"));
		Scene escena = new Scene(raiz);
		primaryStage.setScene(escena);
		primaryStage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
