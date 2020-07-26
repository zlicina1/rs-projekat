package ba.unsa.etf.rs.projekat.Vehicle;

import ba.unsa.etf.rs.projekat.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class VehicleDAOBase implements VehicleDAO {
    private static VehicleDAOBase instance = null;
    private Connection connection;
    private PreparedStatement getUserPs, addUserPs, getIdUserPs, updateUserPs, getVehiclesPs, getManufacturerPs, getOwnerPs, getUserPs2, getLocationPs,
             getFuelPs, getVehiclePs;

    public VehicleDAOBase() {
        String url = "jdbc:sqlite:database.db";
        try {
            connection = DriverManager.getConnection(url);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
             getUserPs = connection.prepareStatement("SELECT name, surname FROM User");
        }catch (SQLException e){
            regenerateBase();
            try {
                getUserPs = connection.prepareStatement("SELECT name, surname FROM User");
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }
        try {
            getIdUserPs = connection.prepareStatement("SELECT MAX(user_id) + 1 FROM User");
            addUserPs = connection.prepareStatement("INSERT INTO User VALUES (?,?,?,?,?,?)");
            getUserPs = connection.prepareStatement("SELECT * FROM User WHERE (username=? or email=?) AND password=?");
            getUserPs2 = connection.prepareStatement("SELECT * FROM User WHERE user_id=?");
            updateUserPs = connection.prepareStatement("UPDATE User SET name=?,surname=?,username=?,email=?,password=? WHERE user_id=?");
            getVehiclesPs = connection.prepareStatement("SELECT * FROM Vehicle");
            getVehiclePs = connection.prepareStatement("SELECT * FROM Vehicle WHERE vehicle_id=?");
            getManufacturerPs = connection.prepareStatement("SELECT * FROM Manufacturer WHERE manufacturer_id=?");
            getOwnerPs = connection.prepareStatement("SELECT * FROM Owner WHERE owner_id=?");
            getLocationPs = connection.prepareStatement("SELECT * FROM Location WHERE location_id=?");
            getFuelPs = connection.prepareStatement("SELECT * FROM Fuel WHERE fuel_id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static VehicleDAOBase getInstance() {
        if (instance == null) instance = new VehicleDAOBase();
        return instance;
    }

    private Vehicle getVehicle(int id){
        Vehicle vehicle = new Vehicle();
        try {
            getVehiclePs.setInt(1,id);
            ResultSet resultSet = getVehiclePs.executeQuery();
//            System.out.println(resultSet.getInt(1));
//            vehicle.setId(id);
//            vehicle.setManufacturer(getManufacturer(resultSet.getInt(2)));
//            vehicle.setOwner(getOwner(resultSet.getInt(3)));
//            vehicle.setAge(resultSet.getInt(4));
//            if (resultSet.getInt(5) == 1)
//                vehicle.setStatus(true);
//            else
//                vehicle.setStatus(false);
//            vehicle.setLocation(getLocation(resultSet.getInt(6)));
//            vehicle.setSpeed(resultSet.getDouble(7));
//            vehicle.setDrivingTime(resultSet.getDouble(8));
//            vehicle.setFuel(getFeul(resultSet.getInt(9)));
            Vehicle vehicle1 = new Vehicle(id,resultSet.getString(2),
                    getManufacturer(resultSet.getInt(3)),
                    getOwner(resultSet.getInt(4)),resultSet.getInt(5),true,
                            getLocation(resultSet.getInt(7)),resultSet.getDouble(8),
                                    resultSet.getDouble(9), getFuel(resultSet.getInt(10)));
            vehicle = vehicle1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    private Fuel getFuel(int anInt) {
        Fuel fuel = new Fuel();
        try {
            getFuelPs.setInt(1,anInt);
            ResultSet rs1 = getFuelPs.executeQuery();
            Fuel fuel1 = new Fuel(rs1.getInt(1),rs1.getString(2),rs1.getDouble(3));
            fuel = fuel1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fuel;
    }

    private Owner getOwner(int anInt) {
        Owner owner = new Owner();
        try {
            getOwnerPs.setInt(1,anInt);
            ResultSet rs1 = getOwnerPs.executeQuery();
            Owner owner1 = new Owner(anInt,getUser2(rs1.getInt(2)),getLocation(rs1.getInt(3)));
            owner = owner1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return owner;
    }

    private Location getLocation(int anInt) {
        Location location = new Location();
        try {
            getLocationPs.setInt(1,anInt);
            ResultSet rs1 = getLocationPs.executeQuery();
            Location location1 = new Location(anInt,rs1.getString(2),rs1.getString(3));
            location = location1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }

    private User getUser2(int anInt) {
        User user = null;
        try {
            getUserPs2.setInt(1, anInt);
            ResultSet resultSet1 = getUserPs2.executeQuery();
            if (resultSet1.next()) {
                user = new User(resultSet1.getString(1),resultSet1.getString(2), resultSet1.getString(3),
                        resultSet1.getString(4), resultSet1.getString(5),resultSet1.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private Manufacturer getManufacturer(int id){
        Manufacturer manufacturer = new Manufacturer();
        try {
            getManufacturerPs.setInt(1,id);
            ResultSet rs1 = getManufacturerPs.executeQuery();
            Manufacturer manufacturer1 = new Manufacturer(id,rs1.getString(2));
            manufacturer = manufacturer1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturer;
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
    public ObservableList<Vehicle> getVehicles() {
        ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
        try {
            ResultSet resultSet1 = getVehiclesPs.executeQuery();
            while (resultSet1.next()){
                Vehicle vehicle = getVehicle(resultSet1.getInt(1));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public void addUser(User user) {
        try {
            int id = 1;
            ResultSet resultSet1 = getIdUserPs.executeQuery();
            if (resultSet1.next()){
                id = resultSet1.getInt(1);
            }
            if (id == 0) id = 1;

            addUserPs.setInt(1,id);
            addUserPs.setString(2,user.getName());
            addUserPs.setString(3,user.getSurname());
            addUserPs.setString(4,user.getUsername());
            addUserPs.setString(5,user.getEmail());
            addUserPs.setString(6,user.getPassword());
            addUserPs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String usernameOrEmail, String password) {
        User user = null;
        try {
            getUserPs.setString(1, usernameOrEmail);
            getUserPs.setString(2, usernameOrEmail);
            getUserPs.setString(3, password);
            ResultSet resultSet1 = getUserPs.executeQuery();
            if (resultSet1.next()) {
                user = new User(resultSet1.getString(1),resultSet1.getString(2), resultSet1.getString(3),
                        resultSet1.getString(4), resultSet1.getString(5),resultSet1.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        try {
            updateUserPs.setString(1,user.getName());
            updateUserPs.setString(2,user.getSurname());
            updateUserPs.setString(3,user.getUsername());
            updateUserPs.setString(4,user.getEmail());
            updateUserPs.setString(5,user.getPassword());
            updateUserPs.setString(6,user.getId());
            updateUserPs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
