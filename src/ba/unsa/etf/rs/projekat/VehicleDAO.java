package ba.unsa.etf.rs.projekat;

import javafx.collections.ObservableList;

public interface VehicleDAO {
    ObservableList<Owner> getOwners();
    ObservableList<Owner> getManufacturers();
    ObservableList<Owner> getVehicles();
    void addOwner(Owner owner);
    void addVehicle(Vehicle vehicle);
    void addManufacturer(Manufacturer manufacturer);
    void addLocation(Location location);
    void addFeul(Fuel fuel);
    void close();
}
