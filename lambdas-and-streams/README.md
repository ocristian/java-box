#JDK 8 MOOC Functional Programming in Java with Lambdas and Streams

Here I'll take some notes about [Lambdas and Streams Introduction](https://apexapps.oracle.com/pls/apex/f?p=44785:141:105593264740337::NO::P141_PAGE_ID,P141_SECTION_ID:250,1807) the online course provided by Simon Ritter @speakjava 


##Lambdas

* [Lesson 1 - Lambda Expressions](#lesson-1---lambda-expressions)
* [Lesson 2 - Lambda Expression Syntax](#lesson-2---lambda-expression-syntax)
* [Lesson 3 - Functional Interfaces And Their Definition](#lesson-3---functional-interfaces-and-their-definition)
* [Lesson 4 - Functional Interfaces in the java.util.function Package](#lesson-4---functional-interfaces-in-the-javautilfunction-package)
* [Lesson 5 - Method and Constructor References](#lesson-5---method-and-constructor-references)
* [Lesson 6 - Referencing External Variables in Lambda Expressions](#lesson-6---referencing-external-variables-in-lambda-expressions)
* [Lesson 7 - Useful New Methods In JDK 8 That Can Use Lambdas](#lesson-7---useful-new-methods-in-jdk-8-that-can-use-lambdas)

### Lesson 1 - Lambda Expressions
see lesson 1 on [Youtube](https://youtu.be/WXtVHTGDV9g)
	
### Lesson 2 - Lambda Expression Syntax
see lesson 2 on [Youtube](https://youtu.be/DD5IKXx4ZPk)
	
##### Lambdas

- to process data
- to process collection of data
- to take advantage of multiple cores
- lambda expressions simplify how to pass behavior as a parameter

######Why Lambda expressions?
> **To make life easier to write parallel code**
> 
> do you remeber concurrency in Java?
>
>- 1.0 - Threads
>- 5.0 - Concurrent
>- 6.0 - Phasers
>- 7.0 - Fork/join Framework
>- 8.0 - Lambda


######Lambda Expressions are Anonymous Functions
> brackets and braces are optional for certain situations in single statements

```java
( parameters ) -> { lambda-body }
```

######Single line Lambdas
- do not need braces
- do not need an explicit return statement

```java
() -> System.ou.println("Lambda in single line")

x -> x + 10

(int x, int y) -> { return x + y; }

//multiple lines
(String x) -> {
	listA.add(x);
	listB.remove(x);
	return listB.size();
}
```

######Type Inference
> remains strongly, statically typed

Method definition:
```java
	static T process(List<T> l, Comparator<T> c)
```

Use the method:
```java
	List<String> list = getList();
	process(list, (String x, String y) -> x.length() – y.length());
```

Compiler smarter:
```java
	String r = process(list, (x, y) -> x.length() – y.length())
```

### Lesson 3 - Functional Interfaces And Their Definition
see lesson 3 on [Youtube](https://youtu.be/oV6nNR6im6o)

> **There is a single abstract method**
> 
> **The Lambda Expression provides the implementation of the abstract method**

- is an Interface
- **has only one abstract method**
- before jdk8, obvious, only one method
- after jdk8, introduced _default_ methods and allows static methods in interfaces
 - allows multiple **inheritance of _behavior_** for java
- New annotation @FunctionalInterface
 - informative, used to indicate that an interface is intended to be a functional interface. see [java doc](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html) for more info.   

######Examples of Functional Interfaces

```java
interface FileFilter { boolean accept(File x);}	
interface ActionListner { void actionPerformed(...);}
interface Callable<T> { T call(); }
```

**Is this a Functional Interface?**
```java
	@FunctionalInterface
	public interface Comparator {
	   // static and default methods
	  int compare(T o1, T o2);
	  boolean equals(Object obj);
	}
```
**Yes**, it is because: 
```java
	equals(Object obj) //is implicit from the Object class
```
and:
```java
	int compare(T o1, T o2); //is the only one abstract method
```


######Examples of Use Lambda Expressions
> can be used anywhere the type is a functional interface

- Variable assignement
```java
Callable c = () -> process();
```
- Methos parameter
```java	
new Thread( () -> process() ).start();
```

### Lesson 4 - Functional Interfaces in the java.util.function Package
see lesson 4 on [Youtube](https://youtu.be/kKFD9fwcmtk)

> Provides a range of functional interfaces
> 
> Used extensively in Streams
> 
> You will need to define your own extensions to the function package

#####Generic Interfaces

#####Consumer<T>
> Operation that takes a single value and returns no result

```java
	String s -> System.out.println(s)
```

#####BiConsumer<T, U>
> Operation that takes TWO values and returns no result	

```java
	(k, v) -> System.out.println("Key: " + k + ", value: " + v);
```

#####Supplier
> A Supplier of Results, the oposite of Consumer

```java
	() -> createLogMessage()
```

#####Function<T, R>
> Accepts one argument and returns a result

Type of argument and result may be different

Useful static method for composing. Ex.: compose and andThen

```java
	Student s -> s.getName()
```

#####Function<T, U, R>
> accepts two arguments and returns a result. Types can be different.

```java
	(String name, Student s) -> new Teacher(name, student)
```

#####UnaryOperator<T>
> Specialized form of funcion
> Single argument and result of the same type

```java
	- T apply(T a)
	String s -> s.toLowerCase()	
```

#####BinaryOperator<T>
> Specialized form of Bifuncion
> Two arguments and a result all of the same type

```java
- T apply(T a, T b)

	(String a, String x) -> {
		if ( x.length() > y.length) ) 
			return x;
		return y;	
	}
```

#####Predicate
> A Boolean valued Function of one Argument

#####BiPredicate	
> A Boolean valued Function of two Argument

useful default and static methods for combination
- and(), or(), negate(), isEqual()

```java
	Student s -> s.graduationYear() == 2011
```


### Lesson 5 - Method and Constructor References
see lesson 5 on [Youtube](https://youtu.be/CURWqa7KWDk)

#####Method References
let us a reuse a method as a lambda expression
Format: target_reference::methos_name
Three kinds of methos reference

- Static method
- Instance method of arbitary method
- Instance method of an existing object 

```java
	FileFilter x = File f -> f.canRead();

	FileFilter x = File::canRead;
```

Rules for Construction
			
	Lambda				( args ) -> ClassName.staticMethod(args)
	Method References				ClassName::staticMethod(args)

	Lambda				( arg0, rest ) -> arg0.instanceMethod(rest)
							instanceOf	
	Method References				ClassName::instanceMethod

	Lambda				( args ) -> expr.instanceMethod(args)
	Method References				expr::instanceMethod

	
	Examples:
	Lambda				( String s ) -> System.out.println(s)
	Method References				System.out::println

	Lambda				( String s, int i ) -> s.substring(i)
	Method References				String::substring

	Lambda				 Axis a -> getLength(a)
	Method References				this::getLength


#####Contructor Reference		

Same concept as a Method Reference
- For the constructor

```java	
	Factory <List<String>> f = () -> return new ArrayList<String>();

	Factory <List<String>> f = 	ArrayList<String>()::new;
```

### Lesson 6 - Referencing External Variables in Lambda Expressions
see lesson 6 on [Youtube](https://youtu.be/sciFQ_s4cQU)

#####Local Variable Capture

Efectivelly final, a variable that meets the requirements for final variables
Closure on values, not on variables

```java
	void expire(File root, long before){
		root.lisfFiles(File f -> f.lastModified <= before)
	}
```

What does "this" mean in a Lambda 	

- "this" referes to the enclosing object, not the lambda itself
- Thinf of "this" as final predefined local
- Remmember the Lambda is an ANNONYMOUS FUNCTION
	- its not associate with class
	- Therefore there can be on "this" for the Lambda

#####Referencing Instance Variable
	
Which are not final, or effectively final

```java
	class DataProcessor{
		private int currentValue;

		public void process(){
			DataSet myData = myFactory.getDataSet();
			dataSet.forEach( d -> d.use( currentValue++ ) );
		}
	}
```

### Lesson 7 - Useful New Methods In JDK 8 That Can Use Lambdas
see lesson 7 on [Youtube](https://youtu.be/olKF7VpJMfg)

Useful New Methods in JDK 8 That can use Lambda

##### Iterable Interface

```java
	Itarable.forEach(Consumer c)

	List<String> myList = ...
	myList.forEach(s -> System.out.println(s));

	//simplefied form, method reference
	myList.forEach(s -> System.out::println);
```

##### Collection Interface

```java
	Collection.removeIf(Predicate p)

	List<String> myList = ...
	myList.removeIf(s -> s.length() == 0);
```

##### List Interface

```java
	List.replaceAll(UnaryOperator o)

	List<String> myList = ...
	myList.replaceAll(s -> s.toUpperCase());

	myList.replaceAll(String::toUpperCase);

	List.sort(Comparator c)
		Replaces Collections.sort(List l, Comparator c)

	List<String> myList = ...
	myList.sort( (x, y) -> x.length() - y.length() );
```

##### Logger Class

```java
	logger.finest(createComplexMessage());
```

	New Methos in Logger Class

		- Takes a Supplier as an argument ( which is a functional interface )

	Simple change to code has big impact on performance
				
```java
	logger.finest( () -> createComplexMessage());
```

We now pass HOW to create the message, not the actual message


##STREAMS

* [Lesson 2.1 - Introducion to Stream API](#lesson-2.1---introducion-to-stream-api)

#####STREAMS


### Lesson 2.1 - Introducion to Stream API
see lesson 2.1 on [Youtube](https://youtu.be/IgQ7yTh5LJY)

> bring funcional style to java
> exploit hardware parallelism - "explicit but unobstrusive"
> intention: replace loops for aggregate operations
> > more concise, readable, composable operations, parallelizable


##### Function Programming Concepts

		Imperative Programming (Names and Values)
		> The same name may be associated with different values

			Use variables to provide an association between names and values
			Use sequence of commands
				Each command consists of an assignment
				Can change variable's value 
				Form is <var_name> = <expression>
				Expressions can refer to other variables
				Values can therefore be passed from command to command
				Commands may be repated through loops	

		Functional Programming (Names and Values)
		> A name is only ever associated with one value

			Based on structured function calls
			Function call which calls other functions in turn (composition)
			```java
				<function1>(<function2>(<function3> ... ) ... )
			```
			Each function receive values from and passes values back the calling function
			Names are only used as formal parameters, once value is assigned it can be changed
			No concept of a command, as used in imperative code, therefore no concept of repetition

##### Execution Order			

		Imperative
			values associated with names can be changed
			the order of execution of commands forms a contrat, if it's changed, the behavior of app may change
		
		Functional
			values associated with names can not be changed
			the order of execution does not impact the results
			there is no fixed execution order

##### Repetition
		
		Imperative
			values associated with names may be changed by commands
			commands may be repeated leading to repeated changes
			new values may be associated with the same name through repetition (loops)
		
		Functional
			values associated with names may not be changed
			repeated changes are achieved by nested function calls
			new values may be associated with the same name through recursion

##### Functions as Values

		lambda expressions allows functions to be trated as values
		make this much simpler than anonymous inner classes

### Lesson 2.2 - Elements of Stream
see lesson 2.2 on [Youtube](https://youtu.be/J4clzago_IM)

##### Stream Overview

	Abstraction for specifying aggregate computations
		- not a data structure
		- can be infinite
		- there is no concept of a loop, is not possible to break out the stream

	Simplifying the description of aggregate computations
		expose opportunities for optimization
		fusing, laziness and parallelism


	Think as like a representation of a PIPELINE
		
		consists of three types
		a source
		zero or more intermediate operations
		a terminal operation, that produces a result or a side-effect

		```java
			// stream() is the Source
			// .filter() and .mapToInt are the intermediate operations
			// .sum() is the terminal operation

			int total = transactions.stream()
				.filter(t -> t.getBuyer().getCity.equals("London"))
				.mapToInt(Transaction::getPrice)
				.sum();
		```

##### Stream Terminal Operations
	
	Papeline is only evaluated when the terminal operations is called
		- all operations can execute sequentially or in parallel
		- intermediate operatins can be merged
		- Stream characteristics help identify optimisations
			- DISTINCT stream passed to distinct() is a no-op

### Lesson 2.3 - Streams of Objects and Primitive Types
see lesson 2.3 on [Youtube](https://youtu.be/O9tajXDd9IU)

> java language is not truly object oriented
> primitive types are included
> > byte, short, int, long, double, float and char
> for more situations these are wrapped as objects
> conversion between primitive and object is often handled by auto-boxing and unboxing

##### Object Stream

> by default, a stream produces elements that are objects
> sometimes, this is not be best solution

```java
	int highScore = students.stream()
		.filter( s -> s.graduationYear() == 2015 )
		.map( s -> s.getScore() )
		.max();
```


##### Primitive Streams

> to avoid a lot of unnecessary object creation we have three primitive stream types
> > IntStream, DoubleStream and LongStream
> these can be used with certain stream operations

```java
	int highScore = students.stream()
		.filter( s -> s.graduationYear() == 2015 )
		.mapToInt( s -> s.getScore() ) // with mapToInt, no oxing or unboxing are necessary
		.max();
```


### Lesson 2.4 - Streams Sources in JDK 8
see lesson 2.4 on [Youtube](https://youtu.be/pbtFL7T_HLw)

##### JDK 8 Libraries
> 95 methods in 23 classes that return a stream
> > many of them, intermediate operations in the Stream interface
> 71 methods in 15 classes can be used as practical Stream sources

##### Collection Interface
- stream()
	+ provides a sequencial of elements in the collection
- parallelStream()
	+ provides a parallel stream of elements in the collection
	+ Uses the [fork-join framework](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html) implementation

##### Arrays Class
- stream()
	+ An array is a collection of data, so logical to be able to create a stream
	+ provides a sequencial strema
	+ overloded methods for different types
		* double, int, long and Object

##### Files Class
- find(Path, BiPredicate, FileVisitOption)
	+ a stream of File references that match a given BiPredicate
- list(Path)
	+ a stream of entries from a given directory
- lines(Path)
	+ a stream of strings that are the lines read from a given file
- walk(Path, FileVisitOption)
	+ a stream of File references walking from a given Path

##### Random Numbers
> generating infinite streams
- three random related classes 
	+ Random, ThreadLocalRandom and SplittableRandom
- methods to produce finite or infinite streams of random numbers
	+ ints(), doubles() and longs()
	+ four versions of each
		finite or infinite
		with and without seed

##### Miscellaneous Classes and Methods
- JarFile/ZipFile: stream()
	+ returns a file stream of contents of the compressed archive
- BufferedReader: lines()
	+ returns a steam of strings that are the lines read from the input
- Pattern: splitAsStream()
	+ retunrs a stream of strings of matches of a pattern
	+ like split(), but returns a stream rather than an array
- CharSequence
	+ chars(): chars values as ints for the sequence
	+ codePoints(): code point values for this sequence
- BitSet
	+ stream(): indices of bits that are set

##### Stream Static Methods
> IntStream, DoubleStream and LongStream

- these interfaces are primitive specialisations of the Stream interface
- concat(Stream, Stream), empty()
	+ concatenates two specified streams, returns an empty stream
- of(T... values)
	+ a stream that consists of the specified values
- range(int, int), rangeClosed(int, int)
	+ a stream from a star to an end value (exclusive or inclusive)
- generate(IntSupplier), iterate(int, IntUnaryOperator)
	+ an infinite stream created by a given Supplier
	+ iterate() uses seed to start the stream











				