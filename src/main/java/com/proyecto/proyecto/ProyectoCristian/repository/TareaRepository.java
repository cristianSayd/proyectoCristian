package com.proyecto.proyecto.ProyectoCristian.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.ProyectoCristian.entity.Tarea;

@Repository("tareaRepository")
public interface TareaRepository  extends JpaRepository<Tarea, Serializable>{

	public abstract Tarea findTareaByIdTarea(String idTarea);
	public abstract List<Tarea> findTareaByIdPadre(String idPadre);
	public abstract List<Tarea> findTareaByIdPadreOrderByNivel(String idPadre);
	public abstract List<Tarea> findTareaBynivel(Integer nivel); 
	
	
	
}
