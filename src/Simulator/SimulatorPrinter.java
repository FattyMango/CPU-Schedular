package Simulator;

import Processor.Processor;
import Task.Task;

import java.util.Observable;
import java.util.Observer;
import java.util.stream.Stream;


public class SimulatorPrinter implements Observer {
    @Override
    public void update(Observable o, Object arg) {

        Simulator simulator = (Simulator) o;
        System.out.println("----------------------------------------------------------");
        System.out.println("Clock = "+arg+"\n");

        printAllTasks(simulator.getAllTasks());

        printTasks(simulator.getReadyTasks());
        System.out.println("Processors:\n\n\t Processor\t\tExecute\t\t(Task,Time)\n");
        printProcessors(simulator.getBusyProcessors());
        printProcessors(simulator.getReadyProcessors());
        System.out.println();


    }
    private void printAllTasks(Stream<Task> stream){
        System.out.print("All Tasks: ID(Arriving Time, Execution Time, Priority)\t\n\t[ ");

        stream.forEach(t -> System.out.printf("T%1$s (%2$s,%3$s,%4$s), ",t.getID(),t.getArrivingTime(),t.getExecutionTime(),t.getPriority() ));
        System.out.print("]\n\n");
    }
    private void printTasks(Stream<Task> stream) {
        System.out.print("Ready Tasks: ID(Execution Time, Priority)\t\n\t[ ");
        stream.forEach(t -> System.out.printf("T%1$s (%2$s,%3$s), ",t.getID(),t.getExecutionTime(),t.getPriority() ));
        System.out.print("]\n\n");

    }

    private void printProcessors(Stream <Processor> stream){
        stream.forEach(p -> {
                    if(p.getTask() != null)
                        System.out.printf("\t\tP%1$s\t\t\t  -->\t\t(T%2$s,%3$s)%n", p.getID(),p.getTask().getID(),p.getTask().getExecutionTime());
                    else
                        System.out.println("\t\tP"+p.getID()+"\t\t\t  -->\t\t(No Task)");
        });
    }

    }



