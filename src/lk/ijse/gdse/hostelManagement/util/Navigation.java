package lk.ijse.gdse.hostelManagement.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route , AnchorPane pane) throws IOException {
        Navigation.pane=pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route){
            case STUDENT:
                initUI("/lk/ijse/gdse/hostelManagement/view/StudentForm.fxml");
                break;
            case ROOM:
                initUI("/lk/ijse/gdse/hostelManagement/view/RoomForm.fxml");
                break;
            case RESERVATION:
                initUI("/lk/ijse/gdse/hostelManagement/view/ReservationForm.fxml");
                break;
            case contextPane:
                initUI("/lk/ijse/gdse/hostelManagement/view/MainForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR,"No UI Found");
        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/gdse/hostelManagement/view" + location)));
    }
}
