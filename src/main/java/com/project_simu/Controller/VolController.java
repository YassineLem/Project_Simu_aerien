package com.project_simu.Controller;

import com.project_simu.Data.VolData;
import com.project_simu.entity.Aeroport;
import com.project_simu.entity.Vol;
import com.project_simu.repository.AeroportRepository;
import com.project_simu.repository.VolRepository;
import com.project_simu.service.AeroportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vols")
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class VolController {
    private static List<VolData> volList = new ArrayList<>(); // Liste pour stocker les données
    @GetMapping()
    public List<VolData> findAll(){
        return volList;
    }
    public static void addVolData(VolData volData) {
        volList.add(volData);
    }
}
