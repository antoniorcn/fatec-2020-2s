package edu.curso;

class MinhaThread2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Minha Thread");
        }
    }
}
public class TesteThread2 {
    public static void main(String[] args) {
        MinhaThread2 mt = new MinhaThread2();
        Thread t2 = new Thread(mt);
        t2.start();
        while(true) {
            System.out.println("Codigo Principal");
        }
    }
}
