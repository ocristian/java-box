package org.ocristian.tdcpoa2015.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.ocristian.tdcpoa2015.model.Artilharia;

public class DadosDeArtilharia {

    public static void main(String[] args) {

	List<Artilharia> artilharia = new CarregarArtilharia().getArtilharia();

	artilheirosDoGremioOrdenadosPorNumeroDeGols(artilharia);

	artilhariaDoCampeonato(artilharia);

	artilheirosAtacantes(artilharia);

	artilheirosGoleiros(artilharia);

	totalDeGolsNoCampeonato(artilharia);

    }

    private static void artilheirosDoGremioOrdenadosPorNumeroDeGols(List<Artilharia> artilharia) {

	System.out.println("Artilheiros do Grêmio ordernados por número de gols");

	List<Artilharia> artilheirosDoGremio = new ArrayList<Artilharia>();

	for (Artilharia art : artilharia) {
	    if ("Grêmio".equals(art.getEquipe_nome())) {
		artilheirosDoGremio.add(art);
	    }
	}

	artilheirosDoGremio.sort(new Comparator<Artilharia>() {
	    @Override
	    public int compare(Artilharia a1, Artilharia a2) {
		return (int) (a2.getTotal_gols() - a1.getTotal_gols());
	    }
	});

	for (Artilharia art : artilheirosDoGremio) {
	    System.out.format("%-2s%-4s%-20s%-4s%-20s%n", art.getTotal_gols(), " - ", art.getJogador_nome(), " - ",
		    art.getJogador_posicao());
	}

	System.out.println(" ");

	// java8
	System.out.println("Com Java 8");
	artilharia.stream()
		.filter(a -> "Grêmio".equals(a.getEquipe_nome()))
		.sorted(
			Comparator.comparing(Artilharia::getTotal_gols).reversed())
		.forEach(a -> System.out
			.format("%-2s%-4s%-20s%-4s%-20s%n", a.getTotal_gols(), " - ", a.getJogador_nome(), " - ", a.getJogador_posicao()));

	System.out.println(" ");

    }

    private static void artilhariaDoCampeonato(List<Artilharia> artilharia) {

	System.out.println("Artilharia do Campeonato");

	List<Artilharia> artilheirosDoCampeonato = new ArrayList<Artilharia>();

	for (Artilharia art : artilharia) {
	    artilheirosDoCampeonato.add(art);
	}

	artilheirosDoCampeonato.sort(new Comparator<Artilharia>() {
	    @Override
	    public int compare(Artilharia a1, Artilharia a2) {
		return (int) (a2.getTotal_gols() - a1.getTotal_gols());
	    }
	});

	for (Artilharia art : artilheirosDoCampeonato) {
	    System.out.format("%-2s%-4s%-20s%-4s%-20s%-4s%-20s%n", art.getTotal_gols(), " - ", art.getJogador_nome(), " - ",
		    art.getJogador_posicao(), " - ", art.getEquipe_nome());
	}

	System.out.println(" ");

	// java8
	System.out.println("Com Java 8");
	artilharia.stream()
		.sorted(Comparator.comparing(Artilharia::getTotal_gols).reversed())
		.forEach(a -> System.out.format("%-2s%-4s%-20s%-4s%-20s%-4s%-20s%n", a.getTotal_gols(), " - ", a.getJogador_nome(), " - ",
			a.getJogador_posicao(), " - ", a.getEquipe_nome()));

	System.out.println(" ");

    }

