package com.proyecto.proyecto.ProyectoCristian.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.ProyectoCristian.model.ActividadModel;
import com.proyecto.proyecto.ProyectoCristian.model.EtapaModel;
import com.proyecto.proyecto.ProyectoCristian.service.serviceImpl.ActividadSercviceImpl;
import com.proyecto.proyecto.ProyectoCristian.service.serviceImpl.EtapaServiceImpl;

@RestController
@RequestMapping("/etapa")
public class EtapaController {
	@Autowired
	@Qualifier("etapaServiceImpl")
	private EtapaServiceImpl etapaServiceImpl;
	
	@CrossOrigin
	@GetMapping("/listEtapas")
	public List<EtapaModel> listEtapas () {
		
		
		return etapaServiceImpl.listAllEtapas();
		
	}
	
	@CrossOrigin
	@PostMapping("/addEtapa")
	public EtapaModel addEtapa(@Valid @RequestBody EtapaModel etapaModel) {
		
		return etapaServiceImpl.addEtapas(etapaModel);
		
	}
	
	
	@CrossOrigin
	@DeleteMapping("/deleteEtapa")
	public boolean deleteEtapa(@RequestParam (value = "idEtapa" , required=true)String idEtapa) {
		
		
		etapaServiceImpl.deleteEtapas(idEtapa);
		return true;
	}
	
	@CrossOrigin
	@GetMapping("/findEtapa")
	public EtapaModel findEtapasById(@RequestParam (value = "idEtapa" , required=true)String idEtapa) {
		
	return etapaServiceImpl.findEtapasById(idEtapa);
	
	}

	
}
