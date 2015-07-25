
#JDK 8 MOOC Functional Programming in Java with Lambdas and Streams

Here I'll take some notes about [Lambdas and Streams Introduction](https://apexapps.oracle.com/pls/apex/f?p=44785:141:105593264740337::NO::P141_PAGE_ID,P141_SECTION_ID:250,1807) the online course provided by Simon Ritter @speakjava 


##Lambdas
* [Lesson 1 - Lambda Expressions](#lesson-1---lambda-expressions)
* [Lesson 2 - Lambda Expression Syntax](#lesson-2---lambda-expression-syntax)
* [Lesson 3 - Functional Interfaces And Their Definition](#lesson-3---functional-interfaces-and-their-definition)
* [Lesson 4 - Functional Interfaces in the java.util.function Package](#lesson-4---functional-interfaces-in-the-java-util-function-package)
* [Lesson 5 - Method and Constructor References](#lesson-5---method-and-constructor-references)
* [Lesson 6 - Referencing External Variables in Lambda Expressions](#lesson-6---referencing-external-variables-in-lambda-expressions)
* [Lesson 7 - Useful New Methods In JDK 8 That Can Use Lambdas](#lesson-7---useful-new-methods-in-jdk-8-that-can-use-lambdas)

### Lesson 1 - Lambda Expressions
https://youtu.be/WXtVHTGDV9g
	
### Lesson 2 - Lambda Expression Syntax
https://youtu.be/DD5IKXx4ZPk
	
##### Lambdas
- to process data
- to process collection of data
- to take advantage of multiple cores
- lambda expressions simplify how to pass behavior as a parameter


Why Lambda expressions?
		
To make life easier to write parallel code

Concurrency in Java:
- 1.0 - Threads
- 5.0 - Concurrent
- 6.0 - Phasers
- 7.0 - Fork/join Framework
- 8.0 - Lambda

Lambda Expressions are Anonymous Functions

```java
( parameters ) -> { lambda-body }
```

Single line Lambdas	
	- Do not need braces
	- do need an explicit return statement

Ex:
			
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

Type Inference 
page 4

method definition
static T process(List<T> l, Comparator<T> c)			

- Brackets and braces are optional for certain situations in single statements
- remains strongly, statically typed




### Lesson 3 - Functional Interfaces And Their Definition
	https://youtu.be/oV6nNR6im6o

	Functional Interfaces and Their Definition

		There is a single abstract method

		is a Interface
		before jdk8
			has _only one_ abstract method
		after jdk8
			introduced _default_ methods
			allows static methods in interfaces

		Examples:
		
			interface FileFilter { boolean accept(File x);}	
			interface ActionListner { void actionPerformed(...);}
			interface Callable<T> { T call(); }

			* equals(Object obj) is implicit from the Object class


		Examples of Use Lambda Expressions (that can be used anywhere the type is a functional interface)

			Variable assignement

					Callable c = () -> process();

			Methos parameter

					new Thread( () -> process() ).start();




### Lesson 4 - Functional Interfaces in the java.util.function Package
	https://youtu.be/kKFD9fwcmtk

	Functional Interfaces int the java.util.function Package

		Provides a range of functional interfaces
		Used extensively in Streams
		You will need to define your own extensions to the finction package

		- Generic Interfaces

			Consumer<T>

				Operation that takes a single value and returns no result
				String s -> System.out.println(s)

			BiConsumer<T, U>

				Operation that takes TWO value and returns no result	
				(k, v) -> System.out.println("Key: " + k + ", value: " + v);


			Supplier

				A Supplier of Results, the oposite of Consumer

					() -> createLogMessage()


			Function<T, R>
			
				Accepts one argument and returns a result

				Type of argument and result may be different
				Useful static method for composing. Ex.: compose and andThen

				Student s -> s.getName()

			Function<T, U, R> accepts two arguments and returns a result. Types can be different.
				
				(String name, Student s) -> new Teacher(name, student)

			UnaryOperator<T>
			
				Specialized form of funcion
				Single argument and result of the same type

					- T apply(T a)

						String s -> s.toLowerCase()	

			BinaryOperator<T>
			
				Specialized form of Bifuncion
				Two arguments and a result all of the same type

					- T apply(T a, T b)

						(String a, String x) -> {
							if ( x.length() > y.length) ) 
								return x;
							return y;	
						}


			Predicate
				
				A Boolean valued Function of one Argument

				BiPredicate	
					A Boolean valued Function of two Argument

				useful default and static methods for combination
					- and(), or(), negate(), isEqual()

				Student s -> s.graduationYear() == 2011
				



### Lesson 5 - Method and Constructor References
	https://youtu.be/CURWqa7KWDk

	Method and Constructor References

		Method References
			let us a reuse a method as a lambda expression
			Format: target_reference::methos_name
			Three kinds of methos reference
				- Static method
				- Instance method of arbitary method
				- Instance method of an existing object 

			FileFilter x = File f -> f.canRead();

			FileFilter x = File::canRead;

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


		Contructor Reference		

			Same concept as a Method Reference
				- For the constructor

			Factory <List<String>> f = () -> return new ArrayList<String>();
			
			Factory <List<String>> f = 	ArrayList<String>()::new;




### Lesson 6 - Referencing External Variables in Lambda Expressions
	https://youtu.be/sciFQ_s4cQU


		Referencing External Variables in Lambda Exprecions

		Local Variable Capture

			Efectivelly final, a variable that meets the requirements for final variables
			Closure on values, not on variables

			void expire(File root, long before){
				root.lisfFiles(File f -> f.lastModified <= before)
			}

		What does "this" mean in a Lambda 	

			- "this" referes to the enclosing object, not the lambda itself
			- Thinf of "this" as final predefined local
			- Remmember the Lambda is an ANNONYMOUS FUNCTION
				- its not associate with class
				- Therefore there can be on "this" for the Lambda


		Referencing Instance Variable
			
			Which are not final, or effectively final
			
			class DataProcessor{
				private int currentValue;

				public void process(){
					DataSet myData = myFactory.getDataSet();
					dataSet.forEach( d -> d.use( currentValue++ ) );
				}
			}		




### Lesson 7 - Useful New Methods In JDK 8 That Can Use Lambdas
	https://youtu.be/olKF7VpJMfg

		Useful New Methods in JDK 8 That can use Lambda

		Iterable Interface

			Itarable.forEach(Consumer c)


			List<String> myList = ...
			myList.forEach(s -> System.out.println(s));

			-- simplefied form, method reference
			myList.forEach(s -> System.out::println);

		Collection Interface
		
			Collection.removeIf(Predicate p)

			List<String> myList = ...
			myList.removeIf(s -> s.length() == 0);


		List Interface

			List.replaceAll(UnaryOperator o)

			List<String> myList = ...
			myList.replaceAll(s -> s.toUpperCase());

			myList.replaceAll(String::toUpperCase);


			List.sort(Comparator c)
				Replaces Collections.sort(List l, Comparator c)

			List<String> myList = ...
			myList.sort( (x, y) -> x.length() - y.length() );

		
		Logger Class
			
			logger.finest(createComplexMessage());

			New Methos in Logger Class

				- Takes a Supplier as an argument ( which is a functional interface )

			Simple change to code has big impact on performance
						
				logger.finest( () -> createComplexMessage());

			We now pass HOW to create the message, not the actual message



	

STREAMS

	LESSON 1
	https://youtu.be/IgQ7yTh5LJY	

		Introducion to Stream API

			Function Programming Concepts

				Imperative Programming (Names and Values)

					Use variables as an association between names and values
					Use sequence of commands
						Each command consists of an assignment
						Can change variable's namens 
						Form is <var_name> = <expression>
						Expressions can refer to other variables
						Values can therefore be passed from command to command
						Commands may repated through loops	

				Functional Programming (Names and Values)

					Based on structured function calls
					Function call which calls other functions in turn (composition)
						<function1>(<function2>(<function3> ... ) ... )
						
