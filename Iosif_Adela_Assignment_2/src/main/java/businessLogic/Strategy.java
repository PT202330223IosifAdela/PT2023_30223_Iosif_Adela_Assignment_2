package businessLogic;

import model.Server;
import model.Task;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public interface Strategy {

    //selectia se face in functie de timpul de asteptare din coada
    public void addTask(List<Server> servers, Task task) throws InterruptedException;


}
