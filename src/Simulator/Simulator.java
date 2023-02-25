package Simulator;

import Processor.Processor;
import Task.Task;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Stream;


public abstract class Simulator extends Observable {
   abstract public void start() throws InterruptedException;

   abstract public void addTask(Task task);
   abstract public void subscribe(Observer o);

   abstract public Stream<Processor> getBusyProcessors();
   abstract public Stream<Processor> getReadyProcessors();
   abstract public Stream<Task> getReadyTasks();
   abstract public Stream<Task> getAllTasks();
}
