package org.ocristian.tdcpoa2015.service;

import java.util.List;
import java.util.stream.LongStream;

import org.ocristian.tdcpoa2015.model.Partida;

public class DadosDaPartida {

    public static void main(String[] args) {

	List<Partida> partidas = new CarregarPartidas().getPartidas();

	publicoTotalNoCampeonato(partidas);

	rendaTotalNoCampeonato(partidas);

	parallelSum();

    }

    private static void publicoTotalNoCampeonato(List<Partida> partidas) {
	System.out.println("Público total do campeonato");

	long publico = partidas.stream()
		.mapToLong(Partida::getPublico)
		.sum();

	System.out.println(publico);

	System.out.println("");
    }

    private static void rendaTotalNoCampeonato(List<Partida> partidas) {
	System.out.println("Renda total do campeonato");

	double renda = partidas.stream()
		.mapToDouble(Partida::getRenda)
		.sum();

	System.out.println(renda);

	System.out.println("");
    }
    
    private static void parallelSum() {
	long startTime = System.nanoTime();
	// 1 bi
	long sum = LongStream.range(0, 1_000_000_000)
		.parallel().filter(x -> x % 2 == 0)
		.sum();
	
	long endTime = System.nanoTime();

	System.out.print("Sum: " + sum + " ");
	System.out.printf("took %dms%n", (endTime - startTime + 500_000L) / 1_000_000L);
    }    

}
