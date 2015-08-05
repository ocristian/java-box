/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */
package ocristian.lambas.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 * <br/>
 * <br/>
 * Exercises solved by:
 * @author <a href="http://about.me/ocristian">Cristian R. Silva
 *         (about.me/ocristian)</a>
 */
public class Lesson2 {
  private static final String WORD_REGEXP = "[- .:,]+";

  /**
   * Run the exercises to ensure we got the right answers
   *
   * @throws java.io.IOException
   */
  public void runExercises() throws IOException {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
    System.out.println("Running exercise 6 solution...");
    exercise6();
    System.out.println("Running exercise 7 solution...");
    exercise7();
  }

  /**
   * Exercise 1
   *
   * Create a new list with all the strings from original list converted to 
   * lower case and print them out.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
    // 1st, get the stream from list
    // 2sd, use map to returns a new stream produced by applying the function
    // 3rd, collect to stream to the new list
    List<String> myList = list.stream()
    		.map(String::toLowerCase)
    		.collect(Collectors.toList());
    
    myList.forEach(System.out::println);
  }

  /**
   * Exercise 2
   *
   * Modify exercise 1 so that the new list only contains strings that have an
   * odd length
   */
  private void exercise2() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
    //applying a filter that use Predicate to verify if the string have odd length
    List<String> myList = list.stream()
    		.filter(s -> (s.length() & 1) == 1)
    		.map(String::toLowerCase)
    		.collect(Collectors.toList());
    
    myList.forEach(System.out::println);
  }

  /**
   * Exercise 3
   *
   * Join the second, third and forth strings of the list into a single string,
   * where each word is separated by a hyphen (-). Print the resulting string.
   */
  private void exercise3() {
    List<String> list = Arrays.asList(
        "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    /* YOUR CODE HERE */
    // restricting the size of stream with skip and limit and joining("-") method 
    //from Collectos to concatenate string with a hyphen
    String splitedString = list.stream()
    		.skip(1)
    		.limit(3)
    		.collect(Collectors.joining("-"));
    System.out.println(splitedString);
  }

  /**
   * Count the number of lines in the file using the BufferedReader provided
   */
  private void exercise4() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
			/* YOUR CODE HERE */
			// 1st, get the stream - lines()
			// 2nd, call the terminal operator count()
			long numberOfLines = reader.lines().count();
			System.out.println(numberOfLines);
		}
  }
  
  /**
   * Using the BufferedReader to access the file, create a list of words with
   * no duplicates contained in the file.  Print the words.
   * 
   * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
   */
	private void exercise5() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
			
			/* YOUR CODE HERE */
			// 1st, get the stream - lines()
			// 2nd, apply the flatMap to map values in a stream to new map
			// 3rd, apply the filter distinct, to get distinct words
			// 4th, collect the result
			
			List<String> words = reader
					.lines()
					.flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
					.distinct()
					.collect(Collectors.toList());

			words.forEach(System.out::println);
		}
	}
  
  /**
   * Using the BufferedReader to access the file create a list of words from 
   * the file, converted to lower-case and with duplicates removed, which is
   * sorted by natural order.  Print the contents of the list.
   */
	private void exercise6() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
			/* YOUR CODE HERE */
			// 1st, get the stream - lines()
			// 2nd, apply the flatMap to map values in a stream to new map
			// 3rd, apply the map to returns a result based on function
			// 4th, apply the filter distinct, to get distinct words
			// 5th, sorting with no arguments, by natural order
			// 6th, collect the result
			
			List<String> words = reader
					.lines()
					.flatMap(line -> Stream.of(line.split(WORD_REGEXP))
					.map(String::toLowerCase))					
					.distinct()
					.sorted()
					.collect(Collectors.toList());

			words.forEach(System.out::println);			
		}
	}
  
  /**
   * Modify exercise6 so that the words are sorted by length
   */
	private void exercise7() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
			/* YOUR CODE HERE */
			// 1st, get the stream - lines()
			// 2nd, apply the flatMap to map values in a stream to new map
			// 3rd, apply the map to returns a result based on function
			// 4th, apply the filter distinct, to get distinct words
			// 5th, sorting by length
			// 6th, collect the result
			
			List<String> words = reader
					.lines()
					.flatMap(line -> Stream.of(line.split(WORD_REGEXP))
					.map(String::toLowerCase))					
					.distinct()
					.sorted((w1, w2) -> w1.length() - w2.length())					
					.collect(Collectors.toList());

			words.forEach(System.out::println);				
		}
	}

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   * @throws IOException If file access does not work
   */
  public static void main(String[] args) throws IOException {
    Lesson2 lesson = new Lesson2();
    lesson.runExercises();
  }
}

