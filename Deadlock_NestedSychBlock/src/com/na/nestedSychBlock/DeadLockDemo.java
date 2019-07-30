package com.na.nestedSychBlock;

class TestClass1 {

}

class TestClass2 {

}

class Thread1 implements Runnable {

    @Override
    public void run() {
        synchronized(TestClass1.class) {
            System.out.println("Acquired lock on TestClass1");
            synchronized (TestClass2.class) {
                System.out.println("Acquired lock on TestClass2");
            }
        }
    }
}

class Thread2 implements Runnable{

    @Override
    public void run() {
        synchronized (TestClass2.class) {
            System.out.println("Acquired lock on TestClass2");
            synchronized (TestClass1.class) {
                System.out.println("Acquired lock on TestClass1");
            }
        }
    }
}


public class DeadLockDemo {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());

        t1.start();
        t2.start();

    }
}
