package lk.ijse.gdse.hostelManagement.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.hostelManagement.bo.BOFactory;
import lk.ijse.gdse.hostelManagement.bo.custom.ReservationBO;
import lk.ijse.gdse.hostelManagement.dto.ReservationDTO;
import lk.ijse.gdse.hostelManagement.dto.RoomDTO;
import lk.ijse.gdse.hostelManagement.dto.StudentDTO;

import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationFormController {
    public TextField txtStName;
    public TextField txtRoomType;
    public ChoiceBox cmbRoomId;
    public ChoiceBox cmbStId;
    public TextField txtQty;
    public RadioButton rbnPayNow;
    public TextField txtResId;
    public ChoiceBox cmbStatus;
    public AnchorPane contextPane;
    private ReservationBO resBO = (ReservationBO) BOFactory.getBO (BOFactory.BOTypes.RESERVATION);

    public void onActionSaveRes(ActionEvent actionEvent) {
        StudentDTO studentDTO=getStudnetDetail ();
        RoomDTO roomDTO=getRoomDetail ();
        String resId=txtResId.getText ();
        String status=cmbStatus.getValue ().toString ();
        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        try {
            boolean isSaveReservation = resBO.saveReservation (
                    new ReservationDTO(
                            resId,
                            sqlDate,
                            studentDTO,
                            roomDTO,
                            status
                    ));
            if (isSaveReservation){
                RoomDTO room=getRoomDetail ();
                System.out.println (room.getQty ()-1);
                room.setQty (room.getQty ()-1);
                resBO.updateRoom (room);
            }

        }catch (Exception e){
            e.printStackTrace ();
        }
    }

    private RoomDTO getRoomDetail() {
        String roomId=cmbRoomId.getValue ().toString ();
        return resBO.getRoom (roomId);
    }

    private StudentDTO getStudnetDetail() {
        String stId=cmbStId.getValue ().toString ();
        return resBO.getStudent (stId);
    }

    public void onActionUpdateRes(ActionEvent actionEvent) {
        String stId=cmbStId.getValue ().toString ();
        String roomID=cmbRoomId.getValue ().toString ();
        String status=cmbStatus.getValue ().toString ();
        String resId=txtResId.getText ();
        StudentDTO studentDTO=getStudnetDetail ();
        RoomDTO roomDTO=getRoomDetail ();
        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        try{
            boolean isUpdate=resBO.updateReservation (
                    new ReservationDTO (
                            resId,
                            sqlDate,
                            studentDTO,
                            roomDTO,
                            status
                    ));
        }catch (Exception e){
            e.printStackTrace ();
        }
    }

    public void onActionDeleteRes(ActionEvent actionEvent) {

    }
    @FXML
    void initialize() {
        setIds ();
        setData();
        setStatus ();
    }

    private void setData() {
        cmbStId.setOnAction(event -> {
            String stId=cmbStId.getValue ().toString ();
            StudentDTO dto = resBO.getStudent (stId);
            txtStName.setText (dto.getStName ());
        });


        cmbRoomId.setOnAction(event -> {
            String roomId=cmbRoomId.getValue ().toString ();
            RoomDTO dto = resBO.getRoom (roomId);
            txtRoomType.setText (dto.getType ());
            txtQty.setText (String.valueOf (dto.getQty ()));
        });
    }

    public void setIds(){
        List<String> stIds=resBO.getStudentIds ();
        ObservableList<String> student = FXCollections.observableArrayList (stIds);
        cmbStId.setItems (student);
        System.out.println(student);

        List<String> roomIds=resBO.getRoomIds ();
        ObservableList room = FXCollections.observableArrayList (roomIds);
        cmbRoomId.setItems (room);
        System.out.println(room);

    }

    public void setStatus(){
        ObservableList<String> data = FXCollections.observableArrayList ("PAID", "UNPAID");
        cmbStatus.setItems (data);
    }
}
