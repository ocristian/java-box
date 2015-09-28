package org.ocristian.tdcpoa2015.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;

import org.ocristian.tdcpoa2015.model.Atletas;
import org.ocristian.tdcpoa2015.model.Jogador;

public class ExemploTypeChecking {

    private static ArrayList<Jogador> listaJogadores = new ArrayList<>(Atletas.listaDeAtletas);

    public static void main(String[] args) {

	Comparator<Jogador> comparatorPorNome = (a1, a2) -> a1.getNome().compareTo(a2.getNome());

	ToIntBiFunction<Jogador, Jogador> toIntBiFuncComparatorPorNome = (a1, a2) -> a1.getNome().compareTo(a2.getNome());

	BiFunction<Jogador, Jogador, Integer> biFuncComparatorPorNome = (a1, a2) -> a1.getNome().compareTo(a2.getNome());

	testTypeChecking(comparatorPorNome);

	testTypeChecking(biFuncComparatorPorNome);

	testTypeChecking((a1) -> a1.getNome().startsWith("N"));

    }

    private static void testTypeChecking(Comparator<Jogador> compararPorNome) {
	listaJogadores.sort(compararPorNome);
    }

    private static void testTypeChecking(Predicate<Jogador> predicate) {
	System.out.println(predicate.test(listaJogadores.stream().findAny().get()));
    }

    private static void testTypeChecking(BiFunction<Jogador, Jogador, Integer> biFunction) {
	Jogador jogador = listaJogadores.stream().findAny().get();
	Jogador jogador2 = listaJogadores.stream().findAny().get();
	biFunction.apply(jogador2, jogador);
    }
}