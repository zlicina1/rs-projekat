package ba.unsa.etf.rs.projekat;

import javafx.beans.property.*;

public class Vehicle {
    private SimpleIntegerProperty id;
    private SimpleObjectProperty<Manufacturer> manufacturer;
    private SimpleObjectProperty<Owner> owner;
    private SimpleIntegerProperty age;
    private SimpleBooleanProperty status;
    private SimpleObjectProperty<Location> location;
    private SimpleDoubleProperty speed;
    private SimpleDoubleProperty drivingTime;
    private SimpleObjectProperty<Fuel> fuelConsumption;

    public Vehicle(Integer id, Manufacturer manufacturer, Owner owner,
                   Integer age, Boolean status, Location location,
                   Double speed, Double drivingTime, Fuel fuelConsumption) {
        this.id = new SimpleIntegerProperty(id);
        this.manufacturer = new SimpleObjectProperty<>(manufacturer);
        this.owner = new SimpleObjectProperty<>(owner);
        this.age = new SimpleIntegerProperty(age);
        this.status = new SimpleBooleanProperty(status);
        this.location = new SimpleObjectProperty<>(location);
        this.speed = new SimpleDoubleProperty(speed);
        this.drivingTime = new SimpleDoubleProperty(drivingTime);
        this.fuelConsumption = new SimpleObjectProperty<>(fuelConsumption);
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

    public Fuel getFuelConsumption() {
        return fuelConsumption.get();
    }

    public SimpleObjectProperty<Fuel> fuelConsumptionProperty() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Fuel fuelConsumption) {
        this.fuelConsumption.set(fuelConsumption);
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
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
