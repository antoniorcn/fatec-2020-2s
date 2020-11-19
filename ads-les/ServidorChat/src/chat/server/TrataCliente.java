package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TrataCliente implements Runnable {

	private Socket cliente;
	private Subject subject;
	
	public TrataCliente(Socket cliente) { 
		this.cliente = cliente;
	}
	
	public String lerDoTelnet() throws IOException { 
		InputStreamReader reader = 
				new InputStreamReader(cliente.getInputStream());
		BufferedReader buf = new BufferedReader(reader);
		if (buf.ready()) { 
			return buf.readLine();
		} else { 
			return null;
		}
	}
	
	public void escreverTelnet(String texto) throws IOException { 
		OutputStream out = cliente.getOutputStream();
		out.write(texto.concat("\n").getBytes());
		out.flush();
	}
	
	@Override
	public void run() {	
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(reader);
		while (true) { 
			try { 
				String linha = this.lerDoTelnet();
				if (linha != null) { 
					System.out.println(linha);
				}
				
				if (bfr.ready()) { 
					String line = bfr.readLine();
					// this.escrever(line);
					this.subject.update(line, this);
				}
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
