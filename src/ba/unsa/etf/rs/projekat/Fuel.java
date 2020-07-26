package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Fuel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty fuelConsumption;


    public Fuel(int id, String name, Double fuelConsumption) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.fuelConsumption = new SimpleDoubleProperty(fuelConsumption);
    }

    public Fuel() {
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getFuelConsumption() {
        return fuelConsumption.get();
    }

    public SimpleDoubleProperty fuelConsumptionProperty() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption.set(fuelConsumption);
    }

    @Override
    public String toString() {
        return name.get();
    }
}
