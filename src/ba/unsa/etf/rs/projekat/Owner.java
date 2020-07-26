package ba.unsa.etf.rs.projekat;

import ba.unsa.etf.rs.projekat.Vehicle.Vehicle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Owner {
    private SimpleIntegerProperty id;
    private SimpleObjectProperty<User> user;
    private SimpleObjectProperty<Location> location;

    public Owner(int id, User user, Location location) {
        this.id = new SimpleIntegerProperty(id);
        this.user = new SimpleObjectProperty<>(user);
        this.location = new SimpleObjectProperty<>(location);
    }

    public Owner() {
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

    public User getUser() {
        return user.get();
    }

    public SimpleObjectProperty<User> userProperty() {
        return user;
    }

    public void setUser(User user) {
        this.user.set(user);
    }

    public Location getLocation() {
        return location.get();
    }

    public SimpleObjectProperty<Location> locationProperty() {
        return location;
    }

    public void setLocation(Location location) {
        this.location.set(location);
    }

    @Override
    public String toString() {
        return id.getName();
    }
}
