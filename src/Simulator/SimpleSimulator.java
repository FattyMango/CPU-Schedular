package Simulator;

import Clock.*;
import Processor.*;
import Schedular.*;
import Task.*;

import java.util.*;
import java.util.stream.Stream;


public class SimpleSimulator extends  Simulator {

    Queue <Task> tasks;
    Queue <Clock> clocks;
    Schedular schedular;

    public SimpleSimulator(int processors , int clocks,String fileName){

        setClocks(clocks);
        schedular = new PrioritySchedular(new ProcessorsManager(processors));
        tasks = new TaskReader(fileName).loadTasks();
        subscribe(schedular);

    }

    @Override
    public void start() throws InterruptedException {
        Clock clock;
        while(!clocks.isEmpty()){
            clock = clocks.poll();

            loadTasks(clock.getID());
            schedular.loadProcessors();


            setChanged();
            notifyObservers(clock.getID());

            clock.run();
        }
    }
    private void loadTasks(int id){
        while (!tasks.isEmpty()&&tasks.peek().getArrivingTime() <= id)
            schedular.addTask(tasks.poll());
    }
    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void subscribe(Observer o) {
        addObserver(o);
    }

    @Override
    public Stream<Processor> getBusyProcessors() {
        return schedular.getBusyProcessors();
    }

    @Override
    public Stream<Processor> getReadyProcessors() {
        return schedular.getReadyProcessors();
    }

    @Override
    public Stream<Task> getReadyTasks() {
        return schedular.getReadyTasks();
    }

    @Override
    public Stream<Task> getAllTasks() {
        return tasks.stream();
    }



    private void setClocks(int numClocks) {
        clocks = new LinkedList<>();
        for (int i =0;i<numClocks;i++)
            clocks.add(new OneSecondClock());
    }
}
