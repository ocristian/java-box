package org.ocristian.tdcpoa2015.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.ocristian.tdcpoa2015.model.AproveitamentoUltimosJogos;
import org.ocristian.tdcpoa2015.model.Brasileirao;
import org.ocristian.tdcpoa2015.model.Classificacao;
import org.ocristian.tdcpoa2015.model.Jogo;

public class DadosDoCampeonato {

    public static void main(String[] args) {

	Brasileirao brasileirao = new CarregarCampeonato().getBrasileirao();

	timesNoCampeonato(brasileirao);
	timesNaLibertadores(brasileirao);
	timesNoRebaixamento(brasileirao);
	timesNaPrimeiraPaginaDaTabela(brasileirao);
	timesNaSegundaPaginaDaTabela(brasileirao);
	timesPorNumeroDeVistorias(brasileirao);
	timesPorNumeroDeEmpates(brasileirao);
	timesPorNumeroDeDerrotas(brasileirao);
	timesPorAproveitamentoComoVisitante(brasileirao);
	timeComMaiorNome(brasileirao);
	timesQueVenceramUltimoJogo(brasileirao);

    }

    private static void timesNoCampeonato(Brasileirao brasileirao) {
	System.out.println("Times na Campeonato: ");

	List<String> times = brasileirao.getClassificacao().stream()
		.map(c -> c.getEquipe().getNome_popular())
		.collect(Collectors.toList());

	times.forEach(System.out::println);

	System.out.println(" ");
    }

    private static void timesNaLibertadores(Brasileirao brasileirao) {

	System.out.println("Times na Libertadores: ");

	brasileirao.getClassificacao().stream()
		.sorted(Comparator.comparing(Classificacao::getPontos).reversed())
		.limit(4)
		.forEach(t -> System.out.format("%-14s%-4s%-5s%n", t.getEquipe().getNome_popular(), " - ", t.getPontos()));

	System.out.println(" ");
    }

    private static void timesNoRebaixamento(Brasileirao brasileirao) {
	System.out.println("Times na Zona de Rebaixamento: ");

	brasileirao.getClassificacao().stream()
		.sorted(
			Comparator.comparing(Classificacao::getPontos)
				.thenComparing(j -> (j.getVitorias() + j.getEmpates() + j.getDerrotas())) // Nro de Jogos
				.thenComparing(Classificacao::getVitorias)
				.thenComparing(Classificacao::getEmpates)
				.thenComparing(Classificacao::getDerrotas))
		.limit(4)
		.sorted(Comparator.comparing(Classificacao::getPontos).reversed())
		.forEach(t -> System.out.format("%-14s%-4s%-5s%n", t.getEquipe().getNome_popular(), " - ", t.getPontos()));

	System.out.println(" ");
    }

    private static void timesNaPrimeiraPaginaDaTabela(Brasileirao brasileirao) {
	System.out.println("Times na Primeira Página da Tabela ");

	brasileirao.getClassificacao().stream()
		.limit(10)
		.forEach(t -> System.out.format("%-14s%-4s%-5s%n", t.getEquipe().getNome_popular(), " - ", t.getPontos()));

	System.out.println(" ");
    }

    private static void timesNaSegundaPaginaDaTabela(Brasileirao brasileirao) {
	System.out.println("Times na Segunda Página da Tabela ");

	brasileirao.getClassificacao().stream()
		.skip(10)
		.forEach(t -> System.out.format("%-14s%-4s%-5s%n", t.getEquipe().getNome_popular(), " - ", t.getPontos()));

	System.out.println(" ");
    }

    private static void timesPorNumeroDeVistorias(Brasileirao brasileirao) {
	System.out.println("Times por Número de Vitorias: ");

	brasileirao.getClassificacao().stream()
		.sorted(Comparator.comparing(Classificacao::getVitorias).reversed())
		.forEach(t -> System.out.format("%-14s%-4s%-5s%n", t.getEquipe().getNome_popular(), " - ", t.getVitorias()));

	System.out.println(" ");
    }

    private static void timesPorNumeroDeEmpates(Brasileirao brasileirao) {
	System.out.println("Times por Número de Empates: ");

	brasileirao.getClassificacao().stream()
		.sorted(Comparator.comparing(Classificacao::getEmpates).reversed())
		.forEach(t -> System.out.format("%-14s%-4s%-5s%n", t.getEquipe().getNome_popular(), " - ", t.getEmpates()));

	System.out.println(" ");
    }

    private static void timesPorNumeroDeDerrotas(Brasileirao brasileirao) {
	System.out.println("Times por Número de Derrotas: ");

	brasileirao.getClassificacao().stream()
		.sorted(Comparator.comparing(Classificacao::getDerrotas).reversed())
		.forEach(t -> System.out.format("%-14s%-4s%-5s%n", t.getEquipe().getNome_popular(), " - ", t.getDerrotas()));

	System.out.println(" ");
    }

    private static void timesPorAproveitamentoComoVisitante(Brasileirao brasileirao) {
	System.out.println("Times por Aproveitamento como Visitante: ");

	Map<String, Long> teams = brasileirao.getClassificacao().stream()
		.map(t -> t.getAproveitamento_ultimos_jogos())
		.flatMap(j -> j.stream())
		.filter(x -> "v".equals(x.getAproveitamento().trim()))
		.map(m -> m.getJogo())
		.filter(x -> "visitante".equals(x.getVencedor_jogo().getLabel()))
		.sorted((t1, t2) -> t1.getEquipe_visitante().getNome_popular().compareTo(t2.getEquipe_visitante().getNome_popular()))
		.collect(
			Collectors.groupingBy(x -> x.getEquipe_visitante().getNome_popular(), Collectors.counting())
		);

	teams.forEach((tname, twins) -> System.out.println(tname + " - " + twins));

	System.out.println(" ");
    }

    private static void timeComMaiorNome(Brasileirao brasileirao) {
	System.out.println("Times com maior nome ");

	Optional<String> nomeDoTime = brasileirao.getClassificacao().stream()
		.map(t -> t.getEquipe().getNome_popular())
		.max(Comparator.comparingInt(String::length));

	System.out.println(nomeDoTime);

	System.out.println(" ");
    }

    private static void timesQueVenceramUltimoJogo(Brasileirao brasileirao) {
	System.out.println("Times que Venceram o Última Jogo: ");

	brasileirao.getClassificacao().stream().map(j -> j.getAproveitamento_ultimos_jogos()).forEach((j) -> {

	    List<AproveitamentoUltimosJogos> aproveitamentoUltimosJogos = j.stream()
		    .filter(x -> "v".equals(x.getAproveitamento().trim()))
		    .collect(Collectors.toList());

	    List<Jogo> jogos = new ArrayList<Jogo>();

	    jogos = aproveitamentoUltimosJogos.stream()
		    .sorted(Comparator.comparing(x -> x.getJogo().getData_realizacao()))
		    .map(x -> x.getJogo()).collect(Collectors.toList());

	    System.out.println(jogos.stream().max(Comparator.comparing(x -> x.getData_realizacao())));

	});

	System.out.println(" ");
    }

}
