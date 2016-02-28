package hibernate.DAO;

import hibernate.HibernateUtil;
import hibernate.entity.Auto;
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
    public void updateDriver(Driver a){
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(a);
        s.getTransaction().commit();
        s.close();

    }
    public List<Driver> getAllDrivers()
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List l=s.createSQLQuery("select* from driver").addEntity(Driver.class).list();
        s.close();
        return l;
    }

    public Driver getDriverById(int i){
        Session s= HibernateUtil.getSessionFactory().openSession();
        Driver d=(Driver)s.load(Driver.class,i);
        s.close();
        return d;
    }

    public void deleteDriver(Driver a){
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(a);
        s.getTransaction().commit();
        s.close();
    }

}
