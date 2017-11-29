package com.proyecto.proyecto.ProyectoCristian.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.proyecto.proyecto.ProyectoCristian.entity.Etapa;
import com.proyecto.proyecto.ProyectoCristian.model.EtapaModel;
import com.proyecto.proyecto.ProyectoCristian.repository.ActividadRepository;

@Component ("etapaConverter" )
public class EtapaConverter {
	
	@Autowired
	@Qualifier("actividadRepository")
	private ActividadRepository actividadRepository;
	
	@Autowired
	@Qualifier("actividadConverter")
	private ActividadConverter actividadConverter;
	
	public Etapa convertEtapaModelToEtapa (EtapaModel etapaM) {
		Etapa etapa =  new Etapa ();
		etapa.setIdEtapa(etapaM.getIdEtapa());
		etapa.setNombre(etapaM.getNombre());	
		etapa.setActividades( actividadConverter.convertActividadToActividadModelList(etapaM.getActividades()));
		etapa.setFechaFin(etapaM.getFechaFin());
		etapa.setFechaInicio(etapaM.getFechaInicio());
	
		return etapa ;
	}
	public EtapaModel convertEtapaToEtapaModel (Etapa etapa) {
		EtapaModel etapaM =  new EtapaModel ();
		etapaM.setIdEtapa(etapa.getIdEtapa());
		etapaM.setNombre(etapa.getNombre());
		etapaM.setActividades(actividadConverter.convertActividadToActividadModelList2(etapa.getActividades()));
		etapaM.setFechaFin(etapa.getFechaFin());
		etapaM.setFechaInicio(etapa.getFechaInicio());
		
		
		return etapaM ;
	}

}
