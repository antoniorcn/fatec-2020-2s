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

public class Principal extends Application 
					implements EventHandler<ActionEvent>,
					AssinanteComando {
	private BorderPane panePrincipal = new BorderPane();
	
	private TelaA telaA = new TelaA();
	private TelaB telaB = new TelaB();
	private TelaC telaC = new TelaC();
	
	private TelaStrategy tela = telaA;
	
	private MenuBar mnuPrincipal = new MenuBar();
	
	private Menu mnuCadastro = new Menu("Cadastro");
	private Menu mnuAjuda = new Menu("Ajuda");
	
	private MenuItem mnuContato = new MenuItem("Contato");
	private MenuItem mnuOutros = new MenuItem("Outros");
	private MenuItem mnuCreditos = new MenuItem("Creditos");
	private MenuItem mnuSair = new MenuItem("Sair");
	
	@Override
	public void start(Stage stage) { 
		Scene scn = new Scene(panePrincipal, 800, 600);
		
		panePrincipal.setTop(mnuPrincipal);
		mnuPrincipal.getMenus().addAll(mnuCadastro, mnuAjuda);
		
		mnuCadastro.getItems().addAll(mnuContato, mnuOutros, mnuSair);
		mnuAjuda.getItems().addAll(mnuCreditos);
		
		mnuContato.setOnAction(this);
		mnuOutros.setOnAction(this);
		mnuCreditos.setOnAction(this);
		mnuSair.setOnAction(this);
		
		telaA.setAssinanteComando(this);
		telaB.setAssinanteComando(this);
		telaC.setAssinanteComando(this);
		
		this.telaContext();
		
		stage.setScene(scn);
		stage.setTitle("Tela principal");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Principal.class, args);
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == mnuSair) { 
			this.executarComando("sair");
		} else if (e.getTarget() == mnuContato) { 
			this.executarComando("contato");
		} else if (e.getTarget() == mnuCreditos) { 
			this.executarComando("creditos");
		} else if (e.getTarget() == mnuOutros) { 
			this.executarComando("outros");	
		}
		
	}
	
	public void telaContext() { 
		panePrincipal.setCenter(tela.getTela());
	}

	@Override
	public void executarComando(String cmd) {
		if ("sair".equals(cmd)) { 
			System.exit(0);
		} else if ("contato".equals(cmd)) { 
			tela = telaA;
		} else if ("creditos".equals(cmd)) { 
			tela = telaB;
		} else if ("outros".equals(cmd)) { 
			tela = telaC;
		}
		this.telaContext();
	}
}
