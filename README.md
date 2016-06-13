# Java 8 Notes

**Table of Contents**  *generated with [DocToc](http://doctoc.herokuapp.com/)*

- [Relevance of Abstract Classes](#relevance-of-abstract-classes)
- [Built in Functional Interfaces (util.functions)](#built-in-functional-interfaces-utilfunctions)
- [Streams](#streams)
- [Utils](#utils)

### Relevance of Abstract Classes
* Abstract classes can hold dynamic(non final) state (member variables), which FI cannot do. Although FIs(& interfaces) can hold final member variables.
* FI -- Class can do implements of multiple FIs achieving multiple inheritance directly.

###Built in Functional Interfaces (util.functions)
https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html


###Streams 
[Reference](http://java.amitph.com/2014/01/understanding-java-8-streams-api.html#.V1ajgNJ97cs)

[Oracle Docs](https://docs.oracle.com/javase/tutorial/collections/streams/)

**Intermediate Operations and Terminal Operations**
  * The intermediate operations will not be invoked until the terminal operation is invoked.

**Lazy Evaluation**
  * Streams are much faster because they are traversed only once even if we chain the operations, they have short-circuited operations and can be evaluated quickly. 
  * Operations or invocations on streams which appear to traverse the stream multiple times actually traverse it only once (Lazy Evaluation). 
  * The intermediate operations will not be invoked until the terminal operation is invoked.

**Creating Streams**
```Java
//From Collections
//List someList = new ArrayList();
//someList.stream().forEach(System.out::println);

//Creating Stream of hardcoded Strings and printing each String
Stream.of("This", "is", "Java8", "Stream").forEach(System.out::println);

//Creating stream of arrays
String[] stringArray = new String[]{"Streams", "can", "be", "created", "from", "arrays"};
Arrays.stream(stringArray).forEach(System.out::println);
        
//Creating BufferedReader for a file
BufferedReader reader = Files.newBufferedReader(Paths.get("File.txt"), StandardCharsets.UTF_8);
//BufferedReader's lines methods returns a stream of all lines
reader.lines().forEach(System.out::println);
```
**Stream APIs**
 * Intermediate -- filter, map, flatMap, reduce -- Integer::min, Integer::max, distinct, limit, skip, sorted, sorted(Comparator.reverseOrder()), 
 * Terminal -- collect, anyMatch, allMatch, noneMatch, findAny, findFirst

**[Parallelism] (https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html)**

###Utils

**Optional**
 * ifPresent()

**SpliIterator**

**New Date APIs**

**Comparator.comparing**

**java.util.stream.Collectors** ([Ref](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html))
 * Collectors.toList()
 * Collectors.toCollection(TreeSet::new)
 * Collectors.joining(", ")
 * Collectors.summingInt(Employee::getSalary))
 * Collectors.groupingBy(Employee::getDepartment) -- returns Map
 * Collectors.groupingBy(Employee::getDepartment,Collectors.summingInt(Employee::getSalary))
 * Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD) -- retruns map with boolean key

**Strings** ([Ref](http://winterbe.com/posts/2015/03/25/java8-examples-string-number-math-files/))
 * concatenation
 ```Java
 String.join(":", "foobar", "foo", "bar");
// => foobar:foo:bar
 ```
 * Split
 ```Java
 Pattern.compile(":")
    .splitAsStream("foobar:foo:bar")
    .filter(s -> s.contains("bar"))
    .sorted()
    .collect(Collectors.joining(":"));
// => bar:foobar

//OR

Pattern pattern = Pattern.compile(".*@gmail\\.com");
Stream.of("bob@gmail.com", "alice@hotmail.com")
    .filter(pattern.asPredicate())
    .count();
// => 1
 ```
***Files***([Ref](http://winterbe.com/posts/2015/03/25/java8-examples-string-number-math-files/))
```Java
(Stream<Path> stream = Files.list(Paths.get("")))
```
