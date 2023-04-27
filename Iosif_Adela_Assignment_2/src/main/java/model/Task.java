package model;

public class Task implements Comparable<Task>{
    private int id;
    private int arrivalTime;
    int serviceTime;

    public Task(int idTask, int arrTime, int serviceTime) {
        this.id = idTask;
        this.arrivalTime = arrTime;
        this.serviceTime = serviceTime;
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

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public int compareTo(Task o) {
        return 0;
    }

    @Override
    public String toString() {
      return "(" + id +"," + arrivalTime + "," + serviceTime + ")";
    }
}
