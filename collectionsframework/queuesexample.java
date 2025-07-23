package collectionsframework;

import java.util.*;
import java.util.concurrent.*;

public class queuesexample {
    public static void main(String[] args) throws InterruptedException {
        queueInterfaceExample();
        abstractQueueExample();
        priorityBlockingQueueExample();
        concurrentLinkedQueueExample();
        arrayBlockingQueueExample();
        delayQueueExample();
        linkedBlockingQueueExample();
        linkedTransferQueueExample();
    }

    static void queueInterfaceExample() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("Queue Interface (LinkedList): " + queue);
        System.out.println("Polled: " + queue.poll());
        System.out.println("Queue after poll: " + queue);
    }

    static void abstractQueueExample() {
        MySimpleQueue<String> myQueue = new MySimpleQueue<>();
        myQueue.offer("One");
        myQueue.offer("Two");
        System.out.println("AbstractQueue subclass: " + myQueue);
        System.out.println("Polled: " + myQueue.poll());
    }

    static void priorityBlockingQueueExample() {
        PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<>();
        pbq.offer(50);
        pbq.offer(10);
        pbq.offer(30);
        System.out.println("PriorityBlockingQueue (sorted): " + pbq);
        System.out.println("Polled: " + pbq.poll());
    }

    static void concurrentLinkedQueueExample() {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<>();
        clq.offer("A");
        clq.offer("B");
        clq.offer("C");
        System.out.println("ConcurrentLinkedQueue: " + clq);
        System.out.println("Polled: " + clq.poll());
    }

    static void arrayBlockingQueueExample() throws InterruptedException {
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(3);
        abq.put("X");
        abq.put("Y");
        abq.put("Z");
        System.out.println("ArrayBlockingQueue (full): " + abq);
        System.out.println("Take: " + abq.take());
        System.out.println("After take: " + abq);
    }

    static void delayQueueExample() throws InterruptedException {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();
        delayQueue.put(new DelayedElement("Delayed1", 1000));
        delayQueue.put(new DelayedElement("Delayed2", 2000));
        System.out.println("DelayQueue: elements added with delay");

        System.out.println("Polling elements with delay:");
        while (!delayQueue.isEmpty()) {
            DelayedElement elem = delayQueue.take();  // waits for delay
            System.out.println("Taken: " + elem.getValue());
        }
    }

    static void linkedBlockingQueueExample() {
        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>();
        lbq.offer("One");
        lbq.offer("Two");
        lbq.offer("Three");
        System.out.println("LinkedBlockingQueue: " + lbq);
    }

    static void linkedTransferQueueExample() throws InterruptedException {
        LinkedTransferQueue<String> ltq = new LinkedTransferQueue<>();
        ltq.offer("Item1");
        System.out.println("LinkedTransferQueue after offer: " + ltq);
        ltq.transfer("Item2"); 
        System.out.println("LinkedTransferQueue after transfer: " + ltq);
    }
}

// Simple AbstractQueue subclass
class MySimpleQueue<E> extends AbstractQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean offer(E e) {
        return list.offer(e);
    }

    @Override
    public E poll() {
        return list.poll();
    }

    @Override
    public E peek() {
        return list.peek();
    }
}

// Helper class for DelayQueue with delay
class DelayedElement implements Delayed {
    private final String value;
    private final long expireTime;

    public DelayedElement(String value, long delayMillis) {
        this.value = value;
        this.expireTime = System.currentTimeMillis() + delayMillis;
    }

    public String getValue() {
        return value;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = expireTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if (this.expireTime < ((DelayedElement) other).expireTime) return -1;
        if (this.expireTime > ((DelayedElement) other).expireTime) return 1;
        return 0;
    }
}
