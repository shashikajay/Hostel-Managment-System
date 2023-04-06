package lk.ijse.gdse.hostelManagement.bo.custom;

import lk.ijse.gdse.hostelManagement.bo.SuperBO;
import lk.ijse.gdse.hostelManagement.dto.RoomDTO;
import lk.ijse.gdse.hostelManagement.dto.StudentDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    List<RoomDTO> loadAll();
    boolean saveRoom(RoomDTO dto);
    boolean updateRoom(RoomDTO dto);
    boolean deleteRoom(RoomDTO dto);
    RoomDTO getRoom(String id) throws Exception;
}
