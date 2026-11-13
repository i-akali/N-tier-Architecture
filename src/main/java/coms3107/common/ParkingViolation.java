package coms3107.common;

public class ParkingViolation {
    private final double fine;
    private final String statePlate;
    private final String zip;

    public ParkingViolation(double fine, String statePlate, String zip) {
        this.fine = fine;
        this.statePlate = statePlate;
        this.zip = zip;
    }

    public double getFine() { return fine; }
    public String getStatePlate() { return statePlate;}
    public String getZip() { return zip; }
}
