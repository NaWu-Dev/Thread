package queue;

class Queue {
    int num;

    boolean valueSet = false;

    public synchronized void put(int num) throws InterruptedException {
        while (valueSet) {
            wait();
        }
        System.out.println("Put : " + num);
        this.num = num;
        valueSet = true;
        notify();
    }

    public synchronized void get() throws InterruptedException {
        while (!valueSet) {
            wait();
        }
        System.out.println("Get : " + num);
        valueSet = false;
        notify();
    }

}
