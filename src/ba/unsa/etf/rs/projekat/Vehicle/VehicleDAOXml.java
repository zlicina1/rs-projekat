package ba.unsa.etf.rs.projekat.Vehicle;

import ba.unsa.etf.rs.projekat.*;
import ba.unsa.etf.rs.projekat.Vehicle.Vehicle;
import ba.unsa.etf.rs.projekat.Vehicle.VehicleDAO;
import javafx.collections.ObservableList;

import java.net.UnknownServiceException;

public class VehicleDAOXml implements VehicleDAO {
    @Override
    public ObservableList<Owner> getOwners() {
        return null;
    }

    @Override
    public ObservableList<Owner> getManufacturers() {
        return null;
    }

    @Override
    public ObservableList<Vehicle> getVehicles() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void addOwner(Owner owner) {

    }

    @Override
    public void addVehicle(Vehicle vehicle) {

    }

    @Override
    public void addManufacturer(Manufacturer manufacturer) {

    }

    @Override
    public void addLocation(Location location) {

    }

    @Override
    public void addFeul(Fuel fuel) {

    }

    @Override
    public User getUser(String string1, String string2) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void close() {

    }
}
