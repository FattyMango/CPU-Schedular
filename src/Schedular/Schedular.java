package Schedular;


import Processor.Processor;
import Task.Task;


import java.util.Observer;
import java.util.stream.Stream;

public interface Schedular extends Observer {
    public void addTask(Task task);
    public boolean taskAvailable();
    public Task popTask();
    public void loadProcessors();
    public Stream<Task> getReadyTasks();
    public Stream<Processor> getBusyProcessors();
    public Stream<Processor> getReadyProcessors();
}
