package com.proyecto.proyecto.ProyectoCristian.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.ProyectoCristian.converter.ActividadConverter;
import com.proyecto.proyecto.ProyectoCristian.converter.EtapaConverter;
import com.proyecto.proyecto.ProyectoCristian.converter.ProyectoConverter;
import com.proyecto.proyecto.ProyectoCristian.entity.Proyecto;
import com.proyecto.proyecto.ProyectoCristian.model.ProyectoModel;
import com.proyecto.proyecto.ProyectoCristian.repository.ProyectoRepository;
import com.proyecto.proyecto.ProyectoCristian.service.ProyectoService;

@Service("proyectoService")
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	@Qualifier("proyectoRepository")
	private ProyectoRepository proyectoRepository;
	
	@Autowired
	@Qualifier("proyectoConverter")
	private ProyectoConverter proyectoConverter;
	
	
	
	@Override
	public List<ProyectoModel> listAllProyectos() {
		List<Proyecto>  listProyectos = proyectoRepository.findAll();
		List<ProyectoModel> proyectosM = new ArrayList<>();
		for (Proyecto proyecto : listProyectos) {
			proyectosM.add(proyectoConverter.convertProyectoModelToProyecto(proyecto));
			
		}
		return proyectosM;
	}

	@Override
	public ProyectoModel addProyecto(ProyectoModel proyectoMo) {
		Proyecto proyecto = proyectoConverter.convertProyectoToProyectoModel(proyectoMo);
		ProyectoModel proyectoM = proyectoConverter.convertProyectoModelToProyecto(proyecto);
		proyectoRepository.save(proyecto);		
		
		
		return proyectoM;
	}

	@Override
	public boolean deleteProyecto(String idProyecto) {
		try {		
		Proyecto proyecto = proyectoRepository.findOne(idProyecto);
		proyectoRepository.delete(proyecto);
		} catch (Exception e) {
			
			return false;
			
		}
		return true;
		
	}

	@Override
	public ProyectoModel findProyectoById(String idProyecto) {
		// TODO Auto-generated method stub
		Proyecto proyecto = proyectoRepository.findProyectoByIdProyecto(idProyecto);
		ProyectoModel proyectoM = proyectoConverter.convertProyectoModelToProyecto(proyecto);
		return proyectoM;
	}

	@Override
	public List<ProyectoModel> listProyectosWithArbol() {
		List<Proyecto>  listProyectos = proyectoRepository.findAll();
		List<ProyectoModel> proyectosM = new ArrayList<>();
		for (Proyecto proyecto : listProyectos) {
			proyectosM.add(proyectoConverter.convertProyectoModelToProyecto2(proyecto));
		}
		
		return proyectosM;
	}
	

	
	
}
