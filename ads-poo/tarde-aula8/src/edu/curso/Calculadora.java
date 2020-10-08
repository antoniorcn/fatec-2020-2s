package edu.curso;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Calculadora extends Application {
	
	public void start(Stage stage) { 
		String[] nomes = {"1", "2", "3", "+", 
				"4", "5", "6", "-",
				"7", "8", "9", "*",
				".", "0", "=", "/"};
		BorderPane panePrincipal = new BorderPane();
		Scene scn = new Scene(panePrincipal, 250, 200);
		
		GridPane paneBotoes = new GridPane();
		panePrincipal.setCenter(paneBotoes);
		
		paneBotoes.setHgap(5);
		paneBotoes.setVgap(5);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(25);
		col1.setHgrow(Priority.ALWAYS);
		col1.setHalignment(HPos.CENTER);
		paneBotoes.getColumnConstraints().addAll(col1, col1, col1, col1);
		FlowPane paneDisplay = new FlowPane();
		paneDisplay.setHgap(10);
		panePrincipal.setTop(paneDisplay);
		for (int i = 0; i < 16; i++) { 
			Button btn = new Button( nomes[i] );
			int lin = i / 4;
			int col = i % 4;
			paneBotoes.add(btn, col, lin);
		}
		TextField txtDisplay = new TextField();
		Button btnCE = new Button("CE");
		paneDisplay.getChildren().addAll(txtDisplay, btnCE);
		stage.setScene(scn);
		stage.setTitle("Calculadora");
		stage.show();		
	}
	public static void main(String[] args) {
		Application.launch(Calculadora.class, args);
	}

}
