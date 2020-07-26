package ba.unsa.etf.rs.projekat.Controller;

import ba.unsa.etf.rs.projekat.Vehicle.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VehicleController {
    public TextField fldIdVehicle;
    public TextField fldNameVehicle;
    public TextField fldManuVehicle;
    public TextField fldOwnerVehicle;
    public TextField fldStatusVehicle;
    public TextField fldAgeVehicle;
    public Vehicle vehicle;

    public VehicleController(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @FXML
    public void initialize(){
        System.out.println(vehicle);
        if (vehicle != null){
            fldIdVehicle.setText(String.valueOf(vehicle.getId()));
            fldNameVehicle.setText(vehicle.getName());
            fldManuVehicle.setText(vehicle.getManufacturer().getName());
            fldOwnerVehicle.setText(vehicle.getOwner().getUser().getName() + " " +  vehicle.getOwner().getUser().getSurname());
            fldAgeVehicle.setText(String.valueOf(vehicle.getAge()));
            if(vehicle.isStatus()) fldStatusVehicle.setText("1");
            else fldStatusVehicle.setText("0");
        }
    }

    public void ActionOk(ActionEvent actionEvent) {
    }

    public void cencelAction(ActionEvent actionEvent) {
    }
}
