package com.proyecto.proyecto.ProyectoCristian.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.proyecto.proyecto.ProyectoCristian.entity.Actividad;
import com.proyecto.proyecto.ProyectoCristian.entity.Proyecto;
import com.proyecto.proyecto.ProyectoCristian.model.ActividadModel;
import com.proyecto.proyecto.ProyectoCristian.model.ProyectoModel;
import com.proyecto.proyecto.ProyectoCristian.repository.ActividadRepository;

@Component ("actividadConverter" )
public class ActividadConverter {
	
	@Autowired
	@Qualifier("actividadRepository")
	private ActividadRepository actividadRepository;
	
	@Autowired
	@Qualifier("tareaConverter")
	private TareaConverter tareaConverter;

	public Actividad convertActividadModelToActividad (ActividadModel actividadModel ) {
		Actividad actividad = new Actividad ();
		actividad.setIdActividad(actividadModel.getIdActividad());
		actividad.setFechaFin(actividadModel.getFechaFin());
		actividad.setFechaInicio(actividadModel.getFechaInicio());
		actividad.setNombre(actividadModel.getNombre());
		actividad.setTareas(tareaConverter.convertListTareaModeToListTarea2(actividadModel.getTareas()));
		
				
		
		return actividad;
	}
	public ActividadModel convertActividadToActividadModel (Actividad actividad ) {
		ActividadModel actividadM = new ActividadModel ();
		actividadM.setIdActividad(actividad.getIdActividad());
		actividadM.setFechaFin(actividad.getFechaFin());
		actividadM.setFechaInicio(actividad.getFechaInicio());
		actividadM.setNombre(actividad.getNombre());
		actividadM.setTareas(tareaConverter.convertListTareaModeToListTarea(actividad.getTareas()));
	
		
				
		
		return actividadM;
	
	}
	public List<Actividad> convertActividadToActividadModelList(List<ActividadModel> actividades){
		List<Actividad> actividades1 = new ArrayList<>();
		for (ActividadModel actividad : actividades) {
			actividades1.add(this.convertActividadModelToActividad(actividad));
		}
		
		return actividades1;
		
	}
	public List<ActividadModel> convertActividadToActividadModelList2(List<Actividad> actividades){
		List<ActividadModel> actividades1 = new ArrayList<>();
		for (Actividad actividad : actividades) {
			actividades1.add(this.convertActividadToActividadModel(actividad));
		}
		
		return actividades1;
		
	}
}
