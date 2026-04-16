package JavaNotes;

public class TestImmutable {
    public static void main(String[] args) {
        Address a1 = new Address("Mumbai", "Maharashtra");

        ImmutableClass i = new ImmutableClass("Harsh", 26, a1);
        System.out.println(i);
        i.getAddress().setCity("Nashik");
        System.out.println(i);
        a1.setState("Empty");
        System.out.println(a1);
        System.out.println(i);
    }
}
