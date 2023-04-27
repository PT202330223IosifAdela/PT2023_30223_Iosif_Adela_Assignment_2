package businessLogic;

import model.Server;
import model.Task;

import java.util.List;

public class TimeStrategy extends Strategy {

    //selectia se face in functie de timpul de asteptare din coada
    public void addTask(List<Server> servers, Task task){
        //cauta coada cu cel mai scurt timp de asteptare si o
        //adauga la task
        int minTime = 9000, iMin = 0, j = 0;
        for(Server s: servers){
            if(s.getWaitingPeriod().intValue() < minTime){
                iMin = j;
            }
            j = j + 1;
        }
        servers.get(iMin).addTask(task);
    }
}
