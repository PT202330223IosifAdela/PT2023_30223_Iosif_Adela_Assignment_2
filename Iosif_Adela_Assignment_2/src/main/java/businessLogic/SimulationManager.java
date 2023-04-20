package businessLogic;

import model.Task;

import java.util.List;

public class SimulationManager implements Runnable {

    //date citite de la UI
    public int timeLimit = 100;
    public int maxProcessingTime = 10;
    public int minProcessingTime = 2;
    public int numberOfServers = 3;
    public int numberOfClients = 100;
    //public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;

    private Scheduler scheduler;
    //private SimulatinFrame frame;
    private List<Task> generateTasks;

    public SimulationManager() {

    }

    public SimulationManager(Integer nrClienti, Integer nrCozi, Integer timpSimulare, Integer arrivMax, Integer arrivMin, Integer servMax, Integer servMin) {
    }

    public void generateNRandomTasks(){

    }

    @Override
    public void run() {
        int currentTime = 0;
        while (currentTime < timeLimit) {
            currentTime++;
        }
    }
    public static void main(String[] args) {
        SimulationManager gen = new SimulationManager();
        Thread t =new Thread(gen);
        t.start();

    }
}
