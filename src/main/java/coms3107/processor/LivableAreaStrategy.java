package coms3107.processor;
import coms3107.common.Property;

public class LivableAreaStrategy implements PropertyValueStrategy{
    @Override
    public Double getValue(Property property) {
        return property.getLivableArea();
    }
}
