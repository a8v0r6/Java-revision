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










