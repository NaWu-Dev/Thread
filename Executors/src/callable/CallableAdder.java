package callable;

import java.util.concurrent.Callable;

public class CallableAdder implements Callable<Integer> {

    Integer oper1;
    Integer oper2;

    CallableAdder(Integer oper1, Integer oper2) {
        this.oper1 = oper1;
        this.oper2 = oper2;
    }

    public Integer call() {
        System.out.println(Thread.currentThread().getName() + ": Partial sum for " + oper1 + " + " + oper2 + " is: " + (oper1 + oper2));
        return oper1 + oper2;
    }

}
