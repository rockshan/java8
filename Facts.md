# java8
## Primitive specializations 
Java type is either a reference type (for example, Byte, Integer, Object, List) or a primitive type (for example, int, double, byte, char). But generic parameters (for example, the T in Consumer<T>) can be bound only to reference types. As a result, in Java there’s a mechanism to convert a primitive type into a corresponding reference type. This mechanism is called boxing. The opposite approach (that is, converting a reference type into a corresponding primitive type) is called unboxing. Java also has an autoboxing mechanism to facilitate the task for programmers: boxing and unboxing operations are done automatically.
But this comes with a performance cost. Boxed values are essentially a wrapper around primitive types and are stored on the heap(dynamic memory allocation). Therefore, boxed values use more memory and require additional memory lookups to fetch the wrapped primitive value.
Java 8 brings a specialized version of the functional interfaces we described earlier in order to avoid autoboxing operations when the inputs or outputs are primitives.

## Restrictions on local variables  
You may be asking yourself why local variables have these restrictions. First, there’s a key difference in how instance and local variables are implemented behind the scenes. Instance variables are stored on the heap, whereas local variables live on the stack. If a lambda could access the local variable directly and the lambda were used in a thread, then the thread using the lambda could try to access the variable after the thread that allocated the variable had deallocated it. Hence, Java implements access to a free local variable as access to a copy of it rather than access to the original variable. This makes no difference if the local variable is assigned to only once—hence the restriction.

## Intermediate operations in Stream pipeline
Intermediate operations such as filter or sorted return another stream as the return type. This allows the operations to be connected to form a query. What’s important is that intermediate operations don’t perform any processing until a terminal operation is invoked on the stream pipeline—they’re ``lazy``. This is because intermediate operations can usually be merged and processed into a single pass by the terminal operation.

## Working with streams
Working with streams in general involves three items:
1. A data source (such as a collection) to perform a query on
2. A chain of intermediate operations that form a stream pipeline
3. A terminal operation that executes the stream pipeline and produces a result
