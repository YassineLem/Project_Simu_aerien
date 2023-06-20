package com.project_simu.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
@Entity
public class Avion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long IDavion;
    private String NameAvion;
    private Avion_type TypeAvion;
    private Integer Consommation;
    private Integer Capacite;
    @OneToMany(mappedBy = "avion", fetch = FetchType.LAZY)
    private Collection<Vol> vols;


    public Avion() {
    }


    public Avion(String nameAvion, Avion_type typeAvion, Integer consommation, Integer capacite) {
        NameAvion = nameAvion;
        TypeAvion = typeAvion;
        Consommation = consommation;
        Capacite = capacite;
    }

    public Long getIDavion() {
        return IDavion;
    }
    public double maxTrajectoire(){
        return (Capacite*100)/Consommation;
    }

    public void setIDavion(Long IDavion) {
        this.IDavion = IDavion;
    }

    public Avion_type getTypeAvion() {
        return TypeAvion;
    }

    public void setTypeAvion(Avion_type typeAvion) {
        TypeAvion = typeAvion;
    }

    public Integer getConsommation() {
        return Consommation;
    }

    public void setConsommation(Integer consommation) {
        Consommation = consommation;
    }

    public Integer getCapacite() {
        return Capacite;
    }

    public void setCapacite(Integer capacite) {
        Capacite = capacite;
    }

    public String getNameAvion() {
        return NameAvion;
    }

    public void setNameAvion(String nameAvion) {
        NameAvion = nameAvion;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "IDavion=" + IDavion +
                ", NameAvion='" + NameAvion + '\'' +
                ", TypeAvion=" + TypeAvion +
                ", Consommation=" + Consommation +
                ", Capacite=" + Capacite +
                '}';
    }
}
