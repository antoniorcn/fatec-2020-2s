package edu.animacao;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bolinha extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Group grp = new Group();
		Scene scn = new Scene(grp, 640, 480);
		
		Canvas canvas = new Canvas(640, 480);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		ctx.setFill(Color.RED);
		// ctx.fillRect(100, 100, 200, 150);
		
		
		new AnimationTimer() {
			double x = 50.0;
			double velX = 5;

			@Override
			public void handle(long time) {
				ctx.clearRect(0, 0, 640, 480);
				ctx.fillOval(x, 200, 30, 30);
				x += velX;
				
				if (x > 640) { 
					velX = -5;
				}
				if (x < 0) {
					velX = 5;
				}
			} 
			
		}.start();
		
		
		grp.getChildren().add(canvas);
		
		stage.setScene(scn);
		stage.setTitle("Bolinha");
		stage.show();		
	}
	
	public static void main(String[] args) {
		Application.launch(Bolinha.class, args);
	}


}
