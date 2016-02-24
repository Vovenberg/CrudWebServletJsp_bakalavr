package hibernate.DAO;

import hibernate.HibernateUtil;
import hibernate.entity.Driver;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Vladimir on 23.02.2016.
 */
public class DriverDao {
    public void addDriver(Driver d){
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(d);
        s.getTransaction().commit();
        s.close();
    }
    public List<Driver> getAllDrivers()
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List l=s.createSQLQuery("select* from driver").addEntity(Driver.class).list();
        return l;
    }

}
