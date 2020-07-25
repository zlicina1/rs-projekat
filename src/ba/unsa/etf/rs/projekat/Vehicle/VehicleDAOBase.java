package ba.unsa.etf.rs.projekat.Vehicle;

import ba.unsa.etf.rs.projekat.*;
import javafx.collections.ObservableList;

import java.sql.*;

public class VehicleDAOBase implements VehicleDAO {
    private static VehicleDAOBase instance = null;
    private Connection connection;
    private PreparedStatement getUserPs, addUserPs, getIdUserPs;

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
            getUserPs = connection.prepareStatement("SELECT name, surname FROM User WHERE (username=? or email=?) AND password=?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static VehicleDAOBase getInstance() {
        if (instance == null) instance = new VehicleDAOBase();
        return instance;
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
    public void getUser(String usernameOrEmail, String password) {
        try {
            getUserPs.setString(1,usernameOrEmail);
            getUserPs.setString(2,usernameOrEmail);
            getUserPs.setString(3,password);
            ResultSet resultSet1 = getUserPs.executeQuery();
            System.out.println(resultSet1.next());
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
