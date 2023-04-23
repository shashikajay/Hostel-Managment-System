package lk.ijse.gdse.hostelManagement.bo.custom.impl;

import lk.ijse.gdse.hostelManagement.bo.custom.ReservationBO;
import lk.ijse.gdse.hostelManagement.dao.DAOFactory;
import lk.ijse.gdse.hostelManagement.dao.custom.ReservationDAO;
import lk.ijse.gdse.hostelManagement.dao.custom.RoomDAO;
import lk.ijse.gdse.hostelManagement.dao.custom.StudentDAO;
import lk.ijse.gdse.hostelManagement.dto.ReservationDTO;
import lk.ijse.gdse.hostelManagement.dto.RoomDTO;
import lk.ijse.gdse.hostelManagement.dto.StudentDTO;
import lk.ijse.gdse.hostelManagement.entity.Reservation;
import lk.ijse.gdse.hostelManagement.entity.Room;
import lk.ijse.gdse.hostelManagement.entity.Student;
import lk.ijse.gdse.hostelManagement.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    private Session session;
    StudentDAO studentDAO=(StudentDAO) DAOFactory.getDaoFactory ().getDAO (DAOFactory.DAOTypes.STUDENT);
    RoomDAO roomDAO=(RoomDAO) DAOFactory.getDaoFactory ().getDAO (DAOFactory.DAOTypes.ROOM);
    ReservationDAO reservationDAO=(ReservationDAO) DAOFactory.getDaoFactory ().getDAO (DAOFactory.DAOTypes.RESERVATION);


    @Override
    public List<String> getStudentIds() {
        try{
            session= SessionFactoryConfig.getInstance ().getSession ();
            studentDAO.setSession (session);
            return studentDAO.getStIds ();

        }catch (Exception e){
            session.close ();
            return null;
        }
    }

    @Override
    public List<String> getRoomIds() {
        try{
            session=SessionFactoryConfig.getInstance ().getSession ();
            roomDAO.setSession (session);
            return roomDAO.roomIds ();
        }catch (Exception e){
            session.close ();
            return null;
        }
    }

    @Override
    public StudentDTO getStudent(String id) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        studentDAO.setSession (session);
        try {
            Student st = studentDAO.getObject (id);
            session.close ();
            return new StudentDTO (
                    st.getStId (),
                    st.getStName (),
                    st.getAddress (),
                    st.getContact (),
                    st.getDob (),
                    st.getGender ()
            );

        } catch (Exception e) {
            e.printStackTrace ();
            transaction.rollback ();
            return null;
        }
    }

    @Override
    public RoomDTO getRoom(String id) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        roomDAO.setSession (session);
        try {
            Room room=roomDAO.getObject (id);
            session.close ();
            return new RoomDTO (
                    room.getRoomId (),
                    room.getType (),
                    room.getKeyMoney (),
                    room.getQty ()
            );

        } catch (Exception e) {
            e.printStackTrace ();
            transaction.rollback ();
            return null;
        }

    }

    @Override
    public ReservationDTO getRes(String resID) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        reservationDAO.setSession (session);
        try {
            Reservation res = reservationDAO.getObject (resID);
            session.close ();
            return new ReservationDTO (
                    res.getResId (),
                    res.getDate (),
                    new StudentDTO (
                            res.getStudent ().getStId (),
                            res.getStudent ().getStName (),
                            res.getStudent ().getAddress (),
                            res.getStudent ().getContact (),
                            res.getStudent ().getDob (),
                            res.getStudent ().getGender ()
                    ),
                    new RoomDTO (
                            res.getRoom ().getRoomId (),
                            res.getRoom ().getType (),
                            res.getRoom ().getKeyMoney (),
                            res.getRoom ().getQty ()
                    ),
                    res.getStatus ()
            );


        } catch (Exception e) {
            e.printStackTrace ();
            transaction.rollback ();
            return null;
        }
    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try {
            roomDAO.setSession (session);
            roomDAO.update (new Room (
                    dto.getRoomID (),
                    dto.getType (),
                    dto.getKeyMoney (),
                    dto.getQty ()
            ));

            transaction.commit ();
            session.close ();
            return true;
        }catch (Exception e){
            transaction.rollback ();;
        }
        return false;
    }

    @Override
    public List<ReservationDTO> loadAllRes() {
        return null;
    }

    @Override
    public boolean saveReservation(ReservationDTO dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try{
            reservationDAO.setSession (session);
            reservationDAO.save (
                    new Reservation (
                            dto.getResID (),
                            dto.getDate (),
                            new Student (
                                    dto.getStudentDTO ().getStId (),
                                    dto.getStudentDTO ().getStName (),
                                    dto.getStudentDTO ().getAddress (),
                                    dto.getStudentDTO ().getContact (),
                                    dto.getStudentDTO ().getDob (),
                                    dto.getStudentDTO ().getGender ()
                            ),
                            new Room (
                                    dto.getRoomDTO ().getRoomID (),
                                    dto.getRoomDTO ().getType (),
                                    dto.getRoomDTO ().getKeyMoney (),
                                    dto.getRoomDTO ().getQty ()
                            ),
                            dto.getStatus ()
                    ));
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e){
            transaction.rollback ();
            e.printStackTrace ();
            return false;
        }
    }

    @Override
    public boolean updateReservation(ReservationDTO dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try{
            reservationDAO.setSession (session);
            reservationDAO.update (
                    new Reservation (
                            dto.getResID (),
                            dto.getDate (),
                            new Student (
                                    dto.getStudentDTO ().getStId (),
                                    dto.getStudentDTO ().getStName (),
                                    dto.getStudentDTO ().getAddress (),
                                    dto.getStudentDTO ().getContact (),
                                    dto.getStudentDTO ().getDob (),
                                    dto.getStudentDTO ().getGender ()
                            ),
                            new Room (
                                    dto.getRoomDTO ().getRoomID (),
                                    dto.getRoomDTO ().getType (),
                                    dto.getRoomDTO ().getKeyMoney (),
                                    dto.getRoomDTO ().getQty ()
                            ),
                            dto.getStatus ()
                    ));
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e){
            transaction.rollback ();
            e.printStackTrace ();
            return false;
        }
    }

    @Override
    public boolean deleteReservation(ReservationDTO dto) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            reservationDAO.setSession(session);
            reservationDAO.delete(
                    new Reservation(
                            dto.getResID(),
                            dto.getDate(),
                            new Student(
                                    dto.getStudentDTO ().getStId (),
                                    dto.getStudentDTO ().getStName (),
                                    dto.getStudentDTO ().getAddress(),
                                    dto.getStudentDTO ().getContact (),
                                    dto.getStudentDTO ().getDob (),
                                    dto.getStudentDTO ().getGender ()
                            ),
                            new Room(
                                    dto.getRoomDTO ().getRoomID (),
                                    dto.getRoomDTO ().getType (),
                                    dto.getRoomDTO ().getKeyMoney (),
                                    dto.getRoomDTO ().getQty ()
                            ),
                            dto.getStatus ()
                    )
            );
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            session.close();
            transaction.rollback();
        }

        return false;
    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public List<ReservationDTO> loadAll() {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        reservationDAO.setSession (session);
        List<Reservation>list= reservationDAO. loadAll ();
        List<ReservationDTO>resList= new ArrayList<>();
        System.out.println ("Check1");

        for (Reservation res :list) {
            resList.add(new ReservationDTO (
                    res.getResId (),
                    res.getDate (),
                    new StudentDTO (
                            res.getStudent ().getStId (),
                            res.getStudent ().getStName (),
                            res.getStudent ().getAddress (),
                            res.getStudent ().getContact (),
                            res.getStudent ().getDob (),
                            res.getStudent ().getGender ()
                    ),
                    new RoomDTO (
                            res.getRoom ().getRoomId (),
                            res.getRoom ().getType (),
                            res.getRoom ().getKeyMoney (),
                            res.getRoom ().getQty ()
                    ),
                    res.getStatus ()
            ));
        }

        System.out.println ("Check2");
        return resList;
    }
}
