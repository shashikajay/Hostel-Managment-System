package lk.ijse.gdse.hostelManagement.dao.custom;

import lk.ijse.gdse.hostelManagement.dao.CrudDAO;
import lk.ijse.gdse.hostelManagement.entity.Reservation;
import lk.ijse.gdse.hostelManagement.entity.User;
import org.hibernate.Session;

public interface UserDAO extends CrudDAO<User> {
    void setSession(Session session);
}
