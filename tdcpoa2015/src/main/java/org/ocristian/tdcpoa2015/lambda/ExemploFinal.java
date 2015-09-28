package org.ocristian.tdcpoa2015.lambda;

public class ExemploFinal {

    private int porta = 1010;

    private void exemploFinal() {
	int port = 8080;
	Runnable r = () -> System.out.print(port);
	r.run();
	
	//port = 8081;
	
	Runnable r2 = () -> System.out.print(porta);
	r2.run();
	porta = 9898;
    }

    public static void main(String[] args) {
	new ExemploFinal().exemploFinal();
    }
}