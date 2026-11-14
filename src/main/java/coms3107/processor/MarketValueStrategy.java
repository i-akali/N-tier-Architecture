package coms3107.processor;
import coms3107.common.Property;

public class MarketValueStrategy implements PropertyValueStrategy{

    @Override
    public Double getValue(Property property) {
        return property.getMarketValue();
    }
}
