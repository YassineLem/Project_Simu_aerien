package com.project_simu.entity;

import jakarta.persistence.*;
import org.hibernate.collection.spi.PersistentMap;

import java.util.HashMap;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Vol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id_vol;
    private String nom_vol;
    @ManyToOne (targetEntity=Aeroport.class)
    private Aeroport Aeroport_depart;
    @ManyToOne(targetEntity=Aeroport.class)
    private Aeroport Aeroport_arrive;
    private LocalDate Date;
    @ManyToOne
    private Avion avion;
    @OneToMany(targetEntity=Aeroport.class)
    Set<Aeroport> Trajectoire;

    public Vol(String nom_vol, Aeroport aeroport_depart, Aeroport aeroport_arrive, LocalDate date, Avion avion) {
        this.nom_vol = nom_vol;
        Aeroport_depart = aeroport_depart;
        Aeroport_arrive = aeroport_arrive;
        Date = date;
        this.avion = avion;
//        Trajectoire=new ArrayList<>();
        };
    public Vol() {
    }

//    public List<Aeroport> getTrajectoire() {
//        return Trajectoire;
//    }
//
//    public void setTrajectoire(List<Aeroport> trajectoire) {
//        Trajectoire = trajectoire;
//    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }



    public Long getId_vol() {
        return Id_vol;
    }
    public void setId_vol(Long id_vol) {
        Id_vol = id_vol;
    }

    public String getNom_vol() {
        return nom_vol;
    }

    public void setNom_vol(String nom_vol) {
        this.nom_vol = nom_vol;
    }

    public Aeroport getAeroport_depart() {
        return Aeroport_depart;
    }

    public void setAeroport_depart(Aeroport aeroport_depart) {
        Aeroport_depart = aeroport_depart;
    }

    public Aeroport getAeroport_arrive() {
        return Aeroport_arrive;
    }

    public void setAeroport_arrive(Aeroport aeroport_arrive) {
        Aeroport_arrive = aeroport_arrive;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }
    private final int EARTH_RADIUS_KM = 6371; // Rayon moyen de la Terre en kilomètres

    public  double calculateDistance() {
        Aeroport deb=this.getAeroport_depart();
        Aeroport fin=this.getAeroport_arrive();
        double dLat = Math.toRadians(fin.getLocalisation().getCoordinate().getY() - deb.getLocalisation().getCoordinate().getY());
        double dLon = Math.toRadians(fin.getLocalisation().getCoordinate().getX() - deb.getLocalisation().getCoordinate().getX());

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(deb.getLocalisation().getCoordinate().getY())) * Math.cos(Math.toRadians(fin.getLocalisation().getCoordinate().getY()))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS_KM * c;
        return distance;
    }

    @Override
    public String toString() {
        return "Vol{" +
                "Id_vol=" + Id_vol +
                ", nom_vol='" + nom_vol + '\'' +
                ", Aeroport_depart=" + Aeroport_depart +
                ", Aeroport_arrive=" + Aeroport_arrive +
                ", Date=" + Date +
                ", avion=" + avion +
                '}';
    }
}
