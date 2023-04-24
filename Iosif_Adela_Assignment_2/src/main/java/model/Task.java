package model;

public class Task implements Comparable<Task>{
    private int arrivalTime;
    int serviceTime;

    public Task(int idTask, int arrTime, int serviceTime) {
    }

    @Override
    public int compareTo(Task o) {
        return 0;
    }
}
