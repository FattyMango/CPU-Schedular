package Clock;

import java.util.Observable;

public interface Clock  {
    public void run() throws InterruptedException;
    public int getID();
}
