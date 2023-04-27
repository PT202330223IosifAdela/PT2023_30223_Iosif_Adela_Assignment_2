package businessLogic;

import model.Server;
import model.Task;

import java.util.List;

public abstract class Strategy {

    //selectia se face in functie de timpul de asteptare din coada
    public abstract void addTask(List<Server> servers, Task task);


}
