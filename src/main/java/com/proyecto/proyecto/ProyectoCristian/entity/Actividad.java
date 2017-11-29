package com.proyecto.proyecto.ProyectoCristian.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "actividades")
public class Actividad {

	@Id
	@Column(name = "id_actividad", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idActividad;
	
	@NotEmpty(message = "Debe indicar el nombre ")
	@Column(name = "nombre")
	private String nombre;
	
	@DateTimeFormat
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@DateTimeFormat
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "id_actividad")
	private List<Tarea> tareas = new ArrayList<>();
	
	public Actividad() {
		
		
	}

	public Actividad(String idActividad, String nombre, Date fechaInicio, Date fechaFin, List<Tarea> tareas) {
	
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tareas = tareas;
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

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	 
	
	
}
