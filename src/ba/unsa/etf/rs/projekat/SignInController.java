package ba.unsa.etf.rs.projekat;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {
    public TextField fldName;
    public TextField fldSurname;
    public TextField fldUsername;
    public TextField fldEmail;
    public PasswordField fldPassword;
    private VehicleDAOBase daoBase;
    private User user;

    public SignInController() {
        daoBase = VehicleDAOBase.getInstance();
    }

    public void ActionSignIn(ActionEvent actionEvent) {
        user = new User(fldName.getText(),fldSurname.getText(),fldUsername.getText(),fldEmail.getText(),fldPassword.getText());
        daoBase.addUser(user);
        System.out.println("Registrovan korisnik!");
    }
}
