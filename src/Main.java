import Simulator.*;


public class Main {
    public static void main(String[] args)  {

        try {
            Simulator s = new SimpleSimulator(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
            SimulatorPrinter printer = new SimulatorPrinter();
            s.subscribe(printer);
            s.start();

        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You must provide all arguments.");
        }
        catch (NumberFormatException e){
            System.out.println("The arguments given are invalid. (expected : Integer, given: String)");
        }
        catch (Exception e ){
            e.printStackTrace();
        }



    }
}