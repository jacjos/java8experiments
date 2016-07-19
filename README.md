# Java 8 Notes

**Table of Contents**

- [Relevance of Abstract Classes](#relevance-of-abstract-classes)
- [Built in Functional Interfaces (util.functions)](#built-in-functional-interfaces-utilfunctions)
- [Streams](#streams)
- [Repeatable Annotations](#repeatable-annotations)
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

###Repeatable Annotations
[Ref](http://winterbe.com/posts/2014/03/16/java-8-tutorial/)

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
**Files**([Ref](http://winterbe.com/posts/2015/03/25/java8-examples-string-number-math-files/))
```Java
(Stream<Path> stream = Files.list(Paths.get("")))
```

**Map** ([Ref](http://winterbe.com/posts/2014/03/16/java-8-tutorial/))
 * putIfAbsent
 * forEach
 * computeIfPresent
 * computeIfAbsent
 * remove
 * merge - Merge either put the key/value into the map if no entry for the key exists, or the merging function will be called to change the existing value

```Java
map.putIfAbsent(i, "val" + i);

map.forEach((id, val) -> System.out.println(val));

map.computeIfPresent(3, (num, val) -> val + num);
map.get(3);             // val33

map.computeIfPresent(9, (num, val) -> null);
map.containsKey(9);     // false

map.computeIfAbsent(23, num -> "val" + num);
map.containsKey(23);    // true

map.computeIfAbsent(3, num -> "bam");
map.get(3);             // val33

map.remove(3, "val3");
map.get(3);             // val33

map.remove(3, "val33");
map.get(3); 

map.getOrDefault(42, "not found");  // not found

map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
map.get(9);             // val9

map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
map.get(9);             // val9concat
```

**Further Reading**
* Whats New in Java 8 -- http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html
* Oracle Overview of Features -- http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html
* http://www.oracle.com/technetwork/articles/java/ma14-java-cover-2177777.html
* Date Time -- http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html
* Metaspace -- https://dzone.com/articles/java-8-permgen-metaspace
* Functional Interfaces Specs -- https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.8
* OReilly Training -- http://www.oreilly.com/online-training/refactoring-legacy-code-with-java-8.html
* http://winterbe.com/posts/2014/03/16/java-8-tutorial/
