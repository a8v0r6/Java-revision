package JavaNotes;

public class MultipleExceptions {
    public static void main(String[] args) {
        try{
            throw new MyException("Custom Exception");
        }
        catch (MyException me) {
            System.out.println("MyExceptions.main");
        }
        catch (Exception e) {
            System.out.println("RuntimeExceptions.main");
        }

    }
}


class MyException extends RuntimeException{
    MyException (String msg) {
        super(msg);
    }
}