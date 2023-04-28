package businessLogic;

import model.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.FileWriter;

public class SimulationManager implements Runnable {
    public int timeLimit = 60;  //t max simulation: 60 60 200
    public static int numberOfServers = 2; //nr de cozi: 2 5 20
    public int numberOfClients = 4; //nr de clienti: 4 50 1000
    public int arrivMin = 2;    ///t min arrival:2 2 10
    public int arrivMax = 30;   ///t max arrival: 30 40 100

    public int serviceMin = 2;  //t min service: 2 1 3
    public int serviceMax = 4; //t max service: 4 7 9
    private static Scheduler scheduler;
    private List<Task> generateTasks;
    private BlockingQueue<Task> coada;
    FileWriter f;

    public SimulationManager(Integer nrCozi) throws IOException {
        coada = new LinkedBlockingQueue<Task>();
        scheduler = new Scheduler(nrCozi);

        try {
            f = new FileWriter("logFile.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        f.write(coada.toString());
    }

    public void generateNRandomTasks() throws InterruptedException {
        //generarea aleatoare a task-urilor
        int idTask, arrTime, serviceTime;
        Random r = new Random();
        this.generateTasks = new ArrayList<>();
        this.coada = new LinkedBlockingQueue<>();

        for (int i = 0; i < numberOfClients; i++) {
            idTask = r.nextInt(1, numberOfClients + 1);
            arrTime = r.nextInt(arrivMin, arrivMax + 1);
            serviceTime = r.nextInt(serviceMin, serviceMax + 1);

            generateTasks.add(new Task(idTask, arrTime, serviceTime));
        }
        Collections.sort(generateTasks);
        for (Task t : generateTasks) {
            //  scheduler.addTask(coada);//t
            coada.add(t);
        }
    }

    @Override
    public void run() {
        try {
            f = new FileWriter("logFile.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            generateNRandomTasks();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int currentTime = 0;
        while (currentTime < timeLimit && !coada.isEmpty()) {
            //System.out.println("Time " + currentTime);
            currentTime++;
            scheduler.printCozi();
            //afisare waiting clients
            try {
                f.write("\nWaiting clients: " + coada.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                f.write("\nTime: " + currentTime + " sec\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                f.write(scheduler.printCozi());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (coada.peek().getArrivalTime() <= currentTime) {
                try {
                    scheduler.addTask(coada);
                    //scheduler.printCozi();
                    //f.write(scheduler.printCozi());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        while (currentTime < timeLimit && !scheduler.eGoala()) {
            //System.out.println("Time: " + currentTime + " sec");
            try {
                f.write("\nWaiting clients: " + coada.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                f.write("\nTime: " + currentTime + " sec\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                // scheduler.printCozi();
                f.write(scheduler.printCozi());
                Thread.sleep(1000);
                currentTime = currentTime + 1;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        SimulationManager gen = new SimulationManager(numberOfServers);
        Thread t = new Thread(gen);
        t.start();
        //nu se mai afiseaza cand scheduler.eGoala devine true
        //cand ajung toate cozile goale nu se mai afiseaza cu close; se indeplineste cond si nu mai intra la afisare
    }
}
