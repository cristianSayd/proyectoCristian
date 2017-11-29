package com.proyecto.proyecto.ProyectoCristian.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.ProyectoCristian.entity.Etapa;



@Repository("etapaRepository")
public interface EtapaRepository extends JpaRepository<Etapa, Serializable>{
	
	


}
