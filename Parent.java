package JavaNotes;

public class Parent {
    {
        System.out.println("Parent.instance initializer 1");
    }

    static {
        System.out.println("Parent.static initializer");
    }

    Parent() {
        System.out.println("Parent constructor");
    }

    {
        System.out.println("Parent.instance initializer 2");
    }

}
