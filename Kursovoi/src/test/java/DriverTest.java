import hibernate.Factory;
import hibernate.entity.Driver;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Created by Vladimir on 24.02.2016.
 */
public class DriverTest {
    @Test
    public void testGetDrivers () {
        List<Driver> list=Factory.getInstanse().getDriverDao().getAllDrivers();
        for (Driver d:list){
            System.out.println(d.getName_driver());
            System.out.println(d.getSurname_driver());
        }
    }



}
