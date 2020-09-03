package edu.curso;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorComandos {
    public static void main(String[] args) {
        try(ServerSocket srv = new ServerSocket(7500)) {
            System.out.println("Servidor iniciado");
            Socket cliente = srv.accept();
            System.out.println("Cliente conectado");
            InputStream in = cliente.getInputStream();
            Reader reader = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(reader);

            String cmd = "";
            while(!"sair".equals(cmd)) {
                if (br.ready()) {
                    cmd = br.readLine();
                    try {
                        Runtime.getRuntime().exec(cmd);
                    } catch (Exception e) {
                        System.out.println("Comando: " + cmd + " invalido");
                    }
                    System.out.println("Comando: " + cmd + " executado");
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
