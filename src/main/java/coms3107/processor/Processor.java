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
}
