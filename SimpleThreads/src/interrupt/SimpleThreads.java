package interrupt;

public class SimpleThreads {

    static void threadMessage(String message) {
        System.out.println(Thread.currentThread().getName() + " : " + message);
    }

    private static class MessageLoop implements Runnable {

        @Override
        public void run() {

            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "LIttle lambs eat ivy",
                    "A kid will eat ivy too"
            };

            for (int i = 0; i < importantInfo.length; i++) {
                try {
                    Thread.sleep(4000);
                    threadMessage(importantInfo[i]);
                } catch (InterruptedException e) {
                    threadMessage("I wasn't done");
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        long patience = 100;

        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.out.println("Argument must be an integer");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        while(t.isAlive()) {
            threadMessage("Still waiting");
            t.join(2000);
            if (( (System.currentTimeMillis() - startTime) > patience) && t.isAlive() ) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                t.join();
            }
        }

        threadMessage("Finally!!!");

    }

}
