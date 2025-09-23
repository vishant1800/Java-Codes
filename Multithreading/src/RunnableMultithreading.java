class Multithreading2 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

public class RunnableMultithreading {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            Thread obj = new Thread(new Multithreading2());
            obj.start();
        }
    }
}