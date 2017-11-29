package com.proyecto.proyecto.ProyectoCristian.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.proyecto.ProyectoCristian.entity.Tarea;
public class ActividadModel {
	private String idActividad;
	private String nombre;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicio;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaFin;
	
	private List<TareaModel> tareas = new ArrayList<>();
	public ActividadModel(String idActividad, String nombre, Date fechaInicio, Date fechaFin, List<TareaModel> tareas) {
		super();
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tareas = tareas;
	}
	public ActividadModel() {
	}
	public String getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public List<TareaModel> getTareas() {
		return tareas;
	}
	public void setTareas(List<TareaModel> tareas) {
		this.tareas = tareas;
	}
	

}
