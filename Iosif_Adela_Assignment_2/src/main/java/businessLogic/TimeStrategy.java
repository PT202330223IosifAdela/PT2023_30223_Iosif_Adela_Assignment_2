package businessLogic;

import model.Server;
import model.Task;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class TimeStrategy implements Strategy {
    private BlockingQueue<Task> coada;

    //selectia se face in functie de timpul de asteptare din coada
    public void addTask(List<Server> servers, Task task) throws InterruptedException {
        //cauta coada cu cel mai scurt timp de asteptare si adauga acolo task

        int minTime = 9000, iMin = 0, j = 0;
        for(Server s: servers){
            if(s.getWaitingPeriod().intValue() < minTime){
                iMin = j;
            }
            j = j + 1;
        }
        servers.get(iMin).addTask(coada);
    }
}
