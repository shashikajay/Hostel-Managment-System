package lk.ijse.gdse.hostelManagement.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.hostelManagement.bo.BOFactory;
import lk.ijse.gdse.hostelManagement.bo.custom.StudentBO;
import lk.ijse.gdse.hostelManagement.dto.StudentDTO;
import org.hibernate.Session;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {
    
    public DatePicker txtDate;
    public TextField txtContact;
    public TextField txtAdress;
    public TextField txtstName;
    public TextField txtstId;
    public TableColumn <StudentDTO,String>colGender;
    public TableColumn <StudentDTO,String>colDob;
    public TableColumn <StudentDTO,String>colContact;
    public TableColumn <StudentDTO,String>colAddress;
    public TableColumn <StudentDTO,String>colStName;
    public TableColumn<StudentDTO,String> colstId;
    public TableView<StudentDTO> tblStudent;
    public AnchorPane contextPane;
    public ChoiceBox cmbGender;

    private Session session;
    private StudentBO studentBO = (StudentBO) BOFactory.getBO (BOFactory.BOTypes.STUDENT);

    @Override
    public void initialize(URL location, ResourceBundle resources)  {
            setGender ();
            setTableStudent ();
            loadAllStudent ();

    }

    public void onActionDelete(ActionEvent actionEvent) {
        String dob = String.valueOf (txtDate.getValue ());
        String gender = cmbGender.getValue ().toString ();
        StudentDTO studentDTO = new StudentDTO (txtstId.getText (), txtstName.getText (), txtAdress.getText (), txtContact.getText (), dob, gender);

        boolean isDeleted=studentBO.deleteStudent (studentDTO);

        if (isDeleted){
            new Alert (Alert.AlertType.INFORMATION, "Student Delete Succuss").show ();
            tblStudent.getItems ().clear ();
            clearData ();
            loadAllStudent ();
        }else{
            new Alert (Alert.AlertType.ERROR, "Something went Wrong").show ();
        }

    }

    public void onActionUpdate(ActionEvent actionEvent) {
        String dob = String.valueOf (txtDate.getValue ());
        String gender = cmbGender.getValue ().toString ();
        StudentDTO studentDTO = new StudentDTO (txtstId.getText (), txtstName.getText (), txtAdress.getText (), txtContact.getText (), dob, gender);

        boolean isUpdate=studentBO.updateStudent (studentDTO);

        if (isUpdate){
            new Alert (Alert.AlertType.INFORMATION, "Student Update Succuss").show ();
            tblStudent.getItems ().clear ();
            clearData ();
            loadAllStudent ();
        }else {
            new Alert (Alert.AlertType.ERROR, "Something went Wrong").show ();
        }
    }

    public void onActionSave(ActionEvent actionEvent) {
        String dob = String.valueOf (txtDate.getValue ());
        String gender = cmbGender.getValue ().toString ();
        StudentDTO studentDTO = new StudentDTO (txtstId.getText (), txtstName.getText (), txtAdress.getText (), txtContact.getText (), dob, "Male");
        studentBO.saveStudent(studentDTO);
        List<StudentDTO> allStudents = studentBO.loadAll ();
//        for (StudentDTO s : allStudents) {
//            if (s.getStId ().equals (txtstId.getText ())) {
//                new Alert (Alert.AlertType.ERROR, "This ID Already Have").show ();
//                break;
//            } else {
//                boolean isSaved = studentBO.saveStudent (studentDTO);
//                new Alert (Alert.AlertType.CONFIRMATION, "Student saved").show ();
//                tblStudent.getItems ().clear ();
//                clearData ();
//                loadAllStudent ();
//            }
//        }
    }

    public void setGender() {
        ObservableList<String> data = FXCollections.observableArrayList ("Male", "Female", "Other");
        cmbGender.setItems (data);
    }

    public void OnActionMouseClicked(MouseEvent mouseEvent) {


        try {
            int index = tblStudent.getSelectionModel ().getSelectedIndex ();
            String stId = colstId.getCellData (index).toString ();//select Column value
            StudentDTO dto = studentBO.getStudent (stId);
            txtstId.setText (dto.getStId ());
            txtstName.setText (dto.getStName ());
            txtAdress.setText (dto.getAddress ());
            txtContact.setText (dto.getContact ());
            txtDate.setValue (LocalDate.parse (dto.getDob ()));
            cmbGender.setValue (dto.getGender ());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setTableStudent() {

        colstId.setCellValueFactory (new PropertyValueFactory<> ("stId"));
        colStName.setCellValueFactory (new PropertyValueFactory<> ("stName"));
        colAddress.setCellValueFactory (new PropertyValueFactory<> ("address"));
        colDob.setCellValueFactory (new PropertyValueFactory<> ("dob"));
        colContact.setCellValueFactory (new PropertyValueFactory<> ("contact"));
        colGender.setCellValueFactory (new PropertyValueFactory<> ("gender"));

    }

    public void clearData() {
        txtstId.clear ();
        txtstName.clear ();
        txtAdress.clear ();
        txtContact.clear ();
        txtDate.setValue (null);
        cmbGender.setValue (null);
    }

    public void loadAllStudent() {

        try {
            List allStudents = studentBO.loadAll ();
            ObservableList observableList = FXCollections.observableArrayList (allStudents);
            tblStudent.setItems (observableList);
            System.out.println(observableList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


