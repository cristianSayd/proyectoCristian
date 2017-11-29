package com.proyecto.proyecto.ProyectoCristian.service;

import java.util.List;

import com.proyecto.proyecto.ProyectoCristian.model.TareaModel;

public interface TareaSevice {

	public abstract List<TareaModel> listAllTarea();
	public abstract TareaModel addTarea(TareaModel tareaModel);
	public  abstract boolean  deleteTarea (String idTarea);
	public  abstract TareaModel findTareaById(String idTarea);
	public abstract List<TareaModel> listarHijosDirectos(String idTarea);
	public abstract List<TareaModel> listarByNivel (Integer nivel);
	public abstract List<TareaModel> listarArbol();
	public abstract List<TareaModel> listArbolByPadre(String idPadre);
	public abstract TareaModel addTareaHijo(TareaModel tareaM ,String idPadre);
	public abstract List<TareaModel> listarTareas (TareaModel tareaM);
	
	
 	
	
	
	
}
