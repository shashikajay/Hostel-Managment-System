package lk.ijse.gdse.hostelManagement.dao.custom;

import lk.ijse.gdse.hostelManagement.dao.CrudDAO;
import lk.ijse.gdse.hostelManagement.entity.Reservation;
import lk.ijse.gdse.hostelManagement.entity.Room;
import org.hibernate.Session;

public interface RoomDAO extends CrudDAO<Room> {
    void setSession(Session session);
}
