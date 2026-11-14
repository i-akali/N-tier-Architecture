package coms3107.processor;
import coms3107.data.*;
import coms3107.common.*;

import java.io.IOException;
import java.util.*;


public class Processor {
    private final List<ParkingViolation> violations;
    private final List<Property> properties;
    private final Map<String, Integer> populations;

    public Processor(ParkingReader parkingReader,
                     PopulationReader populationReader,
                     PropertyReader propertyReader  ) throws IOException {
        violations = parkingReader.read();
        properties = propertyReader.read();
        populations = populationReader.read();
    }

    public int getTotalPopulation() {
        int sum = 0;
        for(int n:  populations.values()) {sum += n;}
        return sum;
    }

    public Map<String, Double> getFinesPerCapita(){

        Map<String, Double> totalFines = new HashMap<>();

        for(ParkingViolation n: violations) {
            if(n.getZip().length() < 5 || !n.getStatePlate().equals("PA") || n.getFine() == 0)
            {
                continue;
            }
            totalFines.put(n.getZip(),
                    totalFines.getOrDefault(n.getZip(), 0.0) + n.getFine());
        }

        Map<String, Double> finesPerCapita = new TreeMap<>();

        for(String zip: totalFines.keySet()){

            if(populations.get(zip) == null || populations.get(zip) == 0) {
                continue;
            }
            finesPerCapita.put(zip, totalFines.get(zip)/populations.get(zip));
        }

        return finesPerCapita;
    }

    private int getAverage(String zip, PropertyValueStrategy strategy){

        double sum = 0;
        int count = 0;

        for(Property property: properties)
        {
            if(!property.getZip().equals(zip)){continue;}
            if(strategy.getValue(property) == null || strategy.getValue(property) == 0){continue;}
            sum += strategy.getValue(property);
            count++;
        }

        if(count == 0){return 0;}

        return (int)Math.round(sum/count);

    }
}
