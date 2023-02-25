package Processor;

import Task.Task;

import java.util.concurrent.atomic.AtomicInteger;

public class ProcessorGenOne implements Processor {
    private static final AtomicInteger count = new AtomicInteger(0);

    private Task task;
    private int ID;
    public ProcessorGenOne(){
        this.task = null;
        this.ID= count.incrementAndGet();
    }
    private void checkTask(){
        if(task.hasFinished())
            task = null;

    }
    @Override
    public void execute() {
        if(task ==  null)
            throw new NullPointerException();
        task.execute();
        checkTask();
    }

    @Override
    public boolean assignTask(Task task) {
        if(isAvailable()){
            this.task = task;
            return true;
        }
        throw new StackOverflowError();
    }

    @Override
    public boolean isAvailable() {
        return this.task == null;
    }

    @Override
    public Task getTask() {
        return task;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        if(task != null)
            return "Processor"+ID+" ("+ task+")";
        return "Processor"+ID+" ()";
    }

}
