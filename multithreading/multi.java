package multithreading;

public class multi {

    // A shared resource: this counter will be accessed by multiple threads
    static class Counter {
        private int count = 0;

        // synchronized ensures only one thread modifies count at a time (avoids race conditions)
        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    // Thread created by implementing Runnable interface (a common way to create threads)
    static class MyRunnable implements Runnable {
        private Counter counter;

        public MyRunnable(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            // This code runs when the thread is started
            System.out.println(Thread.currentThread().getName() + " started counting.");

            // Each thread will increment the counter 1000 times
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }

            System.out.println(Thread.currentThread().getName() + " finished counting.");
        }
    }

    // Thread created by extending the Thread class (another way to create threads)
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread is running with priority: " + getPriority());

            try {
                // Thread sleeps for 0.5 seconds (simulating delay or heavy work)
                Thread.sleep(500);
                System.out.println("MyThread woke up after sleeping!");
            } catch (InterruptedException e) {
                System.out.println("MyThread was interrupted!");
            }
        }
    }

    // Class to demonstrate wait() and notify() for inter-thread communication
    static class WaitNotifyExample {
        private boolean ready = false;

        // Thread will wait here until it's notified
        public synchronized void waitForSignal() {
            try {
                while (!ready) {
                    System.out.println("Waiter: Waiting for signal...");
                    wait(); // Releases lock and waits
                }
                System.out.println("Waiter: Got the signal!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // This method sends the signal (notifies waiting thread)
        public synchronized void sendSignal() {
            ready = true;
            System.out.println("Notifier: Sending signal...");
            notify(); // Wakes up the waiting thread
        }
    }

    public static void main(String[] args) {
        // Create shared Counter object
        Counter counter = new Counter();

        // Create two threads using Runnable (sharing the same counter)
        Thread t1 = new Thread(new MyRunnable(counter), "Worker-1");
        Thread t2 = new Thread(new MyRunnable(counter), "Worker-2");

        // Create a thread by extending Thread class
        MyThread mt = new MyThread();
        mt.setPriority(Thread.MAX_PRIORITY); // set high priority

        // Start the threads
        t1.start();
        t2.start();
        mt.start();

        // Wait and Notify example
        WaitNotifyExample example = new WaitNotifyExample();

        // Thread that waits for a signal
        Thread waiter = new Thread(() -> example.waitForSignal(), "Waiter");

        // Thread that sends the signal after a short delay
        Thread notifier = new Thread(() -> {
            try {
                Thread.sleep(1000); // give waiter time to start waiting
            } catch (InterruptedException e) {}
            example.sendSignal();
        }, "Notifier");

        waiter.start();
        notifier.start();

        // Difference between run() and start()
        Thread fakeThread = new Thread(() -> System.out.println("This is run(), not a real thread!"));
        fakeThread.run(); // just calls run() in main thread, does NOT start a new thread
        System.out.println("The above line was run using run(), not start().");

        // Join all threads so main waits for them to finish
        try {
            t1.join();
            t2.join();
            mt.join();
            waiter.join();
            notifier.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final result after all threads complete
        System.out.println("Final counter value (should be 2000): " + counter.getCount());
    }
}