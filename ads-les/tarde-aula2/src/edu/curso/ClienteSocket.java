package edu.curso;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClienteSocket {

    public static void main(String[] args) {
        try (
            Socket socCli = new Socket("127.0.0.1", 4040) ) {
            InputStream in = socCli.getInputStream();
            OutputStream out = socCli.getOutputStream();
            InputStream console = System.in;
            boolean sair = false;
            while (!sair) {
                if (in.available() > 0) {
                    int i = in.read();
                    if (i != 27) {
                        System.out.print((char) i);
                    } else {
                        sair = true;
                    }
                }

                if (console.available() > 0) {
                    int i = console.read();
                    out.write(i);
                    out.flush();
                    if (i == 27) {
                        sair = true;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
