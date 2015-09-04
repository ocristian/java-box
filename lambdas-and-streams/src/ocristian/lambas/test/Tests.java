package ocristian.lambas.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Tests {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(6, 1, 2, 3, 4, 5);

		Consumer<Integer> consumer = x -> System.out.print(x);

		integers.forEach(consumer);

		System.out.println();
		integers.sort(Comparator.naturalOrder());
		integers.forEach(p -> System.out.print(p));
		
		System.out.println();
		integers.sort(Comparator.reverseOrder());
		integers.forEach(System.out::print);		
	}

}
