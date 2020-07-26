package ba.unsa.etf.rs.projekat.Controller;

import ba.unsa.etf.rs.projekat.User;
import ba.unsa.etf.rs.projekat.Vehicle.VehicleDAOBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class SingUpController {
    public PasswordField fldPassword;
    public TextField fldUserEmail;
    public Label LabelCorrectUser;
    private VehicleDAOBase vehicleDAOBase;
    private User user;

    public SingUpController() {
        vehicleDAOBase = VehicleDAOBase.getInstance();
    }

    public void ActionSignUp(ActionEvent actionEvent) throws IOException {
        user = vehicleDAOBase.getUser(fldUserEmail.getText(),fldPassword.getText());
        if (user != null) {
            LabelCorrectUser.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sign up - information");
            alert.setHeaderText("Welcome to app of the 'Fleet managment'");
            alert.setContentText("User: " + user.getName() + ", " + user.getSurname() + "\nusername: " + user.getUsername());
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            MainController mainController = new MainController(user);
            loader.setController(mainController);
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("User - Fleet managment");
            newStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            newStage.show();
        }
        else {
            LabelCorrectUser.setText("This user does not exist!\nPlease try again!");
        }
    }


}
