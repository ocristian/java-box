package org.ocristian.tdcpoa2015.lambda;

import java.util.ArrayList;
import java.util.Comparator;

import org.ocristian.tdcpoa2015.model.Atletas;
import org.ocristian.tdcpoa2015.model.Jogador;

public class ExemploThisScope {

    private static ArrayList<Jogador> listaJogadores = new ArrayList<>(Atletas.listaDeAtletas);

    private String scope = "class";

    public void testThisScope() {
	// Print class
	Comparator<Jogador> c1 = (a1, a2) -> {
	    String scope = "lambda";
	    System.out.println("lambda: " + this.scope);
	    return a1.getNome().compareTo(a2.getNome());
	};

	listaJogadores.sort(c1);

	// Print innerClassScope
	listaJogadores.sort(new Comparator<Jogador>() {
	    String scope = "anonymous";

	    @Override
	    public int compare(Jogador o1, Jogador o2) {
		System.out.println(this.scope);
		return o1.getNome().compareTo(o2.getNome());
	    }
	});
    }

    public static void main(String[] args) {
	new ExemploThisScope().testThisScope();
    }
}