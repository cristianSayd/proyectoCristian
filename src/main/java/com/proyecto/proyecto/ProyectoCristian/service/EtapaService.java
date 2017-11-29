package com.proyecto.proyecto.ProyectoCristian.service;

import java.util.List;

import com.proyecto.proyecto.ProyectoCristian.model.EtapaModel;

public interface EtapaService {

	public abstract List<EtapaModel> listAllEtapas();
	public abstract EtapaModel addEtapas(EtapaModel etapaModel);
	public  abstract boolean  deleteEtapas (String idEtapa);
	public  abstract EtapaModel findEtapasById(String idEtapa);
}
