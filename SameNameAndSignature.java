package JavaNotes;

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
