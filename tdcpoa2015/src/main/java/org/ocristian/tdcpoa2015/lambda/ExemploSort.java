package org.ocristian.tdcpoa2015.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.ocristian.tdcpoa2015.enums.Posicao;
import org.ocristian.tdcpoa2015.model.Atletas;
import org.ocristian.tdcpoa2015.model.Jogador;

public class ExemploSort {

    public static void main(String[] args) {

	ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>(Atletas.listaDeAtletas);

	ArrayList<Jogador> listaAtacantes = new ArrayList<Jogador>();

	// Java 7
	for (Jogador atletas : listaJogadores) {
	    if (Posicao.ATACANTE.equals(atletas.getPosicao())) {
		listaAtacantes.add(atletas);
	    }
	}

	Collections.sort(listaAtacantes, new Comparator<Jogador>() {
	    public int compare(Jogador a1, Jogador a2) {
		return a1.getNome().compareTo(a2.getNome());
	    }
	});

	for (Jogador atletas : listaAtacantes) {
	    System.out.println(atletas);
	}

	// Java 8
	listaJogadores.removeIf(atleta -> !Posicao.ATACANTE.equals(atleta.getPosicao()));
	listaJogadores.sort((a1, a2) -> a1.getNome().compareTo(a2.getNome()));
	listaJogadores.forEach(System.out::println);

	listaJogadores.removeIf(jogador -> !Posicao.ATACANTE.equals(jogador.getPosicao()));
	listaJogadores.sort(Comparator.comparing(Jogador::getNome));
	listaJogadores.forEach(System.out::println);

	listaJogadores.stream()
		.filter(jogador -> Posicao.ATACANTE.equals(jogador.getPosicao()))
		.sorted(Comparator.comparing(Jogador::getNome))
		.forEach(System.out::println);
	
	listaJogadores.stream()
		.sorted(
			Comparator.comparing(Jogador::getNome)
				.thenComparing(Jogador::getPosicao)
				.thenComparing(Jogador::getDataNascimento)
		);	
    }
}