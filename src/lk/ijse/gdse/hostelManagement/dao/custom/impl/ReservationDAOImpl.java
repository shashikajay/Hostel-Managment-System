package lk.ijse.gdse.hostelManagement.dao.custom.impl;

import lk.ijse.gdse.hostelManagement.dao.custom.ReservationDAO;
import lk.ijse.gdse.hostelManagement.entity.Reservation;
import org.hibernate.Session;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<Reservation> loadAll() {
        return null;
    }

    @Override
    public String save(Reservation reservation) {
        return null;
    }

    @Override
    public void update(Reservation reservation) {

    }

    @Override
    public void delete(Reservation reservation) {

    }

    @Override
    public Reservation getObject(String id) throws Exception {
        return null;
    }
}
