Java 17 features:

1. Sealed classes: You can control who can extend your class.
    ```
    sealed class Shape permits Cirle, Rectangle {
        void area() {
            System.out.println("area method");
        }
    }  
    ```

    `permits` option to choose which class is allowed to extend

    `sealed` keyword to define a sealed class

    but child class can be accessed so how will it be handled?

    1.  final class

        ```
        final class Circle extends Shape {
            void area() {
             // impl
            }
        }
        ```
    2. `non-sealed` to allow child class to be inherited
        
        ```
        non-sealed class Rectangle extends Shape {
            void area() {
                // impl
            }
        }

        class Square extends Rectangle {
            // works 
        }
        ```

