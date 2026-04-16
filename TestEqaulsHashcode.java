package JavaNotes;

public class TestEqaulsHashcode {
    public static void main(String[] args) {
        Person p1 = new Person(123, "xyz");
        Person p2 = new Person(123, "xyz");
        System.out.println(p1.equals(p2));
        System.out.println("p1.hashCode() = " + p1.hashCode());
        System.out.println("p2.hashCode() = " + p2.hashCode());
    }
}
