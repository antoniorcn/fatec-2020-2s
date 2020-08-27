package edu.curso;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
