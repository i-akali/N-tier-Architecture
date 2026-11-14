package coms3107.ui;
import coms3107.processor.*;

import java.util.Scanner;

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
                case "3" -> showAverageMarketValue();
                case "4" -> showAverageLivableArea();
                default -> System.out.println("Please enter a number between 0-4");
            }
            printMenu();
        }
    }

    private void printMenu(){
        System.out.print(
                "0. Exit                                                                                                                                           \n" +
                "1. Total population for all ZIP Codes                                                                                                             \n" +
                "2. Parking fines per capita                                                                                                                       \n" +
                "3. Average market value                                                                                                                           \n" +
                "4. Average total livable area                                                                                                                     \n" +
                "Enter choice: ");
    }

    private void showTotalPopulation(){
        System.out.println(processor.getTotalPopulation());
    }

    private void showFinesPerCapita(){}

    private void showAverageMarketValue(){}

   private void showAverageLivableArea(){}


}
