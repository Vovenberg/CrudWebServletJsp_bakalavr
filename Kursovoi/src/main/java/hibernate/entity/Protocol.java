package hibernate.entity;

import javax.persistence.*;

/**
 * Created by Vladimir on 23.02.2016.
 */
@Entity
@javax.persistence.Table(name = "protocol")
public class Protocol {
    @Id
    @Column(name= "id_protocol")
    Integer id_protocol;
    @ManyToOne
    @JoinColumn(name= "number_auto")
    Auto number_auto;
    @Column(name= "mesto")
    String mesto;
    @Column(name= "opisanie")
    String opisanie;

    public Protocol() {
    }

    public Protocol(Integer id_protocol, Auto number_auto, String mesto, String opisanie) {
        this.id_protocol = id_protocol;
        this.number_auto = number_auto;
        this.mesto = mesto;
        this.opisanie = opisanie;
    }

    public Integer getId_protocol() {
        return id_protocol;
    }

    public void setId_protocol(Integer id_protocol) {
        this.id_protocol = id_protocol;
    }

    public Auto getNumber_auto() {
        return number_auto;
    }

    public void setNumber_auto(Auto number_auto) {
        this.number_auto = number_auto;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }
}