    private static void artilheirosAtacantes(List<Artilharia> artilharia) {

	System.out.println("Artilheiros Atacantes");

	List<Artilharia> artilheirosAtacantes = new ArrayList<Artilharia>();

	for (Artilharia art : artilharia) {
	    if ("Atacante".equals(art.getJogador_posicao())) {
		artilheirosAtacantes.add(art);
	    }
	}

	artilheirosAtacantes.sort(new Comparator<Artilharia>() {
	    @Override
	    public int compare(Artilharia a1, Artilharia a2) {
		return (int) (a2.getTotal_gols() - a1.getTotal_gols());
	    }
	});

	for (Artilharia art : artilheirosAtacantes) {
	    System.out.format("%-2s%-4s%-20s%-4s%-14s%n", art.getTotal_gols(), " - ", art.getJogador_nome(), " - ", art.getEquipe_nome());
	}

	System.out.println(" ");

	// java8
	System.out.println("Com Java 8");
	List<Artilharia> atacantes = artilharia.stream().filter(j -> "Atacante".equals(j.getJogador_posicao()))
		.sorted(Comparator.comparing(Artilharia::getTotal_gols).reversed())
		.collect(Collectors.toList());

	atacantes.forEach(a -> System.out.format("%-2s%-4s%-20s%-4s%-14s%n", a.getTotal_gols(), " - ", a.getJogador_nome(), " - ",
		a.getEquipe_nome()));

	System.out.println("");
	System.out.println("===== groupingBy =====");
	Map<String, Long> atacantesPorTime = artilharia.stream()
		.filter(j -> "Atacante".equals(j.getJogador_posicao()))
		.collect(
			Collectors.groupingBy(Artilharia::getEquipe_nome, Collectors.counting())
		);

	System.out.println(atacantesPorTime);

	System.out.println("");
	System.out.println(" === sum === ");

	long totalDeGols = artilharia.stream()
		.filter(j -> "Atacante".equals(j.getJogador_posicao()))
		.mapToLong(Artilharia::getTotal_gols)
		.sum();

	System.out.println(totalDeGols);

	System.out.println("");
	System.out.println(" === reduce === ");
	long totalDePartidas = artilharia.stream()
		.filter(j -> "Atacante".equals(j.getJogador_posicao()))
		.mapToLong(Artilharia::getTotal_partidas)
		.reduce(0, (a, b) -> a + b);

	System.out.println(totalDePartidas);

	System.out.println("");
	System.out.println("findFirst");

	Optional<Artilharia> primeiroAtacanteArtilheiro = artilharia.stream()
		.filter(j -> "Atacante".equals(j.getJogador_posicao()))
		.findFirst();
	
	System.out.println(primeiroAtacanteArtilheiro);

	System.out.println("");
	System.out.println(" findAny ");
	Optional<String> val = Stream.of("one", "two").findAny();

	System.out.println(val);

	System.out.println(" ");
	System.out.println(" Stream.of ");

	Optional<String> findFirst = 
		Stream.of("Whatever", "it", "takes", "to", "break", "Gotta", "do", "it", "From", "the", "burning",
		"lake", "or", "the", "eastern", "gate", "You'll", "get", "through", "it")
			.filter(j -> {
			    System.out.println("filter: " + j);
			    return j.startsWith("t");
			}).map(j -> {
			    System.out.println("map: " + j);
			    return j.toUpperCase();
			}).findFirst();

	System.out.println(findFirst);

	System.out.println(" ");

    }

    private static void artilheirosGoleiros(List<Artilharia> artilharia) {

	System.out.println("Artilheiros Goleiros");

	List<Artilharia> artilheirosGoleiros = new ArrayList<Artilharia>();

	for (Artilharia art : artilharia) {
	    if ("Goleiro".equals(art.getJogador_posicao())) {
		artilheirosGoleiros.add(art);
	    }
	}

	for (Artilharia art : artilheirosGoleiros) {
	    System.out.format("%-2s%-4s%-20s%-4s%-14s%n", art.getTotal_gols(), " - ", art.getJogador_nome(), " - ", art.getEquipe_nome());
	}

	System.out.println(" ");

	// java8
	System.out.println("Com Java 8");
	List<Artilharia> goleiros = artilharia.stream()
		.filter(j -> "Goleiro".equals(j.getJogador_posicao()))
		.collect(Collectors.toList());

	goleiros.forEach(a -> System.out.format("%-2s%-4s%-20s%-4s%-14s%n", a.getTotal_gols(), " - ", a.getJogador_nome(), " - ",
		a.getEquipe_nome()));

	System.out.println(" ");

    }

    private static void totalDeGolsNoCampeonato(List<Artilharia> artilharia) {

	System.out.println("Total de Gols marcados no campeonato");

	long totalDeGols = 0;

	for (Artilharia art : artilharia) {
	    totalDeGols = totalDeGols + art.getTotal_gols();
	}

	System.out.println(totalDeGols);

	System.out.println(" ");

	// java8
	System.out.println("Com Java 8");

	long gols = artilharia.stream()
		.mapToLong(Artilharia::getTotal_gols)
		.sum();

	System.out.println(gols);

	System.out.println(" ");

    }

}
