package ba.unsa.etf.rs.projekat;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleDAOBase implements VehicleDAO {
    private static VehicleDAOBase instance = null;
    private Connection connection;
    private PreparedStatement getUserPs;

    public VehicleDAOBase() {
        String url = "jdbc:sqlite:database.db";
        try {
            connection = DriverManager.getConnection(url);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
             getUserPs = connection.prepareStatement("SELECT name, surname, location_id FROM User, Location WHERE User.location_id = Location.location_id WHERE user.user_id=?");
        }catch (SQLException e){
            regenerateBase();
            try {
                getUserPs = connection.prepareStatement("SELECT name, surname, location_id FROM User, Location WHERE User.location_id = Location.location_id WHERE user.user_id=?");
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }

    @Override
    public ObservableList<Owner> getOwners() {
        return null;
    }

    @Override
    public ObservableList<Owner> getManufacturers() {
        return null;
    }

    @Override
    public ObservableList<Owner> getVehicles() {
        return null;
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
    public void close() {

    }

    private void regenerateBase() {
    }
}
