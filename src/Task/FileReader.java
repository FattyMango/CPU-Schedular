package Task;

import java.util.Queue;

public interface FileReader {
    public void setFileName(String fileName);
    public Queue<Task> loadTasks();
}
