package edu.solar;

import java.io.InputStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SistemaSolar extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		InputStream is = getClass().getResourceAsStream("/images/space.png");
		Image imgSpace = new Image(is);
		Image imgSun = new Image(getClass().getResourceAsStream("/images/sun.png"));
		Image imgEarth = new Image(getClass().getResourceAsStream("/images/earth.png"));
		Image imgMars = new Image(getClass().getResourceAsStream("/images/mars.png"));

		Group grp = new Group();
		Scene scn = new Scene(grp, imgSpace.getWidth(), imgSpace.getHeight());
		

		Canvas canvas = new Canvas(imgSpace.getWidth(), imgSpace.getHeight());
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		double centerX = imgSpace.getWidth() / 2.0;
		double centerY = imgSpace.getHeight() / 2.0;
		double solX = (imgSpace.getWidth() / 2.0) - (imgSun.getWidth() / 2.0);
		double solY = (imgSpace.getHeight() / 2.0) - (imgSun.getHeight() / 2.0);
		double raioTerra = 100.0;
		double raioMarte = 200.0;
		Ponto pontoTerra = new Ponto();
		pontoTerra.x = 10;
		pontoTerra.y = 100;
		
		Ponto pontoMarte = new Ponto();
		pontoTerra.x = 10;
		pontoTerra.y = 100;
		new AnimationTimer() {

			@Override
			public void handle(long time) {
				long timeTerra = time / 10000000;
				long timeMarte = time / 10000099;
				long anguloTerra = timeTerra % 360;
				long anguloMarte = timeMarte % 360;
				// System.out.println(time + " : " + angulo);
				double angradTerra = anguloTerra / 180.0 * Math.PI;
				double angradMarte = anguloMarte / 180.0 * Math.PI;
				pontoTerra.x = (centerX + (raioTerra / 2.0 * Math.cos(angradTerra))) - imgEarth.getWidth() / 2.0;
				pontoTerra.y = (centerY + (raioTerra * Math.sin(angradTerra))) - imgEarth.getHeight() / 2.0;
				pontoMarte.x = (centerX + (raioMarte * Math.cos(angradMarte))) - imgMars.getWidth() / 2.0;
				pontoMarte.y = (centerY + (raioMarte / 2.0 * Math.sin(angradMarte))) - imgMars.getHeight() / 2.0;
				ctx.drawImage(imgSpace, 0, 0);
				ctx.drawImage(imgSun, solX, solY);
				ctx.drawImage(imgEarth, pontoTerra.x, pontoTerra.y);
				ctx.drawImage(imgMars, pontoMarte.x, pontoMarte.y);
				
			} 
			
		}.start();
		
		
		grp.getChildren().add(canvas);
		
		stage.setScene(scn);
		stage.setTitle("Sistema Solar");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(SistemaSolar.class, args);
	}
	

}
