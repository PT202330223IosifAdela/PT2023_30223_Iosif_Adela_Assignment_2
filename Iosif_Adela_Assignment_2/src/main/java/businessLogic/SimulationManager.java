package businessLogic;

import model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimulationManager implements Runnable {

    //date citite de la UI
    public int timeLimit = 60;  //t max simulation
    public int maxProcessingTime = 10;
    public int minProcessingTime = 2;
    public static int numberOfServers = 2; //nr de cozi
    public int numberOfClients = 4; //nr de clienti
    public int arrivMin = 2;    ///t min arrival
    public int arrivMax = 30;   ///t max arrival

    public int serviceMin = 2;  //t min service
    public int serviceMax = 4; //t max service
    private static Scheduler scheduler;
    //private SimulationFrame frame;
    private List<Task> generateTasks;
    private BlockingQueue<Task> coada;

    public SimulationManager(Integer nrCozi) {
        coada = new LinkedBlockingQueue<Task>();
        scheduler = new Scheduler(nrCozi);
    }

    public SimulationManager(Integer nrClienti, Integer nrCozi, Integer timpSimulare, Integer arrivMax, Integer arrivMin, Integer servMax, Integer servMin) {
    }

    public void generateNRandomTasks() throws InterruptedException {
        int idTask, arrTime, serviceTime;
        Random r = new Random();
        this.generateTasks = new ArrayList<>();
        this.coada = new LinkedBlockingQueue<>();

        for (int i = 0; i < numberOfClients; i++) {
            idTask = r.nextInt(1, numberOfClients + 1);
            arrTime = r.nextInt(arrivMin, arrivMax + 1);
            serviceTime = r.nextInt(serviceMin, serviceMax + 1);

            generateTasks.add(new Task(idTask, arrTime, serviceTime));
/*
            System.out.println(idTask);
            System.out.println(arrTime);
            System.out.println(serviceTime);
            System.out.println("\n");*/
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
            generateNRandomTasks();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int currentTime = 0;
        while (currentTime < timeLimit && !coada.isEmpty()) {
            currentTime++;
            System.out.println("Time " + currentTime);
            if (coada.peek().getArrivalTime() <= currentTime) {
                try {
                    scheduler.addTask(coada);
                    scheduler.printCozi();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        SimulationManager gen = new SimulationManager(numberOfServers);
        Thread t = new Thread(gen);
        t.start();


    }
}
