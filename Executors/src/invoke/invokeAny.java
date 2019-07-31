package invoke;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class invokeAny {

    public static void main(String[] arg) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callableSet = new HashSet<>();

        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 1";
            }
        });

        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 2";
            }
        });

        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 3";
            }
        });

        String result = executorService.invokeAny(callableSet);

        System.out.println("result = " + result);

        executorService.shutdown();

    }

}
