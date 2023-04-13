package lk.ijse.gdse.hostelManagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gdse.hostelManagement.util.Navigation;
import lk.ijse.gdse.hostelManagement.util.Routes;

import java.io.IOException;

public class MainFormController {
    public AnchorPane contextPane;
    public Button resId;
    public Button stManageId;
    public Button roomId;

    public void onActionLogOut(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/lk/ijse/gdse/hostelManagement/view/LoginForm.fxml"));
        Parent parent=fxmlLoader.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public void onActionRervation(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RESERVATION,contextPane);
    }

    public void onActionStudent(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENT,contextPane);

    }

    public void onActionRoom(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ROOM,contextPane);

    }
}
