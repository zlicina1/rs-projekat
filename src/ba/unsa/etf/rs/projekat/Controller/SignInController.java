package ba.unsa.etf.rs.projekat.Controller;

import ba.unsa.etf.rs.projekat.User;
import ba.unsa.etf.rs.projekat.Vehicle.VehicleDAOBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInController {
    public TextField fldName;
    public TextField fldSurname;
    public TextField fldUsername;
    public TextField fldEmail;
    public PasswordField fldPassword;
    public Label LabelValidName;
    public Label LabelValidSurname;
    public Label LabelValidEmail;
    public Label LabelValidPassword;
    public Label LabelValidPassword2;
    public Label LabelValidUsername;
    private VehicleDAOBase daoBase;
    private User user;

    public SignInController() {
        daoBase = VehicleDAOBase.getInstance();
    }

    @FXML
    public void initialize(){
        fldName.textProperty().addListener((obs, oldUser, newUser) ->{
            if (newUser.isEmpty() || !ValidationOfNameSurname(newUser)){
                LabelValidName.setText("Field 'Name' is less than 3 characters!");
            }
            else{
                LabelValidName.setText("");
            }
        });
        fldSurname.textProperty().addListener((obs, oldUser, newUser) ->{
            if (newUser.isEmpty() || !ValidationOfNameSurname(newUser)){
                LabelValidSurname.setText("Field 'Surname' is less than 3 characters!");
            }
            else{
                LabelValidSurname.setText("");
            }
        });
        fldUsername.textProperty().addListener((obs, oldUser, newUser) ->{
            if (newUser.isEmpty() || !ValidationOfUsername(newUser)){
                LabelValidUsername.setText("Field 'Username' must have more than 5 characters and at least one number!");
            }
            else{
                LabelValidUsername.setText("");
            }
        });
    }

    public void ActionSignIn(ActionEvent actionEvent) {
        user = new User(fldName.getText(),fldSurname.getText(),fldUsername.getText(),fldEmail.getText(),fldPassword.getText());
        daoBase.addUser(user);
        System.out.println("Registered new user!");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Infomation");
        alert.setHeaderText("Redistered new user!");
        alert.setContentText("Please now login and go to server!");
        alert.showAndWait();
    }

    private boolean ValidationOfNameSurname(String name){
        String nameRegex = "[A-Za-z]{3,}$";
        Pattern pattern = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }
    private boolean ValidationOfUsername(String name){
        String nameRegex = "[A-Za-z0-9_]{5,}$";
        Pattern pattern = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }
}
