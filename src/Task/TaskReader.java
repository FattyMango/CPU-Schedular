package Task;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TaskReader implements FileReader {
    String fileName;
    public TaskReader(String fileName){
        setFileName(fileName);
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public Queue<Task> loadTasks(){
        Queue<Task> tasks = new LinkedList<Task>();
        try {

            FileInputStream ft = new FileInputStream(fileName);

                DataInputStream in = new DataInputStream(ft);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                line = br.readLine();
                int c=0,n;
                n = Integer.parseInt(line);
                while(c++<n&&(line = br.readLine()) != null){
                    int[] data = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
                    tasks.add(new SimpleTask(data[0],data[1],data[2]));
                }
                in.close();


            }
     catch (Exception e) {
         System.out.println("Error has occurred, please make sure the file provided is valid.");
         System.exit(0);

        }

        return tasks;
    }
}
