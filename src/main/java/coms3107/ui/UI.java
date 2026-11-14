package coms3107.ui;
import coms3107.processor.*;
import java.util.*;

public class UI {
    private final Processor processor;
    private final Scanner scanner;


    public UI(Processor processor){
        this.processor = processor;
        scanner = new Scanner(System.in);
    }

    public void start(){

        printMenu();
        while(scanner.hasNextLine()){

            String input = scanner.nextLine().trim();
            switch (input) {
                case "0" -> {return;}
                case "1" -> showTotalPopulation();
                case "2" -> showFinesPerCapita();
                case "3" -> {
                    System.out.println("Please enter a ZIP code: ");
                    if(scanner.hasNextLine()) showAverageMarketValue(scanner.nextLine().trim());
                }
                case "4" -> {
                    System.out.println("Please enter a ZIP code: ");

                    if(scanner.hasNextLine()) showAverageLivableArea(scanner.nextLine().trim());

                }
                default -> System.out.println("Please enter a number between 0-4");
            }
            printMenu();
        }
    }

    private void printMenu(){
        System.out.print(
                "0. Exit\n" +
                "1. Total population for all ZIP Codes\n" +
                "2. Parking fines per capita\n" +
                "3. Average market value\n" +
                "4. Average total livable area\n" +
                "Enter choice: ");
    }

    private void showTotalPopulation(){
        System.out.println(processor.getTotalPopulation());
    }

    private void showFinesPerCapita(){
        for (Map.Entry<String, Double> entry : processor.getFinesPerCapita().entrySet()) {
            System.out.println(entry.getKey() + " " + String.format("%.4f", entry.getValue()));
        }
    }

    private void showAverageMarketValue(String zip){
        System.out.println(processor.getAverageMarketValue(zip));
    }

   private void showAverageLivableArea(String zip){
       System.out.println(processor.getAverageLivableArea(zip));
   }


}
