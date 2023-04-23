package lk.ijse.gdse.hostelManagement.dao.custom.impl;

import lk.ijse.gdse.hostelManagement.dao.custom.StudentDAO;
import lk.ijse.gdse.hostelManagement.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudenDAOImpl implements StudentDAO {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<Student> loadAll() {
        String sqlQuery= "from Student";
        Query query = session.createQuery(sqlQuery);
        List list =query.list ();
        session.close();
        return list;
    }

    @Override
    public String save(Student student) {
        return (String) session.save (student);
    }

    @Override
    public void update(Student student) {
        session.update (student);
    }

    @Override
    public void delete(Student student) {
        session.delete (student);
    }

    @Override
    public Student getObject(String id) throws Exception {
        return session.get(Student.class,id);
    }

    @Override
    public List<String> getStudentIds() {
        String sqlQuery="SELECT stId FROM Student ";
        Query query = session.createQuery(sqlQuery);
        List<String> list = query.list();
        session.close();
        System.out.println(list);
        return list;
    }

    @Override
    public List<String> getStIds() {
        return null;
    }
}
