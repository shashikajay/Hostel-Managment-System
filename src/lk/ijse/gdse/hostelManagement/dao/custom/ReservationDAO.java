package lk.ijse.gdse.hostelManagement.dao.custom;

import lk.ijse.gdse.hostelManagement.dao.CrudDAO;
import lk.ijse.gdse.hostelManagement.entity.Reservation;
import org.hibernate.Session;

public interface ReservationDAO extends CrudDAO<Reservation> {
    void setSession(Session session);
}
