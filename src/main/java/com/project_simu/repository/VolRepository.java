package com.project_simu.repository;

import com.project_simu.entity.Aeroport;
import com.project_simu.entity.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolRepository extends JpaRepository<Vol,Long> {
}
