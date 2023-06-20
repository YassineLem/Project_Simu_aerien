package com.project_simu.service;

import com.project_simu.entity.Aeroport;
import com.project_simu.repository.AeroportRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.List;
@Service
public class AeroportServiceImp implements AeroportService{
    @Autowired
    private AeroportRepository AeroportRepository;
    public List<Aeroport> findAll() {
        save_csv();
        return AeroportRepository.findAll();
    }
    public void save_csv(){
    List<Aeroport> res=AeroportRepository.findAll();
        if (res.isEmpty() == true) {
            System.out.println("No Data");

            String[] HEADERS = {"nom_aeroport","nbr_piste","nbr_place_sol","temps_acces","duree_boucle","latitude","longitude"};
            String fileLocation = "C:\\Users\\hp\\IdeaProjects\\Project_Simu\\src\\main\\resources\\Airport.csv";
            try {
                Reader in = new FileReader(fileLocation);
                Iterable<CSVRecord> records = CSVFormat.DEFAULT
                        .withHeader(HEADERS)
                        .withFirstRecordAsHeader()
                        .parse(in);
                for (CSVRecord record : records) {
                    // Convert to proper data types
                    String nom_aeroport = record.get("nom_aeroport");
                    Integer nbr_piste = Integer.valueOf(record.get("nbr_piste"));
                    Integer nbr_place_sol=Integer.valueOf(record.get("nbr_place_sol"));
                    Integer temps_acces=Integer.valueOf(record.get("temps_acces"));
                    Integer duree_boucle=Integer.valueOf(record.get("duree_boucle"));
                    Double Latitude = Double.parseDouble(record.get("latitude"));
                    Double Longitude = Double.parseDouble(record.get("longitude"));
                    Point Localisation = new GeometryFactory().createPoint(new Coordinate(Longitude, Latitude));
                    // Load data into our WaterConsumption Table
                    Aeroport air = new Aeroport(nom_aeroport,nbr_piste,nbr_place_sol,temps_acces,duree_boucle,Localisation);
                    AeroportRepository.save(air);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Data Loaded");
        }
    }
}
