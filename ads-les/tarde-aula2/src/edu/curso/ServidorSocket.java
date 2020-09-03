package edu.curso;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
    public static final int PORTA = 4040;
    public static void main(String[] args) {
        try (
            ServerSocket servidor =
                    new ServerSocket(PORTA)) {
            System.out.printf("Servidor iniciado com sucesso " +
                    "na porta %d%n",PORTA);
            System.out.println("Agarudando conexão");
            Socket sock = servidor.accept();
            System.out.println("Cliente conectado");
            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();
            InputStream console = System.in;
            out.write("Bem vindo ao servidor socket em Java...\n\r".getBytes());
            out.flush();
            boolean sair = false;
            while (!sair) {
                int i;
                if (in.available() > 0) {
                    i = in.read();
                    System.out.print((char) i);
                    if (i == 27) {
                        sair = true;
                    }
                }

                if (console.available() > 0) {
                    i = console.read();
                    out.write(i);
                    out.flush();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
