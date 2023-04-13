package lk.ijse.gdse.hostelManagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController {
    public AnchorPane LoginPane;
    public TextField txtUName;
    public PasswordField txtPass;
    public static String userName="admin";
    public static String password="1234";
    public ImageView imgClosed;
    public ImageView imgOpen;
    public TextField txtPassShow;
    public ImageView imgEyeClosed;


    public void btnSign(ActionEvent actionEvent) throws IOException {
        if (txtUName.getText().equals(userName) && txtPass.getText().equals(password)) {
            Stage stage = (Stage) LoginPane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/gdse/hostelManagement/view/MainForm.fxml"))));
        }
    }
}
