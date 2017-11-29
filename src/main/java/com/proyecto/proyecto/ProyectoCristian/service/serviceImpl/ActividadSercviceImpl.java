package com.proyecto.proyecto.ProyectoCristian.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.ProyectoCristian.converter.ActividadConverter;
import com.proyecto.proyecto.ProyectoCristian.converter.TareaConverter;
import com.proyecto.proyecto.ProyectoCristian.entity.Actividad;
import com.proyecto.proyecto.ProyectoCristian.model.ActividadModel;
import com.proyecto.proyecto.ProyectoCristian.model.TareaModel;
import com.proyecto.proyecto.ProyectoCristian.repository.ActividadRepository;
import com.proyecto.proyecto.ProyectoCristian.repository.ProyectoRepository;
import com.proyecto.proyecto.ProyectoCristian.service.ActividadService;

@Service("actividadSercviceImpl")
public class ActividadSercviceImpl implements ActividadService {

	@Autowired
	@Qualifier("proyectoRepository")
	private ProyectoRepository proyectoRepository;

	@Autowired
	@Qualifier("actividadRepository")
	private ActividadRepository actividadRepository;

	@Autowired
	@Qualifier("actividadConverter")
	private ActividadConverter actividadConverter;
	
	@Autowired
	@Qualifier("tareaConverter")
	private TareaConverter tareaConverter;
	

	@Override
	public List<ActividadModel> listAllProyectos() {
		List<Actividad> lis = actividadRepository.findAll();
		List<ActividadModel> lisTModel = new ArrayList<>();
		for (Actividad actividad : lis) {
			lisTModel.add(actividadConverter.convertActividadToActividadModel(actividad));
		}

		return lisTModel;
	}

	@Override
	public ActividadModel addActividad(ActividadModel actividadModel) {
		Actividad actividad = actividadConverter.convertActividadModelToActividad(actividadModel);
		ActividadModel actividadModel1 = actividadConverter.convertActividadToActividadModel(actividad);
		actividadRepository.save(actividad);

		return actividadModel1;
	}

	@Override
	public boolean deleteActividad(String idActividad) {
		try {
			Actividad avctiviad = actividadRepository.findOne(idActividad);
			actividadRepository.delete(avctiviad);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public ActividadModel findActividadById(String idActividad) {
		Actividad actividad = actividadRepository.findOne(idActividad);
		ActividadModel actividadModel = actividadConverter.convertActividadToActividadModel(actividad);
		return actividadModel;
	}

	@Override
	public List<TareaModel> listTareas(String idActividad) {
		List<TareaModel> listTareas = new ArrayList<>();
		Actividad actividad = actividadRepository.findOne(idActividad);
		listTareas =tareaConverter.convertListTareaModeToListTarea(  actividad.getTareas());
		
		return listTareas;
		
	}

}
