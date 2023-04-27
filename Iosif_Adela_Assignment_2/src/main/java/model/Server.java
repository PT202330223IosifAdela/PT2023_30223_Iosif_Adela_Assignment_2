package model;

import java.awt.datatransfer.Clipboard;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable, Comparable<Server> {

    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private AtomicInteger averageWaiting;

    public Server(Integer cap) {
        //initializare coada si waitingPeriod
        this.tasks = new LinkedBlockingDeque<>();
        this.waitingPeriod = new AtomicInteger(0);
    }
   public void addTask(BlockingQueue<Task> coada) throws InterruptedException {
       //tasks.put(coada.take());
        Task t = coada.take();
        tasks.put(t);
        waitingPeriod.addAndGet(t.serviceTime);
    }
/*   public void addTask(Task t) {
       tasks.add(t);    //adaugare task in coada
       waitingPeriod.addAndGet(t.getServiceTime());
   }*/

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    @Override
    public void run() {
        while (true) {

        }
    }

    @Override
    public int compareTo(Server o) {
        return 0;
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

}
