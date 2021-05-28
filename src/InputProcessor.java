import java.util.Scanner;

public class InputProcessor {
    private Manager manager;
    private Scanner scanner = new Scanner(System.in);
    public InputProcessor(Manager manager) {
        this.manager = manager;
    }


    private void processBuyAnimal(String[] split){}
    private void processPickupProduct(String[] split){}
    private void processFillWaterBucket(){}
    private void processPlanting(String[] split){}
    private void processStartingWorkshop(String[] split){}
    private void processCage(String[] split){}
    private void processGoingForwardTime(String[] split){}
    private void processLoadingProducts(String[] split){}
    private void processUnloadingProduct(String[] split){}
    private void processStartTrip(){}

    public void run(){
        String input;
        boolean logout = false;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("exit")){
            while (!input.equalsIgnoreCase("logout")){
                if (input.matches("^(?i)buy\\s+(\\w+)\\s*$")){
                    processBuyAnimal(input.split("\\s+"));
                }else if (input.matches("^(?i)pickup\\s+(\\d\\s+\\d)\\s*$")){
                    processPickupProduct(input.split("\\s+"));
                }else if (input.matches("^(?i)well\\s*$")){
                    processFillWaterBucket();
                }else if (input.matches("^(?i)plant\\s+(\\d\\s+\\d)\\s*$")){
                    processPlanting(input.split("\\s+"));
                }else if (input.matches("^(?i)work\\s+(\\w+)\\s*$")){
                    processStartingWorkshop(input.split("\\s+"));
                }else if (input.matches("^(?i)cage\\s+(\\d\\s+\\d)\\s*$")){
                    processCage(input.split("\\s+"));
                }else if (input.matches("^(?i)turn\\s+(\\d+)\\s*$")){
                    processGoingForwardTime(input.split("\\s+"));
                }else if (input.matches("^(?i)(truck\\s+load)\\s+(\\w+)\\s*$")){
                    processLoadingProducts(input.split("\\s+"));
                }else if (input.matches("^(?i)(truck\\s+unload)\\s+(\\w+)\\s*$")){
                    processUnloadingProduct(input.split("\\s+"));
                }else if (input.matches("^(?i)(truck\\s+go)\\s*$")){
                    processStartTrip();
                }else System.err.println("Invalid Input !");
            }
        }
    }

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
}
