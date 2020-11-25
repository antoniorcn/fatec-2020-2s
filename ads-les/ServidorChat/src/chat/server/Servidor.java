package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor implements Assinante {
	
	private List<TrataCliente> listaClientes = new ArrayList<>();
	private ServerSocket server;
	
	public void executar() throws IOException { 
		server = new ServerSocket(10000);
		while (true) { 
			System.out.println("Aguardando conexao");
			Socket soc = server.accept();
			System.out.println("Cliente conectado");
			TrataCliente tr = new TrataCliente(soc);
			Thread t1 = new Thread(tr);
			t1.start();
			tr.setAssinante(this);
			listaClientes.add(tr);
		}
	}
	
	public void update(String msg, TrataCliente self) throws IOException { 
		for (TrataCliente tr : listaClientes) { 
			if (tr != self) { 
				tr.escreverParaTelnet(msg);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Servidor chat iniciado");
		Servidor srv = new Servidor();
		srv.executar();
	}
}
