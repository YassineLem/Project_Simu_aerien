package com.project_simu.Data;

import com.project_simu.entity.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VolData {

    private static Long dernierId = 0L;
    private Long id_vol;
    private String nom_vol;
    private Aeroport aeroport_depart;
    private Aeroport aeroport_arrive;
    private Avion Avion;
    private LocalDate date;
    private List<Aeroport> Trajectoire=new ArrayList<>();
    public VolData() {
    }

    public VolData(String nom_vol, Aeroport aeroport_depart, Aeroport aeroport_arrive, Avion avion) {
        this.nom_vol = nom_vol;
        this.aeroport_depart = aeroport_depart;
        this.aeroport_arrive = aeroport_arrive;
        Avion = avion;
        date=LocalDate.now();
        dernierId++;
        this.id_vol=dernierId;
    }

    public Long getId_vol() {
        return id_vol;
    }

    public void setId_vol(Long id_vol) {
        this.id_vol = id_vol;
    }

    public String getNom_vol() {
        return nom_vol;
    }

    public void setNom_vol(String nom_vol) {
        this.nom_vol = nom_vol;
    }

    public Aeroport getAeroport_depart() {
        return aeroport_depart;
    }

    public void setAeroport_depart(Aeroport aeroport_depart) {
        this.aeroport_depart = aeroport_depart;
    }

    public Aeroport getAeroport_arrive() {
        return aeroport_arrive;
    }

    public void setAeroport_arrive(Aeroport aeroport_arrive) {
        this.aeroport_arrive = aeroport_arrive;
    }

    public Avion getAvion() {
        return Avion;
    }

    public void setAvion(com.project_simu.entity.Avion avion) {
        Avion = avion;
    }

    public List<Aeroport> getTrajectoire() {
        return Trajectoire;
    }

    public void setTrajectoire(List<Aeroport> trajectoire) {
        Trajectoire = trajectoire;
    }

}
