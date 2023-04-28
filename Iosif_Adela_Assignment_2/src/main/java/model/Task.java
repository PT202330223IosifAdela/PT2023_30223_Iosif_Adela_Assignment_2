package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Comparable<Task> {
    private int id;
    private Integer arrivalTime;
    AtomicInteger serviceTime;

    public Task(int idTask, int arrTime, int serviceTime) {
        this.id = idTask;
        this.arrivalTime = arrTime;
        this.serviceTime = new AtomicInteger(serviceTime);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public AtomicInteger getServiceTime() {
        return serviceTime;
    }


    @Override
    public int compareTo(Task t) {//sortare clienti dupa waitingPeriod
        //se ordoneaza dupa timpul de venire
        //daca timpii sunt egali, se uita la timpii de servire
        if (this.arrivalTime.equals(t.arrivalTime)) {
            Integer stime = serviceTime.get();
            Integer aux = t.serviceTime.get();
            return stime.compareTo(aux);
        } else {
            return this.arrivalTime.compareTo(t.arrivalTime);
        }
    }

    @Override
    public String toString() {
        return "(" + id + "," + arrivalTime + "," + serviceTime + ")\n";
    }

    public void decreaseServiceTime() {
        serviceTime.getAndDecrement();
    }
}
