package edu.curso;

import java.util.function.Function;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class Manipulador implements EventHandler<ActionEvent> {
	private Label label;
	
	@Override
	public void handle(ActionEvent e) { 
//		System.out.printf("Tipo:%s\tOrigem:%s\tDestino%s%n",
//				e.getEventType().getName(), 
//				e.getSource().getClass().getName(), 
//				e.getTarget().getClass().getName());
		System.out.println("Botão apertado");
		getLabel().setText("Botão pressionado");
	}

	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
}


public class TesteEventos extends Application {
	
	@Override
	public void start(Stage stage) { 
		BorderPane bp = new BorderPane();
		Scene scn = new Scene(bp, 400, 200);
		Button btn = new Button("Aperte-me");
		Label lbl = new Label("Texto");
		
//		Manipulador man = new Manipulador();
//		man.setLabel( lbl );
//		btn.addEventFilter(ActionEvent.ANY, man);
		
//		EventHandler<ActionEvent> handle = new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				lbl.setText("Botão pressionado por EventHandler Classe anonima");
//			}
//		};
//		btn.addEventFilter(ActionEvent.ANY, handle);
		
		btn.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> {
			lbl.setText(e.getEventType().getName());
		});
		
//		btn.setOnAction( (e) -> { 
//			lbl.setText("Botão pressionado por setOnAction com Lambda");
//		});
		
		

		
		bp.setBottom(btn);
		bp.setTop(lbl);
		
		stage.setScene(scn);
		stage.setTitle("Teste de Eventos");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TesteEventos.class, args);
	}
}
