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

public class TelaPrincipal extends Application 
							implements EventHandler<ActionEvent>,
							GerenciadorPrincipal {
	
	private MenuItem menuTelaA = new MenuItem("Tela A");
	private MenuItem menuTelaB = new MenuItem("Tela B");
	private MenuItem menuSair = new MenuItem("Sair");
	
	private BorderPane bp = new BorderPane();
	
	private TelaRecheio telaA = new TelaA();
	private TelaRecheio telaB = new TelaB();
	private TelaRecheio telaAtual = telaA;
	
	@Override
	public void start(Stage stage) { 
		MenuBar menuPrincipal = new MenuBar();
		
		Menu menuArquivo = new Menu("Arquivo");
		menuArquivo.getItems().addAll(menuSair);
		
		Menu menuTelas = new Menu("Telas");
		menuTelas.getItems().addAll(menuTelaA, menuTelaB);
		
		menuPrincipal.getMenus().addAll(menuArquivo, menuTelas);
		
		menuSair.setOnAction(this);
		menuTelaA.setOnAction(this);
		menuTelaB.setOnAction(this);
		
		telaA.setGerenciadorPrincipal(this);
		telaB.setGerenciadorPrincipal(this);
		
		bp.setTop(menuPrincipal);
		bp.setCenter(telaAtual.render());
		Scene scn = new Scene(bp, 600, 300);
		
		stage.setScene(scn);
		stage.setTitle("Teste de Menus e Troca de Telas");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal.class, args);
	}

	@Override
	public void handle(ActionEvent e) {
		if(e.getTarget() == menuSair) { 
			comando("sair");
		} else if (e.getTarget() == menuTelaA) { 			
			comando("telaA");
		} else if (e.getTarget() == menuTelaB) { 			
			comando("telaB");
		}
		bp.setCenter(telaAtual.render());
	}

	@Override
	public void comando(String cmd) {
		if("sair".equals(cmd)) { 
			System.exit(0);
		} else if ("telaA".equals(cmd)) { 			
			telaAtual = telaA;
		} else if ("telaB".equals(cmd)) { 			
			telaAtual = telaB;
		}
		bp.setCenter(telaAtual.render());
	}

}
