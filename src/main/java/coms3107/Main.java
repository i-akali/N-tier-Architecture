package coms3107;
import coms3107.data.*;
import coms3107.processor.Processor;
import coms3107.ui.UI;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args){

        if(args.length!= 3)
        {
            System.err.println("Usage: java coms3107.Main parking.csv properties.csv population.txt");
            return;
        }

        for(String n: args)
        {
            File data = new File(n);
            if(!data.exists() || !data.canRead() || !data.isFile())
            {
                System.err.println("File not found or not readable: " + n);
                return;
            }
        }

        try{
            ParkingReader parkingReader = new ParkingReader(args[0]);
            PropertyReader propertyReader = new PropertyReader(args[1]);
            PopulationReader populationReader = new PopulationReader(args[2]);

            Processor processor = new Processor(parkingReader, populationReader,
                    propertyReader);

            UI ui = new UI(processor);
            ui.start();
        }
        catch(IOException e){
            System.err.println("Error reading files: " + e.getMessage());
        }

    }
}