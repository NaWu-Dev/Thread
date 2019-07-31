package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Adder {

    public int sequentialSum() {
        int total = 0;
        for (int i =0 ; i < 100; i++) {
            total++;
        }
        System.out.println("SequentialSum total is: " + total);
        return total;
    }

    public int parallelSum() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> list = new ArrayList<>();
    }

}
