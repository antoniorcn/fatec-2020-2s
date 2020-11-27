package edu.animacao;

import java.io.InputStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
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
		
		new AnimationTimer() {
			double centroX = imgSpace.getWidth() / 2.0;
			double centroY = imgSpace.getHeight() / 2.0;
			double sunX = centroX - imgSun.getWidth() / 2.0;
			double sunY = centroY - imgSun.getHeight() / 2.0;
			double earthX = 400.0;
			double earthY = 0.0;
			double earthRay = 100;
			double marsRay = 200;
			// double earthSpeedX = 5;
			double anguloTerra = 0;
			double anguloMarte = 0;
			
			@Override
			public void handle(long time) {
				anguloTerra -= 1;
				anguloMarte -=0.8;
				double anguloTerraRad = anguloTerra / 180.0 * Math.PI;
				double anguloMarteRad = anguloMarte / 180.0 * Math.PI;
				earthX = centroX + (earthRay * 3/8 * Math.cos(anguloTerraRad)) - imgEarth.getWidth() / 2.0;
				earthY = centroY + (earthRay * 4/5 *Math.sin(anguloTerraRad)) - imgEarth.getHeight() / 2.0;
				double marsX = centroX + (marsRay * 4/5 * Math.cos(anguloMarteRad)) - imgMars.getWidth() / 2.0;
				double marsY = centroY + (marsRay * 3/8 * Math.sin(anguloMarteRad)) - imgMars.getHeight() / 2.0;
				ctx.drawImage(imgSpace, 0, 0);
				ctx.drawImage(imgSun, sunX, sunY);
				ctx.drawImage(imgEarth, earthX, earthY);
				ctx.drawImage(imgMars, marsX, marsY);
			} 
			
			
//			@Override
//			public void handle(long time) {
//				ctx.drawImage(imgSpace, 0, 0);
//				if (earthSpeedX > 0) { 
//					ctx.drawImage(imgSun, sunX, sunY);
//					ctx.drawImage(imgEarth, earthX, 200);
//				} else {
//					ctx.drawImage(imgEarth, earthX, 200);
//					ctx.drawImage(imgSun, sunX, sunY);
//				}
//				earthX += earthSpeedX;
//				if (earthX > 600.0) { 
//					earthSpeedX = -5;
//				}
//				
//				if (earthX < 0) { 
//					earthSpeedX = 5;
//				}
//			} 
			
		}.start();
		
		
		grp.getChildren().add(canvas);
		
		stage.setScene(scn);
		stage.getIcons().add(imgSun);
		stage.setTitle("Sistema Solar");
		stage.show();		
	}
	
	public static void main(String[] args) {
		Application.launch(SistemaSolar.class, args);
	}


}
