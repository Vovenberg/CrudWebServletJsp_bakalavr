package hibernate;

import hibernate.DAO.AutoDao;
import hibernate.DAO.DriverDao;
import hibernate.DAO.ProtocolDao;

/**
 * Created by Vladimir on 18.02.2016.
 */
public class Factory {
    DriverDao driverDao;
    AutoDao autoDao;
    ProtocolDao protocolDao;
    static Factory instanse;

    public static Factory getInstanse(){
        instanse=new Factory();
        return instanse;

    }

    public DriverDao getDriverDao(){
        driverDao=new DriverDao();
        return driverDao;
    }


    public AutoDao getAutoDao(){
        autoDao=new AutoDao();
        return autoDao;

    }

    private ProtocolDao getProtocolDao(){
        protocolDao=new ProtocolDao();
        return protocolDao;
    }
}
