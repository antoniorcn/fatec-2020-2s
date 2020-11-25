package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TrataCliente implements Runnable, Subject {

	private Socket cliente;
	private Assinante assinante;
	private BufferedReader buf;
	private OutputStream out;
	private InputStreamReader reader;
	
	public TrataCliente(Socket cliente) { 
		this.cliente = cliente;
		try {
		reader = new InputStreamReader(cliente.getInputStream());
		out = cliente.getOutputStream();
		buf = new BufferedReader(reader);
			this.escreverParaTelnet("Bem vindo você se conectou no servidor");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String lerDoTelnet() throws IOException { 
		if (buf.ready()) { 
			return buf.readLine();
		} else { 
			return null;
		}
	}
	
	public void escreverParaTelnet(String texto) throws IOException { 
		out.write(texto.concat("\r\n").getBytes());
		out.flush();
	}
	
	@Override
	public void run() {	
		while (true) { 
			try { 
				String linha = this.lerDoTelnet();
				// System.out.println(linha);
				if (linha != null) { 
					System.out.println(linha);
					this.assinante.update(linha, this);
				}
				Thread.sleep(1);
			} catch (IOException e) { 
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setAssinante(Assinante subject) {
		this.assinante = subject;
	}

}
