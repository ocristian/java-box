package org.ocristian.tdcpoa2015.lambda;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.ocristian.tdcpoa2015.model.Atletas;
import org.ocristian.tdcpoa2015.model.Jogador;

public class ExemploFunctionalInterface {

    public static void main(String[] args) {

	ArrayList<Jogador> listaJogadores = new ArrayList<>(Atletas.listaDeAtletas);


	doPredicate(listaJogadores);
	
	doFunction(listaJogadores);

	doCunsumer();

	doBinaryOperator();
    }

    private static void doPredicate(ArrayList<Jogador> listaJogadores) {

	Predicate<Jogador> jogadorComMaisDe70kilos = (jogador) -> jogador.getPeso() > 70.0;

	listaJogadores.stream()
		.filter(jogadorComMaisDe70kilos)
		.forEach(System.out::println);
    }

    private static void doFunction(ArrayList<Jogador> listaJogadores) {
	Function<Jogador, Integer> idade = (jogador) -> {
	    return Period.between(jogador.getDataNascimento(), LocalDate.now()).getYears();
	};

	System.out.println("Idade: " + idade.apply(listaJogadores.stream().findAny().get()));
	
	
	BiFunction<Double, Double, Boolean> imc = (peso, altura) -> {
	    return peso / (altura * altura) >= 18.5 && peso / (altura * altura) <= 25;
	};
	
	System.out.println(imc.apply(120.0, 1.74));
    }

    private static void doCunsumer() {
	
	Consumer<Integer> consumerInc10 = (Integer x) -> {
	    System.out.println(x + 10);
	};
	
	Arrays.asList(1,2,3,4,5).forEach(consumerInc10);
	

	BiConsumer<String, Integer> biConsumer = (String x, Integer y) -> {
	    System.out.println("key: " + x + " Value: " + y);
	};
	
	Map<String, Integer> myMap = new HashMap<String, Integer>() {
	    private static final long serialVersionUID = 1L;
	    {
		put("One", 1);
		put("Two", 2);
		put("Three", 3);
	    }
	};
	
	myMap.forEach(biConsumer);
	
	
    }

    private static void doBinaryOperator() {
	
	BinaryOperator<Integer> binaryOperatorToSum = (Integer xx, Integer yy) -> {
	    return xx + yy;
	};
	
	System.out.println(binaryOperatorToSum.apply(1, 1));

	BinaryOperator<String> binaryOperatorLongestText = (String a, String x) -> {
	    if (a.length() > x.length())
		return a;
	    return x;
	};
	
	System.out.println(binaryOperatorLongestText.apply("This is the biggest", "this text"));
	

	BinaryOperator<String> textConcat = (String a, String b) -> {
	    return a.concat(b);
	};
	
	System.out.println(textConcat.apply("pL", "Á"));
    }
}