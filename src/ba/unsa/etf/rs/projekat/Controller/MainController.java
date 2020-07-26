package ba.unsa.etf.rs.projekat.Controller;

import ba.unsa.etf.rs.projekat.User;
import ba.unsa.etf.rs.projekat.Vehicle.VehicleDAOBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class MainController {
    public ImageView imageIconProfile;
    public Label LabelWelcome;
    public TextArea textArea1;
    public Label LabelProfile;
    public ImageView imageIconHome;
    public Hyperlink firstLink;
    public Hyperlink secondLink;
    public TextArea textArea2;
    public User user;
    public TextField fldId;
    public TextField fldName;
    public TextField fldSurname;
    public TextField fldUsername;
    public TextField fldEmail;
    public TextField fldPassword;
    private VehicleDAOBase dao;

    public MainController(User user) {
        this.user = user;
        dao = VehicleDAOBase.getInstance();
    }

    @FXML
    public void initialize(){
        Image image = new Image("/img/icons8-landlord-80.png");
        LabelWelcome.setText("Welcome ");
        imageIconProfile.setImage(image);
        textArea1.setText("Fleet management is the management of:\n" +
                "\n" +
                "Commercial motor vehicles such as cars, vans, trucks, specialist vehicles (such as mobile construction machinery), forklifts, and trailers\n" +
                "Private vehicles used for work purposes (the 'grey fleet'[1])\n" +
                "Aviation machinery such as aircraft (planes and helicopters)\n" +
                "Ships\n" +
                "Rail cars.\n" +
                "Non-powered assets such as generators, tanks, gear boxes, dumpsters, shipping containers, trailers, excavators, and other equipment that can't run on its own power.");
        firstLink.setText("https://en.wikipedia.org/wiki/Fleet_management");
        firstLink.setVisited(true);
        textArea2.setText("In the UK, in April 2008, the Corporate Manslaughter Act was strengthened to target company directors as well as their drivers in cases of road deaths involving vehicles used on business. The Police have said they now treat every road death as ‘an unlawful killing’ and have the power to seize company records and computers during their investigations. They will bring prosecutions against company directors who fail to provide clear policies and guidance for their employees driving at work.[citation needed]Unfortunately, in the UK a number of businesses are failing to meet their duty of care. In particular " +
                "\nprosecutions can be brought against company directors for failing to meet their duty of " +
                "\ncare and allowing HGV driver hours to exceed the legal limits.");
        fldId.setText(String.valueOf(user.getId()));
        fldName.setText(user.getName());
        fldSurname.setText(user.getSurname());
        fldUsername.setText(user.getUsername());
        fldEmail.setText(user.getEmail());
        fldPassword.setText(user.getPassword());
    }

    public void actionSignOut(ActionEvent actionEvent) throws IOException {
        Scene scene = textArea1.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
//        Parent root = loader.load();
//        Stage newStage = new Stage();
//        newStage.setTitle("User - Fleet managment");
//        newStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
//        newStage.show();
    }

    public void actionUpdate(ActionEvent actionEvent) {
        User user1 = new User(fldId.getText(),fldName.getText(),fldSurname.getText(),fldUsername.getText(),fldEmail.getText(),fldPassword.getText());
        int YesOrNo = JOptionPane.showConfirmDialog(null,"Are you sure you want to update the data?","Update user",JOptionPane.YES_NO_OPTION);
        if (YesOrNo == 0){
            dao.updateUser(user1);
        }
    }
}
