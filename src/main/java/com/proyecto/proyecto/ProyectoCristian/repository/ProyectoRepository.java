package com.proyecto.proyecto.ProyectoCristian.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.ProyectoCristian.entity.Proyecto;

@Repository("proyectoRepository")

public interface ProyectoRepository extends JpaRepository<Proyecto, Serializable>{
	public abstract Proyecto findProyectoByIdProyecto(String idProyecto);
	

}
