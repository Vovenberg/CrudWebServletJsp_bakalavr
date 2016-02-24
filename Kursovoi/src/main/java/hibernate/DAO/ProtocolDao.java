package hibernate.DAO;

import hibernate.HibernateUtil;
import hibernate.entity.Protocol;
import org.hibernate.Session;

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


}
