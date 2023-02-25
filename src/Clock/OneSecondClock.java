package Clock;

import java.util.Observable;
import java.util.concurrent.atomic.AtomicInteger;

public class OneSecondClock implements Clock  {
    private static final AtomicInteger count = new AtomicInteger(0);

    private int ID;
    int duration;
    public OneSecondClock(){
        this.ID =  count.incrementAndGet();
        this.duration = 1000;

    }
    @Override
    public void run() throws InterruptedException {

        Thread.sleep(duration);
    }

    @Override
    public int getID() {
        return ID;
    }


}
