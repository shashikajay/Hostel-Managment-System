package lk.ijse.gdse.hostelManagement.dao.custom.impl;

import lk.ijse.gdse.hostelManagement.dao.custom.RoomDAO;
import lk.ijse.gdse.hostelManagement.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<Room> loadAll() {
        String sqlQuery="From Room";
        Query query = session.createQuery(sqlQuery);
        List list =query.list ();
        session.close();
        return list;
    }

    @Override
    public String save(Room room) {
        return (String) session.save (room);
    }

    @Override
    public void update(Room room) {
        session.update (room);
    }
    @Override
    public void delete(Room room) {
        session.delete (room);
    }

    @Override
    public Room getObject(String id) throws Exception {
        return session.get(Room.class,id);
    }
}
