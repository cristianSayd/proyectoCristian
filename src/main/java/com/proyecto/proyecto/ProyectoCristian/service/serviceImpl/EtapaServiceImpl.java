package com.proyecto.proyecto.ProyectoCristian.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.ProyectoCristian.converter.EtapaConverter;
import com.proyecto.proyecto.ProyectoCristian.entity.Actividad;
import com.proyecto.proyecto.ProyectoCristian.entity.Etapa;
import com.proyecto.proyecto.ProyectoCristian.model.ActividadModel;
import com.proyecto.proyecto.ProyectoCristian.model.EtapaModel;
import com.proyecto.proyecto.ProyectoCristian.repository.ActividadRepository;
import com.proyecto.proyecto.ProyectoCristian.repository.EtapaRepository;
import com.proyecto.proyecto.ProyectoCristian.repository.ProyectoRepository;
import com.proyecto.proyecto.ProyectoCristian.service.EtapaService;

@Service("etapaServiceImpl")
public class EtapaServiceImpl implements EtapaService {

	
	@Autowired
	@Qualifier("proyectoRepository")
	private ProyectoRepository proyectoRepository;
	

	@Autowired
	@Qualifier("actividadRepository")
	private ActividadRepository actividadRepository;
	
	@Autowired
	@Qualifier("etapaRepository")
	private EtapaRepository etapaRepository;
	
	@Autowired
	@Qualifier("etapaConverter")
	private EtapaConverter etapaConverter;
	
	@Override
	public List<EtapaModel> listAllEtapas() {
		List<Etapa> lis = etapaRepository.findAll();
		List<EtapaModel> lisTModel = new ArrayList<>();
		for (Etapa etapa : lis) {
			lisTModel.add(etapaConverter.convertEtapaToEtapaModel(etapa));
		}
		
		return lisTModel;
		
	}

	@Override
	public EtapaModel addEtapas(EtapaModel etapaModel) {
		Etapa etapa = etapaConverter.convertEtapaModelToEtapa(etapaModel);
		EtapaModel etapaModel1 = etapaConverter.convertEtapaToEtapaModel(etapa);
		etapaRepository.save(etapa);
		
		

	return etapaModel1;
	}

	@Override
	public boolean deleteEtapas(String idEtapa) {
		try {
			Etapa etapa = etapaRepository.findOne(idEtapa);
			etapaRepository.delete(etapa);
		} catch (Exception e) {
			e.getMessage();
			return false;
			
		}
		return true;

		
	}

	@Override
	public EtapaModel findEtapasById(String idEtapa) {
		Etapa etapa = etapaRepository.findOne(idEtapa);
		
		return etapaConverter.convertEtapaToEtapaModel(etapa);
	}

}
