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
import com.proyecto.proyecto.ProyectoCristian.repository.ActividadRepository;
import com.proyecto.proyecto.ProyectoCristian.repository.ProyectoRepository;
import com.proyecto.proyecto.ProyectoCristian.service.ProyectoService;
import com.proyecto.proyecto.ProyectoCristian.service.serviceImpl.ActividadSercviceImpl;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
	
	@Autowired
	@Qualifier("actividadRepository")
	private ActividadRepository actividadRepository;
	
	@Autowired
	@Qualifier("actividadSercviceImpl")
	private ActividadSercviceImpl actividadSercviceImpl;
	
	@CrossOrigin
	@GetMapping("/listActividades")
	public List<ActividadModel> listAllActividades () {
		
		
		return actividadSercviceImpl.listAllProyectos();
		
	}
	@CrossOrigin
	@PostMapping("/addActividad")
	public ActividadModel addActividad(@Valid @RequestBody ActividadModel actividadModel) {
		
		return actividadSercviceImpl.addActividad(actividadModel);
		
	}
	@CrossOrigin
	@DeleteMapping("/deleteActividad")
	public boolean delete(@RequestParam (value = "idActividad" , required=true)String idActividad) {
		
		
		actividadSercviceImpl.deleteActividad(idActividad);
		return true;
		
	}
	@CrossOrigin
	@GetMapping("/findActividad")
	public ActividadModel findById(@RequestParam (value = "idActividad" , required=true)String idActividad) {
		
	return actividadSercviceImpl.findActividadById(idActividad);
	
	}
	
	
	

}
