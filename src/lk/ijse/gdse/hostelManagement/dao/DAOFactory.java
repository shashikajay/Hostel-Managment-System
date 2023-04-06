package lk.ijse.gdse.hostelManagement.dao;

import lk.ijse.gdse.hostelManagement.bo.BOFactory;
import lk.ijse.gdse.hostelManagement.bo.SuperBO;
import lk.ijse.gdse.hostelManagement.bo.custom.impl.ReservationBOImpl;
import lk.ijse.gdse.hostelManagement.bo.custom.impl.RoomBOImpl;
import lk.ijse.gdse.hostelManagement.bo.custom.impl.StudentBOImpl;
import lk.ijse.gdse.hostelManagement.bo.custom.impl.UserBOImpl;
import lk.ijse.gdse.hostelManagement.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.gdse.hostelManagement.dao.custom.impl.RoomDAOImpl;
import lk.ijse.gdse.hostelManagement.dao.custom.impl.StudenDAOImpl;
import lk.ijse.gdse.hostelManagement.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    public static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory=new DAOFactory ();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        STUDENT,ROOM,USER,RESERVATION
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case STUDENT:
                return new StudenDAOImpl ();
            case ROOM:
                return new RoomDAOImpl ();
            case RESERVATION:
                return new ReservationDAOImpl ();
            case USER:
                return new UserDAOImpl ();
            default:
                return null;
        }
    }

}
