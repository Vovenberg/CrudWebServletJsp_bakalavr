package hibernate.DAO;

import hibernate.HibernateUtil;
import hibernate.entity.Auto;
import hibernate.entity.Driver;
import hibernate.entity.Protocol;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Vladimir on 23.02.2016.
 */
public class AutoDao {
    public void addAuto(Auto a){
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(a);
        s.getTransaction().commit();
        s.close();
    }

    public List<Auto> getAllAuto()
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List l=s.createSQLQuery("select* from auto").addEntity(Auto.class).list();
        s.close();
        return l;
    }
    public Auto getAutoById(int i){
        Session s= HibernateUtil.getSessionFactory().openSession();
        Auto a=(Auto) s.load(Auto.class,i);
        s.close();
        return a;
    }

    public void updateAuto(Auto a){
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(a);
        s.getTransaction().commit();
        s.close();

    }
    public void deleteAuto(Auto a){
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(a);
        s.getTransaction().commit();
        s.close();
    }
}
