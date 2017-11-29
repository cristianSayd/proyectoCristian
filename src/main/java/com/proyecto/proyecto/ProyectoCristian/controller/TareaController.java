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
import com.proyecto.proyecto.ProyectoCristian.model.TareaModel;
import com.proyecto.proyecto.ProyectoCristian.service.ProyectoService;
import com.proyecto.proyecto.ProyectoCristian.service.serviceImpl.TareaServiceImpl;

@RestController

@RequestMapping("/tarea")
public class TareaController {

	@Autowired
	@Qualifier("proyectoService")
	private ProyectoService proyectoService;
	
	@Autowired
	@Qualifier("tareaServiceImpl")
	private TareaServiceImpl tareaServiceImpl;
	
	@CrossOrigin
	@GetMapping("/getAllTareas")
	public List<TareaModel> getListProyectos(){
	
		
		return tareaServiceImpl.listAllTarea();
	}
	@CrossOrigin
	@PostMapping("/addTarea")
	public TareaModel addTarea(@Valid @RequestBody TareaModel tareaModel) {
		
		return tareaServiceImpl.addTarea(tareaModel);
		
	}	
	@CrossOrigin
	@DeleteMapping("/deleteTarea")
	public boolean deleteTarea ( @RequestParam (value = "idTarea", required = true) String idTarea) {
		
		
		tareaServiceImpl.deleteTarea(idTarea);
		return true;
		

	}
	@CrossOrigin
	@GetMapping("/findTarea")
	public TareaModel findProyecto ( @RequestParam(value = "idTarea ", required = true )String idTarea) {
		
		
		
		return tareaServiceImpl.findTareaById(idTarea);
		
	}
	@CrossOrigin
	@GetMapping("/listHijosDirectos")
	public List<TareaModel> listHijosDirectos ( @RequestParam(value = "idPadre ", required = true )String idPadre) {
		
		return tareaServiceImpl.listarHijosDirectos(idPadre);
		
	}
	@CrossOrigin
	@GetMapping("/listArbol")
	public List<TareaModel> listArbol ( ) {
		
		return tareaServiceImpl.listarArbol();
		
	}
	@CrossOrigin
	@GetMapping("/listArbolByidPadre")
	public List<TareaModel> listArbolByPadre( @RequestParam(value = "idPadre ", required = true )String idPadre) {
		tareaServiceImpl.tareas1.clear();
		
		return tareaServiceImpl.listArbolByPadre(idPadre);
		
	}
	
	
	
	
}
