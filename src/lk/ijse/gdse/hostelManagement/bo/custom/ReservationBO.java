package lk.ijse.gdse.hostelManagement.bo.custom;

import lk.ijse.gdse.hostelManagement.bo.SuperBO;
import lk.ijse.gdse.hostelManagement.dto.ReservationDTO;
import lk.ijse.gdse.hostelManagement.dto.RoomDTO;
import lk.ijse.gdse.hostelManagement.dto.StudentDTO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    List<String> getStudentIds();
    List<String> getRoomIds();
    StudentDTO getStudent(String id);
    RoomDTO getRoom(String id);
    boolean updateRoom(RoomDTO dto);
    List<ReservationDTO> loadAllRes();
    boolean saveReservation(ReservationDTO dto);
    boolean updateReservation(ReservationDTO dto);
    boolean deleteReservation(ReservationDTO dto);
}
