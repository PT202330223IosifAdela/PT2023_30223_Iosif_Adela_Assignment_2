package businessLogic;

import model.Server;
import model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Scheduler {
    private List<Server> servers;
    private List<Thread> threads;
    final int maxNoServers = 10;
    final int maxTasksPerServer = 10;
    private Strategy strategy;
    private int nrServ;

    public Scheduler(int nrServ) {//nr de cozi de la Simulation Manager
        servers = new ArrayList<>();
        threads = new ArrayList<>();
        for (int i = 0; i < nrServ; i++) {//creem obiectele server(cozile) si le pornim
            Server s = new Server();
            servers.add(s);
            Thread t = new Thread(s);
            threads.add(t);
            t.start();
        }
    }

    //metoda testare afisare
    public String printCozi() {
        String st = "";
        for (Server s : servers) {
            st += "Queue " + servers.indexOf(s) + " " + s;
          //  System.out.println("Queue " + servers.indexOf(s) + " " + s);
        }
        return st;
    }

    public void addTask(BlockingQueue<Task> coada) throws InterruptedException {
        //adaugare task in coada
        //incrementare waitingPeriod
        //sortare cozi
        List<Server> serv = new ArrayList<>();
        serv.addAll(servers);
        Collections.sort(serv);
        serv.get(0).addTask(coada);
    }
    public boolean eGoala() {//daca toate cozile sunt goale, returneaza 1
        for(Server s: servers) {
            if(!s.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
