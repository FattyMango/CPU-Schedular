package Processor;

import Task.Task;

import java.util.Iterator;
import java.util.Observer;
import java.util.stream.Stream;

public interface Manager {

    public void execute();
    public void loadTask(Task task);
    public boolean isAvailable();
    public Stream<Processor> getBusyProcessors();
    public Stream<Processor> getReadyProcessors();

}
