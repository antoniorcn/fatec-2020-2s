package edu.curso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class MinhaJanela1 extends Application {
	@Override
	public void start(Stage stage) { 
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 600, 400);
		Label lblHello = new Label("Hello World");
		painel.getChildren().add(lblHello);
		stage.setScene(scn);
		stage.setTitle("Minha Janela Java FX");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(MinhaJanela1.class, args);
	}
}
