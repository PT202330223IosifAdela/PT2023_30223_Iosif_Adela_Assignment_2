package businessLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interf.Interface;
public class Control{
    private Interface i;
    private Integer nrClienti;
    private Integer nrCozi;
    private Integer timpSimulare;
    private Integer arrivMin;
    private Integer arrivMax;
    private Integer servMin;
    private Integer servMax;
    private SimulationManager s;

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
}
