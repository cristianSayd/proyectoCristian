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

import com.proyecto.proyecto.ProyectoCristian.model.ProyectoModel;
import com.proyecto.proyecto.ProyectoCristian.repository.ProyectoRepository;
import com.proyecto.proyecto.ProyectoCristian.service.ProyectoService;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
	@Qualifier("proyectoRepository")
	private ProyectoRepository proyectoRepository;
	
	@Autowired
	@Qualifier("proyectoService")
	private ProyectoService proyectoService;
	
	@CrossOrigin
	@GetMapping("/getAllProyectos")
	public List<ProyectoModel> getListProyectos(){
	
		
		return proyectoService.listAllProyectos();
	}
	
	@CrossOrigin
	@PostMapping("/addProyecto")
	public ProyectoModel addProyecto(@Valid @RequestBody ProyectoModel proyectoM) {
		
		return proyectoService.addProyecto(proyectoM);
		
	}	
	@CrossOrigin
	@DeleteMapping("/deleteProyecto")
	public boolean deleteProyecto ( @RequestParam (value = "idProyecto", required = true) String idProyecto) {
		
		proyectoService.deleteProyecto(idProyecto);
		return true;
		

	}
	@CrossOrigin
	@GetMapping("/findProyecto")
	public ProyectoModel findProyecto ( @RequestParam(value = "idProyecto ", required = true )String idProyecto) {
		
		
		
		return proyectoService.findProyectoById(idProyecto);
		
	}
	@CrossOrigin
	@GetMapping("/listProyectoAndArbol")
	public List<ProyectoModel> listArbolProyecto(){
		
		
		return proyectoService.listProyectosWithArbol();
	}
	
}
