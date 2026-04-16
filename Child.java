package JavaNotes;

public class Child extends Parent{
    static {
        System.out.println("Child.static initializer");
    }

    {
        System.out.println("Child.instance initializer 1");
    }

    public Child() {
        System.out.println("Child constructor");
    }

    {
        System.out.println("Child.instance initializer 2");
    }
}
