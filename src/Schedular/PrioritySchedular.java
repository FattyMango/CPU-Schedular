package Schedular;

import Processor.Manager;
import Processor.Processor;
import Task.Task;

import java.util.*;
import java.util.stream.Stream;

public class PrioritySchedular implements Schedular {
    private Queue<Task> readyQueue;
    private Manager processorsManager;
    public PrioritySchedular(Manager processorsManager){
        readyQueue = new PriorityQueue<Task>(Collections.reverseOrder());
         this.processorsManager = processorsManager;
    }
    @Override
    public void addTask(Task task) {
    readyQueue.add(task);
    }

    @Override
    public boolean taskAvailable() {
        return !readyQueue.isEmpty();
    }

    @Override
    public Task popTask() {
        return  readyQueue.poll();
    }

    @Override
    public Stream<Task> getReadyTasks() {
        return readyQueue.stream();
    }

    @Override
    public Stream<Processor> getBusyProcessors() {
        return processorsManager.getBusyProcessors();
    }

    @Override
    public Stream<Processor> getReadyProcessors() {
        return processorsManager.getReadyProcessors();
    }


    @Override
    public void update(Observable o, Object arg) {
        processorsManager.execute();

    }
    public void loadProcessors(){
        while (processorsManager.isAvailable() && taskAvailable())
            processorsManager.loadTask(popTask());
    }
}
