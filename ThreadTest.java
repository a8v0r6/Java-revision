package JavaNotes;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class RunnableTask1 implements Runnable {
    private final ReentrantLock resource1, resource2;

    public RunnableTask1(ReentrantLock resource1, ReentrantLock resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        resource1.lock();
        System.out.println("Task 1: Printing : " + resource1);

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        try {
            if (resource2.tryLock()) {
                System.out.println("Task 1: Printing : " + resource2);
                resource2.unlock();
            }
        }
        catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        resource1.unlock();
    }
}

class RunnableTask2 implements Runnable {
    private final ReentrantLock resource1, resource2;

    public RunnableTask2(ReentrantLock resource1, ReentrantLock resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        resource2.lock();
        System.out.println("Task 2: Printing : " + resource2);

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            if (resource1.tryLock(500, TimeUnit.MICROSECONDS)) {
                System.out.println("Task 2: Printing : " + resource1);
                resource1.unlock();
            }
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        resource2.unlock();


    }
}

public class ThreadTest {
    public static void main(String[] args) {
        final ReentrantLock resource1 = new ReentrantLock();
        final ReentrantLock resource2 = new ReentrantLock();

        Thread t1 = new Thread(new RunnableTask1(resource1, resource2));
        Thread t2 = new Thread(new RunnableTask2(resource1, resource2));

        t1.start();
        t2.start();
    }
}
