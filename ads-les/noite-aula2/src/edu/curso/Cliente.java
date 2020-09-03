package edu.curso;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String args[]) {
        try(Socket cli = new Socket("127.0.0.1", 7000)) {
            System.out.println("Cliente conectado....");
            boolean sair = false;
            InputStream in = cli.getInputStream();
            OutputStream out = cli.getOutputStream();
            while(!sair) {
                if (in.available() > 0) {
                    int i = in.read();
                    System.out.print((char) i);
                }

                if (System.in.available() > 0) {
                    int i = System.in.read();
                    if (i == (int)'@') {
                        i = 27;
                        sair = true;
                    }
                    out.write(i);
                    out.flush();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
