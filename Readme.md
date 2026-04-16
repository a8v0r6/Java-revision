Java Tricky Questions part1 

1. There should always be catch or finally with try , but incase of try with resource we can use try without any catch or finally. 
** Resource should be autocloseable **

2. Return statement in try and finally block, which one will be returned?
    ```

    try{
        return 1;

    }

    finally {
        return 2
    }

    ```
    It will return 2 because finally will always run and it has higher priority


3. What happens when we are returning something in try and in finally we are returning something?

    ```

    int x = 0;

    try{
        return x;

    }

    finally {
        x = 2;
    }
    // What will be returned here?

    ```

    It will return 0 only here because when we update x in finally we are not returning it 
    if we return x here then it takes precedence

4. When will finally not be executed??

    ```
    System.exit(0)
    ```

    or when JVM crashes 

5. Can a class have method with 2 interface with same name ?

    Case I: 
        
        ```
        interface A{
            void method();
        }
        interface B {
            void method();
        }
        public class SameNameAndSignature implements A, B { 
            @Override
            public void method() {
                System.out.println("SameNameAndSignature.method");
            }
        }

        ```
    This will work because at runtime we are overriding the method in our concrete class but if we don't override there will be error

    Case II:

        ```
        interface A{
            void method();
        }
        interface B {
            int method();
        }
        public class SameNameAndSignature implements A, B {

            @Override
            public int method() {

                return 0;
            }
            @Override
            public void method() {
                System.out.println("SameNameAndSignature.method");
            }
        }
        ```
    Here it will give complile time error here

    Case III:

        ```
        interface A{
            void method();
        }
        interface B {
            void method();
        }
        public class SameNameAndSignature implements A, B {

            @Override
            public void method() {
                A.super.method() 
            }
        }
        ```
    We can use super keyword to access default impl of interface

6. Can we call obj.wait() without syncronized locks?

    No we cannot because wait it used when we want to release a lock and wait, but without a monitor we cannot call wait

7. Multiple exceptions in one block

    ```
    try {

    }

    catch (SQLException se) {
        e.printStactrace()
    }
    catch (IOException se) {
        e.printStactrace()
    }

    ```

    We can pipe("|") them together if we have same behaviour in both, else we can keep it separate

    ```
    catch (IOException | SQLException se) {
        e.printStactrace()
    }
    ```

    what if there is a broader exception catch ?

    ```

    public class MultipleExceptions {
        public static void main(String[] args) {
            try{
                throw new MyException("Custom Exception");
            }
            catch (Exception e) {
                System.out.println("RuntimeExceptions.main");
            }
            catch (MyException me) {
                System.out.println("MyExceptions.main");
            }
        }
    }

    class MyException extends RuntimeException{
        MyException (String msg) {
            super(msg);
        }
    }
    ```

    This will give compile time error that exception is already called

8. Can we override a static method?

Static method belongs to class not instance, they cannot be overridden 
only instance level methods can be overridden

9. Errors and exceptions: 

    Both are of type throwable

    Errors : Occur when system level problem
    There is no recoverability, execution is stopped
    All errors are Unchecked and of type Error
    ```
    OutOfMemoryError
    StackOverflowError
    ```

    Exception : Occurs when there is code level problem
    We can gracefull handle the problem by logging, showing error reason (for some cases)
    with try catch we can handle exception,
    so the code execution keeps on going and doesn't stop when there is a problem

    there are Checked and Unchecked exceptions
    checked are compile time exceptions 
    ```
    FileNotFoundException
    SQLException
    ```
    at compile time it is checked whether file exists or not, sql connection can be made, etc

    Unchecked exceptions are runtime exception - they don't need to explicitly declared when we throw runtime exceptio

10. Garbage Collectors :

Clears memory in java heap

    1. Serial GC

        How it works: Uses a single thread for all garbage collection work. It stops all application threads (Stop-The-World) during the process.

        Best for: Small data sets (up to 100MB), single-processor machines, or client-side applications where low memory footprint is more important than pause times.

        Flag: -XX:+UseSerialGC

    2. Parallel GC (Throughput Collector)

        How it works: Similar to Serial GC but uses multiple threads for young generation collection. It is optimized for high throughput.

        Best for: Batch processing, data analysis, and applications where the total "work done" is more important than occasional long pauses. This was the default in Java 8.

        Flag: -XX:+UseParallelGC

    3. CMS (Concurrent Mark Sweep)

        How it works: Designed to minimize pauses by performing most of its work (marking and sweeping) concurrently with the application threads.

        Status: Deprecated in Java 9 and removed in Java 14. G1 is its successor.

        Trade-off: It reduces pause times but consumes more CPU and can suffer from memory fragmentation (no compaction).

    4. G1 (Garbage First)

        How it works: Divides the heap into many small regions. It tracks which regions are mostly "garbage" and collects those first (hence the name). 
        It is the current default for most modern JVMs.

        Best for: Large heaps (4GB+) where you want predictable, consistent pause times. It provides a balance between throughput and latency.

        Flag: -XX:+UseG1GC

    5. ZGC (Z Garbage Collector)

        How it works: A scalable, low-latency GC. It performs all expensive work concurrently, without stopping the execution of application threads 
        for more than a few milliseconds, regardless of heap size.

        Best for: Applications requiring extremely low latency (sub-millisecond) and very large heaps (up to 16TB).

        Flag: -XX:+UseZGC

    6. Shenandoah

        How it works: Similar to ZGC, it is an ultra-low-latency collector. Developed by Red Hat, it performs evacuation (moving objects to compact the heap) 
        concurrently with the application threads.

        Best for: Large heaps where pause times must stay low and consistent, even during compaction.

        Flag: -XX:+UseShenandoahGC

    7. Epsilon

        How it works: The "No-Op" collector. It handles memory allocation but does not reclaim any memory. When the heap is full, the JVM shuts down with an OutOfMemoryError.

        Best for: Performance testing, short-lived jobs (serverless), or extremely memory-sensitive applications where you manage memory manually or know it won't overflow.

        Flag: -XX:+UseEpsilonGC

11. Singleton Class

    To create singleton class - class with only one instance
    



