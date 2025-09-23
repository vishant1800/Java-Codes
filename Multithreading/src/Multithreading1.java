
class Multithreading extends Thread {
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

public class Multithreading1 {
    public static void main(String[] args) {
        int n = 10; // Number of threads
        System.out.println("Main is starting");
        for (int i = 0; i < n; i++) {  // asynchronous process
            Multithreading object = new Multithreading();
            object.start();
        }
        System.out.println("Main is exiting");
    }
}