package model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable, Comparable<Server> {

    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private AtomicInteger averageWaiting;

    public Server() {
        //initializare coada si waitingPeriod
        this.tasks = new LinkedBlockingDeque<>();
        this.waitingPeriod = new AtomicInteger(0);
    }

    public void addTask(BlockingQueue<Task> coada) throws InterruptedException {
        //tasks.put(coada.take());
        Task t = coada.take();
        tasks.put(t);
        waitingPeriod.addAndGet(t.serviceTime.get());
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    @Override
    public void run() {
        while (true) {//scad waitingPeriod si serviceTime la fiecare client
            Task t = tasks.peek();
            if (t != null) {
                waitingPeriod.getAndDecrement();
                t.decreaseServiceTime();
                if (t.getServiceTime().get() == 0) {
                    try {
                        tasks.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public int compareTo(Server s) {
        Integer w1 = waitingPeriod.get();
        Integer w2 = s.waitingPeriod.get();
        return w1.compareTo(w2);
    }

    public BlockingQueue<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public String toString() {
        StringBuilder clienti = new StringBuilder("Queue");
        if (tasks.isEmpty()) { //coada e goala
            return clienti + " closed\n";
        } else {
            for (Task t : tasks) {
                clienti.append(t.toString()).append("\n");
            }
            return clienti + "";
        }
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
