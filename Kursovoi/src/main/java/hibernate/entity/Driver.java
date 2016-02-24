package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Vladimir on 23.02.2016.
 */
@Entity
@javax.persistence.Table(name="driver")
public class Driver {
    @Id
    @Column(name= "id_driver")
    Integer id_driver;
    @Column(name= "name_driver")
    String name_driver;
    @Column(name= "surname_driver")
    String surname_driver;
    @Column(name= "vod_udost")
    Integer vod_udost;

    public Driver() {
    }

    public Driver(Integer id_driver, String name_driver, String surname_driver, Integer vod_udost) {
        this.id_driver = id_driver;
        this.name_driver = name_driver;
        this.surname_driver = surname_driver;
        this.vod_udost = vod_udost;
    }

    public Integer getId_driver() {
        return id_driver;
    }

    public void setId_driver(Integer id_driver) {
        this.id_driver = id_driver;
    }

    public String getName_driver() {
        return name_driver;
    }

    public void setName_driver(String name_driver) {
        this.name_driver = name_driver;
    }

    public String getSurname_driver() {
        return surname_driver;
    }

    public void setSurname_driver(String surname_driver) {
        this.surname_driver = surname_driver;
    }

    public Integer getVod_udost() {
        return vod_udost;
    }

    public void setVod_udost(Integer vod_udost) {
        this.vod_udost = vod_udost;
    }
}
