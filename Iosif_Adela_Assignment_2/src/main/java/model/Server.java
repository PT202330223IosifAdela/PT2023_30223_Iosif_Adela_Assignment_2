package model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private AtomicInteger averageWaiting;

    public Server() {

    }

    @Override
    public void run() {
        while (true) {

        }
    }

    /*public Task[] getTasks() {

    }*/
}
