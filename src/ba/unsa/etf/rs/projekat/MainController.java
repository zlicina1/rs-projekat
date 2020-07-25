package ba.unsa.etf.rs.projekat;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private VBox vbox;
    private Parent fxml;
    private SignInController SignInController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("/fxml/signIn.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }
            catch(IOException ex){

            }
        });
    }

    @FXML
    public void open_SignUp(ActionEvent actionEvent) {
        System.out.println("Sign Up");
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(0);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("/fxml/signUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }
            catch(IOException ex){

            }
        });
    }

    @FXML
    public void open_SignIn(ActionEvent actionEvent) {
        System.out.println("Sign In");
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("/fxml/signIn.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }
            catch(IOException ex){

            }
        });
    }

    @FXML
    public void ActionSignIn(ActionEvent actionEvent) {
        System.out.println("fdgfdgfd");
        //   User newUser = new User(fldName.getText(),fldSurname.getText(),fldUsername.getText(),fldEmail.getText(),fldPassword.getText());
        //    daoBase.addUser(newUser);
    }
}
