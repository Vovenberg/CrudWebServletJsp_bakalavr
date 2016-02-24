package hibernate.entity;

import javax.persistence.*;

/**
 * Created by Vladimir on 23.02.2016.
 */
@Entity
@javax.persistence.Table(name = "auto")
public class Auto {
    @Id
    @Column(name= "number_auto")
    Integer number_auto;
    @ManyToOne
    @JoinColumn(name= "id_driver")
    Driver id_driver;
    @Column(name= "marka")
    String marka;
    @Column(name= "svidet_o_registr")
    Integer svidet_o_registr;

    public Auto() {
    }

    public Auto(Integer number_auto, Driver id_driver, String marka, Integer svidet_o_registr) {
        this.number_auto = number_auto;
        this.id_driver = id_driver;
        this.marka = marka;
        this.svidet_o_registr = svidet_o_registr;
    }

    public Integer getNumber_auto() {
        return number_auto;
    }

    public void setNumber_auto(Integer number_auto) {
        this.number_auto = number_auto;
    }

    public Driver getId_driver() {
        return id_driver;
    }

    public void setId_driver(Driver id_driver) {
        this.id_driver = id_driver;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Integer getSvidet_o_registr() {
        return svidet_o_registr;
    }

    public void setSvidet_o_registr(Integer svidet_o_registr) {
        this.svidet_o_registr = svidet_o_registr;
    }
}
