package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSample {

    public static void main(String[] args) {

        int threadNumber = 3;
        int workerNumber = 10;
        Runnable[] worker = new Runnable[workerNumber];

        for (int i=0; i < workerNumber; i++ ) {
            worker[i] = new WorkerThread("" + i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);

        for (int i=0; i < workerNumber; i++ ) {
            executorService.execute(worker[i]);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        System.out.println("All threads are finished.");

    }

}
