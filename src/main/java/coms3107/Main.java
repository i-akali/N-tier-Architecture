package coms3107;
import coms3107.data.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {

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

        ParkingReader parkingReaderReader = new ParkingReader(args[0]);
        PopulationReader populationReader = new PopulationReader(args[1]);
        PropertyReader propertyReader = new PropertyReader(args[2]);

    }
}