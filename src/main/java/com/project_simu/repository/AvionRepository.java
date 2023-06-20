package com.project_simu.repository;

import com.project_simu.entity.Avion;
import com.project_simu.entity.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion,Long> {
}
