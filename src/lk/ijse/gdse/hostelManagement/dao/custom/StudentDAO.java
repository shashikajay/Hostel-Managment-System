package lk.ijse.gdse.hostelManagement.dao.custom;

import lk.ijse.gdse.hostelManagement.dao.CrudDAO;
import lk.ijse.gdse.hostelManagement.entity.Reservation;
import lk.ijse.gdse.hostelManagement.entity.Student;
import org.hibernate.Session;

public interface StudentDAO extends CrudDAO<Student> {
    void setSession(Session session);
}
