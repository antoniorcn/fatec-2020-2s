package edu.solar;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

class Ponto { 
	double x;
	double y;
}

public class Bolinha extends Application {
	
	public void start(Stage stage) { 
		Group grp = new Group();
		Scene scn = new Scene(grp, 640, 480);
		
		Canvas canvas = new Canvas(640, 480);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		
		grp.getChildren().add(canvas);
		final Ponto ponto = new Ponto();
		final Ponto veloc = new Ponto();
		veloc.x = 10.0;
		

		new AnimationTimer()  { 
			public void handle(long time) {  
				ctx.clearRect(0,  0,  640, 480);
				ctx.setFill(Color.RED);
				ctx.fillOval(ponto.x, 100, 30, 30);
				ponto.x = ponto.x + veloc.x;
				if (ponto.x > 640) { 
					veloc.x = -10.0;
				}
				if (ponto.x < 0) { 
					veloc.x = 10.0;
				}
			}
		}.start();
		
		stage.setScene(scn);
		stage.setTitle("Bolinha");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Bolinha.class, args);
	}

}
