package ba.unsa.etf.rs.projekat.Controller;

import ba.unsa.etf.rs.projekat.User;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    public MainController(User user) {
        this.user = user;
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
    }

}
