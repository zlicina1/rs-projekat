package ba.unsa.etf.rs.projekat.Controller;

import ba.unsa.etf.rs.projekat.Vehicle.VehicleDAOBase;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SingUpController {
    public PasswordField fldPassword;
    public TextField fldUserEmail;
    private VehicleDAOBase vehicleDAOBase;

    public SingUpController() {
        vehicleDAOBase = VehicleDAOBase.getInstance();
    }

    public void ActionSignUp(ActionEvent actionEvent) {
        vehicleDAOBase.getUser(fldUserEmail.getText(),fldPassword.getText());
    }


}
