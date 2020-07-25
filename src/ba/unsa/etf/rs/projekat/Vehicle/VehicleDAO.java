package ba.unsa.etf.rs.projekat.Vehicle;

import ba.unsa.etf.rs.projekat.*;
import ba.unsa.etf.rs.projekat.Vehicle.Vehicle;
import javafx.collections.ObservableList;

public interface VehicleDAO {
    ObservableList<Owner> getOwners();
    ObservableList<Owner> getManufacturers();
    ObservableList<Owner> getVehicles();
    void addUser(User user);
    void addOwner(Owner owner);
    void addVehicle(Vehicle vehicle);
    void addManufacturer(Manufacturer manufacturer);
    void addLocation(Location location);
    void addFeul(Fuel fuel);
    void getUser(String string1, String string2);
    void close();
}
