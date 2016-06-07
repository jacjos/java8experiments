# Java 8 Notes

### Relevance of Abstract Classes
* Abstract classes can hold state (member variables), which FI cannot do.
* FI -- Class can do implements of multiple FIs achieving multiple inheritance directly.

###Built in Functional Interfaces (util.functions)
https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html


###Streams 
[Reference](http://java.amitph.com/2014/01/understanding-java-8-streams-api.html#.V1ajgNJ97cs)

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
