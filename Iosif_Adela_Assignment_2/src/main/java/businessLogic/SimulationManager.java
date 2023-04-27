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
    public int timeLimit = 100;
    public int maxProcessingTime = 10;
    public int minProcessingTime = 2;
    public int numberOfServers = 3;
    public int numberOfClients = 100;
    //public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;

    public int arrivMin=10;
    public int arrivMax=100;

    public int serviceMin=5;
    public int serviceMax=50;
    private Scheduler scheduler;
    //private SimulationFrame frame;
    private List<Task> generateTasks;
    private BlockingQueue<Task> coada;

    public SimulationManager() {

    }

    public SimulationManager(Integer nrClienti, Integer nrCozi, Integer timpSimulare, Integer arrivMax, Integer arrivMin, Integer servMax, Integer servMin) {
    }

    public void generateNRandomTasks() throws InterruptedException {
        int idTask, arrTime, serviceTime;
        Random r = new Random();
        this.generateTasks = new ArrayList<>();
        this.coada = new LinkedBlockingQueue<>();

        for(int i = 0; i < numberOfClients; i++){
            idTask = r.nextInt(1, numberOfClients+1);
            arrTime = r.nextInt(arrivMin, arrivMax+1);
            serviceTime = r.nextInt(serviceMin,serviceMax+1);

            generateTasks.add(new Task(idTask,arrTime,serviceTime));

            System.out.println(idTask);
            System.out.println(arrTime);
            System.out.println(serviceTime);
            System.out.println("\n");
        }
        Collections.sort(generateTasks);

        for(Task t:generateTasks){
               scheduler.addTask(coada);
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
        while (currentTime < timeLimit) {
            currentTime++;
            System.out.println("tCurent " + currentTime + "seconds");
            try {
                if(coada.take().getArrivalTime() <= currentTime){
                    try {
                        scheduler.addTask(coada);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        SimulationManager gen = new SimulationManager();
        Thread t =new Thread(gen);
        t.start();

    }
}
