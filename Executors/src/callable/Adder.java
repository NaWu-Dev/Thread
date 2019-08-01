package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Adder {

    public int sequentialSum() {
        int total = 0;
        for (int i =0 ; i < 100; i++) {
            total+=i;
        }
        System.out.println("SequentialSum total is: " + total);
        return total;
    }

    public int parallelSum() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> list = new ArrayList<>();

        int count = 1, prev = 0;

        for (int i = 0; i < 100; i++) {
            if (count % 2 == 0) {
                System.out.println("Prev : " + prev + " current : " + i);
                Future<Integer> future = executor.submit(new CallableAdder(prev, i));
                list.add(future);
                continue;
            }
            prev = i;
            count++;
        }

        int total = 0;
        for (Future<Integer> fut : list) {
            try {
                total += fut.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Parallel Total Sum is: " + total);
        executor.shutdown();
        return total;
    }

    static public void main(String[] arg) {
        Adder adder = new Adder();
        int pSum = adder.parallelSum();
        int sSum = adder.sequentialSum();
        System.out.println("Parallel sum : " + pSum);
        System.out.println("Sequential sum : " + sSum);
    }

}
