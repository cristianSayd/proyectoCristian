package com.proyecto.proyecto.ProyectoCristian.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.proyecto.proyecto.ProyectoCristian.entity.Etapa;
import com.proyecto.proyecto.ProyectoCristian.entity.Proyecto;
import com.proyecto.proyecto.ProyectoCristian.model.EtapaModel;
import com.proyecto.proyecto.ProyectoCristian.model.ProyectoModel;

@Component ("proyectoConverter" )
public class ProyectoConverter {
	
	@Autowired
	@Qualifier("etapaConverter")
	private EtapaConverter etapaConverter;
	
	public Proyecto convertProyectoToProyectoModel (ProyectoModel proyectoMo ) {
		Proyecto proyecto = new Proyecto ();
		proyecto.setNombre(proyectoMo.getNombre());
		proyecto.setFechaFin(proyectoMo.getFechaFin());
		proyecto.setFechaInicio(proyectoMo.getFechaInicio());
		proyecto.setIdProyecto(proyectoMo.getIdProyecto());
		
		
				
		
		return proyecto;
		
		
	}
	public ProyectoModel convertProyectoModelToProyecto (Proyecto proyecto) {
		ProyectoModel proyectoM = new ProyectoModel ();
		proyectoM.setNombre(proyecto.getNombre());
		proyectoM.setFechaFin(proyecto.getFechaFin());
		proyectoM.setFechaInicio(proyecto.getFechaInicio());
		proyectoM.setIdProyecto(proyecto.getIdProyecto());
		List<EtapaModel> etapasM = new ArrayList<>();
		for (Etapa etapaModel : proyecto.getEtapas()) {
			etapasM.add(etapaConverter.convertEtapaToEtapaModel(etapaModel));
		}
		proyectoM.setEtapas(etapasM);
		
		
				
		
		return proyectoM;
		
		
	}
	public ProyectoModel convertProyectoModelToProyecto2 (Proyecto proyecto) {
		ProyectoModel proyectoM = new ProyectoModel ();
		proyectoM.setNombre(proyecto.getNombre());
		proyectoM.setFechaFin(proyecto.getFechaFin());
		proyectoM.setFechaInicio(proyecto.getFechaInicio());
		proyectoM.setIdProyecto(proyecto.getIdProyecto());
		List<EtapaModel> etapaM = new ArrayList<>();
		for (Etapa etapaModel : proyecto.getEtapas()) {
			etapaM.add(etapaConverter.convertEtapaToEtapaModel(etapaModel));
		}
		proyectoM.setEtapas(etapaM);
		
		
				
		
		return proyectoM;
		
		
	}
	

}
