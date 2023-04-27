package businessLogic;

import model.Server;
import model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Scheduler{
    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer) {
        this.maxNoServers = maxNoServers;
        this.maxTasksPerServer = maxTasksPerServer;
    }
    public void addTask(BlockingQueue<Task> coada) throws InterruptedException {
        //adaugare task in coada
        //incrementare waitingPeriod
        List<Server> serv = new ArrayList<>();
        serv.addAll(servers);
        Collections.sort(serv);
        serv.get(0).addTask(coada);
    }

  /*  public void tasksList(Task task){
        strategy.addTask(servers, task);
    }*/


    /*public void changeStrategy(SelectionPolicy policy)
    {
        if(policy == SelectionPolicy.SHORTEST_QUEUE){

        }
    }*/
}
