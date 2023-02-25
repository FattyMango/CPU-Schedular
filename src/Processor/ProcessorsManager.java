package Processor;

import Task.Task;

import java.util.*;
import java.util.stream.Stream;


public class ProcessorsManager implements Manager {
    Queue<Processor> readyProcessors,busyProcessors;

    public ProcessorsManager(int numProcessors){
        readyProcessors = new LinkedList<>();
        busyProcessors = new LinkedList<>();
        setProcessors(numProcessors);

    }


    public void execute(){

        for (Iterator<Processor> iterator = busyProcessors.iterator(); iterator.hasNext();){
            Processor p = iterator.next();
            p.execute();
            if(p.isAvailable()){
                readyProcessors.add(p);
                iterator.remove();
            }

        }
    }

    public void loadTask(Task task){
        if (!isAvailable())
            return;
        Processor p = readyProcessors.remove();
        p.assignTask(task);
        busyProcessors.add(p);
    }
    public boolean isAvailable(){
        return !readyProcessors.isEmpty();
}



    public Stream<Processor> getBusyProcessors() {
        return busyProcessors.stream();
    }


    public Stream<Processor> getReadyProcessors() {
        return readyProcessors.stream();
    }

    private void setProcessors(int numProcessors) {

        for (int i =0;i<numProcessors;i++)
            addProcessor(new ProcessorGenOne());

    }
    private void addProcessor(Processor p){
        if(p.isAvailable())
            readyProcessors.add(p);
        else
            busyProcessors.add(p);
    }

}
