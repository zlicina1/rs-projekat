package ba.unsa.etf.rs.projekat.Vehicle;

import ba.unsa.etf.rs.projekat.Fuel;
import ba.unsa.etf.rs.projekat.Location;
import ba.unsa.etf.rs.projekat.Manufacturer;
import ba.unsa.etf.rs.projekat.Owner;
import javafx.beans.property.*;

public class Vehicle {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleObjectProperty<Manufacturer> manufacturer;
    private SimpleObjectProperty<Owner> owner;
    private SimpleIntegerProperty age;
    private SimpleBooleanProperty status;
    private SimpleObjectProperty<Location> location;
    private SimpleDoubleProperty speed;
    private SimpleDoubleProperty drivingTime;
    private SimpleObjectProperty<Fuel> fuel;

    public Vehicle(int id, String name, Manufacturer manufacturer, Owner owner,
                   Integer age, Boolean status, Location location,
                   Double speed, Double drivingTime, Fuel fuel) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.manufacturer = new SimpleObjectProperty<>(manufacturer);
        this.owner = new SimpleObjectProperty<>(owner);
        this.age = new SimpleIntegerProperty(age);
        this.status = new SimpleBooleanProperty(status);
        this.location = new SimpleObjectProperty<>(location);
        this.speed = new SimpleDoubleProperty(speed);
        this.drivingTime = new SimpleDoubleProperty(drivingTime);
        this.fuel = new SimpleObjectProperty<>(fuel);
    }

    public Vehicle() {
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

    public Manufacturer getManufacturer() {
        return manufacturer.get();
    }

    public SimpleObjectProperty<Manufacturer> manufacturerProperty() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer.set(manufacturer);
    }

    public Owner getOwner() {
        return owner.get();
    }

    public SimpleObjectProperty<Owner> ownerProperty() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner.set(owner);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public boolean isStatus() {
        return status.get();
    }

    public SimpleBooleanProperty statusProperty() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status.set(status);
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

    public double getSpeed() {
        return speed.get();
    }

    public SimpleDoubleProperty speedProperty() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed.set(speed);
    }

    public double getDrivingTime() {
        return drivingTime.get();
    }

    public SimpleDoubleProperty drivingTimeProperty() {
        return drivingTime;
    }

    public void setDrivingTime(double drivingTime) {
        this.drivingTime.set(drivingTime);
    }

    public Fuel getFuel() {
        return fuel.get();
    }

    public SimpleObjectProperty<Fuel> fuelProperty() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel.set(fuel);
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", manufacturer=" + manufacturer +
                ", owner=" + owner +
                ", age=" + age +
                ", status=" + status +
                ", location=" + location +
                ", speed=" + speed +
                ", drivingTime=" + drivingTime +
                ", fuel=" + fuel +
                '}';
    }
}
