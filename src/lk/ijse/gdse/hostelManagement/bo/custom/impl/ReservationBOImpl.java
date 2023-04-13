package lk.ijse.gdse.hostelManagement.bo.custom.impl;

import lk.ijse.gdse.hostelManagement.bo.custom.ReservationBO;
import lk.ijse.gdse.hostelManagement.dto.ReservationDTO;
import lk.ijse.gdse.hostelManagement.dto.RoomDTO;
import lk.ijse.gdse.hostelManagement.dto.StudentDTO;

import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    @Override
    public List<String> getStudentIds() {
        return null;
    }

    @Override
    public List<String> getRoomIds() {
        return null;
    }

    @Override
    public StudentDTO getStudent(String id) {
        return null;
    }

    @Override
    public RoomDTO getRoom(String id) {
        return null;
    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        return false;
    }

    @Override
    public List<ReservationDTO> loadAllRes() {
        return null;
    }

    @Override
    public boolean saveReservation(ReservationDTO dto) {
        return false;
    }

    @Override
    public boolean updateReservation(ReservationDTO dto) {
        return false;
    }

    @Override
    public boolean deleteReservation(ReservationDTO dto) {
        return false;
    }
}
