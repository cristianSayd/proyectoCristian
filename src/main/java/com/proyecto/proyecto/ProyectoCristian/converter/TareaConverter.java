package com.proyecto.proyecto.ProyectoCristian.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.proyecto.proyecto.ProyectoCristian.entity.Tarea;
import com.proyecto.proyecto.ProyectoCristian.model.TareaModel;

@Component ("tareaConverter" )
public class TareaConverter {
	
	public Tarea convertTaeaModelToTarea ( TareaModel tareaModel) {
		Tarea tarea = new Tarea ();
		tarea.setIdTarea(tareaModel.getIdTarea());
		tarea.setFechaFin(tareaModel.getFechaFin());
		tarea.setFechaInicio(tareaModel.getFechaInicio());
		tarea.setIdPadre(tareaModel.getIdPadre());
		tarea.setNombre(tareaModel.getNombre());
		tarea.setNivel(tareaModel.getNivel());
		
		
		
		return tarea ;
	}
	public TareaModel convertTareaModeToTarea(Tarea tarea ) {
		TareaModel tareaM = new TareaModel();
		tareaM.setIdTarea(tarea.getIdTarea());
		tareaM.setFechaFin(tarea.getFechaFin());
		tareaM.setFechaInicio(tarea.getFechaInicio());
		tareaM.setIdPadre(tarea.getIdPadre());
		tareaM.setNombre(tarea.getNombre());
		tareaM.setNivel(tarea.getNivel());
		
		
		return tareaM;
	}
	public List<Tarea> convertListTareaModeToListTarea2(List<TareaModel> tareas){
		List<Tarea> tareasE = new ArrayList<>();
		for (TareaModel tareaM : tareas) {
			
			tareasE.add(this.convertTaeaModelToTarea(tareaM));
			
		}
		
		return tareasE;
		
	}
	public List<TareaModel> convertListTareaModeToListTarea(List<Tarea> tareasE){
		List<TareaModel> tareasM = new ArrayList<>();
		for (Tarea tareaE : tareasE) {
			
			tareasM.add(this.convertTareaModeToTarea(tareaE));
			
		}
		
		return tareasM;
		
	}

}
