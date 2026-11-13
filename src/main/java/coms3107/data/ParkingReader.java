package coms3107.data;
import coms3107.common.ParkingViolation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ParkingReader {

    private final String filename;

    public ParkingReader(String filename) {
        this.filename = filename;
    }

    public List<ParkingViolation> read() throws IOException {
        List<ParkingViolation> violations = new ArrayList<ParkingViolation>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;


            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",", -1);
                double fine = Double.parseDouble(parts[1]);
                String state = parts[4];
                String zip = parts[6];
                violations.add(new ParkingViolation(fine, state,zip));
            }
        }

        return violations;
    }


}
