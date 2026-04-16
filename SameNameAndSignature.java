package JavaNotes;

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
