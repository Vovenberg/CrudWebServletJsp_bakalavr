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
public class ProtocolDao {
    public void addProtocol(Protocol p){
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(p);
        s.getTransaction().commit();
        s.close();

    }

    public void updateProtocol(Protocol a){
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(a);
        s.getTransaction().commit();
        s.close();

    }
    public List<Protocol> getAllProtocols()
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List l=s.createSQLQuery("select* from protocol").addEntity(Protocol.class).list();
        s.close();
        return l;
    }
    public Protocol getProtocolById(int i){
        Session s= HibernateUtil.getSessionFactory().openSession();
        Protocol p=(Protocol) s.load(Protocol.class,i);
        s.close();
        return p;
    }

    public void deleteProtocol(Protocol a){
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(a);
        s.getTransaction().commit();
        s.close();
    }

}
