package Processor;


import Task.Task;



public interface Processor  {
    public void execute();
    public boolean assignTask(Task task);
    public boolean isAvailable();
    public Task getTask();
    public int getID();
}
