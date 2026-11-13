package coms3107.common;

public class Property {
    private final Double marketValue;
    private final Double livableArea;
    private final String zip;

    public Property(Double marketValue, Double livableArea, String zip) {
        this.marketValue = marketValue;
        this.livableArea = livableArea;
        this.zip = zip;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public String getZip() {
        return zip;
    }

    public Double getLivableArea() {
        return livableArea;
    }
}
