package executorService;

import java.util.Date;

public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            Date date = new Date();
            if (i == 0) {
                System.out.println(Thread.currentThread().getName() + " Start Command = " + command + " - " + date);
            } else {
                System.out.println(Thread.currentThread().getName() + " Executing.... " + date);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " End. ");

    }

    @Override
    public String toString() {
        return this.command;
    }
}
