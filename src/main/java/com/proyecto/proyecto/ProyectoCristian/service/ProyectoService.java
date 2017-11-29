package com.proyecto.proyecto.ProyectoCristian.service;

import java.util.List;

import com.proyecto.proyecto.ProyectoCristian.entity.Proyecto;
import com.proyecto.proyecto.ProyectoCristian.model.ProyectoModel;

public interface ProyectoService {

	public abstract List<ProyectoModel> listAllProyectos();
	public abstract ProyectoModel addProyecto(ProyectoModel proyectoMo);
	public  abstract boolean  deleteProyecto (String idProyecto);
	public  abstract ProyectoModel findProyectoById(String idProyecto);
	public abstract List<ProyectoModel> listProyectosWithArbol();
	
	
	
}
