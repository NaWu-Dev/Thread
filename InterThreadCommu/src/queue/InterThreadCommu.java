package queue;

public class InterThreadCommu {

    public static void main(String[] args) {
        Queue q = new Queue();
        new Producer(q);
        new Consumer(q);
    }

}
