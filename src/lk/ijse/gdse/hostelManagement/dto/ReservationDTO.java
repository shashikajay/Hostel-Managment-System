package lk.ijse.gdse.hostelManagement.dto;

import java.util.Date;

public class ReservationDTO {

    private String resID;

    public ReservationDTO(String resID, java.util.Date date, StudentDTO studentDTO, RoomDTO roomDTO, String status) {
        this.resID = resID;
        this.date = date;
        this.setStudentDTO (studentDTO);
        this.setRoomDTO (roomDTO);
        this.status = status;
    }

    private java.util.Date date;
    private StudentDTO studentDTO;
    private RoomDTO roomDTO;
    private String status;

    public String getResID() {
        return resID;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public RoomDTO getRoomDTO() {
        return roomDTO;
    }

    public void setRoomDTO(RoomDTO roomDTO) {
        this.roomDTO = roomDTO;
    }
}
