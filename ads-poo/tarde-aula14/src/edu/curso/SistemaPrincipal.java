package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SistemaPrincipal extends Application 
		implements EventHandler<ActionEvent>,
					GerenciadorComandos {
	
	private MenuBar mnuBar = new MenuBar();
	
	private Menu mnuSistema = new Menu("Sistema");
	private MenuItem mnuContato = new MenuItem("Contato");
	private MenuItem mnuSair = new MenuItem("Sair");
	
	private Menu mnuAjuda = new Menu("Ajuda");
	private MenuItem mnuCreditos = new MenuItem("Créditos");
	
	private BorderPane panePrincipal = new BorderPane();
	
	private ContatoBoundary ccontatoBoundary = new ContatoBoundary();
	private CreditosBoundary creditosBoundary = new CreditosBoundary();

	public void start(Stage stage) { 
		
		mnuSistema.getItems().addAll(mnuContato, mnuSair);
		mnuAjuda.getItems().addAll(mnuCreditos);
		
		mnuContato.setOnAction(this);
		mnuSair.setOnAction(this);
		mnuCreditos.setOnAction(this);
		
		mnuBar.getMenus().addAll(mnuSistema, mnuAjuda);
		
		Scene scn = new Scene(panePrincipal, 640, 480);
		
		panePrincipal.setTop(mnuBar);
		
		stage.setScene(scn);
		stage.setTitle("Sistema Integrado");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(SistemaPrincipal.class, args);
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == mnuSair) { 
			executarComando("sair");
		} else if (e.getTarget() == mnuContato) { 
			executarComando("contato");
		} else if (e.getTarget() == mnuCreditos) { 
			executarComando("creditos");
		}
	}

	@Override
	public void executarComando(String comando) {
		if ("sair".equals(comando)) { 
			System.exit(0);
		} else if ("contato".equals(comando)) { 
			panePrincipal.setCenter(ccontatoBoundary.gerarTela());
		} else if ("creditos".equals(comando)) { 
			panePrincipal.setCenter(creditosBoundary.gerarTela());			
		}
	}
}
