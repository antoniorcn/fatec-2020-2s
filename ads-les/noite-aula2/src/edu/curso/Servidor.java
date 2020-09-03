package edu.curso;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
    public static void main(String args[]) {
        try(ServerSocket servidor = new ServerSocket(7000)) {
            System.out.println("Servidor está iniciado," +
                    " a porta foi reservada com sucesso");
            System.out.println("Aguardando conexão do cliente");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");
            OutputStream out = cliente.getOutputStream();
            InputStream in = cliente.getInputStream();
            out.write("Ola cliente voce conectou no servidor Java\n\r"
                    .getBytes());
            out.flush();
            boolean sair = false;
            while(!sair) {
                if (in.available() > 0) {
                    int i = in.read();
                    if (i == 27) {
                        sair = true;
                    } else {
                        System.out.print((char) i);
                    }
                }

                if (System.in.available() > 0) {
                    int i = System.in.read();
                    if (i == (int)'@') {
                        sair = true;
                    } else if (i == 10) {
                        out.write(13);
                        out.write(10);
                        out.flush();
                    } else {
                        out.write(i);
                        out.flush();
                    }
                }
            }
            System.out.println("Servidor encerrado");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
