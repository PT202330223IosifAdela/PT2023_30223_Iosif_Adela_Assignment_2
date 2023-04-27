package model;

public class Task implements Comparable<Task>{
    private int id;
    private Integer arrivalTime;
    Integer serviceTime;

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
    public int compareTo(Task t) {//sortare clienti dupa waitingPeriod
        //se ordoneaza dupa timpul de venire
        //daca timpii sunt egali, se uita la timpii de servire
       if(this.arrivalTime.equals(t.arrivalTime)){
           return this.serviceTime.compareTo(t.serviceTime);
       }
       else{
           return this.arrivalTime.compareTo(t.arrivalTime);
       }
    }

    @Override
    public String toString() {
      return "(" + id +"," + arrivalTime + "," + serviceTime + ")";
    }
    public void decreaseServiceTime(){
         serviceTime = serviceTime - 1;
    }
}
