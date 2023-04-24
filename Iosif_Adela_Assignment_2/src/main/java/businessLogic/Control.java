package businessLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interf.Interface;
public class Control implements ActionListener{
    private Interface i;
    private Integer nrClienti;
    private Integer nrCozi;
    private Integer timpSimulare;
    private Integer arrivMin;
    private Integer arrivMax;
    private Integer servMin;
    private Integer servMax;
    private SimulationManager s;

    public Control(Interface i) {
        this.i = i;
    }

    public Integer getNrClienti() {
        return nrClienti;
    }

    public Integer getNrCozi() {
        return nrCozi;
    }

    public Integer getTimpSimulare() {
        return timpSimulare;
    }

    public Integer getArrivMin() {
        return arrivMin;
    }

    public Integer getArrivMax() {
        return arrivMax;
    }

    public Integer getServMin() {
        return servMin;
    }

    public Integer getServMax() {
        return servMax;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nrClienti = i.getNrTasks();
        nrCozi = i.getNrCozi();
        arrivMax = i.getArrivMax();
        arrivMin = i.getServiceMin();
        servMax = i.getArrivMax();
        servMin = i.getArrivMin();
        timpSimulare = i.getSimu();

        SimulationManager simulMan = new SimulationManager(nrClienti,
                nrCozi,timpSimulare,arrivMax,arrivMin,servMax,servMin);

        Thread begin = new Thread(simulMan);
        begin.start();
        i.dispose();
    }
}
