#JDK 8 MOOC Functional Programming in Java with Lambdas and Streams

Here I'll take some notes about [Lambdas and Streams Introduction](https://apexapps.oracle.com/pls/apex/f?p=44785:141:105593264740337::NO::P141_PAGE_ID,P141_SECTION_ID:250,1807) the online course provided by [Simon Ritter](https://github.com/speakjava).

[1. Lambdas](#1-lambdas)

[2. Streams](#2-streams)

[3. Advanced Lambda and Stream Concepts](#3-advanced-lambda-and-stream-concepts)

---
##1. Lambdas

* [Lesson 1.1 - Lambda Expressions](#lesson-11---lambda-expressions)
* [Lesson 1.2 - Lambda Expression Syntax](#lesson-12---lambda-expression-syntax)
* [Lesson 1.3 - Functional Interfaces And Their Definition](#lesson-13---functional-interfaces-and-their-definition)
* [Lesson 1.4 - Functional Interfaces in the java.util.function Package](#lesson-14---functional-interfaces-in-the-javautilfunction-package)
* [Lesson 1.5 - Method and Constructor References](#lesson-15---method-and-constructor-references)
* [Lesson 1.6 - Referencing External Variables in Lambda Expressions](#lesson-16---referencing-external-variables-in-lambda-expressions)
* [Lesson 1.7 - Useful New Methods In JDK 8 That Can Use Lambdas](#lesson-17---useful-new-methods-in-jdk-8-that-can-use-lambdas)

### Lesson 1.1 - Lambda Expressions
see lesson 1.1 on [Youtube](https://youtu.be/WXtVHTGDV9g)
	
### Lesson 1.2 - Lambda Expression Syntax
see lesson 1.2 on [Youtube](https://youtu.be/DD5IKXx4ZPk)
	
##### Lambdas

- to process data
- to process collection of data
- to take advantage of multiple cores
- lambda expressions simplify how to pass behavior as a parameter

######Why Lambda expressions?
> **To make life easier to write parallel code**
> 
> do you remember concurrency in Java?
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
() -> System.out.println("Lambda in single line")

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

### Lesson 1.3 - Functional Interfaces And Their Definition
see lesson 1.3 on [Youtube](https://youtu.be/oV6nNR6im6o)

> **There is a single abstract method**
> 
> **The Lambda Expression provides the implementation of the abstract method**

- is an Interface
- **has only one abstract method**
- before jdk8, obvious, only one method
- after jdk8, introduced _default_ methods and allows static methods in interfaces
 - allows multiple **inheritances of _behavior_** for java
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

- Variable assignment
```java
Callable c = () -> process();
```
- Methos parameter
```java	
new Thread( () -> process() ).start();
```

### Lesson 1.4 - Functional Interfaces in the java.util.function Package
see lesson 1.4 on [Youtube](https://youtu.be/kKFD9fwcmtk)

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
> A Supplier of Results, the opposite of Consumer

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
> Specialized form of function
> Single argument and result of the same type

```java
	- T apply(T a)
	String s -> s.toLowerCase()	
```

#####BinaryOperator<T>
> Specialized form of Bifunction
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


### Lesson 1.5 - Method and Constructor References
see lesson 1.5 on [Youtube](https://youtu.be/CURWqa7KWDk)

#####Method References
let us a reuse a method as a lambda expression
Format: target_reference::method_name
Three kinds of methods reference

- Static method
- Instance method of arbitrary method
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

### Lesson 1.6 - Referencing External Variables in Lambda Expressions
see lesson 1.6 on [Youtube](https://youtu.be/sciFQ_s4cQU)

#####Local Variable Capture

Effectively final, a variable that meets the requirements for final variables
Closure on values, not on variables

```java
	void expire(File root, long before){
		root.lisfFiles(File f -> f.lastModified <= before)
	}
```

What does "this" mean in a Lambda 	

- "this" refers to the enclosing object, not the lambda itself
- Think of "this" as final predefined local
- Remember the Lambda is an ANNONYMOUS FUNCTION
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

### Lesson 1.7 - Useful New Methods In JDK 8 That Can Use Lambdas
see lesson 1.7 on [Youtube](https://youtu.be/olKF7VpJMfg)

Useful New Methods in JDK 8 That can use Lambda

##### Iterable Interface

```java
	Itarable.forEach(Consumer c)

	List<String> myList = ...
	myList.forEach(s -> System.out.println(s));

	//simplified form, method reference
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


---
##2. STREAMS

* [Lesson 2.1 - Introduction to Stream API](#lesson-21---introduction-to-stream-api)
* [Lesson 2.2 - Elements of Stream](#lesson-22---elements-of-stream)
* [Lesson 2.3 - Streams of Objects and Primitive Types](#lesson-23---streams-of-objects-and-primitive-types)
* [Lesson 2.4 - Streams Sources in JDK 8](#lesson-24---streams-sources-in-jdk-8)
* [Lesson 2.5 - Stream Interface: Intermediate Operations](#lesson-25---stream-interface-intermediate-operations)
* [Lesson 2.6 - Stream Interface: Terminal Operations](#lesson-26---stream-interface-terminal-operations)
* [Lesson 2.7 - The Optional Class](#lesson-27---the-optional-class)

#####STREAMS

### Lesson 2.1 - Introduction to Stream API
see lesson 2.1 on [Youtube](https://youtu.be/IgQ7yTh5LJY)

> bring functional style to java
> 
> exploit hardware parallelism - "explicit but unobtrusive"
> 
> intention: replace loops for aggregate operations
> > more concise, readable, composable operations, parallelizable


##### Functional Programming Concepts

_Imperative Programming (Names and Values)_
> The same name may be associated with different values

- Use variables to provide an association between names and values
- Use sequence of commands
	+ Each command consists of an assignment
	+ Can change variable's value 
	+ Form is _<var_name>_ = _<expression>_
	+ Expressions can refer to other variables
	+ Values can therefore be passed from command to command
	+ Commands may be repeated through loops	

_Functional Programming (Names and Values)_
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

_Imperative_

values associated with names can be changed
the order of execution of commands forms a contract, if it's changed, the behavior of app may change

_Functional_

values associated with names can not be changed
the order of execution does not impact the results
there is no fixed execution order

##### Repetition
		
_Imperative_

values associated with names may be changed by commands
commands may be repeated leading to repeated changes
new values may be associated with the same name through repetition (loops)
		
_Functional_

values associated with names may not be changed
repeated changes are achieved by nested function calls
new values may be associated with the same name through recursion

##### Functions as Values

lambda expressions allows functions to be treated as values
make this much simpler than anonymous inner classes

### Lesson 2.2 - Elements of Stream
see lesson 2.2 on [Youtube](https://youtu.be/J4clzago_IM)

##### Stream Overview

- Abstraction for specifying aggregate computations
	+ not a data structure
	+ can be infinite
	+ there is no concept of a loop, is not possible to break out the stream

- Simplifying the description of aggregate computations
	+ expose opportunities for optimization
	+ fusing, laziness and parallelism
		
- Think as like a representation of a PIPELINE
	+ consists of three types
		* a source
		* zero or more intermediate operations
		* a terminal operation, that produces a result or a side-effect

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

> Pipeline is only evaluated when the terminal operations is called

- all operations can execute sequentially or in parallel
- intermediate operations can be merged
- Stream characteristics help identify optimisations
	+ DISTINCT stream passed to distinct() is a no-op

### Lesson 2.3 - Streams of Objects and Primitive Types
see lesson 2.3 on [Youtube](https://youtu.be/O9tajXDd9IU)

> java language is not truly object oriented
> 
> primitive types are included
> > byte, short, int, long, double, float and char
> 
> for more situations these are wrapped as objects
> 
> conversion between primitive and object is often handled by auto-boxing and unboxing

##### Object Stream

> by default, a stream produces elements that are objects
> 
> sometimes, this is not be the best solution

```java
	int highScore = students.stream()
		.filter( s -> s.graduationYear() == 2015 )
		.map( s -> s.getScore() )
		.max();
```


##### Primitive Streams

> to avoid a lot of unnecessary object creation we have three primitive stream types
> > IntStream, DoubleStream and LongStream
> 
> these can be used with certain stream operations

```java
	int highScore = students.stream()
		.filter( s -> s.graduationYear() == 2015 )
		.mapToInt( s -> s.getScore() ) // with mapToInt, no boxing or unboxing are necessary
		.max();
```


### Lesson 2.4 - Streams Sources in JDK 8
see lesson 2.4 on [Youtube](https://youtu.be/pbtFL7T_HLw)

##### JDK 8 Libraries
> 95 methods in 23 classes that return a stream
> > many of them, intermediate operations in the Stream interface
> 
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
	+ provides a sequencial stream
	+ overloaded methods for different types
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
		* finite or infinite
		* with and without seed

##### Miscellaneous Classes and Methods
- JarFile/ZipFile: stream()
	+ returns a file stream of contents of the compressed archive
- BufferedReader: lines()
	+ returns a stream of strings that are the lines read from the input
- Pattern: splitAsStream()
	+ returns a stream of strings of matches of a pattern
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

### Lesson 2.5 - Stream Interface: Intermediate Operations 
see lesson 2.5 on [Youtube](https://youtu.be/2eIr0U78_gA)
> represents aggregate operations on elements
> 
> most methods can use Lambda Expressions to define behaviour
> 
> powerfull range of intermediate operations allow streams to be manipulated as required

- stream provide a sequence of elements
	+ supporting either sequencial or parallel aggregate operations
- most operations take a parameter that describes its behaviour
	+ typically using lambda expressions
	+ must be non-interfering (does not modify the stream)
	+ typically stateless
- streams may be changed from sequencial to parallel (and vice-versa)
	+ all processing is done either sequencially or in parallel
	+ last call wins

##### Filtering and Mapping
- distinct()
	+ returns a stream with no duplicate elements
- filter(Predicate p)
	+ returns a stream with only those elements that return true for the Predicate 
- map(Function f)
	+ return a stream where the give function is applied to each element on the input stream
- mapToInt(), mapToDouble() and mapToLong()
	+ like map(), but producing streams of primitives rather than objects

##### Maps and FlatMaps
> Map values in a stream

- Map
	+ 1-to-1 mapping
	+ input stream -> output stream
- FlatMap
	+ 1-to-many mapping
	+ input stream -> many maps -> output stream
	+ FlatMap example: Words in a File

```java
 	List<String> output = reader
 		.lines()
 		.flatMap( line -> Stream.of( line.split( REGEXP ) ) )
 		.filter( word -> word.length() > 0 )
 		.collect( Collectors.toList() );
```

##### Restricting the size of a Stream
- skip(long n)
	+ returns a stream that _skips the first n_ elements of the input stream
- limit(long n)
- 	returns a stream that _only contains the first n_ elements of the input stream  
```java
	String output = bufferedReader
		.lines()
		.skip(2)
		.limit(2)
		.collect( Collectors.joining() );
```

##### Sorting and Unsorting
- sorted( Comparator c )
	+ returns a stream that is sorted with the order determined by the Comparator
	+ sorted() with no arguments sorts by natural order
- unordered()
	+ inherited from BaseStream
	+ returns a stream that is unordered (used internally)
	+ can improve efficiency of operations like distinct() and groupingBy()

##### Observing Stream Elements
> as they go past

- peek( Consumer c )
	+ returns an output stream that is identical to the input stream
	+ each elements is passed to the accept() method of the Consumer
	+ the Consumer most not modify the elements of the stream
	+ useful for debbugin and doing more than one thing with a stream

### Lesson 2.6 - Stream Interface: Terminal Operations 
see lesson 2.6 on [Youtube](https://youtu.be/4jjXu8A6cuY)

- terminates the pipeline of operations on the stream
- only at this point is any processing performed
	+ this allows for optimisations of the pipeline
		* lazy evaluation
		* merge/fused operations
		* eliminations of redundant operations
		* parallel execution
- generate a explicit result or a side efect

##### Matching Elements
- findFirst(Predicate p)
	+ the first element that matches using the give Predicate
- findAny(Predicate p)
	+ works the same way as finFirst(), but for a parallel stream
- boolean allMatch(Predicate p)
	+ whether all elements of the stream match using the Predicate
- boolean anyMatch(Predicate p)
	+ whether any elements of the stream match using the Predicate
- boolean noneMatch(Predicate p)
	+ whether no elements match using the Predicate

##### Collecting Results
- collector(Collector c)
	+ performs a mutable reduction on the stream
- toArray()
	+ returns an array containing the  elements of the stream

##### Numerical Results

> Object Stream

- count()
	+ return how many elements are in the stream
- max(Comparator c)
	+ the maximum value element of the stream using the Comparator
	+ return an Optional, since the stream may be empty
- min(Comparator c)
	+ the minimum value element of the stream using the Comparator
	+ return an Optional, since the stream may be empty

> Primitive Type Streams (IntStream, DoubleStream and LongStream)

- average()
	+ return the arithmetic mean of the stream
	+ returns an Optional, as the stream may be empty
- sum()
	+ returns the sum of the stream elements

##### Iteration
- forEach( Consumer c )
	+ performs an action for each element of this stream
- forEachOrdered(Consumer c )
	+ like forEach, but ensures that the order of the elements (if one exists) is respected when used for a parallel stream

##### Folding a Stream
> creating a single result from multiple input elements

- reduce( BinaryOperator accumulator )
	+ performs a reduction on the stream using a BinaryOperator
	+ the accumulator takes a partial result and the next element, returns a new partial result
	+ returns an Optional 
	+ two other versions
		* takes a initial value (does not return an Optional)
		* takes a initial value and BiFuction (equivalent to a fused map and reduce)

### Lesson 2.7 - The Optional Class 
see lesson 2.7 on [Youtube](https://youtu.be/HwxFhHsGneo)

##### Avoiding NullPointerExceptions
```java
	String direction = gpsData.getPosition().getLatitude().getDirection();
```
_And if gpsData or gpsData.getPosition() or gpsData.getLatitude() return a null?_

_pLá!!!!_ NullPointerExceptions for you!

maybe this way?
```java
	String direction = "UNKNOWN";

	if (gpsData != null) {
		Position p = gpsData.getPosition();

		if (p != null) {
			Latitude latitude = p.getLatitude();

			if (latitude != null) {
				direction = latitude.getDirection(); 
			}
		}
	}

```

good, but now we have the Optional Class

##### Optional Class
> helping to eliminate the NullPointerException

- terminal operations like min() and max() may not return a direct result 
	+ suppose the input stream is empty?
- Optional<T>
	+ container for another object reference (null or real object)
	+ think of it like a stream of 0 or 1 elements
	+ guaranteed that the Optional reference returned will not be null

##### Optional ifPresent()
> do something when set

```java
	//before
	if (x != null) {
		print(x);
	}

	//now, with Optional
	opt.ifPresent( x -> print(x) );

	// with method reference
	opt.ifPresent(this::print);

```

##### Optional filter()
> reject certain values of the Optional

```java
	//before
	if (x != null && x.contains("a")) {
		print(x);
	}

	opt.filter( x -> x.contains("a") )
		.ifPresent(this::print);

```

##### Optional map()
> transform value if present

```java
	//before
	if (x != null) {
		String t = x.trim();
		if (t.lenght() > 0) {
			print(t);
		}
	}

	opt.map( String::trim )
		.filter( t -> t.lenght() > 0)
		.ifPresent( this::print );

```

##### Optional flatMap()
> further

```java
	public String findSimilar(String s)

	Optional<String> tryFindSimilar(String s)

	Optional<Optional<String>> bad = opt.map(this::tryFindSimilar);

	Optional<String> similar = opt.flatMap(this::tryFindSimilar);

```

##### Updating or GPS code

```java
	class GPSData {
		public Optional<Position> getPosition {...}
	}

	class Position {
		public Optional<Latitude> getLatitude {...}
	}

	class Latitude {
		public String getDirection {...}
	}


	String direction = Optional
		.ofNullable(gpsData) // reference could be null
		.flatmap(GPSData::getPosition) //return an Optional
		.flatMap(Position::getLatitude)	//return an Optional
		.map(Latitude::getDirection) //returns a String
		.orElse("None"); // if is null, return None otherwise the value

```

---
##3. Advanced Lambda and Stream Concepts

* [Lesson 3.1 - Understanding and Using Reductions](#lesson-31---understanding-and-using-reductions)
* [Lesson 3.2 - Finite and Infinite Streams](#lesson-32---finite-and-infinite-streams)
* [Lesson 3.3 - Avoiding the use of forEach](#lesson-33---avoiding-the-use-of-forEach)
* [Lesson 3.4 - Using Collectors](#lesson-34---using-collectors)
* [Lesson 3.5 - Parallel Streams (and when not use them)](#lesson-35---parallel-streams-and-when-not-use-them)
* [Lesson 3.6 - Debbuging Lambdas and Streams](#lesson-36---debbuging-lambdas-and-streams)
* [Lesson 3.7 - Conclusions](#lesson-37---conclusions)


### Lesson 3.1 - Understanding and Using Reductions
see lesson 3.1 on [Youtube](https://youtu.be/tTiI_ibmpcM)

- reduction take a stream and reduces it to a single value
- the way the reduction works is defined by accumulator
	+ which is a BinaryOperator
	+ the accumulator is applied successively to the stream elements
	+ the reduce() method maintains a partial result state
	+ like a recursive approach, but without the resource overhead
- requires you to think differently to an imperative, loop based approach

##### A Simple Problem

- Find the *length of the longest line* in a file

```java
	Path input = Paths.get("lines.txt");

	int longestLineLength = Files.lines(input)
		.mapToInt(String::length)
		.max()
		.getAsInt();
```

##### Another Simple Problem

- Find the *longest line* in a file

*Naive Stream Solution*
	
```java
	int longest = Files.lines(input)
		.sort( ( x, y ) -> y.length() - x.length() )
		.findFirst()
		.get();
```
- _Big files will take a long time and a lot of resources_

*External Iteration Solution*
	
```java
	String longest = "";

	while( ( String s = reader.readLine() ) != null )
		if ( s.length() > longest.length() )
			longest = s;
```
- _Simple, but inherently serial_
- _Not thread safe due to mutable state_
- _Not functional_

*Recursive Approach*

```java
	String findLongestString(String s, int index, List<String> l) {

		....
		String s2 = findLongestString(l.get(index), index + 1, l);
		....
	}


	List<String> lines = new ArrayList<>();

	while( ( String s = reader.readLine() ) != null )
		lines.add(s);

	String longest = findLongestString("", 0, lines);	

```

- _Not explicit loop, no mutable state, so we now have a functional solution_
- _Unfortunately not a usable one_
	+ larger data sets will generate an OutOfMemoryException

*A better Stream Solution*
- the Stream API uses the well known filter-map-reduce pattern
- for this problem we do not need to filter() or map(), just reduce()
- reduce method definition
```java
	Optional<T> reduce(BinaryOperation<T> accumulator) 
```
- the key is to find the right accumulator
	+ recall the accumulator takes a partial result and the next element, and returns a new partial result
	+ in essence it does the same as our recursive solution
	+ without all the stack frames
- use the recursive approach as an accumulator for a reduction
```java
	String longestLine = Files.lines(input)
		.reduce( ( x, y ) -> {
			if ( x.length() > y.length() )
				return x; // x in effect maintains state, by always holding the longest string found so far
			return y;	
		})
		.get();
```

*The Simplest Stream Solution*
- use a specialised form of max()
- one that takes a Comparator as a parameter
```java
	Files.lines(input)
		.max( comparingInt( String::length ) )
		.get();
```
- comparingInt() is a static method on Comparator
```java
	Comparator<T> comparingInt( ToIntFunction<? extends T> keyExtractor )
```

### Lesson 3.2 - Finite and Infinite Streams
see lesson 3.2 on [Youtube](https://youtu.be/bt5MIkrYgzM)

- streams can be finite as well as infinite
- there is no concept of breaking out of a stream
- use terminal operator to stop processing
- or use infinite stream infinitely

##### Dealing with the Indeterminate
> imperative java

- how to continue processing when we can`t predict for how long?
```java
	while ( true ){
		doSomeProcessing();

		if ( someCriteriaIsTrue() )
			break;
		// loop repeats indefinitely	
	}
```

##### Using Infinite Streams
> making the Stream finite

- terminate the Stream when a condictions is met
	+ findFirst( Predicate p ), works with sequencial and parallel streams
	+ findAny( Predicate p ), work with parallel streams
```java
	int r = Random.ints() //infinite stream of random integers
		.findFirst( i -> i > 256 ); //stream terminates when a number os gratter than 256
```

> keeping it infinite

- sometimes we need to continue to use a stream indefinitely
- what terminal operation should we use for this?
	+ _*use forEach()*_
	+ this consumes the element from the stream
	+ but does not terminate it

> infinite example

- reading a temperature from a serial sensor
	+ converting from fahrenheit to celcius, removing F
	+ notifying a listener of changes if registered
```java
	thermalReader.lines()
		.mapToDouble( s -> 
			Double.parseDouble( s.substring( 0, s.length() - 1 ) ) )
		.map( t -> ( ( t - 32 ) * 5 / 9 ) )
		.filter( t -> currentTemperature.equals(t) )
		.peek( t -> listner.ifPresent( l -> l.temperatureChanged(t) ) )
		.forEach( t -> currentTemperature.set(t) );	
```

### Lesson 3.3 - Avoiding the use of forEach
see lesson 3.3 on [Youtube](https://youtu.be/WiDWt5TjY4E)

- if you are thinking of using forEach(), stop!
- can it be replaced with a combination of mapping and reducing?
- if so, it is unlikely to be right approach to be functional
- certain situations are valid for using forEach()
	+ printing values from the stream

##### Using Streams Effectively

> Stop thinking imperatvely

- imperative programming uses loops for repetitive behaviour
- it also use variables to hold state
- we can continue to do that in some ways with streams 
- _THIS IS WRONG_

> still thinking Imperatively

_sum all the values on some list_
```java
	List<Transactions> transactions = ....

	LongAdder transactionTotal = new LongAdder(); // designed on Java 8 for frequently updates and reads operations

	transactions.stream()
		.forEach( t -> transactionTotal.add( t.getValue() ) ); 
		// transactionTotal.add( t.getValue() ) -- we are modifying state wich is wrong for a functional approach

	long total = transactionTotal.sum();	
```

> the correct Functional Approach

```java
	List<Transactions> transactions = ....

	long total = transactions.stream()
		.mapToLong( t -> t.getValue() ) // create a stream of long values that is passed to the next function
		.sum(); // use a reduction to create a single result
```


> Legitimate use of forEach, no state being modified

- simplified iteration
- may be made parallel _if order is not important_

```java
	List<Transactions> transactions = ....

	transactions.stream()
		.forEach( t -> t.printClientName() );
```

### Lesson 3.4 - Using Collectors
see lesson 3.4 on [Youtube](https://youtu.be/1xWUiMH_rh0)

- a Collector performs a mutable reduction on a stream
	+ accumulate inputs elements into a mutable result container
	+ result container can be a List, Map, String etc
- use the collect() method to terminate the stream
- Collectors utility class has many methods that can create a Collector

##### Composing Collectors

- several Collectors methods have versions with a downstrea collector
- allows a second collector to be used
	+ collectingAndThen()
	+ groupingBy() / groupingByConcurrent()
	+ mapping()
	+ partitioningBy()

##### Collecting into a Collection

- toCollection(Supplier factory)
	+ adds the elements of the stream to a Collection ( created using factory )
	+ uses encounter order
- toList()
	+ adds the elements of the stream to a List
- toSet()
	+ adds the elements of the stream to a Set
	+ eliminates duplicates	 

##### Collecting to a Map

- toMap( Function keyMapper, Function valueMapper )
	+ creates a Map from elements of the stream
	+ key and value produced using provided functions
	+ use Function.identify() to get the stream element

```java
	Map<Student, Double> studentScore = students.stream()
		.collect( toMap( Functions.identify(), student -> getScore( student ) ) );
```

> handling duplicated keys


```java
	toMap( Function keyMapper, Function valueMapper , BinaryOperator merge);
```

- the same process as first toMap() method
	+ but uses BinaryOperator to merge values for duplicated keys


```java
	Map<String, String> occupants = people.strema()
		.collect( toMap( Person::getAddress, Person::getName, ( x,y ) -> x + "," + y )); //people at the same address are merged into a CSV string
```


##### Grouping results

- groupingBy( Function )
	+ Groups stream elements using the Function into a Map
	+ result is Map<K, List<V>>

```java
	Map m = words.stream()
		.collect( Collectors.groupingBy( String::length ));
```

- groupingBy( Function, Collector )
	+ Groups stream elements using the Function
	+ a reduction is performed on each group using the downstream Collector

```java
	Map m = words.stream()
		.collect( Collectors.groupingBy( String::length, counting() ));
```

##### Joining String results

- joining()
	+ collector concatenates input strings
- joining( delimiter )
	+ collector concatenates stream using CharSequence delimiter

```java
	collect( Collectors.joining(",") ); //create CSV
```

- joining( delimiter, prefix, suffix )
	+ collector concatenates the prefix, stream strings separated by delimiter and suffix

##### Numeric Collectors
> also available in Double and Long forms

- averagingInt( toIntFunction )
	+ averages the results generated by the supplied function
- summarizingInt( toIntFunction )
	+ summarises ( count, sum, min, max, average ) results generated by supplied function
- summingInt( toIntFunction )
	+ equivalent to a map() then sum()
- maxBy( Comparator ), minBy( Comparator )
	+ maximum or minimum value based on Comparator

##### Other Collectors

- reducing( BinaryOperator )
	+ equivalent Collector to reduce() terminal operation
	+ only use for multi-level reductions, or downstream collectors
- partitioningBy( Predicate )
	+ creates a Map<Boolean, List> containig two groups based on Predicate
- mapping( Function, Collector )
	+ adapts a Collector to accpet diferent type elements mapped by the Function

```java
	Map<City, Set<String>> lastNamesByCity = people.stream()
		.collect( groupingBy( Person::getCity, mapping( Person::getLasName, toSet() ) ) );
```

### Lesson 3.5 - Parallel Streams (and when not use them)
see lesson 3.5 on [Youtube](https://youtu.be/lFNnpfMBiCE)

- streams can be processed sequentially or in parallel
	+ the whole stream is processed in sequentially or in parallel
	+ in most cases how the stream is defined will not affect the result
	+ findFirst(), findAny(), forEach(), forEachOrdered() do
- don't assume that a parallel stream will return a result faster
	+ many factors affect performance

##### Serial and Parallel Streams

- Collection stream sources
	+ stream()
	+ parallelStream()
- stream can be made parallel or sequential at any point
	+ parallel()
	+ sequential()
- that last call wins
	+ whole stream is either sequential or parallel
- calling concat() with a sequential and parallel stream will produce a parallel stream

##### Parallel Streams

- implemented internally using the fork-join framework
- will default to as many threads for the pool as the OS reports processors
	+ which may not be what you want

```java
	System.setProperty( "java.util.concurrent.ForkJoinPool.common.parallelism", "32767");
```
- remember, parallel streams always need more work to process
	+ but they might finish it more quickly

> considerations

- findFirst() and findAny()
	+ findAny() is non-deterministic, so better for parallel stream performance
	+ use findFirst() if a deterministic result is required
- forEach() and forEachOrdered()
	+ forEach() is non-deterministic for a parallel stream and ordered data
	+ use forEachOrdered() if a deterministic result is required

##### When to use Parallel Streams
> no simple answer

- data set size is important, as is the type of data structure
	+ ArrayList:		GOOD
	+ HashSet, TreeSet:	OK
	+ LinkedList:		BAD
- operations are also important
	+ certain operations decompose to parallel tasks better than others 
	+ filter() and map() are excellent
	+ sorted() and distinct() do not decompose well

> quantitative considerations

- N = size of the data set
- Q = cost per element through the stream pipeline
- N x Q = total cost of pipeline operations
- the bigger N x Q is the better a parallel stream will perform
- it is easier to know N than Q , but Q can be estimated
- if in doubt, profile

### Lesson 3.6 - Debbuging Lambdas and Streams
see lesson 3.6 on [Youtube](https://youtu.be/krLTMstEYOo)

##### Problems with Debbuging Streams

- Streams provide a high level abstraction
	+ this is good for making code clear and easy to understand 
	+ this is bad for debbuging
		* a lot happens internally in the library code
		* setting breakpoints is not simple
		* streams operations are merged to improve efficiency

##### Simple Debbuging

- use peek()
	+ like the use of print statements

```java
	List<String> sortedWords = reader.lines()	//lines from file
		.peek( System.out::println)	// print lines
		.flatMap( line -> Stream.of( line.split( REGEXP ) ) ) //words from file
		.map( String::toLowerCase ) //in lower case
		.distinct() // remove duplicates
		.sort( (x, y) -> x.length() - y.length() ) // sort by length
		.collect( Collectors.toList() );	// collect to list
```

##### Setting a breakpoint

- add a peek() method call between stream operations
- use Consumer that does nothing if required
	+ some debbuging tools don't like empty bodies
```java
	List<String> sortedWords = reader.lines()	//lines from file
		.flatMap( line -> Stream.of( line.split( REGEXP ) ) ) //words from file
		.peek( s -> s)	// set breakpoint here		
		.map( String::toLowerCase ) //in lower case
		.distinct() // remove duplicates
		.sort( (x, y) -> x.length() - y.length() ) // sort by length
		.collect( Collectors.toList() );	// collect to list
```

> using a method reference

- lambda expressions do not compile to equivalent inner class
	+ compiled to invokedynamic call
	+ implementation decided at runtime
	+ better chance of optimisation, makes debugging harder
- solution
	+ extract the code from a lambda expression into a separete method
	+ replace the lamba with a method reference for the new method
	+ set breakpoints on the statements in the new method
	+ examine program state using debugger


### Lesson 3.7 - Conclusions
see lesson 3.7 on [Youtube](https://youtu.be/QnNySqVZse0)

##### Lambda Expressions

- give us a simple way to _define behaviour_
	+ can be assigned to a variable or passed as a parameter
- can be used wherever the type is a *functional interface*
	+ one that *has only one abstract method*
	+ the lambda expression provides an implementation of the abstract method

##### Stream API

- pipeline of operations to process collections of data
	+ multiple sources, not just from the Collections API
	+ cab be processed sequentially or in parallel
- sources, intermediate and terminal operations
- behaviour of intermediate and terminal operations often defined using lambda expressions
- terminal operations often return a Optional 
- we can now use a functional style of programming in java

##### Lambda and Streams: Think Differently

- need to think functional rather than imperative
	+ try to stop thinking in loops and using mutable state
- think of how to approach problems usgin recursion
	+ rather than a explicit loop
	+ avoid forEach( except for special cases )
- infinite streams don't need to be infinite
- remember, parallel streams always involve more work
	+ sometimes they complete the work quicker


That is all folks! Feel free to share and contribute.
Thanks!