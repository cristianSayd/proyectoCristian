package com.proyecto.proyecto.ProyectoCristian.service;

import java.util.List;


import com.proyecto.proyecto.ProyectoCristian.model.ActividadModel;
import com.proyecto.proyecto.ProyectoCristian.model.TareaModel;

public interface ActividadService {

	public abstract List<ActividadModel> listAllProyectos();
	public abstract ActividadModel addActividad(ActividadModel actividadModel);
	public  abstract boolean  deleteActividad (String idActividad);
	public  abstract ActividadModel findActividadById(String idActividad);
	public abstract List<TareaModel> listTareas(String idActividad);
}
