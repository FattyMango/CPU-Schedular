package Task;

public interface Task extends Comparable {
     public void execute();
     public boolean hasFinished();
     public int getArrivingTime();
    public int getID();
    public int getExecutionTime();
    public int getPriority();
}
