package coms3107.data;
import coms3107.common.Property;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PropertyReader {
    private final String filename;

    public PropertyReader(String filename) {
        this.filename = filename;
    }

    public List<Property> read() throws IOException{
        List<Property> properties = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] headers = line.split(",");
            int mv = -1, la = -1,zp = -1;

            for(int i =0; i < headers.length; i++) {
                switch (headers[i]) {
                    case "market_value" -> mv = i;
                    case "total_livable_area" -> la = i;
                    case "zip_code" -> zp = i;
                }
            }
            if (mv == -1 || la == -1 || zp == -1) {
                throw new IOException("Properties file is missing a required column (market_value, total_livable_area, or zip_code)");
            }
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",", -1);
                Double marketValue = parseOrNull(parts[mv]);
                Double livableArea = parseOrNull(parts[la]);
                String zip = parts[zp].length() < 5 ? "": parts[zp].substring(0,5);
                properties.add(new Property(marketValue, livableArea, zip));
            }
        }
        return properties;
    }

    // Returns null for missing or non-numeric values so each field is validated independently
    private Double parseOrNull(String text) {
        try {
            return Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
