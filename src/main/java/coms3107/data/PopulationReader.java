package coms3107.data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PopulationReader {
    private final String filename;

    public PopulationReader(String filename) {
        this.filename = filename;
    }

    // Each line is "<zip> <population>"; returns a map from ZIP Code to population
    public Map<String, Integer> read() throws IOException {
        Map<String, Integer> populations = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s+");
                String zip = parts[0];
                int population = Integer.parseInt(parts[1]);
                populations.put(zip, population);
            }
        }

        return populations;
    }
}
