package Task;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleTask implements Task {
    private static final AtomicInteger count = new AtomicInteger(0);

    private int priority,arrivingTime,ID,time;


    public SimpleTask(int arrivingTime, int time, int priority){
        this.arrivingTime = arrivingTime;
        this.time = time;
        this.priority = priority;
        this.ID= count.incrementAndGet();
    }

    @Override
    public void execute() {
        if(!hasFinished())
            time--;
    }

    @Override
    public boolean hasFinished() {
        return time == 0;
    }

    @Override
    public int getArrivingTime() {
        return arrivingTime;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getExecutionTime() {
        return time;
    }
    @Override
    public int getPriority(){
        return priority;
    }
    @Override
    public int compareTo(Object obj) {
        SimpleTask otherTask = (SimpleTask) obj;
        int priorityResult = this.priority - (otherTask.getPriority());
        if (priorityResult == 0)
            return this.time - otherTask.time;
        return priorityResult;
    }

    @Override
    public String toString() {
        return "(T"+getID()+","+getExecutionTime()+")";
    }
}
