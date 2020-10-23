package edu.curso;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TesteEventosBCE extends Application 
			implements EventHandler<ActionEvent> {
	
	private Label lbl = new Label("Texto");
	private Button btn1 = new Button("Aperte-me");
	private Button btn2 = new Button("Aperte-me novamente");
	private Map<Button, String> acoes = new HashMap<>();
	
	public TesteEventosBCE() { 
		acoes.put(btn1, "Botão 1 apertado");
		acoes.put(btn2, "Botão 2 apertado");
	}
	
	@Override
	public void start(Stage stage) { 
		BorderPane bp = new BorderPane();
		Scene scn = new Scene(bp, 400, 200);
		
		//btn1.addEventFilter(ActionEvent.ANY, this);
		
		
		btn1.setOnAction(this);
		btn2.setOnAction(this);
	
		bp.setBottom(btn2);
		bp.setRight(btn1);
		bp.setTop(lbl);
		
		stage.setScene(scn);
		stage.setTitle("Teste de Eventos BCE");
		stage.show();
	}
	
	@Override
	public void handle(ActionEvent e) {		
//		if (e.getTarget() == btn1) { 
//			lbl.setText("Botão 1 pressionado usando classe Boundary");
//		} else if (e.getTarget() == btn2) { 
//			lbl.setText("Botão 2 pressionado usando classe Boundary");
//		}
		String txt = acoes.get(e.getTarget());
		lbl.setText(txt);
	}
	
	public static void main(String[] args) {
		Application.launch(TesteEventosBCE.class, args);
	}
}
