package com.project_simu.Controller;

import com.project_simu.entity.Aeroport;
import com.project_simu.service.AeroportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aeroport")
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class AeroportController {
    @Autowired
    private AeroportService AeroportService;
    @GetMapping()
    public List<Aeroport> findAll(){
       return AeroportService.findAll();
    }

}
